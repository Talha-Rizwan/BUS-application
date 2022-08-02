package application;


public class DATE {
int day;
int month;
int year;
public DATE() {
	day=0;
	month=0;
	year=2021;
}
public void display() {
	System.out.println(day+","+month+","+year);
}
public String getDate() {
	return day+","+month+","+year;
}
public DATE(int day, int month, int year) {
	this.day = day;
	this.month = month;
	this.year = year;
}
public int getDay() {
	return day;
}
public void setDay(int day) {
	this.day = day;
}
public int getMonth() {
	return month;
}
public void setMonth(int month) {
	this.month = month;
}
public int getYear() {
	return year;
}
public void setYear(int year) {
	this.year = year;
}
public boolean isEqual(DATE d) {
	if(d.day==this.day) {
		if(d.month==this.month) {
			if(d.year==this.year) {
				return true;
			}
		}
	}
	return false;
}
}

