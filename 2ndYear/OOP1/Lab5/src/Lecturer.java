public class Lecturer {
	private String name;
	private int ID;
	private int MAXNOOFBOOKS = 15;
	private BookList books = new BookList(MAXNOOFBOOKS);
	
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
		return "Name is " + this.getName() +
				"\nId is "+ this.getID() +
				"\nMaximum number of books "+MAXNOOFBOOKS;				
	}
	void print(){
		System.out.println(this.toString());
	}
	public double calculateYearlyBookPayment() {
		return books.calculateYearlyBookPayment(); 
	}
	public boolean contains(int ID) {
		
		return false;
	}

}	