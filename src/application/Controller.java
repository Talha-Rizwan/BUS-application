package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
public class Controller 
{
	@FXML
	private TextField mobile_no;
	@FXML
	private TextField password;
	@FXML
	private Button login;
	@FXML
	private Button create_new_account;
	String mobile_number;
	String pass;
	static int i=0;
	public void Login_Fun(ActionEvent event) throws IOException
	{
		mobile_number=mobile_no.getText();
		System.out.println(mobile_number);
		pass=password.getText();
		System.out.println(pass);
		SystemController Box = SystemController.getInstance();
		if(i==0) {
			MySql Object=new MySql();
			Object.getCustomersFromDatabase();
			i=1;
		}
		if(Box.login(mobile_number, pass)==true) {//system call
			Box.setAllRoutes();
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("LoginSuccessfulInterface.fxml"));
			Scene scene = new Scene(root);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
			primaryStage.resizableProperty().setValue(Boolean.FALSE);
			primaryStage.setScene(scene);
			primaryStage.show();
		}
		else {
			//Account Does not Exist
			Alert login_failed = new Alert(AlertType.ERROR);
			login_failed.setHeaderText("Login Failed");
			login_failed.setContentText("First Create Account");
			login_failed.showAndWait();
		}
	}
	public void Create_New_Account(ActionEvent event) throws IOException
	{
		BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("CreateAccountInterface.fxml"));
		Scene scene = new Scene(root);
		//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
		primaryStage.resizableProperty().setValue(Boolean.FALSE);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
