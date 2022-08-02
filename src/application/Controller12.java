package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Controller12 {
	@FXML
	Label enter_bank_name;
	@FXML
	Label enter_account_number;
	@FXML
	private TextField bank_name;
	@FXML
	private TextField account_number;
	@FXML
	private Button confirm;
	public void Confirmationnn(ActionEvent event) throws IOException
	{
		BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("BuyTicketsPreBookSeatsBookedSuccessfullyInterface.fxml"));
		Scene scene = new Scene(root);
		Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
		primaryStage.resizableProperty().setValue(Boolean.FALSE);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
