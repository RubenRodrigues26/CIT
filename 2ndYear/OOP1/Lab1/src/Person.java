
public class Person {

	private int stars;
	private String phone;
	private String name;
	
	
	Person(int stars, String phone, String name){
		// this.stars = i; // or:
		setStars(stars);
		setPhone(phone);
		setName(name);
	}
	
	void jump(){
		System.out.println("I jumped");
	}
	
	void jump(int jumps){
		System.out.println("I jumped " + jumps + " times!" );	
	}
	
	public String toString(){
		return 	"Name value is " + getName() +
				"\nStars value is " + getStars() +
				"\nPhone value is " + getPhone();	
	}
	
	void print(){
		System.out.print(this.toString());
	}
	
	// Setters
	public void setStars(int stars){
		this.stars = stars;
	}
	
	public void setPhone(String phone){
		this.phone = phone;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	//Getters
	public int getStars(){
		return this.stars;
	}
	public String getPhone(){
		return this.phone;
	}
	public String getName(){
		return this.name;
	}	
}
