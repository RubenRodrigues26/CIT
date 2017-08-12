import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import javax.swing.JOptionPane;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * @author Ruben Rodrigues R00144165
 */
public class Payment extends BorderPane {

	private GridPane root;
	protected TextField txtName, txtAddress, txtRegDate, txtPlan, txtID, txtBalance;
	private Label lblName, lblAddress, lblRegDate, lblPlan, lblID, lblBalance;
	protected Button btnPrev, btnNext, btnCancel, btnPP;
	private ArrayList<GymMember> memberList = new ArrayList<GymMember>();
	private ArrayList<Integer> arl = new ArrayList<Integer>();
	private int currentIndex = 0;
	private String tempString;
	private boolean valid = false;
	protected Button btnSave2, btnCancel2;
	protected TextField txtPayAmt;
	protected ComboBox<String> paymentOption;
	private DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
	private Date today = new Date();
	String name, address, accType ,sDate;
	double balance;
	protected TextField txtCCN, txtPayAmount;
	private Label lblCCN, lblPayAmount;
	private String sdatez, namez, accz, addz;
	private int idz;
	private double balz;
	private boolean back = false;

	public Payment(int idz, String namez, String accz, String addz, double balz, String sdatez) {
		super(); 
		this.sdatez = sdatez;
		this.idz = idz;
		this.namez = namez;
		this.accz = accz;
		this.addz = addz;
		this.balz = balz;
		paymentOption = new ComboBox<String>();
		paymentOption.getItems().addAll("MasterCard", "Visa");
		paymentOption.setPromptText("Payment Type");
		lblCCN = new Label("Credit Card Number");
		txtCCN = new TextField();
		txtCCN.setPromptText("Enter credit card info");
		lblPayAmount = new Label("Charge Amount");
		txtPayAmount = new TextField();
		txtPayAmount.setPromptText("0.00");

		//Creating the labels
		lblID = new Label("Account #: ");
		lblName = new Label("Name: ");
		lblAddress = new Label("Credit Card Type: ");
		lblRegDate = new Label("Payment Date: ");
		lblPlan = new Label("Membership Plan: ");
		lblBalance = new Label("Balance: ");

		//Creating the text fields
		txtID = new TextField();
		txtID.setEditable(false);

		txtName = new TextField();
		txtName.setEditable(false);

		txtAddress = new TextField();
		txtAddress.setEditable(false);

		txtRegDate = new TextField();
		txtRegDate.setEditable(false);

		txtPlan = new TextField();
		txtPlan.setEditable(false);

		txtBalance = new TextField();
		txtBalance.setEditable(false);

		btnCancel = new Button("Cancel");
		btnCancel.setId("btnCancel");

		btnPP = new Button("_Process Payment");
		btnPP.setId("btnSave");

		btnPP.setOnAction(e -> {
				calculatePayment();
				System.out.println(paymentOption.getValue());
				if(back==true){
					Node  source = (Node)  e.getSource(); 
					Stage stage  = (Stage) source.getScene().getWindow();
					stage.close();
				}
			
		});

		//Adding the labels and text fields to the scene
		root = new GridPane();
		root.add(lblID, 0, 0);
		root.add(lblName, 0, 1);
		root.add(lblRegDate, 0, 3);
		root.add(txtID, 1, 0);
		root.add(txtName, 1, 1);
		root.add(txtRegDate, 1, 3);
		root.add(lblAddress, 0, 4);
		root.add(paymentOption, 1, 4);
		root.add(lblPlan, 0, 2);
		root.add(txtPlan, 1, 2);
		root.add(lblCCN, 0,5);
		root.add(txtCCN, 1,5);

		txtCCN = new TextField();
		txtCCN.setPromptText("Enter credit card info");
		lblPayAmount = new Label("Charge Amount");
		txtPayAmount = new TextField();
		txtPayAmount.setPromptText("0.00");
		root.add(lblBalance, 0, 6);
		root.add(txtBalance, 1, 6);
		root.add(lblPayAmount,0,7);
		root.add(txtPayAmount,1,7);

		root.setHgap(5);
		root.setVgap(20);
		root.setAlignment(Pos.CENTER);

		//Buttons
		HBox buttons = new HBox();
		buttons.getChildren().addAll(btnCancel, btnPP);
		buttons.setAlignment(Pos.BOTTOM_CENTER);
		buttons.setPadding(new Insets(20, 20, 20, 20));
		buttons.setSpacing(10);
		this.setCenter(root);
		this.setBottom(buttons);

		setAlignmentsAndSizes();

		//Reading individually
		File file = new File("members.txt");
		readFile(file);
		display(memberList);
		//getTempString uses constructor passed variables
		getTempString();
		showFromIndView();
	}

	public void showFromIndView(){
		System.out.println(tempString);
		txtID.setText(idz+"");
		txtName.setText(namez);
		txtPlan.setText(accz);
		String sDate = dateFormat.format(today) + "";
		txtRegDate.setText(sDate);
		txtBalance.setText(balz+"");
	}

	public void calculatePayment(){
		try{
			if(paymentOption.getValue()==null){
				Alert alert = new Alert(Alert.AlertType.INFORMATION);
				alert.setHeaderText(null);
				alert.setTitle("Invalid Credit Card");
				alert.setContentText("Select Credit Card");
				alert.show();
			}
			else if ((txtCCN.getText()==null)||(txtCCN.getText().length()<12)){  
				Alert alert = new Alert(Alert.AlertType.INFORMATION);
				alert.setHeaderText(null);
				alert.setTitle("Invalid Credit Card Number");
				alert.setContentText("Enter 12 digit credit card");
				alert.show();
			}
			else if ((txtPayAmount.getText()==null) || (Double.parseDouble(txtPayAmount.getText())<.01)){
				Alert alert = new Alert(Alert.AlertType.INFORMATION);
				alert.setHeaderText(null);
				alert.setTitle("Invalid Amount");
				alert.setContentText("Enter a charge amount greater than 1 cent");
				alert.show();
			}
			else{
				System.out.println("Got this far");
				moreCalc();
			}
		}catch(Exception e){
			System.out.println(e);
		}
	}

	public void moreCalc(){
		try{
			double charge = Double.parseDouble(txtPayAmount.getText());
			if (charge> balz){
				balz = 0.00;
				finalCalc();
			}
			else{
				balz = balz - charge;
				System.out.println(balz);
				finalCalc();
			}

		}catch(Exception e){
			Alert alert = new Alert(Alert.AlertType.WARNING);
			alert.setHeaderText(null);
			alert.setTitle("Invalid Charge Amount");
			alert.setContentText("Enter a charge amount greater than 1 cent");
		}
	}

	public void finalCalc(){
		editRecord();
		int dialogResult = JOptionPane.showConfirmDialog(null, "Payment Processed \n Generate Receipt?", "Generate Receipt", JOptionPane.YES_NO_OPTION);
		if (dialogResult == JOptionPane.YES_OPTION){
			generateReceipt();
		}
		back = true;

	}

	public void generateReceipt(){
		try {
			int id = Integer.parseInt(txtID.getText());
			String sDate = dateFormat.format(today); 
			String name = namez;
			String address = addz;
			String regDate = sdatez;
			double balance = balz;
			String plan = accz;
			String forReceipt = "receipt for account " + id + " " +namez;
					if (balance < 0) {
						Alert alert = new Alert(Alert.AlertType.WARNING);
						alert.setHeaderText(null);
						alert.setTitle("Invalid Balance");
						alert.setContentText("Enter a valid balance");
						alert.show();
					} else {
						File file = new File(forReceipt+".txt");
						PrintWriter write = new PrintWriter(new FileWriter(file, true));
						write.print("\n"+ "==========Account Information===============");
						write.print("\n" + "Account Number: " + id);  
						write.print("\n"+ "Name: " +name );
						write.print("\n"+ "Address: " + address);
						write.print("\n" + "Registration date: " + regDate);
						write.print("\n"+ "Plan: " + plan);

						write.print("\n"+ "==========Payment Information===============");
						write.print("\n"+ "Transaction Date: " + sDate);
						write.print("\n"+ "Payment Type: " + paymentOption.getValue());// balance + "|");    
						write.print("\n"+"Credit Card Number: " + txtCCN.getText());
						write.print("\n"+"Balance Due: $" + txtBalance.getText());
						write.print("\n"+"Amount Charged to Credit Card: $" + txtPayAmount.getText());
						write.print("\n"+"Remaining Balance: $" + balz);
						write.print("\r");
						write.close();
						System.out.println("Receipt Saved");
						valid = true;
					}

		} catch (IOException ex) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setTitle("Error");
			alert.setContentText("File not found " + ex.getMessage());
			alert.show();
		} catch (NumberFormatException ex) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setTitle("Error");
			alert.setContentText("Invalid Entry ");
			alert.show();
		}
	}

	//This method edits the record
	public void editRecord() {
		int dialogResult = JOptionPane.showConfirmDialog(null, "Edit Record?", "Warning", JOptionPane.YES_NO_OPTION);
		String checkString = txtID.getText() + "|"
				+ txtName.getText() + "|"
				+ txtAddress.getText() + "|"
				+ txtPlan.getText() + "|"
				+ txtBalance.getText() + "|"
				+ txtRegDate.getText() + "|";
		System.out.println(checkString);
		System.out.println(tempString);
		if (tempString.equals(checkString)) {
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setHeaderText(null);
			alert.setTitle("No Change");
			alert.setContentText("Same Record Entered");
			alert.show();
		} 
		else {
			if (dialogResult == JOptionPane.YES_OPTION) {
				saveRecord();

				if (valid == true) {
					delRecord();
				}
			}
		}
	}

	//Displayes the text fields so than it can grab them its how it retrieves the records
	public void getTempString() {
		tempString = idz + "|"+ namez + "|"+ addz + "|"+ accz + "|"+ balz + "|"+ sdatez + "|";
	}

	public void readFile(File file) {
		try {
			Scanner input = new Scanner(file);
			input.useDelimiter("\\|\\s*");

			input.nextLine();
			while (input.hasNext()) {
				int id = input.nextInt();
				String name = input.next();
				String address = input.next();
				String accType = input.next();
				double balance = input.nextDouble();
				String sDate = input.next();

				GymMember member = new GymMember(id, name, address, accType, balance, sDate);
				memberList.add(member);
				arl.add(id);
			}
			input.close();

		} catch (FileNotFoundException ex) {
			txtID.setText("File not found " + ex.getMessage());
		}
	}

	//This method displays the records
	private void display(ArrayList<GymMember> al) {

		int id = al.get(currentIndex).getId();
		String convertId = id + "";
		txtID.setText(convertId);

		//Add Name
		String name = al.get(currentIndex).getName();
		txtName.setText(name);

		//Address
		String address = al.get(currentIndex).getAddress();
		txtAddress.setText(address);

		//accType
		Double balance = al.get(currentIndex).getBalance();
		String cBalance = balance + "";
		txtBalance.setText(cBalance);

		//balance
		String accType = al.get(currentIndex).getAccType();
		txtPlan.setText(accType);

		//SignUpDate
		String sDate = al.get(currentIndex).getsDate();
		txtRegDate.setText(sDate);
	}

	//This method styles the page
	private void setAlignmentsAndSizes() {
		this.setPadding(new Insets(20, 20, 20, 20));

		txtID.setPrefSize(10, 10);
		GridPane.setHalignment(lblID, HPos.RIGHT);
		GridPane.setHalignment(lblName, HPos.RIGHT);
		GridPane.setHalignment(lblAddress, HPos.RIGHT);
		GridPane.setHalignment(lblRegDate, HPos.RIGHT);
		GridPane.setHalignment(lblPlan, HPos.RIGHT);
		GridPane.setHalignment(lblBalance, HPos.RIGHT);
	}

	//this method will increment the index
	public void incrementIndex() {
		if (currentIndex == (memberList.size() - 1)) {
			currentIndex = 0;
			display(memberList);
			getTempString();
		} else {
			currentIndex++;
			display(memberList); //refresh display
			getTempString();
			System.out.println(tempString);
		}
	}

	//this method will decrement the index
	public void decrementIndex() {
		if (currentIndex == 0) {
			currentIndex = (memberList.size() - 1);// Go back to max index.
			display(memberList);
			getTempString();
		} else {
			currentIndex -= 1;
			display(memberList);
			getTempString();
		}
	}

	//This method searches the indexes
	public void searchIndex() {

		try {
			int num = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter member id ", "Search for Member", JOptionPane.INFORMATION_MESSAGE));
			if (arl.contains(num)) {
				currentIndex = arl.indexOf(num);
				display(memberList);
				getTempString();
			} else {
				JOptionPane.showMessageDialog(null, "Member not found", "Not Found", JOptionPane.ERROR_MESSAGE);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Invalid input", "Error", JOptionPane.ERROR_MESSAGE);

		}
	}

	//This method deletes the record
	public void delRecord() {
		try {
			File inputFile = new File("members.txt");
			File tempFile = new File("myTempFile.txt");

			BufferedReader reader = new BufferedReader(new FileReader(inputFile));
			BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

			String lineToRemove = tempString;
			String currentLine;
			while ((currentLine = reader.readLine()) != null) {
				// trim newline when comparing with lineToRemove
				String trimmedLine = currentLine.trim();
				if (trimmedLine.equals(lineToRemove)) {
					continue;
				}
				writer.write(currentLine + System.getProperty("line.separator"));
			}
			writer.close();
			reader.close();
			if (!inputFile.delete()) {
				System.out.println("Error");
				return;
			}
			tempFile.renameTo(inputFile);
			if (!tempFile.renameTo(inputFile)) {
				System.out.println("Could not edit file");
			}
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setHeaderText(null);
			alert.setTitle("Record Edited");
			alert.setContentText("Record Successfully Updated");
			alert.show();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	//This method saves the record
	public void saveRecord() {

		try {
			int id = Integer.parseInt(txtID.getText());
			String name = namez;
			String address = addz;
			String regDate = sdatez;
			double balance = balz;
			String plan = accz;
			if (balance < 0) {
				Alert alert = new Alert(Alert.AlertType.WARNING);
				alert.setHeaderText(null);
				alert.setTitle("Invalid Balance");
				alert.setContentText("Enter a valid balance");
				alert.show();
			} else {
				File file = new File("members.txt");
				PrintWriter write = new PrintWriter(new FileWriter(file, true));
				write.print("\n" + id);
				write.print("|" + name + "|");
				write.print(address + "|");
				write.print(plan + "|");
				write.print(balance + "|");
				write.print(regDate + "|");
				write.print("\r");
				write.close();
				valid = true;
			}

		} catch (IOException ex) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setTitle("Error");
			alert.setContentText("File not found " + ex.getMessage());
			alert.show();
		} catch (NumberFormatException ex) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setTitle("Error");
			alert.setContentText("Invalid Entry ");
			alert.show();
		}
	}

}