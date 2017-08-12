
import java.util.Scanner;
public class beerTrain {
	
	public static final String BEER_NAME[] = new String[] {"Heineken","Bud Light","Coors Lite",
			"Leffe Blonde","Budweiser","Erdinger Non-Alcoholic","Bud Premier Select","Corona",
			"Barefoot Bohemian","3 Monts"};
	public static final double BEER_STRENGTH[] = new double[] {4, 4.2, 4.3, 6.6, 5, 0, 7.4, 4.6, 4, 8.5};
	public static void main(String args[]){
		
		Scanner keyboard = new Scanner(System.in);					
		mainMenu(keyboard);
		
	}	
		public static void mainMenu(Scanner keyboard)
		{
			System.out.print("1)Sort by Beer Strenght");
			System.out.print("\n2)Sort by Beer Name");
			System.out.print("\n3)Search by Beers\n\n");
			int firstChoice;
			firstChoice =  keyboard.nextInt();
			
			if(firstChoice == 1){
				char secondChoice;
				System.out.println("a) By Highest Strenght\nb) By Lowest Strenght\nc) Return to main menu");
				secondChoice = keyboard.next().toUpperCase().charAt(0);
					
						if(secondChoice == 'A' ){
							maxToMinByStrength();
						}
						if(secondChoice == 'B' ){
							minToMaxByStrength();
						}
						if(secondChoice == 'C' ){
							mainMenu(keyboard);
						}
			}
			if(firstChoice == 2){
				char secondChoice;
				System.out.println("a) By Name Ascending\nb) By Name Descending\nc) Return to main menu");
					secondChoice = keyboard.next().toUpperCase().charAt(0);						
					
						if(secondChoice == 'A' ){
							maxToMinByName();
						}
						if(secondChoice == 'B' ){
							minToMaxByName();
						}
						if(secondChoice == 'C' ){
							mainMenu(keyboard);
						}
			}
			if(firstChoice == 3){
				char secondChoice;
				System.out.println("a) Greater or equal than a Certain Strength\nb) Less or equal than a Certain Strength\nc) By Beer Name. Note that the beer name search is a free text search. The keyword search ignores case. The keyword must be at least 3 characters in length.\nd) Return to main menu");
				secondChoice = keyboard.next().toUpperCase().charAt(0);
					
						if(secondChoice == 'A' ){ //greater or equal then given number
							greaterOrEqual(keyboard);
						}
						if(secondChoice == 'B' ){
							LessOrEqual(keyboard);
						}
						if(secondChoice == 'C' ){
							System.out.print("Enter beer name:");
							searchFreeText(keyboard);
						}
						if(secondChoice == 'D' ){
							mainMenu(keyboard);
						}
			}
	}	
	public static void selectionTwo(){
		System.out.print("a)\n\n By Highest Strenght\nb) By Lowest Strenght\nc) Return to main menu");
		System.out.print("\n\na) By Name Ascending\nb) By Name Descending\nc) Return to main menu");
		System.out.print("\n\na) Greater or equal then Certain Strenght\nb) Less or equal than a Certain Strenght\nc) By Beer Name. Note that the beer name search is a free text search. The keyword search ignores case.\n   The keyword must be at least 3 characters in lenght.\nd) Return to main menu\n\n");
	}
	public static void maxToMinByStrength(){
		double tmp;
        String tmp1 = "";
		   for (int i = 0; i < BEER_STRENGTH.length; i++) {
		       for (int j = i + 1; j < BEER_STRENGTH.length; j++) {
		           if (BEER_STRENGTH[i] > BEER_STRENGTH[j]) {
		               tmp = BEER_STRENGTH[j];
		               tmp1 = BEER_NAME[j];
		               BEER_STRENGTH[j] = BEER_STRENGTH[i];
		               BEER_NAME[j] = BEER_NAME[i];
		               BEER_STRENGTH[i] = tmp;
		               BEER_NAME[i] = tmp1;
		           }
		       }
		   }
		   for(int x = 0; x < BEER_STRENGTH.length; x++){
			System.out.println(BEER_NAME[x]   + " " +  BEER_STRENGTH[x]);
		   }
		}
	public static void minToMaxByStrength(){			
		double tmp;
        String tmp1 = "";
		   for (int i = 0; i < BEER_STRENGTH.length; i++) {
		       for (int j = i + 1; j < BEER_STRENGTH.length; j++) {
		           if (BEER_STRENGTH[i] < BEER_STRENGTH[j]) {
		               tmp = BEER_STRENGTH[j];
		               tmp1 = BEER_NAME[j];
		               BEER_STRENGTH[j] = BEER_STRENGTH[i];
		               BEER_NAME[j] = BEER_NAME[i];
		               BEER_STRENGTH[i] = tmp;
		               BEER_NAME[i] = tmp1;
		           }
		       }
		   }
		   for(int x = 0; x < BEER_STRENGTH.length; x++){
			System.out.println( BEER_NAME[x]+ " " +  BEER_STRENGTH[x]);
		   }
	}
	public static void maxToMinByName(){
		double tmp;
        String tmp1 = "";
		   for (int i = 0; i < BEER_NAME.length; i++) {
		       for (int j = i + 1; j < BEER_NAME.length; j++) {
		           if (BEER_NAME[i].compareTo(BEER_NAME[j]) > 0) {
		               tmp = BEER_STRENGTH[j];
		               tmp1 = BEER_NAME[j];
		               BEER_STRENGTH[j] = BEER_STRENGTH[i];
		               BEER_NAME[j] = BEER_NAME[i];
		               BEER_STRENGTH[i] = tmp;
		               BEER_NAME[i] = tmp1;
		           }
		       }
		   }
		   for(int x = 0; x < BEER_STRENGTH.length; x++){
			System.out.println(BEER_NAME[x]   + " " +  BEER_STRENGTH[x]);
		   }
		}
	public static void minToMaxByName(){			
		double tmp;
        String tmp1 = "";
		   for (int i = 0; i < BEER_NAME.length; i++) {
		       for (int j = i + 1; j < BEER_NAME.length; j++) {
		           if (BEER_NAME[i].compareTo(BEER_NAME[j]) < 0) {
		               tmp = BEER_STRENGTH[j];
		               tmp1 = BEER_NAME[j];
		               BEER_STRENGTH[j] = BEER_STRENGTH[i];
		               BEER_NAME[j] = BEER_NAME[i];
		               BEER_STRENGTH[i] = tmp;
		               BEER_NAME[i] = tmp1;
		           }
		       }
		   }
		   for(int x = 0; x < BEER_STRENGTH.length; x++){
			System.out.println(BEER_NAME[x]   + " " +  BEER_STRENGTH[x]);
		   }
	}
	public static void greaterOrEqual(Scanner keyboard){
		double tmp;
        String tmp1 = "";
		   double percentage;
		   System.out.println("please enter the number");
		   	while(!keyboard.hasNextDouble())
		   	{
		   		System.out.print("Please enter a number:");
		   		keyboard.next();
		   	}
		   percentage = keyboard.nextDouble();
		 	for(int x = 0; x < BEER_STRENGTH.length; x++){
		 		if(percentage <=  BEER_STRENGTH[x]){
		 			System.out.println(BEER_STRENGTH[x] + " " + BEER_NAME[x]);
		 		}
		 	}		
	}
	public static void LessOrEqual(Scanner keyboard){
		double tmp;
        String tmp1 = "";
	   double percentage;
	   System.out.println("please enter the number");
	   	while(!keyboard.hasNextDouble())
	   	{
	   		System.out.print("Please enter a number:");
	   		keyboard.next();
	   	}
	   percentage = keyboard.nextDouble();
	 	for(int x = 0; x < BEER_STRENGTH.length; x++){
	 		if(percentage >=  BEER_STRENGTH[x]){
	 			System.out.println(BEER_STRENGTH[x] + " " + BEER_NAME[x]);
	 		}
	 	}	
	}
	public static void searchFreeText(Scanner keyboard){
		
		String search = keyboard.next();
		for(int i = 0; i < BEER_NAME.length; i++){
			String beerName = BEER_NAME[i].toLowerCase();
			if(beerName.contains(search))
				System.out.println("The alcohol content of "+"\""+beerName +"\""+" is " + BEER_STRENGTH[i]+"%");
									
			search.toLowerCase();
		}
	}
}
