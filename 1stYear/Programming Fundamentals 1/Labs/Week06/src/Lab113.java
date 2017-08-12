import java.util.Scanner;

public class Lab113 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner input = new Scanner(System.in);
		
		int deg1, min1, sec1, deg2, min2, sec2;
		int sumDeg, sumMin, sumSec;
		
		String DEGREE = "\u00B0";
		System.out.println("Please provide the angle's degrees");
			deg1 = input.nextInt();
		System.out.println("Please provide the angle's minutes");
			min1 = input.nextInt();
		System.out.println("Please provide the angle's seconds");
			sec1 = input.nextInt();
		System.out.println("Please provide the angle's degrees");
			deg2 = input.nextInt();
		System.out.println("Please provide the angle's minutes");
			min2 = input.nextInt();
		System.out.println("Please provide the angle's seconds");
			sec2 = input.nextInt();

			sumSec = sec1 + sec2;
			sumMin = min1 + min2 + sumSec/60;
			sumSec %= 60;
			sumDeg = deg1 + deg2 + sumMin/60;
			sumMin %= 60;
			sumDeg %= 360;
			
		System.out.println(deg1 + DEGREE + min1 + "\""+ sec1 + "\'");
		System.out.println(deg2 + DEGREE + min2 + "\""+ sec2 + "\'");
		System.out.println("=====================================");
		System.out.println(sumDeg + DEGREE + sumMin + "\""+ sumSec + "\'");


	}

}
