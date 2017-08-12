// Reads hours worked for several TAs (Teaching Assistants) and reports their overall hours worked 
import java.io.*;
import java.util.*;

/* File structure:
123 Mick 12.5 8.1 7.6 3.2
456 John 4.0 11.6 6.5 2.7 12
789 Richard 8.0 8.0 8.0 8.0 7.5
*/

public class HoursWorked {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner input = new Scanner(new File("hours.txt"));
		Scanner console = new Scanner(System.in);
		
		System.out.print("Enter ID: ");
		int id = console.nextInt();
		
		String line = findEmployee(input, id);
		if (line.length() != 0) {
			processTAHours(line, System.out); // System.out is a PrintStream object!
		} else {
			System.out.println("Not found!");
		}
	}
	
	public static String findEmployee(Scanner input, int id) {
		while (input.hasNextLine()) {
			String line = input.nextLine();
			Scanner lineScan = new Scanner(line);
			int lineID = lineScan.nextInt();
			
			if (id == lineID) {
				return line;
			}
		}
		return "";
	}
	
	// reads and reports hours worked for a single TA
	public static void processTAHours(String line, PrintStream out) {
		Scanner lineScan = new Scanner(line);
		
		int userId = lineScan.nextInt();
		String name = lineScan.next();
		
		double hoursWorked = 0;
		while (lineScan.hasNextDouble()) {
			hoursWorked = hoursWorked + lineScan.nextDouble();
		}
		
		out.println(name + " ID#" + userId + " worked " + round(hoursWorked, 1) + " hours");	
	}
		
	// rounds the value to the specified places
	public static double round(double value, int places) {
		return Math.round(value * Math.pow(10, places)) / Math.pow(10, places);
	}
}