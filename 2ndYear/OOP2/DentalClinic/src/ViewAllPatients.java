import java.io.*;
import java.util.*;
import javafx.collections.*;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;

/**
 * @author Ruben Rodrigues
 */

public class ViewAllPatients extends GridPane { 

	protected TableView<Patient> table; 
	protected Button btnAdd, btnDelete, btnProcedures, btnPayment;
	private ArrayList<Patient> memberList = new ArrayList<Patient>();
	
	public ViewAllPatients() {

		super();

		//read file 
		File file = new File("members.txt");
		readFile(file);
				
		//tableview features
		table = new TableView<Patient>();
		table.setEditable(true);

		//TableColumn name  
		TableColumn<Patient, String> idCol = new TableColumn<Patient, String>("ID #");
		TableColumn<Patient, String> nameCol = new TableColumn<Patient, String>("Name");
		TableColumn<Patient, String> addressCol = new TableColumn<Patient, String>("Address");
		TableColumn<Patient, String> phoneNoCol = new TableColumn<Patient, String>("PhoneNo");

		//Add to Column 
		idCol.setCellValueFactory(new PropertyValueFactory<Patient, String>("id") );
		nameCol.setCellValueFactory(new PropertyValueFactory<Patient, String>("name"));
		addressCol.setCellValueFactory(new PropertyValueFactory<Patient, String>("address"));
		phoneNoCol.setCellValueFactory(new PropertyValueFactory<Patient, String>("phoneNo"));

		//Convert ArrayList to ObservableList 
		ObservableList<Patient> tryList = FXCollections.observableArrayList(memberList);

		table.setItems(tryList);

		table.getColumns().addAll(idCol, nameCol, addressCol, phoneNoCol);

		//Create labels and buttons on this page
		Label showAll = new Label("Patient Records");
		showAll.setId("Records");

		btnAdd = new Button();
		btnAdd.setText("Add Member");

		btnDelete = new Button();
		btnDelete.setText("Delete Member");
		
		btnProcedures = new Button();
		btnProcedures.setText("Procedures");
		
		btnPayment = new Button();
		btnPayment.setText("Payment");

		//Add the buttons to the page with some styling
		VBox btnCol = new VBox();
		btnCol.getChildren().addAll(btnAdd, btnDelete, btnProcedures, btnPayment);
		btnCol.setSpacing(10);
		btnCol.setPadding(new Insets(20, 20, 20, 20));

		this.add(showAll, 1, 2);
		this.add(btnCol, 3, 5);
		this.add(btnProcedures, 1, 9);
		this.add(btnPayment, 2, 9);
		

		table.setPrefSize(500, 400);

		this.add(table, 0, 3, 3, 3);

		this.setPadding(new Insets(20, 20, 20, 20));
	}
	
	public void saveFile(){

		try {
			
			/* Create a FileWriter and clean contents in the file before start to write the list of members.*/
			FileWriter fileOut = new FileWriter("members.txt");
			fileOut.write("");
			
			for(Patient v : memberList){
				String memberStr = v.getId() + "|" + v.getName() + "|" + v.getAddress() + 
						"|" + v.getPhoneNo() + "|\n";
				
				fileOut.append(memberStr);
				
			}
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("Record Saved");
            alert.setContentText("Record Successfully Saved");
            alert.show();
			
			fileOut.close();

		} catch (IOException e) {
		
			e.printStackTrace();
		}
	}

	/**
	 * @param file 
	 */
	public void readFile(File file) {

		try {
			Scanner input = new Scanner(file);
			input.useDelimiter("\\|\\s*");

			while (input.hasNext()) {

				int id = input.nextInt();
				String name = input.next();
				String address = input.next();
				String PhoneNo = input.next();

				Patient member = new Patient(id, name, address, PhoneNo);
				memberList.add(member);
			}
			input.close();//close file

		} catch (FileNotFoundException ex) {
			System.out.println("File not found " + ex.getMessage());
		}
	}

	public void removeMember(Patient member){
		table.getItems().remove(member);
		memberList.remove(member);
		saveFile();
	}

}
