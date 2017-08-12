package Q2;
/**
 *@Author (Ruben Rodrigues) 
 *@ID (R00144165)
 */
public class TestRationalNumbers {

	public static void main(String[] args) {
		RationalNumber rational1 = new RationalNumber(6,10);
		RationalNumber rational2 = new RationalNumber(10,60);
		
		RationalNumber rational3 = rational1.add(rational2);
		RationalNumber rational4 = rational1.subtract(rational2);
		RationalNumber rational5 = rational1.multiply(rational2);
		RationalNumber rational6 = rational1.divide(rational2);
		
		
		//Adding
		System.out.println(rational1.getDonominator()+"     "+rational2.getDonominator()+"     "+rational3.getDonominator());
	
		System.out.println("-"+"  +  "+"-"+"  =  ");
		
		System.out.println(rational1.getNumerator()+"    "+rational2.getNumerator()+"     "+ rational3.getNumerator()+"\n\n");	
		
		//Subtracting
		System.out.println(rational1.getDonominator()+"     "+rational2.getDonominator()+"     "+rational4.getDonominator());
		
		System.out.println("-"+"  -  "+"-"+"  =  ");
		
		System.out.println(rational1.getNumerator()+"    "+rational2.getNumerator()+"     "+ rational4.getNumerator()+"\n\n");
		
		//Multiplying
		System.out.println(rational1.getDonominator()+"     "+rational2.getDonominator()+"     "+rational5.getDonominator());
		
		System.out.println("-"+"  *  "+"-"+"  =  ");
		
		System.out.println(rational1.getNumerator()+"    "+rational2.getNumerator()+"     "+ rational5.getNumerator()+"\n\n");
		
		//Dividing
		System.out.println(rational1.getDonominator()+"     "+rational2.getDonominator()+"     "+rational6.getDonominator());
		
		System.out.println("-"+"  /  "+"-"+"  =  ");
		
		System.out.println(rational1.getNumerator()+"    "+rational2.getNumerator()+"     "+ rational6.getNumerator()+"\n\n");
		
	}
}