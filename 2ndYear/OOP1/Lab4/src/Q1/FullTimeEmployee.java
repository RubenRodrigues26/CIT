package Q1;
/**
 *@Author (Ruben Rodrigues) 
 *@ID (R00144165)
 */
//this class extends employee so it inherits its variables and methods
public class FullTimeEmployee extends Employee{
	private double annualSalary;
	
	//we have to setup the parent so we call super to call our parent constructor
	public FullTimeEmployee(String name, String number, double salary){
		super(name,number);
		setAnnualSalary(salary);
	}
	
	public void setAnnualSalary(double salary){
		this.annualSalary = salary;
	}	
	
	public double getAnnualSalary(){
		return this.annualSalary;
	}
	
	public double calculateMonthlyPay(){
		return this.annualSalary/12;
	}
	
	public String getStatus()
	{
	  return "Full-Time";
	}

}
