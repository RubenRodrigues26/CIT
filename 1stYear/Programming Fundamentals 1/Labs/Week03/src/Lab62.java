import java.util.Scanner;

public class Lab62 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Radians?");
	    	double radians = keyboard.nextDouble();
		
	    System.out.println("Math.sin:"+Math.sin(radians)+"\nMath.cos:"+Math.cos(radians));
		
	    keyboard.close();
	}

}
