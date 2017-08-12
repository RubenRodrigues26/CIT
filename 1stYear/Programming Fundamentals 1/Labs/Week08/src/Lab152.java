import java.util.Scanner;

public class Lab152 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Scanner input = new Scanner(System.in);
		
		
		System.out.println("Chose a odd number?");
		int x  = input.nextInt();
		
		for (int k = 1; k <= 5 ; k += 1)
		{
			if (k==5)
			System.out.print(k+"="+(k+5+x));
			else
				System.out.print(k+"+");
		}

			
	
	}

}
