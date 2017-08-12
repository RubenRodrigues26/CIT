import java.util.Scanner;

public class Lab91 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner input = new Scanner (System.in);
		
		String	teamName1;
		int	tries1;
		int	conversions1;
		int	goals1;
		int	penalties1;
		int	totalPoints1;
		String	teamName2;
		int	tries2;
		int	conversions2;
		int	goals2;
		int	penalties2;
		int	totalPoints2;
		
		System.out.println("Team 1 name?");
			teamName1 = input.nextLine();
		System.out.println("Tries?");
			tries1 = input.nextInt();
		System.out.println("Conversions?");
			conversions1 = input.nextInt();
		System.out.println("Goals?");
			goals1 = input.nextInt();
		System.out.println("Penalties?");
			penalties1 = input.nextInt();
			totalPoints1 = tries1*5+conversions1*2+goals1*3+penalties1*3;
		System.out.println("Total score for Team 1 is "+totalPoints1+".");
		
			input.nextLine();
		
		System.out.println("Team 2 name?");
			teamName2 = input.nextLine();
		System.out.println("Tries?");
			tries2 = input.nextInt();
		System.out.println("Conversions?");
			conversions2 = input.nextInt();
		System.out.println("Goals?");
			goals2 = input.nextInt();
		System.out.println("Penalties?");
			penalties2 = input.nextInt();
			totalPoints2 = tries2*5+conversions2*2+goals2*3+penalties2*3;
		System.out.println("Total score for Team 2 is "+totalPoints2+".");
		
		input.close();
		
		if (totalPoints1>totalPoints2)
			System.out.println("The winner is "+teamName1+".");
		
			else if(totalPoints1<totalPoints2)
				System.out.println("The winner is "+teamName2+".");
				
				else 
					System.out.println("It's a tie");
					
					
	}

}
