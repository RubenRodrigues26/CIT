import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

/**
 * @author Ruben Rodrigues R00144165
 */
public class AddMember extends GridPane{

	BorderPane root;
	protected TextField txtName, txtAddress, txtRegDate, txtPlan, txtID, txtBalance;
	private Label lblName, lblAddress, lblRegDate, lblPlan, lblID, lblBalance;
	protected Button btnSave, btnCancel;
	private ArrayList<GymMember> memberList = new ArrayList<GymMember>();
	private ArrayList<Integer> arl = new ArrayList<Integer>();
	@SuppressWarnings("unused")
	private int currentIndex = 0;
	private DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
	private Date today = new Date();
	private ChoiceBox<String> choiceBox = new ChoiceBox<>();

	public AddMember() {
		super();

		lblID = new Label("Account #: ");
		lblName = new Label("Name: ");
		lblAddress = new Label("Address: ");
		lblRegDate = new Label("Registration Date: ");
		lblPlan = new Label("Membership Plan: ");
		lblBalance = new Label("Balance: ");

		txtID = new TextField();
		txtID.setEditable(false);

		txtName = new TextField();

		txtAddress = new TextField();

		txtRegDate = new TextField();
		txtRegDate.setEditable(false);

		choiceBox.getItems().addAll("Basic", "Standard", "Premium");
		choiceBox.setValue("Standard");

		txtBalance = new TextField();

		btnSave = new Button("Save");

		btnCancel = new Button("Cancel");

		this.add(lblID, 0, 1);
		this.add(lblName, 2, 1);
		this.add(lblAddress, 0, 2);
		this.add(lblRegDate, 0, 3);
		this.add(txtID, 1, 1);
		this.add(txtName, 3, 1);
		this.add(txtAddress, 1, 2);
		this.add(txtRegDate, 1, 3);
		this.add(lblPlan, 2, 2);
		this.add(choiceBox, 3, 2);
		this.add(lblBalance, 2, 3);
		this.add(txtBalance, 3, 3);

		//Buttons
		this.add(btnSave, 1, 4);
		this.add(btnCancel, 2, 4);

		setAlignmentsAndSizes();

		//Reading invidiually
		File file = new File("members.txt");
		readFile(file);
		display(memberList);
	}

	//This method reads the file
	public void readFile(File file) {
		try {
			Scanner input = new Scanner(file);
			input.useDelimiter("\\|\\s*");

			input.nextLine();
			while (input.hasNext()) {
				int id = input.nextInt();
				arl.add(id);
				String name = input.next();
				String address = input.next();
				String accType = input.next();
				double balance = input.nextDouble();
				String sDate = input.next();

				GymMember member = new GymMember(id, name, address, accType, balance, sDate);
				memberList.add(member);

			}
			input.close();

		} catch (FileNotFoundException ex) {
			txtID.setText("File not found " + ex.getMessage());
		}
	}

	//This method displays the records
	private void display(ArrayList<GymMember> al) {

		int arraycheck = al.size();
		int id = (arraycheck + 1);
		//Check arraylist to see if id exists
		if (arl.contains(id)) {
			id++;
			while (arl.contains(id)) {
				id++;
			}
		}

		//ID
		String convertId = id + "";
		txtID.setText(convertId);

		//Add Name
		txtName.setPromptText("Name");

		//Address
		txtAddress.setPromptText("Address");

		//Balance
		txtBalance.setPromptText("00.00");

		//Date
		String sDate = dateFormat.format(today) + "";
		txtRegDate.setText(sDate);
	}

	//This method styles the page
	private void setAlignmentsAndSizes() {

		this.setPadding(new Insets(20, 20, 20, 20));
		this.setHgap(5);
		this.setVgap(20);
		this.setAlignment(Pos.CENTER);

		btnSave.setPrefWidth(70);
		btnCancel.setPrefWidth(70);
		txtID.setPrefSize(10, 10);

		GridPane.setHalignment(lblID, HPos.RIGHT);
		GridPane.setHalignment(lblName, HPos.RIGHT);
		GridPane.setHalignment(lblAddress, HPos.RIGHT);
		GridPane.setHalignment(lblRegDate, HPos.RIGHT);
		GridPane.setHalignment(lblPlan, HPos.RIGHT);
		GridPane.setHalignment(lblBalance, HPos.RIGHT);
		GridPane.setHalignment(btnSave, HPos.RIGHT);
		GridPane.setHalignment(btnCancel, HPos.RIGHT);
	}

	//This method saves the member details
	public void saveRecord() {

		try {
			int id = Integer.parseInt(txtID.getText());
			String name = txtName.getText();
			String address = txtAddress.getText();
			String regDate = txtRegDate.getText();
			double balance = Double.parseDouble(txtBalance.getText());
			String plan = choiceBox.getValue();

			if (name.equals("Enter Name") || name.equals(" ")) {
				Alert alert = new Alert(Alert.AlertType.WARNING);
				alert.setHeaderText(null);
				alert.setTitle("Invalid Name");
				alert.setContentText("Enter Valid Name");
				alert.show();
			} else if (address.equals("Enter Address") || address.equals("")) {
				Alert alert = new Alert(Alert.AlertType.WARNING);
				alert.setHeaderText(null);
				alert.setTitle("Invalid Address");
				alert.setContentText("Enter Valid Address");
				alert.show();
			} else if (!(plan.equals("Basic") || plan.equals("Standard") || plan.equals("Premium"))) {
				Alert alert = new Alert(Alert.AlertType.WARNING);
				alert.setHeaderText(null);
				alert.setTitle("Invalid Plan");
				alert.setContentText("Enter Premium or Regular");
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
				Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
				alert.setHeaderText(null);
				alert.setTitle("Record Added");
				alert.setContentText("Record Successfully added");
				alert.show();

				//Increments the record
				id++;
				if (arl.contains(id)) {
					id++;
					while (arl.contains(id)) {
						id++;
					}
				}
				txtID.setText(id + "");
				txtName.setText("Enter Name");
				txtAddress.setText("Enter Address");
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
			alert.setContentText("Invalid Entry " + ex.getMessage());
			alert.show();
		}
	}
}
