package application;

public class BookedSeats {
Route route;
int busSeatNumber;
boolean bought;
long bookingId;
static long generateId;


public long getBookingId() {
	return bookingId;
}
public void setBookingId(long bookingId) {
	this.bookingId = bookingId;
}
public boolean isBought() {
	return bought;
}
public void setBought(boolean bought) {
	this.bought = bought;
}
public int getBusSeatNumber() {
	return busSeatNumber;
}
public void setBusSeatNumber(int busSeatNumber) {
	this.busSeatNumber = busSeatNumber;
}
public BookedSeats(Route routeID, int busSeatNumber,boolean bought) {
	this.route = routeID;
	this.busSeatNumber = busSeatNumber;
	this.bought=bought;
	generateId=generateId+1;
	this.bookingId=generateId;
	System.out.println("Booking id : "+bookingId);

}
}

