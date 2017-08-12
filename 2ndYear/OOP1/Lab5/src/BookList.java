import java.util.ArrayList;

public class BookList {
	
	ArrayList<Book> listOfBooks ;
	private int MAXNOOFBOOKS;
	
	public BookList(int i){
		listOfBooks = new ArrayList<Book>();	
		MAXNOOFBOOKS = i;
	}
	public BookList(){
		listOfBooks = new ArrayList<Book>();
	}
	public Book getBook(int i) {
		Book b1 = null;
		return b1;
	}
	
	public Book search(int i ){
		Book b1 = null;
		return b1;
	}
	
	public boolean removeBook(Book book){
		return true;
	}
	
	public double calculateYearlyBookPayment(){
		double payment=0;
		for(Book b : listOfBooks){
			payment+=b.getPrice();
		}
			
		
		return payment;
	}
		
	public void addBook(Book book) {
		
		if(listOfBooks.size()>=MAXNOOFBOOKS){
			System.out.println("Lecturer has as a maximum of " +MAXNOOFBOOKS+ " books");
		} else{
			listOfBooks.add(book);
		}
		
	}
	
	//returns the employee object where the number matches
	public Book findBookByTitle(String title){
		Book emp = null;
		for(Book e:listOfBooks){
			if(e.getTitle().toUpperCase().equals(title.toUpperCase())){
				emp = e;
			}
		}
		
		return emp;
	}

}
