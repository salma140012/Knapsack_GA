import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Random;

public class GA {

	int popSize = 10;
	Chromosome cr;
	Chromosome[] population;
	Chromosome[] Parents;
	Chromosome[] offsprings;
	double crossOverProbability = 0.7;
	double mutationProbability = 0.02;

	public GA() {
	}
          //num of items , weight of items, value of items , knapsack capacity it can hold
	void run(int len, int[] items_weight, int[] items_value, int knapsack_capacity) {
		// this for loop is to determine number of generations
        for(int i =0 ; i < 2 ; i++) {
        	System.out.println("--------------------------------------------------");
        	System.out.println("-----------------------  generation " +(i+1)+"  ---------------------------");
        	System.out.println("--------------------------------------------------");
		// populationGeneration
		this.population = populationGeneration(len);

		// calculate fitness
		//this for loop is to calculate fitness for every chromosome in population
		for (int j = 0; j < this.popSize; j++) {
			calcFitness(items_weight, items_value, knapsack_capacity, len);
		}
		// selection
		rankSelection();
		// crossover
		Crossover(len);
		// mutation
		mutation(len);
        // print output
		print(items_weight, items_value);
		//replace old population with offsprings
		replacement();
        }
	}

   // function to generate population using gene generation fuction in class chromosome
	Chromosome[] populationGeneration(int length) {

		cr = new Chromosome();
		this.population = new Chromosome[popSize];
		for (int i = 0; i < popSize; i++) {
			this.population[i] = new Chromosome();
		}
		for (int j = 0; j < popSize; j++) {

			this.population[j].genes = cr.geneGeneration(length);
		}
		return this.population;
	}

	//function to calculate fitness of each chromosome in population based on
	//the items weight and value that has been entered
	//does so using index and checking if item has been selected in chromosome to add 
	//both its values and checking if it's valid
	void calcFitness(int[] items_weight, int[] items_value, int knapsack_capacity, int len) {
		double totalWeight = 0.0;
		double totalValue = 0.0;
		double fitness = 0.0;

		for (int i = 0; i < popSize; i++) {
			boolean overweight = false;
			for (int j = 0; j < len; j++) {
				if (this.population[i].genes[j] == 1) {

					totalValue += items_value[j];
					totalWeight += items_weight[j];

				}
			}
			if (totalWeight > knapsack_capacity) { // death penalty for infeasible solutions

				this.population[i].setFitness(0);
			} else {
				fitness = totalValue;
				this.population[i].setFitness(fitness);
			}
			totalValue = 0.0;
			totalWeight = 0.0;

		}

	}
  
	
	//function to eliminate chromosomes with fitness 0 ( subjected to death penalty)
	//used in rank selection function
	Chromosome[] getValidPopulation() {
		int valid = 0;
		for (int i = 0; i < popSize; i++) {
			if (this.population[i].fitness > 0) {
				valid += 1;
			}
		}

		Chromosome[] validPopulation = new Chromosome[valid];
		for (int m = 0; m < valid; m++) {
			validPopulation[m] = new Chromosome();
		}
		int yes_add = 0; // to avoid out of index error between population array and valid population
							// array
		for (int j = 0; j < popSize; j++) {

			if (this.population[j].fitness > 0) {
				validPopulation[yes_add] = this.population[j];
				yes_add += 1;
			}
		}

		return validPopulation;
	}
 
	//function to select parents based on rank after it assigns it
	Chromosome rankSelection() {
		Chromosome[] rankSelection = getValidPopulation(); // getting chromosomes that escaped the death penalty
		double totalRanks = 0;
		int size = rankSelection.length;
		
		//sorting the chromosomes in ascending order with respect to fitness
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size - 1; j++) {
				if (rankSelection[j].fitness > rankSelection[j + 1].fitness) {
					Chromosome temp = rankSelection[j];
					rankSelection[j] = rankSelection[j + 1];
					rankSelection[j + 1] = temp;
				}
			}
		}
 
		//calculating total ranks
		for (int k = 0; k < size; k++) {
			rankSelection[k].setRank(k + 1);
			totalRanks += rankSelection[k].getRank();

		}
        
		//dividing rank of each chromosome by total rank value and setting it
		for (int m = 0; m < size; m++) {
			double tempValue = (rankSelection[m].getRank()) / totalRanks;
			double value = new BigDecimal(tempValue).setScale(2, RoundingMode.HALF_UP).doubleValue(); // to approximate
			rankSelection[m].setRankDivison(value);
			// rankSelection[m].setIntervalStart(0);
			// rankSelection[m].setIntervalEnd(rankSelection[m].getRankDivison());

		}
		
		//setting the range of selection for each chromosome with the interval's start and end
		double End_interval_value = rankSelection[0].getRankDivision();
		rankSelection[0].setIntervalStart(0);
		rankSelection[0].setIntervalEnd(rankSelection[0].getRankDivision());
		for (int n = 1; n < size; n++) {
			rankSelection[n].setIntervalStart(End_interval_value);
			End_interval_value += rankSelection[n].getRankDivision();
			rankSelection[n].setIntervalEnd(End_interval_value);

		}
        
		//generating a random number to compare with chromosomes interval and select one that satisfies the if condition
		Chromosome Parent = new Chromosome();
		Random rand = new Random(); // instance of random class
		double double_random = rand.nextDouble(); // Random double value between 0.0 and 1.0
		for (int z = 0; z < size; z++) {

			if (double_random > rankSelection[z].getIntervalStart()
					&& double_random < rankSelection[z].getIntervalEnd()) {
				Parent = rankSelection[z];
			}

		}

		return Parent;

	}
 
	//getting 10 parents from the rank selection function and storing them in parents array in class
	//to use in crossover function
	Chromosome[] parentSelected() {
		this.Parents = new Chromosome[10]; // 10 parents ---> 5 pairs of parents
		for (int i = 0; i < 10; i++) {
			this.Parents[i] = rankSelection();
			// System.out.println(Arrays.toString(Parents[i].genes));
		}
		return this.Parents;
	}
 
	//function performing crossover using parents selected and initializing offspring array
	void Crossover(int len) {

		this.Parents = parentSelected();
		this.offsprings = new Chromosome[this.Parents.length]; // initialization of genes length in offsprings
		for (int init = 0; init < this.Parents.length; init++) {
			this.offsprings[init] = new Chromosome(len);
		}

		int min = 1;
		int max = (len - 1); 
		//crossover point
		int Xc = (int) Math.floor(Math.random() * (max - min + 1) + min); // random from 0 to 1 parent gene length -1
		
		for (int i = 0; i < 10; i += 2) {

			Random rand = new Random();
			double double_random = rand.nextDouble();

			if (double_random <= this.crossOverProbability) {

				for (int j = 0; j < Xc; j++) {

					this.offsprings[i].genes[j] = this.Parents[i].genes[j];
					this.offsprings[i + 1].genes[j] = this.Parents[i + 1].genes[j];
				}

				for (int k = Xc; k < this.Parents[i].genes.length; k++) {
					this.offsprings[i].genes[k] = this.Parents[i + 1].genes[k];
					this.offsprings[i + 1].genes[k] = this.Parents[i].genes[k];
				}
			}

			else {
				this.offsprings[i] = this.Parents[i];
				this.offsprings[i + 1] = this.Parents[i + 1];
			}

		}


	}

	Chromosome[] mutation(int len) {
		//this.offsprings = Crossover(len);
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < this.offsprings[i].genes[j]; j++) {
				Random rand = new Random();
				double double_random = rand.nextDouble();
				if (double_random <= mutationProbability) {
					if (this.offsprings[i].genes[j] == 0) {
						this.offsprings[i].genes[j] = 1;
					} else if (this.offsprings[i].genes[j] == 1) {
						this.offsprings[i].genes[j] = 0;
					}
				}
			}
		}
		return this.offsprings;
	}

	//Generational replacement
	void replacement() {

		this.population=this.offsprings;
		
	}
	
	//print function to show output in main
	void print(int[] items_weight, int[] items_value) {
		// this.Parents = parentSelected();
		int selected_items = 0;
		for (int i = 0; i < this.Parents.length; i++) {
			selected_items = 0;
			for (int j = 0; j < this.Parents[0].genes.length; j++) {
				if (this.Parents[i].genes[j] == 1) {
					selected_items += 1;
				}
				this.Parents[i].setSelectedItems(selected_items);

			}
			System.out.println("--------------------------------------------------");
			System.out.println("Selected items in Parent " + (i + 1) + " : " + this.Parents[i].getSelectedItems());
			System.out.println("Total value : " + this.Parents[i].fitness);
			System.out.println("--------------------------------------------------");
		}

		for (int v = 0; v < this.Parents.length; v++) {
			for (int w = 0; w < this.Parents[0].genes.length; w++) {
				if (this.Parents[v].genes[w] == 1) {
					System.out.println("--------------------------------------------------");
					System.out.println("I'm Parent---> " + (v + 1));
					System.out.println("Item " + (w + 1) + " weight : " + items_weight[w]);
					System.out.println("Item " + (w + 1) + " value : " + items_value[w]);

					System.out.println("--------------------------------------------------");
				}
			}
		}

	}

Chromosome[] getPopulation() {
	return this.population;
}

Chromosome[] getOffsprings() {
	return this.offsprings;
}}