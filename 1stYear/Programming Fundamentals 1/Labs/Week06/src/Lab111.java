import java.util.Scanner;

public class Lab111 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		String firstName1;
		String surName1;
		String firstName2;
		String surName2;
		
		Scanner input = new Scanner (System.in);
		
		System.out.println("What is your fisrt and surname?");
			firstName1 = input.next();
			surName1 = input.nextLine();
		System.out.println("What is your fisrt and surname?");
			firstName2 = input.next();
			surName2 = input.nextLine();
			
		
		if (firstName1 == firstName2 && surName1 == surName2)
			System.out.println(surName1+", "+firstName1+" given twice.");
			
			else if (firstName1 == firstName2 || surName1 == surName2);
			System.out.println(surName1+", "+firstName1+"\n"+surName2+", "+firstName2);
		
		
	}

}
