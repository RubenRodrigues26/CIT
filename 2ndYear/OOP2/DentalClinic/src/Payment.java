
public class Payment {

	int payment;
	double paymentAmt;

	public Payment(int payment, double paymentAmt){

		this.payment = payment;
		this.paymentAmt = paymentAmt;
	}

	//Getters
	public int getPayment() {
		return payment;
	}
	
	public double getPaymentAmt() {
		return paymentAmt;
	}

	//Setters
	public void setPayment(int payment) {
		this.payment = payment;
	}
	
	public void setPaymentAmt(double paymentAmt) {
		this.paymentAmt = paymentAmt;
	}
}
