package Q3;
/**
 * Ruben Rodrigues
 * R00144165
 */
import java.util.ArrayList;

public class BookList {

	ArrayList<Book> listOfBooks;
	
	public BookList(){
		listOfBooks = new ArrayList<Book>();
	}
	//Adding to the Arraylist (listOfBooks) with whatever information is passed when a new Book object is created
	public void addBook(Book book) {
		listOfBooks.add(book);
	}

}
