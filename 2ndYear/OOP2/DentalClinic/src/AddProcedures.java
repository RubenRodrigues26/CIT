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
public class AddProcedures extends GridPane {

    BorderPane root;

    protected TextField txtName, txtCost;
    private Label lblName, lblCost;
    protected Button btnSave2, btnCancel2;
    private Stage stage;
    private ArrayList<Procedure> procedureList = new ArrayList<Procedure>();
    private int currentIndex = 0;

    public AddProcedures() {

        super();

        lblName = new Label("Name: ");
        lblCost = new Label("Cost: ");

        txtName = new TextField();
        
        txtCost = new TextField();

        btnSave2 = new Button("_Save");
        btnCancel2 = new Button("_Cancel");

        this.add(lblName, 0, 1);
        this.add(lblCost, 0, 2);
        this.add(txtName, 1, 1);
        this.add(txtCost, 1, 2);

        //Buttons
        this.add(btnSave2, 1, 4);
        this.add(btnCancel2, 2, 4);

        setAlignmentsAndSizes();
        
        // Reading invidiually
        File file = new File("procedures.txt");
        readFile2(file);

        display(procedureList);

    }
    /**
     * This method reads the file
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
        	
        }
    }
    /**
     * This method displays the records
     * @param al 
     */
    private void display(ArrayList<Procedure> al) {

        //Add Name
        txtName.setPromptText("Name");

        //Address
        txtCost.setPromptText("Cost");

    }
    
    /**
     * This method styles the page
     */
    private void setAlignmentsAndSizes() {

        this.setPadding(new Insets(20, 20, 20, 20));
        this.setHgap(5);
        this.setVgap(20);
        this.setAlignment(Pos.CENTER);

        btnSave2.setPrefWidth(70);
        btnCancel2.setPrefWidth(70);

        GridPane.setHalignment(lblName, HPos.RIGHT);
        GridPane.setHalignment(lblCost, HPos.RIGHT);
        GridPane.setHalignment(btnSave2, HPos.RIGHT);
        GridPane.setHalignment(btnCancel2, HPos.RIGHT);
    }

    public void saveRecord() {

        try {
            String name = txtName.getText();
            String cost = txtCost.getText();

            if (name.equals("Enter Name") || name.equals(" ")) {

                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setHeaderText(null);
                alert.setTitle("Invalid Name");
                alert.setContentText("Enter Valid Name");
                alert.show();

            } else if (cost.equals(Double.parseDouble(cost))){

                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setHeaderText(null);
                alert.setTitle("Invalid Cost");
                alert.setContentText("Enter Valid Cost");
                alert.show();

            } else {

                File file = new File("procedures.txt");

                PrintWriter write = new PrintWriter(new FileWriter(file, true));
                write.print("\n" + name + "|");
                write.print(cost + "|");
                write.print("\r");
                write.close();

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setHeaderText(null);
                alert.setTitle("Record Added");
                alert.setContentText("Record Successfully added");
                alert.show();

                            readFile2(file);              

                txtName.setText("Enter Name");
                txtCost.setText("Enter Cost");

                display(procedureList);
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
