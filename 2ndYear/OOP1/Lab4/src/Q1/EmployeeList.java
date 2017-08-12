package Q1;
/**
 *@Author (Ruben Rodrigues) 
 *@ID (R00144165)
 */
import java.util.ArrayList;

public class EmployeeList {
	ArrayList<Employee> employees;
	
	public EmployeeList(){
		//arraylist instantiation 
		employees = new ArrayList<Employee>();
	}
	
	//add a new employee object to our arraylist
	public void addEmployee(Employee emp){
		employees.add(emp);
	}
	
	//remove an employee object from our arraylist based on the index	
	public boolean removeEmployee(Employee emp){
		//returns a boolean if the object is found in the list and removed
		return employees.remove(emp);
	}
	
	public String toString(){
		String output = "";
		
		for(Employee emp:employees){
			output += "\n======================\n"+
					"Name: "+emp.getName()+"\nNumber: "+emp.getNumber()+"\nStatus: "+emp.getStatus();
			if(emp instanceof FullTimeEmployee){
				FullTimeEmployee fullEmp = (FullTimeEmployee)emp;
				output += "\nAnnual Salary: "+fullEmp.getAnnualSalary()+"\nMonthly Pay:"+Math.round(fullEmp.calculateMonthlyPay()*100)/100;
			}
			else if(emp instanceof PartTimeEmployee){
				PartTimeEmployee partEmp = (PartTimeEmployee)emp;
				output += "\nHourly Salary: "+partEmp.getHourlyPay()+"\nThis weeks wages: "+partEmp.calculateWeeklyPay();
			}			
		}
		
		return output;
	}
	
	void print(){
		System.out.print(this.toString());
	}
}
