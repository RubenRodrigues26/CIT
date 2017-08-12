// input:
// 1 9.1 243153 The Godfather (1972)
//
// output:
// Search word? part 
// Rank    Votes   Rating  Title
// 2       139085  9.0     The Godfather: Part II (1974)
// 40      129172  8.5     The Departed (2006)
// 95      20401   8.2     The Apartment (1960)
// 192     30587   8.0     Spartacus (1960)
import java.io.*;
import java.util.*;

public class IMDBSearcher {
	public static void main(String[] args) throws FileNotFoundException {
		System.out.println("This program will allow you to search the");
		System.out.println("imdb top 250 movies for a particular phrase.");
		System.out.println();
		
		Scanner console = new Scanner(System.in);
		System.out.print("Search phrase: ");
		String search = console.nextLine().toLowerCase();
		
		Scanner input = new Scanner(new File("imdb.txt"));
		// 1 9.1 243153 The Godfather (1972)

		while (input.hasNextLine()) {
			String line = input.nextLine();
			if (line.toLowerCase().contains(search)) {
				//System.out.println(line);
				displayMovieInfo(line);
			}
		}
	}
	
	public static void displayMovieInfo(String line) {
		Scanner lineScan = new Scanner(line);
		int rank = lineScan.nextInt();
		double rating = lineScan.nextDouble();
		lineScan.nextInt();
		
		String title = "";
		while (lineScan.hasNext()) {
			title = title + lineScan.next() + " ";
		}
		System.out.println(rank + "\t" + rating + "\t" + title);
	}
}