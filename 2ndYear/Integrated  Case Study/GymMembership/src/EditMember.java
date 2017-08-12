import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

/**
 * @author Ruben Rodrigues R00144165
 */
public class EditMember extends BorderPane {

	private GridPane root;
	protected TextField txtName, txtAddress, txtRegDate, txtPlan, txtID, txtBalance;
	private Label lblName, lblAddress, lblRegDate, lblPlan, lblID, lblBalance;
	protected Button btnCancel, btnSave;
	private ArrayList<GymMember> memberList = new ArrayList<GymMember>();
	private ArrayList<Integer> arl = new ArrayList<Integer>();
	private int currentIndex = 0;
	private String tempString;
	private boolean valid = false;
	protected Button btnSave2, btnCancel2;

	public EditMember() {
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

		txtBalance = new TextField();

		btnCancel = new Button("_Cancel");
		btnCancel.setId("btnCancel");

		btnSave = new Button("_Save");
		btnSave.setId("btnSave");

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

		//Buttons
		HBox buttons = new HBox();
		buttons.getChildren().addAll(btnCancel, btnSave);
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
		getTempString();
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setHeaderText(null);
		alert.setTitle("Edit Guide");
		alert.setContentText("To save the record:\nEdit the text and then press Save.\nTo cancel: press cancel to go back to record view.");
		alert.show();
	}

	public EditMember(int id, String name, String address, String accType, double balance, String sDate) {
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

		txtAddress = new TextField();

		txtRegDate = new TextField();
		txtRegDate.setEditable(false);

		txtPlan = new TextField();

		txtBalance = new TextField();

		btnCancel2 = new Button("_Cancel");
		btnCancel2.setId("btnCancel");

		btnSave2 = new Button("_Save");
		btnSave2.setId("btnSave");

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

		//Buttons
		HBox buttons = new HBox();
		buttons.getChildren().addAll(btnCancel2, btnSave2);
		buttons.setAlignment(Pos.BOTTOM_CENTER);
		buttons.setPadding(new Insets(20, 20, 20, 20));
		buttons.setSpacing(10);
		this.setCenter(root);
		this.setBottom(buttons);

		setAlignmentsAndSizes();

		//Reading invidiually
		File file = new File("members.txt");
		readFile(file);

		//Grab passes parameters and set them
		txtID.setText(""+id);
		txtName.setText(name);
		txtAddress.setText(address);
		txtRegDate.setText(sDate);
		txtPlan.setText(accType);
		txtBalance.setText(""+balance);
		getTempString();
	}

	public void editRecord() {
		int dialogResult = JOptionPane.showConfirmDialog(null, "Edit Record?", "Warning", JOptionPane.YES_NO_OPTION);
		String checkString = txtID.getText() + "|"
				+ txtName.getText() + "|"
				+ txtAddress.getText() + "|"
				+ txtPlan.getText() + "|"
				+ txtBalance.getText() + "|"
				+ txtRegDate.getText() + "|";

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

	/**
	 * This method retrieves the current record
	 */
	public void getTempString() {
		tempString = txtID.getText() + "|"
				+ txtName.getText() + "|"
				+ txtAddress.getText() + "|"
				+ txtPlan.getText() + "|"
				+ txtBalance.getText() + "|"
				+ txtRegDate.getText() + "|";
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
			input.close();//close file

		} catch (FileNotFoundException ex) {
			txtID.setText("File not found " + ex.getMessage());
		}
	}

	/**
	 * This method displays the records
	 * @param al
	 */
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

		//get SignUpDate
		String sDate = al.get(currentIndex).getsDate();
		txtRegDate.setText(sDate);
	}

	/**
	 * This method styles the page
	 */
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

	public void incrementIndex() {
		if (currentIndex == (memberList.size() - 1)) {
			currentIndex = 0;
			display(memberList);
			getTempString();
		} else {
			currentIndex++;
			display(memberList); //refresh display
			getTempString();
		}
	}

	public void decrementIndex() {
		if (currentIndex == 0) {
			currentIndex = (memberList.size() - 1); // Go back to max index.
			display(memberList);
			getTempString();
		} else {
			currentIndex -= 1;
			display(memberList);
			getTempString();
		}
	}

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

	/**
	 * This method deletes the record
	 */
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
			@SuppressWarnings("unused")
			boolean successful = tempFile.renameTo(inputFile);
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

	/**
	 * This method saves the record
	 */
	public void saveRecord() {

		try {
			int id = Integer.parseInt(txtID.getText());
			String name = txtName.getText();
			String address = txtAddress.getText();
			String regDate = txtRegDate.getText();
			double balance = Double.parseDouble(txtBalance.getText());
			String plan = txtPlan.getText();
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
			} else if (balance < 0) {
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
