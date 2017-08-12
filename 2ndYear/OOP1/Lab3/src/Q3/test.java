package Q3;
/**
 *@Author (Ruben Rodrigues) 
 *@ID (R00144165)
 */
public abstract class test {

	public static void main(String[] args) {
		
		Lecturer lecturer1 = new Lecturer("John",21);
		Book book1 = new Book("Rickson",56853,"cona",29.99);
		
		lecturer1.addBook(book1);
		lecturer1.print();

	}

}