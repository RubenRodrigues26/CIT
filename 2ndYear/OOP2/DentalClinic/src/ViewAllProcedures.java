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

public class ViewAllProcedures extends GridPane { 

	protected TableView<Procedure> table; 
	protected Button btnAdd2, btnDelete2, btnPatient, btnPayment;
	private ArrayList<Procedure> procedureList = new ArrayList<Procedure>();
	
	public ViewAllProcedures() {

		super();

		//read file 
		File file = new File("procedures.txt");
		readFile2(file);
				
		//tableview features
		table = new TableView<Procedure>();
		table.setEditable(true);

		//TableColumn name  
		TableColumn<Procedure, String> nameCol = new TableColumn<Procedure, String>("Name");
		TableColumn<Procedure, String> costCol = new TableColumn<Procedure, String>("Cost");

		//Add to Column 
		nameCol.setCellValueFactory(new PropertyValueFactory<Procedure, String>("name"));
		costCol.setCellValueFactory(new PropertyValueFactory<Procedure, String>("cost"));

		//Convert ArrayList to ObservableList 
		ObservableList<Procedure> tryList = FXCollections.observableArrayList(procedureList);

		table.setItems(tryList);

		table.getColumns().addAll(nameCol, costCol);

		//Create labels and buttons on this page
		Label showAll = new Label("Procedures Records");
		showAll.setId("Records");

		btnAdd2 = new Button();
		btnAdd2.setText("Add Member");

		btnDelete2 = new Button();
		btnDelete2.setText("Delete Member");
		
		btnPatient = new Button();
		btnPatient.setText("Patients");
		
		btnPayment = new Button();
		btnPayment.setText("Payment");

		//Add the buttons to the page with some styling
		VBox btnCol = new VBox();
		btnCol.getChildren().addAll(btnAdd2, btnDelete2, btnPatient, btnPayment);
		btnCol.setSpacing(10);
		btnCol.setPadding(new Insets(20, 20, 20, 20));

		this.add(showAll, 1, 2);
		this.add(btnCol, 3, 5);
		this.add(btnPatient, 1, 9);
		this.add(btnPayment, 2, 9);
		

		table.setPrefSize(500, 400);

		this.add(table, 0, 3, 3, 3);

		this.setPadding(new Insets(20, 20, 20, 20));
	}
	
	public void saveFile2(){

		try {
			
			/* Create a FileWriter and clean contents in the file before start to write the list of members.*/
			FileWriter fileOut = new FileWriter("procedures.txt");
			fileOut.write("");
			
			for(Procedure v : procedureList){
				String memberStr = v.getName() + "|" + v.getCost() + "|\n";
				
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
	public void readFile2(File file) {

		try {
			Scanner input = new Scanner(file);
			input.useDelimiter("\\|\\s*");

			while (input.hasNext()) {

				String name = input.next();
				double cost = input.nextDouble();

				Procedure member = new Procedure(name, cost);
				procedureList.add(member);
			}
			input.close();//close file

		} catch (FileNotFoundException ex) {
			System.out.println("File not found " + ex.getMessage());
		}
	}

	public void removeMember(Procedure member){
		table.getItems().remove(member);
		procedureList.remove(member);
		saveFile2();
	}

}
