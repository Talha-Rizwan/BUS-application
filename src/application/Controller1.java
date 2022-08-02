package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
public class Controller1 implements Initializable{
	@FXML
	private TextField first_name;
	@FXML
	private TextField last_name;
	@FXML
	private Label gend;
	@FXML
	private ChoiceBox<String> cb;
	private String[] gender= {"Male","Female","Other"};
	@FXML
	private TextField mobile_no;
	@FXML
	private TextField cnic;
	@FXML
	private TextField email;
	@FXML
	private TextField password;
	@FXML
	private Button register;
	String firstName;
	String lastName;
	String Cnic;
	String mobile_number;
	String gende;
	String email_;
	String pass;
	public void initialize(URL arg0, ResourceBundle arg1) {
		cb.getItems().addAll(gender);
	}
	
	public void getgender(ActionEvent event)
	{
		String mygender=cb.getValue();
		gend.setText(mygender);
	}
	public void After_Registeration(ActionEvent event) throws IOException
	{
		firstName = first_name.getText();
		lastName=last_name.getText();
		gende=cb.getValue().toString();
		mobile_number=mobile_no.getText();
		Cnic = cnic.getText();
		email_=email.getText();
		pass=password.getText();
		System.out.println(firstName);
		SystemController Box = SystemController.getInstance();
		Box.addCustomer(firstName, lastName, gende,mobile_number , Cnic, email_, pass);
		BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("RegisterationInterface.fxml"));
		Scene scene = new Scene(root);
		//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
		primaryStage.resizableProperty().setValue(Boolean.FALSE);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
}
