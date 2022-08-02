package application;

import java.io.IOException;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
public class Controller5 {
	@FXML
	private TextField rou_id;
	String route_identification;
	@FXML
    private TableColumn<Route, String> route_end;
    @FXML
    private TableColumn<Route, String> route_id;
    @FXML
    private TableColumn<Route, String> route_start;
    @FXML
    private TableView<Route> table;
    @FXML
    private Button next;
    @FXML
    private TableColumn<Route, Double> ticket_price;
    @FXML
    private TableColumn<Route, String> timings;
    @FXML
	 public void initialize() {
		 	//System.out.println("Name");
	    	TempClass tempObject=TempClass.getInstance();
	    	for (int i = 0; i < tempObject.observableList.size(); i++) {
					tempObject.observableList.get(i).display();
				}
	    	route_id.setCellValueFactory(cellData->new SimpleStringProperty(cellData.getValue().getRouteId()));
	    	route_start.setCellValueFactory(cellData->new SimpleStringProperty(cellData.getValue().getRouteStart()));
	    	route_end.setCellValueFactory(cellData->new SimpleStringProperty(cellData.getValue().getRouteEnd()));
	    	ticket_price.setCellValueFactory(cellData->new SimpleDoubleProperty(cellData.getValue().getFare()).asObject());
	    	timings.setCellValueFactory(cellData->new SimpleStringProperty(cellData.getValue().getTime()));
	    	table.setItems(tempObject.observableList);
	    }
    public void After_Route_ID(ActionEvent event) throws IOException
	{
    	
    	route_identification=rou_id.getText();
    	System.out.println(route_identification);
    	SystemController Box = SystemController.getInstance();
    	TempClass tempObject=TempClass.getInstance();
    	tempObject.TempRoute=Box.selectBus(route_identification);
    	ArrayList<Integer> tempAllSeats=tempObject.TempRoute.bus.getAvailableSeats();
    	
    	tempObject.seatList=FXCollections.observableList(tempAllSeats);
		/*
    	ArrayList<Integer> tempAllSeats1=new ArrayList<Integer>();
    	ArrayList<Integer> tempAllSeats2=new ArrayList<Integer>();
    	ArrayList<Integer> tempAllSeats3=new ArrayList<Integer>();;
    	int temp=13;
    	for(int i=0;i<12;i++)
    		tempAllSeats1.add(tempAllSeats.get(i));
    	for(int i=0;i<12;i++)
    	{
    		tempAllSeats2.add(tempAllSeats.get(temp));
    		temp=temp+1;
    	}
    	for(int i=0;i<12;i++)
    	{
    		tempAllSeats3.add(tempAllSeats.get(temp));
    		temp=temp+1;
    	}
    	//TempClass tempObject=TempClass.getInstance();
		//tempObject.seatList=FXCollections.observableList(tempAllSeats);
    	tempObject.seatList1=FXCollections.observableList(tempAllSeats1);
    	tempObject.seatList2=FXCollections.observableList(tempAllSeats2);
    	tempObject.seatList3=FXCollections.observableList(tempAllSeats3);
		
    	for(int i=0;i<12;i++)
    	{
    		System.out.println(tempAllSeats1.get(i));
    		System.out.println(tempAllSeats2.get(i));
    		System.out.println(tempAllSeats3.get(i));
    	}
    	*/
    	
		BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("PreBookSeatsSelectSeatInterface.fxml"));
		Scene scene = new Scene(root);
		//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
		primaryStage.resizableProperty().setValue(Boolean.FALSE);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
