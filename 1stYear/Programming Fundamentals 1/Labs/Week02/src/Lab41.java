import java.util.Scanner;

public class Lab41 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		double milesDriven, gallonsUsed, mpg;
		Scanner input = new Scanner (System.in);
		
		System.out.println("Program to calculate mileage.\n");
		System.out.println("How many miles did you drive?");
		
		milesDriven = input.nextDouble();
		
		System.out.println("How many gallons did you take?");
		
		gallonsUsed = input.nextDouble();
		mpg = milesDriven / gallonsUsed;
		
		System.out.println("Your miles per gallon usage was "+mpg+"."+ "\n");
		System.out.println("You traveled "+milesDriven+" miles and used "+gallonsUsed+" gallons of fuel.");
		
			input.close();
	}

}
