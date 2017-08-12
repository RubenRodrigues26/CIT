//Ruben Rodrigues R00144165

import java.util.Scanner;
import java.io.*;
public class annualSales {

	public static int YEAR;
	public static String QUARTER;
	public static int NUMBER;
	public static int AVERAGE_2012, AVERAGE_2013, AVERAGE_2014, AVERAGE_2015;
	public static int MIN_SALES_2012 = Integer.MAX_VALUE, MIN_SALES_2013 = Integer.MAX_VALUE, MIN_SALES_2014 = Integer.MAX_VALUE, MIN_SALES_2015 = Integer.MAX_VALUE;
	public static int MAX_SALES_2012,  MAX_SALES_2013,  MAX_SALES_2014,  MAX_SALES_2015 = 0;
	public static String MIN_SALES_QUARTER_2012, MIN_SALES_QUARTER_2013, MIN_SALES_QUARTER_2014, MIN_SALES_QUARTER_2015 ="";
	public static String MAX_SALES_QUARTER_2012, MAX_SALES_QUARTER_2013, MAX_SALES_QUARTER_2014, MAX_SALES_QUARTER_2015 ="";
	public static void main(String[] args) 
			throws FileNotFoundException, IOException{
		
		Scanner inFile = new Scanner(new File("C:/Users/Worten/workspace/Assignment 3/src/sales.txt"));
		PrintWriter outFile2012 = new PrintWriter("C:/Users/Worten/workspace/Assignment 3/src/2012_result.txt");
		PrintWriter outFile2013 = new PrintWriter("C:/Users/Worten/workspace/Assignment 3/src/2013_result.txt");
		PrintWriter outFile2014 = new PrintWriter("C:/Users/Worten/workspace/Assignment 3/src/2014_result.txt");
		PrintWriter outFile2015 = new PrintWriter("C:/Users/Worten/workspace/Assignment 3/src/2015_result.txt");
		
		outFile2012.println("--- 2012 DATA ---\n\n");
		outFile2013.println("--- 2013 DATA ---\n\n");
		outFile2014.println("--- 2014 DATA ---\n\n");
		outFile2015.println("--- 2015 DATA ---\n\n");
		while (inFile.hasNext())
		{			
			String str = (inFile.next());
			String[] arr = str.split(",");					
			YEAR = Integer.parseInt(arr[0]);
			QUARTER = arr[1];
			NUMBER = Integer.parseInt(arr[2]);
			
			year2012(outFile2012);
			year2013(outFile2013);
			year2014(outFile2014);
			year2015(outFile2015);
			
		}	
		outFile2012.println("\n--- 2012 RESULTS ---");
		outFile2012.println("2012 Average Sales:" +AVERAGE_2012/4);
		outFile2012.println("Lowest sales were in "+MIN_SALES_QUARTER_2012+" "+"("+MIN_SALES_2012+")");
		outFile2012.println("Highest sales were in "+MAX_SALES_QUARTER_2012+" "+"("+MAX_SALES_2012+")");
		
		outFile2013.println("\n--- 2013 RESULTS ---");
		outFile2013.println("2013 Average Sales:" +AVERAGE_2013/4);
		outFile2013.println("Lowest sales were in "+MIN_SALES_QUARTER_2013+" "+"("+MIN_SALES_2013+")");
		outFile2013.println("Highest sales were in "+MAX_SALES_QUARTER_2013+" "+"("+MAX_SALES_2013+")");
		
		outFile2014.println("\n--- 2014 RESULTS ---");
		outFile2014.println("2014 Average Sales:" +AVERAGE_2014/4);
		outFile2014.println("Lowest sales were in "+MIN_SALES_QUARTER_2014+" "+"("+MIN_SALES_2014+")");
		outFile2014.println("Highest sales were in "+MAX_SALES_QUARTER_2014+" "+"("+MAX_SALES_2014+")");
		
		outFile2015.println("\n--- 2015 RESULTS ---");
		outFile2015.println("2015 Average Sales:" +AVERAGE_2015/4);
		outFile2015.println("Lowest sales were in "+MIN_SALES_QUARTER_2015+" "+"("+MIN_SALES_2015+")");
		outFile2015.println("Highest sales were in "+MAX_SALES_QUARTER_2015+" "+"("+MAX_SALES_2015+")");
			
		averageQ4();
		
		inFile.close();				
		outFile2012.close();
		outFile2013.close();
		outFile2014.close();
		outFile2015.close();
	}	
	public static void year2012(PrintWriter outFile2012){		
		if(YEAR == 2012){				
			outFile2012.println(YEAR + " - " + QUARTER + " - " +  NUMBER);
			AVERAGE_2012 += NUMBER;
			
			if(NUMBER>MAX_SALES_2012){
				MAX_SALES_2012=NUMBER;
				MAX_SALES_QUARTER_2012=QUARTER;
			}
			if(NUMBER<MIN_SALES_2012){
				MIN_SALES_2012=NUMBER;
				MIN_SALES_QUARTER_2012=QUARTER;
			}
		}					
	}	
	public static void year2013(PrintWriter outFile2013){		
		if(YEAR == 2013){				
			outFile2013.println(YEAR + " - " + QUARTER + " - " +  NUMBER);
			AVERAGE_2013 += NUMBER;
			
			if(NUMBER>MAX_SALES_2013){
				MAX_SALES_2013=NUMBER;
				MAX_SALES_QUARTER_2013=QUARTER;
			}
			if(NUMBER<MIN_SALES_2013){
				MIN_SALES_2013=NUMBER;
				MIN_SALES_QUARTER_2013=QUARTER;
			}
		}					
	}		
	public static void year2014(PrintWriter outFile2014){		
		if(YEAR == 2014){				
			outFile2014.println(YEAR + " - " + QUARTER + " - " +  NUMBER);
			AVERAGE_2014 += NUMBER;
			
			if(NUMBER>MAX_SALES_2014){
				MAX_SALES_2014=NUMBER;
				MAX_SALES_QUARTER_2014=QUARTER;
			}
			if(NUMBER<MIN_SALES_2014){
				MIN_SALES_2014=NUMBER;
				MIN_SALES_QUARTER_2014=QUARTER;
			}
		}					
	}		
	public static void year2015(PrintWriter outFile2015){		
		if(YEAR == 2015){				
			outFile2015.println(YEAR + " - " + QUARTER + " - " +  NUMBER);
			AVERAGE_2015 += NUMBER;
			
			if(NUMBER>MAX_SALES_2015){
				MAX_SALES_2015=NUMBER;
				MAX_SALES_QUARTER_2015=QUARTER;
			}
			if(NUMBER<MIN_SALES_2015){
				MIN_SALES_2015=NUMBER;
				MIN_SALES_QUARTER_2015=QUARTER;
			}
		}					
	}	
	public static void averageQ4(){
		if (QUARTER.equals("Q4")){
			int averageQ4 =0;
			averageQ4 += NUMBER;
			System.out.println("Q4 Average Sales: "+averageQ4 );
		}	
	}
	
}