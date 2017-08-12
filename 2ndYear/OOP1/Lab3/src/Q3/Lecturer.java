package Q3;
/**
 *@Author (Ruben Rodrigues) 
 *@ID (R00144165)
 */
public class Lecturer {
	private String name;
	private int ID;
	private BookList books = new BookList();
	private int MAXNOOFBOOKS = 15;
	
	public Lecturer(String name, int ID){
		this.name=name;
		this.ID=ID;
	}
	public String getName(){
		return this.name;
	}
	public int getID(){
		return this.ID;
	}
	
	public void addBook(Book book){
		books.addBook(book);	
	}
	public BookList getBookList(){
		return this.books;
	}
	
	public String toString(){
		return "Name: " + this.getName() +
				"\nId: "+ this.getID() +
				"\nMaximum number of books "+MAXNOOFBOOKS;				
	}
	
	void print(){
		System.out.println(this.toString());
	}
}	