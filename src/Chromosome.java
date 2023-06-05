import java.util.Arrays;
import java.util.Random;

public class Chromosome {

	int[] genes= new int[this.len];  
	int len;
	double fitness;
	int rank;
	double rankDivision;
	double interval_start;
	double interval_end;
	int selected_items;


	public Chromosome() {
	
	}

	public Chromosome(int len) {
		this.len = len;
		this.genes= new int[this.len];
	}

	public int[] geneGeneration(int len) {
		this.len = len;
		this.genes = new int[len];
		Random rand = new Random(); // instance of random class
		int upperbound = 2;  //function uses upperbound-1

		for (int i = 0; i < len; i++) {
			int int_random = rand.nextInt(upperbound); // randomizing each bit with 1 or 0 
			this.genes[i] = int_random;
		}
		return genes;
	}

	void setFitness(double fitness) {
		this.fitness = fitness;
	}

	double getFitness() {
		return fitness;
	}

	void setRank(int rank) {
		this.rank = rank;

	}

	int getRank() {
		return this.rank;
	}

	void setSelectedItems(int selected_items) {
		this.selected_items= selected_items;

	}

	int getSelectedItems() {
		return this.selected_items;
	}
	void setRankDivison(double rankDivision) {
		this.rankDivision = rankDivision;

	}

	double getRankDivision() {
		return this.rankDivision;
	}

	int[] getgenes() {
		return this.genes;
	}

	void setIntervalStart(double interval_start) {
		this.interval_start = interval_start;

	}

	double getIntervalStart() {
		return this.interval_start;
	}

	void setIntervalEnd(double interval_end) {
		this.interval_end = interval_end;

	}

	double getIntervalEnd() {
		return this.interval_end;
	}

	void print() {

		System.out.println(Arrays.toString(genes));

	}

}