import java.util.Scanner;

/**
 * This program reads a sequence of daily high temperatures into an array
 * and determines the average and number of days that were above average.
 */
public class WeatherArray {

	public static void main(String[] args) {
		
		int numDays, numAboveAverage;
		double[] temperatures;
		double average;
		
		Scanner keyboard = new Scanner(System.in);
		
		// get number of days
		System.out.print("How many days\' temperatures? ");
		numDays = readPositiveInt(keyboard);
		
		// read daily values into temperatures array
		temperatures = getTemperatures(keyboard, numDays);
		
		// get average temperature
		average = getAverage(temperatures);
		
		// get number of days above average
		numAboveAverage = getNumAbove(temperatures, average);
		
		System.out.printf("Average temp = %.1f\n", average);
		System.out.println(numAboveAverage + " days were above average.");
		
		keyboard.close();

	}
	
	/**
	 * Read (and validate) a positive integer from the keyboard
	 * @param keyboard Scanner object to read from keyboard
	 * @return Positive integer input from user
	 */
	public static int readPositiveInt(Scanner keyboard) {
		int input;
		boolean valid = false;
		do
		{
			input = readInt(keyboard);
			if (input <= 0)
				System.out.print("Invalid input! Enter a positive integer: ");
			else
				valid = true;
		} while(!valid);
		return input;
	}
	
	/**
	 * Read (and validate) an integer from the keyboard
	 * @param keyboard Scanner object to read from keyboard
	 * @return Integer input from user
	 */
	public static int readInt(Scanner keyboard) {
		while(!keyboard.hasNextInt())
		{
			keyboard.next(); // consume invalid input
			System.out.print("Invalid input! Enter an integer: ");
		}
		return keyboard.nextInt();
	}
	
	/**
	 * Read daily high temperatures into an array
	 * @param keyboard Scanner object to read from keyboard
	 * @param numDays Number of days to be read
	 * @return Temperatures array
	 */
	public static double[] getTemperatures(Scanner keyboard, int numDays) {
		double[] temperatures = new double[numDays];
		for(int i = 1; i <= numDays; i++)
		{
			System.out.print("Day " + i + "\'s high temp: ");
			temperatures[i - 1] = readDouble(keyboard); // note: index = i - 1, not i
		}
		return temperatures;
	}
	
	/**
	 * Read (and validate) a double from the keyboard
	 * @param keyboard Scanner object to read from keyboard
	 * @return Numeric input from user
	 */
	public static double readDouble(Scanner keyboard) {
		while(!keyboard.hasNextDouble())
		{
			keyboard.next(); // consume invalid input
			System.out.print("Invalid input! Enter a numeric value: ");
		}
		return keyboard.nextDouble();
	}
	
	/**
	 * Get the average value of an array of numeric elements
	 * @param array Array to be averaged
	 * @return Average value
	 */
	public static double getAverage(double[] array) {
		return getTotal(array) / array.length;
	}
	
	/**
	 * Get the total of an array of numeric elements
	 * @param array Array to be totaled
	 * @return Total value
	 */
	public static double getTotal(double[] array) {
		double total = 0;
		for(int i = 0; i < array.length; i++)
			total += array[i];
		return total;
	}
	
	/**
	 * Get the number of elements in an array above a given value
	 * @param array Array of elements to be tested
	 * @param value Value against which elements of array are to be tested
	 * @return Number of elements in the array greater than the given value
	 */
	public static int getNumAbove(double[] array, double value) {
		int num = 0;
		for(int i = 0; i < array.length; i++)
		{
			if(array[i] > value)
				num++;
		}
		return num;
	}

}
