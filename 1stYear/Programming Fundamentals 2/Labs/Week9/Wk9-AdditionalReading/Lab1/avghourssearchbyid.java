// This program searches an input file of employees' hours worked
// for a particular employee and outputs that employee's hours data.

import java.io.*;    // for File
import java.util.*;  // for Scanner

public class avghourssearchbyid {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner console = new Scanner(System.in);
        System.out.print("Enter an ID: ");
        int searchId = console.nextInt();       // e.g. 456
        
        Scanner input = new Scanner(new File("hours.txt"));
        String line = findPerson(input, searchId);
        if (line.length() > 0) {
            processLine(line);
        } else {
            System.out.println("ID #" + searchId + " was not found");
        }
        
        console.close();
        input.close();
    }
// Locates and returns the line of data about a particular person.
    public static String findPerson(Scanner input, int searchId) {
        while (input.hasNextLine()) {
            String line = input.nextLine();
            Scanner lineScan = new Scanner(line);
            int id = lineScan.nextInt();          // e.g. 456
            
            lineScan.close();
            if (id == searchId) {
                return line;                      // we found them!
            }
            
        }
        return "";           // not found, so return an empty line
        
    }

    // Totals the hours worked by the person and outputs their info.
    public static void processLine(String line) {
        Scanner lineScan = new Scanner(line);
        int id = lineScan.nextInt();              // e.g. 456
        String name = lineScan.next();            // e.g. "Brad"
        double hours = 0.0;
        int days = 0;
        while (lineScan.hasNextDouble()) {
            hours += lineScan.nextDouble();
            days++;
        }

        System.out.println(name + " worked " + hours + " hours ("
                + (hours / days) + " hours/day)");
        
        lineScan.close();
    }
    
}    
    