//Ruben Rodrigues R00144165

import java.util.Scanner;
public class Cruise4 {

	public static void main(String[] args) {

		//Initiate variables & keyboard
		Scanner input = new Scanner(System.in);
		String firstName ="";
		String surName="";
		String accommodation="";
		String customerInfo="";
		String newOrder="";
		int	numberDays;
		int accommodationType;
		int numberOfPassengers = 0;
		int firstNameLength;
		int surnameLength;
		int days;
		final int BASIC=200;
		final int STANDARD=250;
		final int PREMIUM=350;
		int total;
		int totalCost;
		char initialFirst ;
		final double cashDiscount = 0.10;
		double discountedPrice = 0;

		
		//Use do loop if booking for more passengers
		do{
			//use do loop to validate if first name has at least 1 character if not ask for surname again
			do {
				//Asking for information and saving into the input
				System.out.println("Enter your first name?");
					firstName = input.next();
					initialFirst = firstName.charAt(0);
					initialFirst = Character.toUpperCase(initialFirst);
					
					//Calculate length of the first name
					firstNameLength = firstName.length();
				if (firstNameLength < 1){
					System.out.print("First name has to be at least 1 character long!!!");
			}
				while (firstNameLength < 0);
					
			//use do loop to validate if surname has at least 1 character if not ask for surname again
			do {		
				System.out.println("Enter your  surname?");
					surName = input.next();
					
					//Calculate length of the surname
					surnameLength = surName.length();
				if (surnameLength < 0){
				System.out.print("Surname has to be at least 1 character long!!!\n");
				}
			}
				while (surnameLength < 1);	
			//Ensure that the number of days entered is an integer and greater than 0
			do {
			System.out.println("Enter how many days you are staying?");
				numberDays = input.nextInt();
				
				// clear keyboard
				input.nextLine();
			}
				//Validating if entered number is integer
				while (! input.hasNextInt());
				{
					// clear keyboard
					input.nextLine();	
					
				System.out.println("Enter how many days you are staying?");
					numberDays = input.nextInt();
			
				}
				//Number of days save to days
				days = input.nextInt();
			}
			//If negative number entered for days repeat question again
			while (days <= 0);

			//Display types of accommodation and ask which one do they prefer and save to accommodationType
			System.out.println("Enter type of accommodation?\n1.Basic\n2.Standard\n3.Premium");
				accommodationType = input.nextInt();

			//use if statement to determine cost per day	
			if(accommodationType == 1)
				{
				accommodationType = BASIC;
				accommodation="Basic";
				}
			else if (accommodationType == 2)
				{
					accommodationType = STANDARD ;
					accommodation="Standard";
				}
			else if (accommodationType == 3){
						accommodationType = PREMIUM;
						accommodation="Premium";}
			else{
			System.out.println("Please enter a number between 1 and 3.");
				} 
				//Calculate total cost ad save to cost
				total = accommodationType*numberDays;
				//Saving all the information in the variable customerInfo
				customerInfo += initialFirst+"."+"\t"+surName+"    \t"+numberDays+"\t"+accommodation+"\t"+total+"\n";
					
			System.out.println("Would you like to enter the details for another passenger? (Y/N):");
				newOrder = input.next();
				
				numberOfPassengers += 1;
					
				}while (newOrder.charAt(0) != 'N' && newOrder.charAt(0) != 'n');

					//Display summary of the bill
					System.out.println("Wild Atlantic Cruise Booking Details\n"
						+ "--------------------------------------\n"
						+ "Name\tSurname\t\tDays\tType\t\tCost");
			
					System.out.println(customerInfo);
						//Calculate total in case there more than one customer cost ad save to cost
						totalCost = total += accommodationType*numberDays;
						
					System.out.println("Total Cost(\u20ac):"+totalCost);
					//Calculate 10% discount if there more than or 3 passengers 
					if (numberOfPassengers >=3){
						discountedPrice = totalCost * cashDiscount;
						System.out.print("Total Cost After Discount (10.0%) (€): " + (totalCost-discountedPrice));
					}
		
				input.close();
	}

}