import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

/**
 * @author Ruben Rodrigues R00144165
 */
public class ViewAll extends GridPane { 

	protected TableView<GymMember> table;
	protected Button btnAdd, btnDelete, btnSearch, btnLogout;
	private ArrayList<GymMember> memberList = new ArrayList<GymMember>();

	//Created these private variables to store the table double pass back to the screen
	private String sdatez, namez, accz, addz;
	private int idz;
	private double balz;

	@SuppressWarnings("unchecked")
	public ViewAll() {
		super();

		//Read file 
		File file = new File("members.txt");
		readFile(file);

		//Tableview features
		table = new TableView<GymMember>();
		table.setEditable(true);

		table.setRowFactory( tv -> {
			TableRow<GymMember> row = new TableRow<>();
			row.setOnMouseClicked(event -> {

				if (event.getClickCount() == 2 && (! row.isEmpty()) ) {
					GymMember rowData = row.getItem();
					System.out.println(rowData.getId());
					accz =rowData.getAccType();
					addz =rowData.getAddress();
					balz = rowData.getBalance();
					namez = rowData.getName();
					idz = rowData.getId();
					sdatez = rowData.getsDate();
				}
			});
			return row ;
		});
		//TableColumn name  
		TableColumn<GymMember, String> idCol = new TableColumn<GymMember, String>("Account #");
		TableColumn<GymMember, String> nameCol = new TableColumn<GymMember, String>("Name");
		TableColumn<GymMember, String> addressCol = new TableColumn<GymMember, String>("Address");
		TableColumn<GymMember, String> accountCol = new TableColumn<GymMember, String>("Account");
		TableColumn<GymMember, String> balanceCol = new TableColumn<GymMember, String>("Balance");

		//Add to Column 
		idCol.setCellValueFactory(new PropertyValueFactory<GymMember, String>("id") );
		nameCol.setCellValueFactory(new PropertyValueFactory<GymMember, String>("name"));
		addressCol.setCellValueFactory(new PropertyValueFactory<GymMember, String>("address"));	
		accountCol.setCellValueFactory(new PropertyValueFactory<GymMember, String>("accType"));
		balanceCol.setCellValueFactory(new PropertyValueFactory<GymMember, String>("balance"));

		//Convert ArrayList to ObservableList 
		ObservableList<GymMember> tryList = FXCollections.observableArrayList(memberList);
		table.setItems(tryList);
		table.getColumns().addAll(idCol, nameCol, addressCol, accountCol, balanceCol);

		//Create labels and buttons on this page
		Label showAll = new Label("Member Records");
		showAll.setId("records");

		btnAdd = new Button("Add Member");
		btnDelete = new Button("Delete Member");
		btnLogout = new Button("Logout");
		btnSearch = new Button("Search");

		//Add the buttons to the page with some styling
		VBox btnCol = new VBox();
		btnCol.getChildren().addAll(btnSearch, btnAdd, btnDelete, btnLogout);
		btnCol.setSpacing(10);
		btnCol.setPadding(new Insets(20, 20, 20, 20));

		this.add(showAll, 2, 2);
		this.add(btnCol, 3, 5);
		this.add(btnLogout, 4, 9);
		table.setPrefSize(650, 400);
		this.add(table, 0, 3, 3, 3);
		this.setPadding(new Insets(20, 20, 20, 20));

		idCol.prefWidthProperty().bind(table.widthProperty().multiply(0.2));
		nameCol.prefWidthProperty().bind(table.widthProperty().multiply(0.2));
		addressCol.prefWidthProperty().bind(table.widthProperty().multiply(0.2));
		accountCol.prefWidthProperty().bind(table.widthProperty().multiply(0.2));
		balanceCol.prefWidthProperty().bind(table.widthProperty().multiply(0.2));

		idCol.setResizable(false);
		nameCol.setResizable(false);
		addressCol.setResizable(false);
		accountCol.setResizable(false);
		balanceCol.setResizable(false);
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
			}
			input.close();

		} catch (FileNotFoundException ex) {
			System.out.println("File not found " + ex.getMessage());
		}
	}

	public void saveFile(){

		try {
			//Create a FileWriter and clean contents in the file before start to write the list of members
			FileWriter fileOut = new FileWriter("members.txt");
			fileOut.write("");

			for(GymMember v : memberList){
				String memberStr = v.getId() + "|" + v.getName() + "|" + v.getAddress() + 
						"|" + v.getAccType() + "|" + v.getBalance() + "|" + v.getsDate() + "|\n";

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

	public void removeMember(GymMember member){
		table.getItems().remove(member);
		memberList.remove(member);
		saveFile();
	}

	public String getSdatez() {
		return sdatez;
	}

	public String getNamez() {
		return namez;
	}

	public String getAccz() {
		return accz;
	}

	public String getAddz() {
		return addz;
	}

	public int getIdz() {
		return idz;
	}

	public double getBalz() {
		return balz;
	}
}