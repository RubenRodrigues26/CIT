import java.util.Scanner;

public class Lab51 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner keyboard = new Scanner(System.in);
			
			System.out.println("Radius?");
		
		double radius = keyboard.nextDouble();
		double circumference = 2 * Math.PI * radius;
		
			System.out.println("The circumference is " + circumference);
		
			keyboard.close();

		
		
	}

}
