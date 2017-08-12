import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author Ruben Rodrigues
 */
public class CDental extends Application {

    private ViewAllPatients vPatientsPane;
    private ViewAllProcedures vProceduresPane;
    private AddPatient aPatientPane;
    private AddProcedures aProcedurePane;
    private Stage stage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
    	
        stage = primaryStage;
        Scene scene = ViewPatientPane();
        primaryStage.setTitle("Patients");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public Scene ViewPatientPane() {

    	vPatientsPane = new ViewAllPatients();
    	vPatientsPane.btnAdd.setOnAction(e -> viewCodes(e));
    	vPatientsPane.btnDelete.setOnAction(e -> viewCodes(e));
    	vPatientsPane.btnProcedures.setOnAction(e -> viewCodes(e));

        Scene scene = new Scene(vPatientsPane, 800, 450);
        return scene;
    }
    
    public Scene ViewproceduresPane() {

    	vProceduresPane = new ViewAllProcedures();
    	vProceduresPane.btnAdd2.setOnAction(e -> viewCodes2(e));
    	vProceduresPane.btnDelete2.setOnAction(e -> viewCodes2(e));
    	vProceduresPane.btnPatient.setOnAction(e -> viewCodes2(e));

        Scene scene1 = new Scene(vProceduresPane, 800, 450);
        return scene1;
    }

    public void viewCodes(ActionEvent e) {

        if (e.getSource().equals(vPatientsPane.btnAdd)) {
            stage.setScene(AddPane());

        } else if (e.getSource().equals(vPatientsPane.btnDelete)) {
        	Patient selectedItem = vPatientsPane.table.getSelectionModel().getSelectedItem();
        	vPatientsPane.removeMember(selectedItem);
        	
        } else if (e.getSource().equals(vPatientsPane.btnProcedures)) {
        	stage.setScene(ViewproceduresPane());
        	
        } 
    }
    
    public void viewCodes2(ActionEvent e) {

        if (e.getSource().equals(vProceduresPane.btnAdd2)) {
            stage.setScene(AddPane2());

        } else if (e.getSource().equals(vProceduresPane.btnDelete2)) {
        	Procedure selectedItem = vProceduresPane.table.getSelectionModel().getSelectedItem();
        	vProceduresPane.removeMember(selectedItem);
        	
        } else if (e.getSource().equals(vProceduresPane.btnPayment)) {
        	stage.setScene(ViewproceduresPane());
        	
        } else if (e.getSource().equals(vProceduresPane.btnPatient)) {
        	 stage.setScene(ViewPatientPane());
        }
    }
    
    /**
     * @return the member that is added
     */
    public Scene AddPane() {

    	aPatientPane = new AddPatient();
    	aPatientPane.btnSave.setOnAction(e -> addCode(e));
    	aPatientPane.btnCancel.setOnAction(e -> addCode(e));

        Scene scene = new Scene(aPatientPane, 600, 400);
        return scene;
    }
    
    public Scene AddPane2() {

    	aProcedurePane = new AddProcedures();
    	aProcedurePane.btnSave2.setOnAction(e -> addCode2(e));
    	aProcedurePane.btnCancel2.setOnAction(e -> addCode2(e));

        Scene scene1 = new Scene(aProcedurePane, 600, 400);
        return scene1;
    }

    public void addCode(ActionEvent e) {

        if (e.getSource().equals(aPatientPane.btnSave)) {
        	aPatientPane.saveRecord();
            stage.setScene(AddPane());

        } else if (e.getSource().equals(aPatientPane.btnCancel)) {
            stage.setScene(ViewPatientPane());
        }
    }
    
    public void addCode2(ActionEvent e) {

        if (e.getSource().equals(aProcedurePane.btnSave2)) {
        	aProcedurePane.saveRecord();
            stage.setScene(AddPane2());
            
        }else if (e.getSource().equals(aProcedurePane.btnCancel2)) {
            stage.setScene(ViewproceduresPane());
        }
    }

}

