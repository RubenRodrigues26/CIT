package Q2;
/**
 *@Author (Ruben Rodrigues) 
 *@ID (R00144165)
 */
public class test {

	
	public static void main(String[] args) {
			
		//Declaring objects and the values in them
		Person person1 = new Person("John", 40 , "Cork");
		Cat cat1 = new Cat("Felix" , 7);
		//Adding to the ArrayList
		person1.addPet(cat1);
		
		cat1.setOwner(person1);
		//Only used to see if we are successfully adding to the ArrayList
		System.out.println(person1.isEmpty()); 
		person1.print();

	}

}
