//Ruben Rodrigues R00144165

import java.util.Scanner;
public class Cruise2 {

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
		final int BASIC=200;
		final int STANDARD=250;
		final int PREMIUM=350;
		int total;
		int totalCost;
		char initialFirst ;

		
		//Start of the "do" loop which will run until the "while" is true
		do{
			//Asking for information and saving into the input
			System.out.println("Enter your first name?");
				firstName = input.next();
				initialFirst = firstName.charAt(0);
				initialFirst = Character.toUpperCase(initialFirst);
			System.out.println("Enter your  surname?");
				surName = input.next();
			System.out.println("Enter how many days you are staying?");
				numberDays = input.nextInt();
				
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
					
				}while (newOrder.charAt(0) != 'N' && newOrder.charAt(0) != 'n');

					//Display summary of the bill
					System.out.println("Wild Atlantic Cruise Booking Details\n"
						+ "--------------------------------------\n"
						+ "Name\tSurname\t\tDays\tType\t\tCost");
			
					System.out.println(customerInfo);
						//Calculate total in case there more than one customer cost ad save to cost
						totalCost = total += accommodationType*numberDays;
					System.out.println("Total Cost(\u20ac):"+totalCost);

				input.close();
	}

}
