import java.util.Scanner;

public class Lab71 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String firstName;
		String lastName;
		String fullName;
		char firstInitial;
		char lastInitial;
		
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("What is your first name?");
			firstName = keyboard.next();
		System.out.println("What is your surname?");
			lastName = keyboard.next();
			
		firstInitial = firstName.charAt(0);
		lastInitial = lastName.charAt(0);
		firstInitial = Character.toUpperCase(firstInitial);
		lastInitial = Character.toUpperCase(lastInitial);
		
		System.out.println(firstInitial + "." + lastInitial + ".");	
		System.out.println(firstName.toUpperCase() + " " +lastName.toUpperCase() );
		System.out.println(firstName.length()+lastName.length());
		

		keyboard.close();
		

		
		
		
	}

}

