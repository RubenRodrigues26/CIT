import java.util.Scanner;

public class TestStudentPartA {

	public static int i = 0;
	public static int studentNo = 0;
	public static int[] mark = new int[500];
	public static String[] markRange = new String[500];
	public static String[] fName = new String[500];
	public static String[] sName = new String[500];
	
	public static void main(String[] args) {
	    
		Scanner input = new Scanner(System.in);
		
		do {
			System.out.print("How many students? ");
		 	studentNo = input.nextInt();
		}while (studentNo<2);
		 	
	  	//Storing data into the arrays
		for (i = 0; i < studentNo; i++) {
		     System.out.print("Enter first name: ");
		       	fName[i] = input.next();
		     System.out.print("Enter second name: ");
		        	sName[i] = input.next();
		     System.out.print("Enter mark: ");
		        mark[i] = Integer.parseInt(input.next());	
		        
		        if (mark[i] >=0 && mark[i] <=39){
		        	markRange[i] = "Fail";
		        }
		        else if (mark[i] >=40 && mark[i] <=64){
		        	markRange[i] = "Pass";
		        }
		        else if (mark[i] >=65 && mark[i] <=84){
		        	markRange[i] = "Merit";
		        }
		        else if (mark[i] >=85 && mark[i] <=100){
		        	markRange[i] = "Distinction";		        	
		        }else {
		        	System.out.println("Error not a valid number.");
		        }
		     }		
		
		// Printing the values
	    for (i = 0; i < studentNo; i++) {
	        System.out.println(fName[i]+" "+sName [i]+" received a " +markRange[i]+ " for his mark of " + mark[i]+".");
	    }
	    
	    
	    
	}
		
}

