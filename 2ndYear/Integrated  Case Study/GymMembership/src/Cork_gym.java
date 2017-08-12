import javafx.application.Application;		

import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * @author Ruben Rodrigues R00144165
 */
public class Cork_gym extends Application {

	private Login logPane;
	private ViewAll vPane;
	private AddMember aPane;
	private EditMember ePane;	
	private IndividualView iPane;
	private Stage stage;
	private MenuItem exitItem;
	final ContextMenu contextMenu = new ContextMenu(); 
	final MenuItem removeMenuItem = new MenuItem("Remove");

	//Credentials can be changed here
	private String user = "1"; 
	private String pw = "1";

	public static void main(String[] args) {
		launch(args);
	}

	/**
	 * @param primaryStage
	 * @throws Exception
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {

		stage = primaryStage;
		Scene scene = firstScene();
		primaryStage.setTitle("Cork Gym");
		primaryStage.setScene(scene);
		scene.getStylesheets().add("loginstyle.css");
		primaryStage.show();
	}

	/**
	 * @return the login page
	 */
	public Scene firstScene() {
		logPane = new Login();
		logPane.btnFirst.setOnAction(e -> eventCode(e));

		Scene scene = new Scene(logPane, 400, 200);
		return scene;
	}

	/**
	 * @return the individual member page
	 */
	public Scene individualScene() {
		iPane = new IndividualView();
		iPane.btnNext.setOnAction(e -> singleCode(e));
		iPane.btnPrev.setOnAction(e -> singleCode(e));
		iPane.btnHome.setOnAction(e -> singleCode(e));
		iPane.btnDel.setOnAction(e -> singleCode(e));
		iPane.btnEdit.setOnAction(e -> singleCodeE(e));

		Scene scene = new Scene(iPane, 600, 400);
		scene.getStylesheets().add("main.css");
		return scene;
	}

	public Scene individualScene2(int i, String a, String b, String c, double d, String z) {
		iPane = new IndividualView(i,a,b,c,d,z);
		iPane.btnNext.setOnAction (e -> singleCode(e));
		iPane.btnPrev.setOnAction(e -> singleCode(e));
		iPane.btnHome.setOnAction(e -> singleCode(e));
		iPane.btnDel.setOnAction(e -> singleCode(e));
		iPane.btnEdit.setOnAction(e -> singleCodeE(e));

		Scene scene = new Scene(iPane, 600, 400);
		scene.getStylesheets().add("main.css");
		return scene;
	}

	public void singleCode(ActionEvent e) {
		if (e.getSource().equals(iPane.btnNext)) {
			iPane.incrementIndex();
		} else if (e.getSource().equals(iPane.btnPrev)) {
			iPane.decrementIndex();
		} else if (e.getSource().equals(iPane.btnHome)) {
			stage.setScene(ViewPane());
		} else if (e.getSource().equals(iPane.btnDel)) {
			iPane.delRecord();
			stage.setScene(ViewPane());
		} else if (e.getSource().equals(iPane.btnSearch)) {
			stage.setScene(editScene());
		}
	}

	public void singleCodeE(ActionEvent e){
		if (e.getSource().equals(iPane.btnEdit)){       
			iPane.grabEverything();
			int i = iPane.getIdz();
			String nm = iPane.getNamez();
			String ad = iPane.getAddz();       
			String ac = iPane.getAccz();
			double bl = iPane.getBalz();
			String sd = iPane.getSdatez();
			stage.setScene(editScene(i,nm, ad, ac, bl, sd));
		}
	}

	/**
	 * @return the individual member page
	 */
	public Scene editScene() {
		ePane = new EditMember();
		ePane.btnCancel.setOnAction(e -> editCode(e));
		ePane.btnSave.setOnAction(e -> editCode(e));

		Scene scene = new Scene(ePane, 600, 400);
		scene.getStylesheets().add("main.css");
		return scene;
	}

	public Scene editScene(int i, String a, String b, String c, double d, String z) {
		ePane = new EditMember(i, a, b, c, d, z);
		ePane.btnCancel2.setOnAction(e -> editCode2(e));
		ePane.btnSave2.setOnAction(e -> editCode2(e));

		Scene scene = new Scene(ePane, 600, 400);
		scene.getStylesheets().add("main.css");
		return scene;
	}
	public void editCode2(ActionEvent e) {
		if (e.getSource().equals(ePane.btnCancel2)) {
			stage.setScene(ViewPane());
		}
		else if (e.getSource().equals(ePane.btnSave2)) {
			ePane.editRecord();
			stage.setScene(ViewPane());
		}
	}

	public void editCode(ActionEvent e) {
		if(e.getSource().equals(ePane.btnCancel)) {
			stage.setScene(individualScene());
		} else if (e.getSource().equals(ePane.btnSave)) {
			ePane.editRecord();
			stage.setScene(ViewPane());
		}
	}

	/**
	 * @return all the records
	 */
	public Scene ViewPane() {
		vPane = new ViewAll();
		vPane.btnLogout.setOnAction(e -> viewCodes(e));
		vPane.btnAdd.setOnAction(e -> viewCodes(e));
		vPane.btnDelete.setOnAction(e -> viewCodes(e));
		vPane.btnSearch.setOnAction(e -> viewCodes(e));

		vPane.table.setOnMouseClicked(e->viewCodesMouse(e));
		//
		Scene scene = new Scene(vPane, 700, 450);
		scene.getStylesheets().add("main.css");
		return scene;
	}

	public void viewCodesMouse(MouseEvent e){

		if(e.getClickCount() == 2){ 

			int i = vPane.getIdz();
			String nm = vPane.getNamez();
			String ad = vPane.getAddz();       
			String ac = vPane.getAccz();
			double bl = vPane.getBalz();
			String sd = vPane.getSdatez();
			stage.setScene(individualScene2(i,nm, ad, ac, bl, sd));
		}else if(e.getClickCount() == 1){ 

			contextMenu.getItems().add(removeMenuItem);  
		}
	}

	public void viewCodes(ActionEvent e) {
		if (e.getSource().equals(vPane.btnAdd)) {
			stage.setScene(AddPane());
		} else if (e.getSource().equals(vPane.btnDelete)) {
			GymMember selectedItem = vPane.table.getSelectionModel().getSelectedItem();
			vPane.removeMember(selectedItem);
		} else if (e.getSource().equals(vPane.btnSearch)) {
			stage.setScene(individualScene());
			iPane.searchIndex();
		} else if (e.getSource().equals(vPane.btnLogout)) {
			stage.setScene(firstScene());
		}
	}

	/**
	 * @return the member that is added
	 */
	public Scene AddPane() {
		aPane = new AddMember();
		aPane.btnSave.setOnAction(e -> addCode(e));
		aPane.btnCancel.setOnAction(e -> addCode(e));
		Scene scene = new Scene(aPane, 600, 400);
		scene.getStylesheets().add("main.css");
		return scene;
	}

	public void addCode(ActionEvent e) {
		if (e.getSource().equals(aPane.btnSave)) {
			aPane.saveRecord();
			stage.setScene(AddPane());
		} else if (e.getSource().equals(aPane.btnCancel)) {
			stage.setScene(ViewPane());
		}
	}

	public void navCodes(ActionEvent e) {
		if (e.getSource().equals(vPane.btnAdd)) {
			stage.setScene(AddPane());
		}
	}

	public void eventCode(ActionEvent e) {

		if (e.getSource().equals(exitItem)) {
			System.exit(0);
		}
		if (e.getSource().equals(logPane.btnFirst)) {
			if ((user.equals(logPane.getTextField1())) && (pw.equals(logPane.getTextField2()))) { 
				stage.setScene(ViewPane());
			} else {
				logPane.warningMessage();
			}
		}
	}

}