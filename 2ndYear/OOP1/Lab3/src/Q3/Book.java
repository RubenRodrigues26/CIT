package Q3;
/**
 *@Author (Ruben Rodrigues) 
 *@ID (R00144165)
 */
public class Book {
	private String title;
	private int ISBN;
	private String author;
	private double price;
	//Constructor
	public Book(String title, int ISBN, String author, double price){
		this.title=title;
		this.ISBN=ISBN;
		this.author=author;
		this.price=price;
	}
	//Setters
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
	//Getters
	public String getTitle(){
		return this.title;
	}
	public int getISBN(){
		return this.ISBN;
	}
	public String getauthor(){
		return this.author;
	}
	public double price(){
		return this.price;
	}
	
}
