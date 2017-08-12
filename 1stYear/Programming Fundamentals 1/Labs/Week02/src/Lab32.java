
public class Lab32 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		float  hoursWorked = 32.5f;
		final double HOURLY_RATE = 9.35;
		double wages;
		final double TAX_RATE = 0.22;
		double taxDue;
		double takeHome;
		
		
		
		wages = HOURLY_RATE * hoursWorked;
		taxDue = TAX_RATE * wages;
		takeHome = wages - taxDue;
		
		System.out.println(wages = HOURLY_RATE * hoursWorked);
		System.out.println(taxDue = TAX_RATE * wages);
		System.out.println(takeHome = wages - taxDue);
		
		
		
	}

}
