import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * @author Ruben Rodrigues R00144165
 */
public class IndividualView extends BorderPane {

	private GridPane root;
	protected TextField txtName, txtAddress, txtRegDate, txtPlan, txtID, txtBalance;
	private Label lblName, lblAddress, lblRegDate, lblPlan, lblID, lblBalance;
	protected Button btnPrev, btnNext, btnHome, btnSearch, btnDel, btnEdit;
	private ArrayList<GymMember> memberList = new ArrayList<GymMember>();
	private ArrayList<Integer> arl = new ArrayList<Integer>();
	private int currentIndex = 0;

	private String sdatez, namez, accz, addz;
	private int idz;
	private double balz;

	protected Button btnPay;
	protected Payment pPane;

	public IndividualView() {
		super();
		//Creating the labels
		lblID = new Label("Account #: ");
		lblName = new Label("Name: ");
		lblAddress = new Label("Address: ");
		lblRegDate = new Label("Registration Date: ");
		lblPlan = new Label("Membership Plan: ");
		lblBalance = new Label("Balance: ");

		//Creating the textfields
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

		btnPrev = new Button("Previous");
		btnNext = new Button("Next");
		btnHome = new Button("Home");
		btnEdit = new Button("Edit");
		btnPay = new Button("Payment");

		btnDel = new Button("Delete");
		btnDel.setId("btnDel");

		btnPay.setOnAction(e -> {

			double check = Double.parseDouble(txtBalance.getText());
			if(check > 0.00){
				Stage stage2 = new Stage();

				stage2.setScene(payScene());
				stage2.setTitle("Payment for account #" +txtID.getText());
				stage2.show();
			}
			else{
				Alert alert = new Alert(Alert.AlertType.INFORMATION);
				alert.setHeaderText(null);
				alert.setTitle("Cannot make payment");
				alert.setContentText("Account # " + txtID.getText() + " has paid up to date");
				alert.show();
			}
		});

		//Adding the labels and textfields to the scene
		root = new GridPane();
		root.add(lblID, 0, 1);
		root.add(lblName, 2, 1);
		root.add(lblAddress, 0, 2);
		root.add(lblRegDate, 0, 3);
		root.add(txtID, 1, 1);
		root.add(txtName, 3, 1);
		root.add(txtAddress, 1, 2);
		root.add(txtRegDate, 1, 3);
		root.add(lblPlan, 2, 2);
		root.add(txtPlan, 3, 2);
		root.add(lblBalance, 2, 3);
		root.add(txtBalance, 3, 3);

		root.setHgap(5);
		root.setVgap(20);
		root.setAlignment(Pos.CENTER);

		HBox buttons = new HBox();
		buttons.getChildren().addAll(btnPrev, btnHome, btnNext, btnDel, btnPay, btnEdit);
		buttons.setAlignment(Pos.BOTTOM_CENTER);
		buttons.setPadding(new Insets(20, 20, 20, 20));
		buttons.setSpacing(10);
		this.setCenter(root);
		this.setBottom(buttons);

		setAlignmentsAndSizes();

		//Reading invidiually
		File file = new File("members.txt");
		readFile(file);
		display(memberList);
	}
	//Second Constructor 
	public IndividualView(int id, String name, String address, String accType, double balance, String sDate) {
		super();

		//Creating the labels
		lblID = new Label("Account #: ");
		lblName = new Label("Name: ");
		lblAddress = new Label("Address: ");
		lblRegDate = new Label("Registration Date: ");
		lblPlan = new Label("Membership Plan: ");
		lblBalance = new Label("Balance: ");

		//Creating the textfields
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

		btnPay = new Button("Payment");
		btnPrev = new Button("Previous");
		btnNext = new Button("Next");
		btnHome = new Button("Home");
		btnEdit = new Button("Edit");
		btnDel = new Button("Delete");
		btnDel.setId("btnDel");

		//Adding the labels and textfields to the scene
		root = new GridPane();
		root.add(lblID, 0, 1);
		root.add(lblName, 2, 1);
		root.add(lblAddress, 0, 2);
		root.add(lblRegDate, 0, 3);
		root.add(txtID, 1, 1);
		root.add(txtName, 3, 1);
		root.add(txtAddress, 1, 2);
		root.add(txtRegDate, 1, 3);
		root.add(lblPlan, 2, 2);
		root.add(txtPlan, 3, 2);
		root.add(lblBalance, 2, 3);
		root.add(txtBalance, 3, 3);

		root.setHgap(5);
		root.setVgap(20);
		root.setAlignment(Pos.CENTER);

		HBox buttons = new HBox();
		buttons.getChildren().addAll(btnPrev, btnHome, btnNext, btnDel,btnPay, btnEdit);
		buttons.setAlignment(Pos.BOTTOM_CENTER);
		buttons.setPadding(new Insets(20, 20, 20, 20));
		buttons.setSpacing(10);
		this.setCenter(root);
		this.setBottom(buttons);

		setAlignmentsAndSizes();

		//Reading individually  
		File file = new File("members.txt");
		readFile(file);
		txtID.setText(""+id);
		txtName.setText(name);
		txtAddress.setText(address);
		txtRegDate.setText(sDate);
		txtPlan.setText(accType);
		txtBalance.setText(""+balance);
		checkForIndex(); //checks the index, so that u start when u open at!

		btnPay.setOnAction(e -> {

				double check = Double.parseDouble(txtBalance.getText());
				if(check > 0.00){
					Stage stage2 = new Stage();

					stage2.setScene(payScene());
					stage2.setTitle("Payment for account #" +txtID.getText());
					stage2.show();
				}
				else{
					Alert alert = new Alert(Alert.AlertType.INFORMATION);
					alert.setHeaderText(null);
					alert.setTitle("Cannot make payment");
					alert.setContentText("Account # " + txtID.getText() + " has paid up to date");
					alert.show();
				}
		});
	}

	public Scene payScene() {
		grabEverything();

		//New Constructor
		pPane = new Payment(idz, namez, accz, addz, balz, sdatez); 
		pPane.btnCancel.setOnAction(e -> payCode(e));

		//Pay Scene
		Scene scene = new Scene(pPane, 400, 600);
		scene.getStylesheets().add("main.css");
		return scene;   

	}

	//An event in this class that calls another class
	public void payCode(ActionEvent e){
		if(e.getSource()==pPane.btnCancel){
			pPane.getScene().getWindow().hide();
		}
	}

	//This method deletes a record
	public void delRecord() {
		int dialogResult = JOptionPane.showConfirmDialog(null, "Delete Record?", "Warning", JOptionPane.YES_NO_OPTION);
		if (dialogResult == JOptionPane.YES_OPTION) {
			try {
				File inputFile = new File("members.txt");
				File tempFile = new File("myTempFile.txt");

				BufferedReader reader = new BufferedReader(new FileReader(inputFile));
				BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

				String lineToRemove = txtID.getText() + "|"
						+ txtName.getText() + "|"
						+ txtAddress.getText() + "|"
						+ txtPlan.getText() + "|"
						+ txtBalance.getText() + "|"
						+ txtRegDate.getText() + "|";
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
					System.out.println("Could not delete file");
					return;
				}
				@SuppressWarnings("unused")
				boolean successful = tempFile.renameTo(inputFile);
				if (!tempFile.renameTo(inputFile)) {
					System.out.println("Could not rename file");
				}
				Alert alert = new Alert(Alert.AlertType.INFORMATION);
				alert.setHeaderText(null);
				alert.setTitle("Record Deleted");
				alert.setContentText("Record Successfully Deleted");
				alert.show();

			} catch (Exception e) {
				System.out.println(e);
			}
		} else if (dialogResult == JOptionPane.NO_OPTION) {
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setHeaderText(null);
			alert.setTitle("Delete Canceled");
			alert.setContentText("Record Deletion Canceled");
			alert.show();
		}
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

	private void checkForIndex() {
		for (int i = 0; i < memberList.size(); i++)
			if(memberList.get(i).getId() == Integer.parseInt(txtID.getText())){
				currentIndex = i;
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

		//Balance
		String accType = al.get(currentIndex).getAccType();
		txtPlan.setText(accType);

		//SignUpDate
		String sDate = al.get(currentIndex).getsDate();
		txtRegDate.setText(sDate);
	}

	//This method styles the page
	private void setAlignmentsAndSizes() {
		this.setPadding(new Insets(20, 20, 20, 20));

		btnPrev.setPrefWidth(70);
		btnNext.setPrefWidth(70);
		txtID.setPrefSize(10, 10);

		GridPane.setHalignment(lblID, HPos.RIGHT);
		GridPane.setHalignment(lblName, HPos.RIGHT);
		GridPane.setHalignment(lblAddress, HPos.RIGHT);
		GridPane.setHalignment(lblRegDate, HPos.RIGHT);
		GridPane.setHalignment(lblPlan, HPos.RIGHT);
		GridPane.setHalignment(lblBalance, HPos.RIGHT);
		GridPane.setHalignment(btnPrev, HPos.RIGHT);
		GridPane.setHalignment(btnNext, HPos.RIGHT);
	}

	//this method will increment the index
	public void incrementIndex() {
		if (currentIndex == (memberList.size() - 1)) {
			currentIndex = 0;
			display(memberList);
		} else {
			currentIndex++;
			display(memberList); //refresh display
		}
	}

	//this method will decrement the index
	public void decrementIndex() {
		if (currentIndex == 0) {
			currentIndex = (memberList.size() - 1); // Go back to max index.
			display(memberList);
		} else {
			currentIndex -= 1;
			display(memberList);
		}
	}

	//This method searches the indexes
	public void searchIndex() {

		try {
			int num = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter Account #", "Search for Account #", JOptionPane.INFORMATION_MESSAGE));

			if (arl.contains(num)) {
				currentIndex = arl.indexOf(num);
				display(memberList);
			} else {
				JOptionPane.showMessageDialog(null, "Member not found\nProceeding to Record View", "Not Found", JOptionPane.ERROR_MESSAGE);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Invalid input", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void grabEverything(){

		idz = Integer.parseInt(txtID.getText());
		sdatez = txtRegDate.getText();
		namez = txtName.getText();
		accz = txtPlan.getText();
		addz = txtAddress.getText();    
		balz = Double.parseDouble(txtBalance.getText());
	}

	//Setters and getters. 
	public String getSdatez() {
		return sdatez;
	}

	public String getNamez() {
		return namez;
	}

	public void setNamez(String namez) {
		namez = txtName.getText();
	}

	public String getAccz() {
		return accz;
	}

	public void setAccz(String accz) {
		accz = txtPlan.getText();
	}

	public String getAddz() {
		return addz;
	}

	public void setAddz(String addz) {
		addz = txtAddress.getText();
	}

	public int getIdz() {
		return idz;
	}

	public void setIdz(int idz) {
		idz = Integer.parseInt(txtID.getText());
	}

	public double getBalz() {
		return balz;
	}

	public void setBalz(double balz) {
		balz = Double.parseDouble(txtBalance.getText());
	}
}