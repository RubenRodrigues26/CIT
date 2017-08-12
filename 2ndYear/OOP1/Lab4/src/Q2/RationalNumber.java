package Q2;
/**
 *@Author (Ruben Rodrigues) 
 *@ID (R00144165)
 */
public class RationalNumber {
	private int denominator, numerator;
	
	public RationalNumber(){
		
	}
	//Instantiating properties
	public RationalNumber(int num1, int num2){
		this.denominator=num1;
		this.numerator=num2;
	}
	
	public int getDonominator(){return this.denominator;}
	
	public int getNumerator(){return this.numerator;}
	
	//Adding as required form formula
	public RationalNumber add(RationalNumber rat1){
		int num1=(this.getDonominator()*rat1.getNumerator())+
				(this.getNumerator()*rat1.getDonominator());			
				
		int num2 =this.numerator * rat1.numerator;
		
			return new RationalNumber(num1,num2);
	}
	//Subtracting as required form formula
	public RationalNumber subtract(RationalNumber rat1){
		int num1=(this.getDonominator()*rat1.getNumerator())-
				(this.getNumerator()*rat1.getDonominator());				
				
		int num2 =this.numerator * rat1.numerator;
		
			return new RationalNumber(num1,num2);
	}
	//Multiplying as required form formula
	public RationalNumber multiply(RationalNumber rat1){
		int num1=this.getDonominator()*rat1.getDonominator();
							
		int num2 =this.numerator * rat1.numerator;
		
			return new RationalNumber(num1,num2);
	}
	//Dividing as required form formula
	public RationalNumber divide(RationalNumber rat1){
		int num1=this.getDonominator()*rat1.getNumerator();
				
				
			int num2 =this.numerator * rat1.denominator;
		
			return new RationalNumber(num1,num2);
	}
	
	
	
}
