import java.util.Scanner;

public class Lab151 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Scanner input = new Scanner(System.in);
		
		
		System.out.println("Chose a odd number?");
		int anyNumber = input.nextInt();
		
		for (int k = 1; k <= anyNumber ; k += 1)
		{
			if (k==anyNumber)
			System.out.print(k);
			else
				System.out.print(k+", ");
		}

		
			
	}

}
