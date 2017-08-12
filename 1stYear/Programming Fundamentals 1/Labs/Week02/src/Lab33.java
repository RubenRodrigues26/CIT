import java.util.Scanner;

public class Lab33 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String FIRST_NAME;
		char MIDDLE_INITIAL;
		String SURNAME;
		int age;

		Scanner input = new Scanner(System.in);
		
		
		System.out.println("Whats your age?");
			age = input.nextInt();
		System.out.println("You are "+(age + 1) +"in 2016!\n");
		
		System.out.println("Whats your fisrt name?");
			FIRST_NAME = input.next();
		System.out.println("Whats your middle inicial?");
			MIDDLE_INITIAL = input.next().charAt(0);
		System.out.println("Whats your surname?");
			SURNAME = input.next();
		
			input.close();
		
		System.out.println(FIRST_NAME +" "+ MIDDLE_INITIAL + ". " + SURNAME);
		
		
		
		
		
	}

}
