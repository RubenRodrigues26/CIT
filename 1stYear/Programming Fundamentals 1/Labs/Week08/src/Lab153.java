import java.util.Scanner;

public class Lab153 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*HarmonicSum*/
		
Scanner input = new Scanner(System.in);
		
		
		System.out.println("Chose a odd number?");
		int x  = input.nextInt();
		int p = 1;
		for (int k = 1; k <= 5 ; k += 1)
		{
			if (k==5)
			System.out.print(k+"="+(p+k/2+5+x));
			else
				System.out.print("1"+k+"/2+");
		}

			
	
		
		
	}

}
