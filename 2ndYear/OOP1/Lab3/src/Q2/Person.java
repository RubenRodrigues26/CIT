package Q2;
/**
 *@Author (Ruben Rodrigues) 
 *@ID (R00144165)
 */
import java.util.ArrayList;

public class Person {

	private String name;
	private int age;
	private String address;
	ArrayList<Cat> pets;	
	
	public Person(String name, int age, String address){
		this.name=name;
		this.age=age;
		this.address=address;
		pets = new ArrayList<Cat>();
	}
	//Setters
	public void setName(String name){
		this.name=name;
	}
	public void setAge(int age){
		this.age=age;
	}
	public void setAddress(String address){
		this.address=address;
	}
	//Getters
	public String getName(){
		return this.name;
	}
	public int getAge(){
		return this.age;
	}
	public String getAddress(){
		return this.address;
	}
	//This method restricts the array so that it doesn't accept more than 20 positions (pets)
	public void addPet(Cat cat){
		
		if(pets.size()>=20){
			System.out.println("Owner has as a max of 20 pets.");
		} else{
			pets.add(cat);
		}
	}
	//This method will show that we are adding cats successfully
	public boolean isEmpty(){
		
		return pets.isEmpty();
	}
	public String toString(){
		return "Name: " + this.getName() +
				"\nAge: "+ this.getAge() +
				"\nAddress: "+this.getAddress();				
	}
	void print(){
		System.out.println(this.toString());
	}
}