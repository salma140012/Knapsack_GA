import java.util.Arrays;
import java.util.Scanner;


public class Main {
public static void main(String[] args) {
	 
			 while(true)
			 {
				 System.out.println("*****************************************************"); 
				 System.out.println("Enter number of test case ----- From 1 to 20 -----");
				 System.out.println("For Exit press 0 ");
				 System.out.println("*****************************************************"); 
				 Scanner num = new Scanner(System.in);  
				 int n = num.nextInt();//Enter number of case
				 GA ga = new GA();
				 switch(n) {
					 case 1:
						 int[] itemsV1= {1,7,22,23,6};
						 int[] itemsW1= {4,7,1,3,3};
						 int Kcapacity1=14;
						 ga.run(5,itemsW1, itemsV1, Kcapacity1);
						 break;
						 
					 case 2:
						 int[] itemsV2= {27,27,12,28,23};
						 int[] itemsW2= {10,9,8,8,3};
						 int Kcapacity2=28;
						 ga.run(5,itemsW2, itemsV2, Kcapacity2);
						 break;
						 
					 case 3:
						 int[] itemsV3= {35,12,32,34,29};
						 int[] itemsW3= {4,11,7,4,8};
						 int Kcapacity3=25;
						 ga.run(5,itemsW3, itemsV3, Kcapacity3);
						 break;
						 
					 case 4:
						 int[] itemsV4= {2,7,14,16,9};
						 int[] itemsW4= {7,10,1,4,2};
						 int Kcapacity4=18;
						 ga.run(5,itemsW4, itemsV4, Kcapacity4);
						 break;
						 
					 case 5:
						 int[] itemsV5= {1,15,51,21,6,15,21,25,49,13};
						 int[] itemsW5= {8,5,11,7,5,7,8,4,1,5};
						 int Kcapacity5=44;
						 ga.run(10,itemsW5, itemsV5, Kcapacity5);
						 break;
						 
					 case 6:
						 int[] itemsV6= {18,55,20,30,4,19,27,58,8,58};
						 int[] itemsW6= {5,6,2,6,9,11,9,3,6,10};
						 int Kcapacity6=48;
						 ga.run(10,itemsW6, itemsV6, Kcapacity6);
						 break;
						 
					 case 7:
						 int[] itemsV7= {20,38,15,17,26,6,41,37,17,42};
						 int[] itemsW7= {11,3,5,2,2,4,6,2,9,2};
						 int Kcapacity7=34;
						 ga.run(10,itemsW7, itemsV7, Kcapacity7);
						 break;
						 
					 case 8:
						 int[] itemsV8= {25,19,15,5,46,21,2,58,18,6};
						 int[] itemsW8= {7,7,6,9,3,10,8,5,8,5};
						 int Kcapacity8=49;
						 ga.run(10,itemsW8, itemsV8, Kcapacity8);
						 break;
						 
					 case 9:
						 int[] itemsV9= {252,212,150,242,250,277,136,390,236,276,297,243,183,95,195,267,243,183,95,195,269,304,337,139,138};
						 int[] itemsW9= {38,46,1,43,50,39,3,10,36,17,9,48,28,19,42,30,26,39,41,37};
						 int Kcapacity9=423;
						 ga.run(20,itemsW9, itemsV9, Kcapacity9);
						 break;
						
					 case 10:
						 int[] itemsV10= {360,212,84,100,132,122,271,166,351,93,226,237,311,187,44,16,148,208,38,143};
						 int[] itemsW10= {26,42,11,25,23,36,16,12,15,45,21,42,28,20,47,47,48,4,23,16};
						 int Kcapacity10=384;
						 ga.run(20,itemsW10, itemsV10, Kcapacity10);
						 break;
						 
					 case 11:
						 int[] itemsV11= {119,296,155,127,58,76,104,34,224,109,30,206,18,164,159,99,78,280,362,137};
						 int[] itemsW11= {26,3,35,19,21,5,42,39,33,29,9,27,33,45,9,10,46,41,11,50};
						 int Kcapacity11=375;
						 ga.run(20,itemsW11, itemsV11, Kcapacity11);
						 
					 case 12:
						 int[] itemsV12= {229,18,214,275,1,305,191,271,322,2,77,62,152,74,144,110,246,159,358,350};
						 int[] itemsW12= {20,27,1,37,38,4,20,26,45,7,20,25,37,25,13,25,13,25,50,17,44,21};
						 int Kcapacity12=353;
						 ga.run(20,itemsW12, itemsV12, Kcapacity12);
						 break;
						 
					 case 13:
						 int[] itemsV13= {178,428,441,217,56,419,343,504,178,38,426,409,403,190,334,162,92,229,29,124,298,251,199,172,559,418,515,347,576,517};
						 int[] itemsW13= {36,46,12,33,45,26,31,7,43,18,28,29,13,49,19,15,39,39,7,40,48,40,32,19,31,41,4,10,40,10};
						 int Kcapacity13=597;
						 ga.run(30,itemsW13, itemsV13, Kcapacity13);
						 break;
						 
					 case 14:
						 int[] itemsV14= {413,247,41,157,99,161,101,323,91,596,372,378,508,24,535,11,16,240,163,529,571,69,271,398,212,528,550,625,170,142};
						 int[] itemsW14= {31,41,40,35,42,10,13,30,28,32,43,21,37,40,48,45,25,4,40,7,47,48,18,43,12,23,12,29,28,13};
						 int Kcapacity14=621;
						 ga.run(30,itemsW14, itemsV14, Kcapacity14);
						 break;
						 
					 case 15:
						 int[] itemsV15= {451,246,503,232,197,149,127,221,509,155,326,417,255,141,367,461,462,358,435,371,561,301,4,180,163,320,218,256,184,396};
						 int[] itemsW15= {1,4,41,41,27,33,23,43,14,29,3,30,25,8,37,17,41,50,12,4,29,33,44,43,42,8,32,39,6};
						 int Kcapacity15=560;
						 ga.run(itemsW15.length,itemsW15, itemsV15, Kcapacity15);
						 break;
					 case 16:
						 int[] itemsV16= {317,512,190,524,223,539,170,268,104,549,328,528,309,127,238,143,227,489,332,452,457,139,155,145,378,508,1,546,445,238};
						 int[] itemsW16= {45,33,12,32,11,18,29,30,27,1,30,49,44,13,20,31,22,46,22,24,42,38,12,9,5,8,24,47,17,37};
						 int Kcapacity16=546;
						 ga.run(itemsW16.length,itemsW16, itemsV16, Kcapacity16);
						 break;
						 
					 case 17:
						 int[] itemsV17= {824,216,467,103,467,245,701,351,314,517,365,778,165,498,579,608,409,24,550,56,604,237,339,29,467,478,650,827,841,291,453,281,286,431,583,639,674,162,774,597,646,415,502,289,390,527,259,66,600,575};
						 int[] itemsW17= {46,13,20,9,3,10,5,5,39,10,43,4,30,23,47,48,16,50,18,23,33,40,20,17,26,46,46,8,35,22,15,27,14,46,18,45,2,24,26,36,12,17,28,23,41,17,2,22,18,22};
						 int Kcapacity17=849;
						 ga.run(itemsW17.length,itemsW17, itemsV17, Kcapacity17);
						 break;
						 
					 case 18:
						 int[] itemsV18= {421,50,620,150,338,781,690,800,243,675,327,163,105,528,109,294,511,808,440,204,126,710,140,776,395,716,46,74,77,456,372,367,133,626,673,476,156,482,167,649,177,660,621,164,636,535,351,132,239,431};
						 int[] itemsW18= {11,50,29,15,45,8,38,5,8,38,5,8,16,31,9,20,1,36,41,37,41,3,45,14,2,45,40,11,20,6,1,49,26,44,18,19,20,16,48,2,6,22,23,6,35,33,21,2,34,45,38,7,10};
						 int Kcapacity18=808;
						 ga.run(itemsV18.length,itemsW18, itemsV18, Kcapacity18);
						 break;
						 
					 case 19:
						 int[] itemsV19= {788,310,158,687,148,590,212,722,535,703,206,696,42,885,797,827,398,191,160,847,825,456,40,147,542,456,857,166,814,507,724,700,415,595,659,881,364,106,659,221,413,58,825,360,200,272,111,863,728,62};
						 int[] itemsW19= {50,50,17,28,16,48,21,36,9,49,33,49,20,35,47,19,8,31,36,17,44,32,1,8,37,31,13,30,6,25,20,8,22,38,24,29,22,32,4,35,18,32,4,3,30,4,31,50,4,8};
						 int Kcapacity19=886;
						 ga.run(itemsW19.length,itemsW19, itemsV19, Kcapacity19);
						 break;
						 
					 case 20:
						 int[] itemsV20= {286,239,591,784,244,546,769,93,598,500,273,846,882,347,592,527,623,288,68,599,595,592,336,99,64,135,261,53,203,279,628,392,162,109,248,46,406,912,784,335,536,394,893,657,168,200,88,599,299};
						 int[] itemsW20= {4,36,35,16,40,35,4,26,4,24,23,50,33,10,40,30,10,16,15,25,32,2,45,2,40,44,23,3,14,40,28,4,42,23,46,37,38,2,28,27,5,46,50,21,36,28,35,23,35,20};
						 int Kcapacity20=908;
						 ga.run(itemsV20.length,itemsW20, itemsV20, Kcapacity20);
						 break;
						 
						 
					 case 0:
						 System.exit(0);
						 
						 
					 default:
					        System.out.println("Unknown Entry");
					        break;
						 
					
						 
					 
					
				 }
				 
					
			 	
			 }
	
		}

}