import java.util.Random;

public class Lab112 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
	Random random = new Random();
		
		
	System.out.println("How about do you wanna be?");
	int randomInt = random.nextInt(7);
		

	switch (randomInt)
	{
		case 1: System.out.println("It is certain."); break;
		case 2: System.out.println("Without a doubt."); break;
		case 3: System.out.println("Yes."); break;
		case 4: System.out.println("Reply hazy, try again."); break;
		case 5: System.out.println("Outlook not so good."); break;
		case 6: System.out.println("No."); break;
		
	}
		
	}


}
