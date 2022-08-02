package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Controller2 {
	@FXML
	private Button conti;
	
	public void Registeration_Confirmation(ActionEvent event) throws IOException
	{
		BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("Sample.fxml"));
		Scene scene = new Scene(root);
		//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
		primaryStage.resizableProperty().setValue(Boolean.FALSE);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
