package Q1;
/**
 *@Author (Ruben Rodrigues) 
 *@ID (R00144165)
 */
abstract class Employee {
	private String number;
	private String name;
	private double annualSalary;
	
	
	public Employee(String number, String name){
		this.name = name;
		this.number = number;
	}
		
	public String getName(){
		return this.name;
	}
	
	public String getNumber(){
		return this.number;
	}
	//abstract method so we have to overwrite and write code for each subclass	
	abstract String getStatus();
}