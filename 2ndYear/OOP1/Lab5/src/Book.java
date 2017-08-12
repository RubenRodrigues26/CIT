

public class Book {
	private String title;
	private int ISBN;
	private String author;
	private double price;
	
	public Book(String title, int ISBN, String author, double price){
		this.title=title;
		this.ISBN=ISBN;
		this.author=author;
		this.price=price;
	}
	public void settitle(String title){
		this.title = title;
	}
	public void setISBN(int ISBN){
		this.ISBN = ISBN;
	}
	public void setauthor(String author){
		this.author = author;
	}
	public void setprice(double price){
		this.price = price;
	}
	
	public String getTitle(){
		return this.title;
	}
	public int getISBN(){
		return this.ISBN;
	}
	public String getauthor(){
		return this.author;
	}
	public double getPrice(){
		return this.price;
	}
	
}
