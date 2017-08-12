import java.util.ArrayList;

public class Invoice {

	int invoiceNo;
	double invoiceAmt;
	boolean isPaid;
	ArrayList<Procedure> proced; 
	ArrayList<Payment> pay; 
	
	public Invoice(int invoiceNo, double invoiceAmt){
		
		this.invoiceNo = invoiceNo;
		this.invoiceAmt = invoiceAmt;
	}
	
	//Getters
    public int getInvoiceNo() {
        return invoiceNo;
    }
    
    public double getInvoiceAmt() {
        return invoiceAmt;
    }

    //Setters
    public void setInvoiceNo(int invoiceNo) {
        this.invoiceNo = invoiceNo;
    }
    
    public void setInvoiceAmt(int invoiceAmt) {
        this.invoiceAmt = invoiceAmt;
    }
	
}
