
import java.util.Scanner;

public class Q1_99Bottles {

	public static void main(String[] args) {
		
		int beerNum;
		String word = "bottles";
		Scanner input = new Scanner(System.in);
		
		//input for the number of "bottles  on the wall"
		System.out.println("How many bottles on the wall?");
		beerNum = input.nextInt();
		
		//starting loop to run the 99 bottles decreasing by1 in the end
		while (beerNum > 0) {
		 
			System.out.println(beerNum + " " + word + " of beer on the wall");
			System.out.println(beerNum + " " + word + " of beer.");
			System.out.println("Take one down.");
			System.out.println("Pass it around.");
			System.out.println("");
			beerNum = beerNum - 1;//decreasing bottles
		                         
		if (beerNum == 1) {
		word = "bottle";  // singular, as in ONE bottle.
			}              
		//Condition to change bottles to singular when bottles reach 1
		if (beerNum > 0) {
		System.out.println(beerNum + " " + word + " of beer on the wall");
		System.out.println("");
		} 
		
			else {
		System.out.println("No more bottles of beer on the wall.");
			}  // end else
		} // end while loop
		input.close();
	}  // end main method
}  // end class
