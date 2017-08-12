import java.util.ArrayList;
import java.util.Scanner;

public class TestStudentPartC {
	public static String newAdding;
	public static int i = 0;
	public static int removeStudentNo = 0;
	public static int studentNo = 0;
	public static ArrayList<Integer> mark = new ArrayList<Integer>();
	public static String[] markRange = new String[500];
    public static ArrayList<String> fName = new ArrayList<String>();
    public static ArrayList<String> sName = new ArrayList<String>();
	
	public static void main(String[] args) {
		//do while loop do ensure the user input at least 20 students
		Scanner input = new Scanner(System.in);
		do {
			System.out.print("How many students? ");
		 	studentNo = input.nextInt();
		}while (studentNo<2);
		//Storing all data into the arrays
		for (i = 0; i < studentNo; i++) {
			System.out.println("Student first name: ");
			fName.add(input.next());
			System.out.println("Student second name: ");
			sName.add(input.next());
			System.out.println("Student mark: ");
			mark.add(input.nextInt());
		}	
		mainMenu(input);
		
	}	
		public static void mainMenu(Scanner input)
		{
			System.out.print("1)Add students");
			System.out.print("\n2)Remove students");
			System.out.print("\n3)List students\n\n");
			int firstChoice;
			firstChoice =  input.nextInt();
			while (mainMenuValidation(firstChoice) == false) {
				System.out.print("Please enter one digit:");
				firstChoice =  input.nextInt();
			}
			//Adds a student to the arraylist
			if(firstChoice == 1){
				char secondChoice;
				System.out.println("A)Continue to add student\nB)Return to main menu.");
				secondChoice = input.next().toUpperCase().charAt(0);
				while( ABCValidation(secondChoice) == false)
				{
					System.out.print("Please select option A/B:");
					secondChoice = input.next().toUpperCase().charAt(0);
				}		
					if(secondChoice == 'A' ){ 
							System.out.println("Type a student first name ");
							fName.add(input.next());
							System.out.println("Type a student second name ");
							sName.add(input.next());
							System.out.println("Student mark ");
							mark.add(input.nextInt());	    
							mainMenu(input);				
					}
					if(secondChoice == 'B' ){
						mainMenu(input);
					}				
			}
			//Removes a student to the arraylist
			if(firstChoice == 2){
				char secondChoice;
				System.out.println("A)Continue to remove student.\nB)Return to main menu");
					secondChoice = input.next().toUpperCase().charAt(0);						
					while( ABCValidation(secondChoice) == false)
					{
						System.out.print("Please select option A/B:");
						secondChoice = input.next().toUpperCase().charAt(0);
					}		
						if(secondChoice == 'A' ){
							System.out.print("Select student bu No. to remove:");
							removeStudentNo = input.nextInt();
							fName.remove(removeStudentNo-1);
							sName.remove(removeStudentNo-1);
							mark.remove(removeStudentNo-1);
							mainMenu(input);
						}
						if(secondChoice == 'B' ){
							mainMenu(input);
						}
			}
			// Printing all the values of the arraylist
			if(firstChoice == 3){
				char secondChoice;
				System.out.println("A)List students:\nB)Back to Main Menu.");
				secondChoice = input.next().toUpperCase().charAt(0);
				while( ABCValidation(secondChoice) == false)
				{
					System.out.print("Please select option A/B:");
					secondChoice = input.next().toUpperCase().charAt(0);
				}		
					if(secondChoice == 'A' ){
						for (i = 0; i < studentNo; i++) {
							System.out.println("Studante No. "+i+" "+fName.get(i)+" "+sName.get(i)+" received a " + " for his mark of " + mark.get(i)+".");
							}	
						mainMenu(input);
					}
					if(secondChoice == 'B' ){
						mainMenu(input);
					}				
			}
		}		
		public static boolean mainMenuValidation(int firstChoice){
			boolean logic =false;
			if((firstChoice == 1 ) || (firstChoice == 2) || (firstChoice == 3)) {
				logic = true;
			}
			return logic;
		}	
		public static boolean ABCValidation(char secondChoice){
			boolean logic = false;
			if ((secondChoice == 'A') || (secondChoice == 'B') ||(secondChoice == 'C')){
				logic = true;
			}
			return logic; 
		}
	}
	
/**
 * With the Arraylist you can dynamically add or remove values unlike the Array where you have to 
 * statically size it when the array is created.
 * 
 * Arraylist classes have many ways to manipulate store objects.
 *  
 * Arraylist supports generics.
 * 
 * Arraylist is object oriented.
 */
