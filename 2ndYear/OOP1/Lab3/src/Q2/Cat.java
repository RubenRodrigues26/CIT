package Q2;
/**
 *@Author (Ruben Rodrigues) 
 *@ID (R00144165)
 */
public class Cat{
	private String name;
	private int age;
	private Person owner ;
	
	
	public Cat(String name, int age){
		this.name=name;
		this.age=age;
	}
	
	//Setters
	public void setName(String name){
		this.name=name;
	}
	public void setAge(int age){
		this.age=age;
	}
	public void setOwner(Person p1){
		this.owner = p1;		
	}
		
	//Getters
	public String getName(){
		return this.name;
	}
	public int getage(){
		return this.age;
	}
		public Person getOwner(){
		return this.owner;
		
	}
}