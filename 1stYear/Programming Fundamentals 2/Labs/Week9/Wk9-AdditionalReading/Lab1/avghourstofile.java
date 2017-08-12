// Processes an employee input file and outputs each employee's hours.
import java.io.*;    // for File
import java.util.Scanner;  // for Scanner

public class avghourstofile {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("hours.txt"));
        PrintStream out = new PrintStream(new File("hours_out.txt"));
        while (input.hasNextLine()) {
            String line = input.nextLine();
            Scanner lineScan = new Scanner(line);
            int id = lineScan.nextInt();          // e.g. 456
            String name = lineScan.next();        // e.g. "Eric"
            double sum = 0.0;
            int count = 0;
            while (lineScan.hasNextDouble()) {
                sum = sum + lineScan.nextDouble();
                count++;
            }

            double average = sum / count;
            out.println(name + " (ID#" + id + ") worked " +
                        sum + " hours (" + average + " hours/day)");
            
            lineScan.close();
        }
        
        input.close();
    }
}
