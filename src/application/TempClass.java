package application;

import javafx.collections.ObservableList;

public class TempClass {
    private static TempClass tempObject = null;
    public ObservableList<Route> observableList;
    public ObservableList<Integer> seatList;
    public Route TempRoute;
    public long booking_id;
    public int menu;
    private TempClass()
    {
    	observableList=null;
    	seatList=null;
    	TempRoute=null;
    	booking_id=0;
    	menu=0;
    }
    public static TempClass getInstance()
    {
        if (tempObject == null)
        	tempObject = new TempClass();
        return tempObject;
    }
}
