package Q1;
/**
 *@Author (Ruben Rodrigues) 
 *@ID (R00144165)
 */
public class TestEmployee {

	public static void main(String[] args) {
		
		EmployeeList emp1 = new EmployeeList();
		
		FullTimeEmployee full1 = new FullTimeEmployee("john","R12434632",23000);
		FullTimeEmployee full2 = new FullTimeEmployee("kevin","R12438452",25000);
		PartTimeEmployee part1 = new PartTimeEmployee("sarah","R12784472",22.5);
		PartTimeEmployee part2 = new PartTimeEmployee("rachel","R1240052",24.5);
		
		emp1.addEmployee(full1);
		emp1.addEmployee(full2);
		emp1.addEmployee(part1);
		emp1.addEmployee(part2);

		emp1.print();
	}

}
