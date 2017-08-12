package Q1;
/**
 *@Author (Ruben Rodrigues) 
 *@ID (R00144165)
 */
//this class extends employee so it inherits its variables and methods
public class PartTimeEmployee extends Employee{
	private double hourlyPay;
	private double weeklyPay;
	//we have to setup the parent so we call super to call our parent constructor
	public PartTimeEmployee(String name, String number, double hourlyPay){
		super(name,number);
		setHourlyPay(hourlyPay);
	}
	
	public void setHourlyPay(double hourlyPay){
		this.hourlyPay = hourlyPay;
	}
		
	public double getHourlyPay(){
		return this.hourlyPay;
	}
	
	public double calculateWeeklyPay(){
		return this.weeklyPay = hourlyPay*20;	
	}
	
	public void setWeeklyPay(){
		this.weeklyPay = hourlyPay;
	}
	public double getWeeklyPay(){
		return this.weeklyPay;
	}
	public String getStatus()
	{
	  return "Part-Time";
	}

}
