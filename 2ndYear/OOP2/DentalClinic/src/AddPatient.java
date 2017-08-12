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
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
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
import javafx.stage.Stage;

/**
 * @author Ruben Rodrigues
 */
public class AddPatient extends GridPane {

    BorderPane root;

    protected TextField txtName, txtAddress, txtPhoneNo, txtID;
    private Label lblName, lblAddress, lblPhoneNo, lblID;
    protected Button btnSave, btnCancel;
    private Stage stage;
    private ArrayList<Patient> memberList = new ArrayList<Patient>();
    private ArrayList<Integer> arl = new ArrayList<Integer>();
    private int currentIndex = 0;

    public AddPatient() {

        super();

        lblID = new Label("Account #: ");
        lblName = new Label("Name: ");
        lblAddress = new Label("Address: ");
        lblPhoneNo = new Label("PhoneNo: ");

        txtID = new TextField();
        txtID.setEditable(false);
        
        txtName = new TextField();
        
        txtAddress = new TextField();
        
        txtPhoneNo = new TextField();

        btnSave = new Button("_Save");
        btnCancel = new Button("_Cancel");

        this.add(lblID, 0, 1);
        this.add(lblName, 2, 1);
        this.add(lblAddress, 0, 2);
        this.add(txtID, 1, 1);
        this.add(txtName, 3, 1);
        this.add(txtAddress, 1, 2);
        this.add(txtPhoneNo, 3, 2);
        this.add(lblPhoneNo, 2, 2);

        //Buttons
        this.add(btnSave, 1, 4);
        this.add(btnCancel, 2, 4);

        setAlignmentsAndSizes();
        
        // Reading invidiually
        File file = new File("members.txt");
        readFile(file);

        display(memberList);

    }
    /**
     * This method reads the file
     * @param file 
     */
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
                String phoneNo = input.next();

                Patient member = new Patient(id, name, address, phoneNo);
                memberList.add(member);
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
    private void display(ArrayList<Patient> al) {

        int id = al.size();

        //Checkwith arraylist to see if id exists          
        while (arl.contains(id)) {
                id++;
        	}

        String convertId = id + "";
        txtID.setText(convertId);

        //Add Name
        txtName.setPromptText("Name");

        //Address
        txtAddress.setPromptText("Address");

    }
    
    /**
     * This method styles the page
     */
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
        GridPane.setHalignment(lblPhoneNo, HPos.RIGHT);
        GridPane.setHalignment(btnSave, HPos.RIGHT);
        GridPane.setHalignment(btnCancel, HPos.RIGHT);
    }

    public void saveRecord() {

        try {
            int id = Integer.parseInt(txtID.getText());
            String name = txtName.getText();
            String address = txtAddress.getText();
            String PhoneNo = txtPhoneNo.getText();

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

            } else {

                File file = new File("members.txt");

                PrintWriter write = new PrintWriter(new FileWriter(file, true));
                write.print("\n" + id);
                write.print("|" + name + "|");
                write.print(address + "|");
                write.print(PhoneNo + "|");
                write.print("\r");
                write.close();

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setHeaderText(null);
                alert.setTitle("Record Added");
                alert.setContentText("Record Successfully added");
                alert.show();

                            readFile(file);              

                txtID.setText(id + "");
                txtName.setText("Enter Name");
                txtAddress.setText("Enter Address");

                display(memberList);
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
