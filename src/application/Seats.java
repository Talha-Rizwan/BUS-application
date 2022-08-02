package application;


public class Seats {
int number;
boolean booked;
public Seats() {
	number=0;
	booked=false;
}
public Seats(int number, boolean booked) {
	this.number = number;
	this.booked = booked;
}
public int getNumber() {
	return number;
}
public void setNumber(int number) {
	this.number = number;
}
public boolean isBooked() {
	return booked;
}
public void setBooked(boolean booked) {
	this.booked = booked;
}

}

