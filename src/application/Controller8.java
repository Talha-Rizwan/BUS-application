package application;
import java.io.IOException;
import java.util.ArrayList;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Controller8 {
	@FXML
	private TableColumn<Route, String> route_start;
	@FXML
	private TableColumn<Route,String> route_end;
	@FXML
	private TableColumn<Route,Double> ticket_price;
	@FXML
	private TableColumn<Route, String> timings;
	@FXML
	private TableView<Route> table;
	@FXML
	private Button return_to_main_menu;
	public void initialize() {
		SystemController Box = SystemController.getInstance();
		ArrayList<Route> allRoutes1 = Box.allRoutes; 
		TempClass tempObject=TempClass.getInstance();
		tempObject.observableList=FXCollections.observableList(allRoutes1);
		route_start.setCellValueFactory(cellData->new SimpleStringProperty(cellData.getValue().getRouteStart()));
    	route_end.setCellValueFactory(cellData->new SimpleStringProperty(cellData.getValue().getRouteEnd()));
    	ticket_price.setCellValueFactory(cellData->new SimpleDoubleProperty(cellData.getValue().getFare()).asObject());
    	timings.setCellValueFactory(cellData->new SimpleStringProperty(cellData.getValue().getTime()));
    	table.setItems(tempObject.observableList);		
    }
	public void After_Seat_Number(ActionEvent event) throws IOException
	{
		BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("LoginSuccessfulInterface.fxml"));
		Scene scene = new Scene(root);
		//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
		primaryStage.resizableProperty().setValue(Boolean.FALSE);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
}
