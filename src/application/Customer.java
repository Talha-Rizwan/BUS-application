package application;
import java.util.ArrayList;

public class Customer extends Person{
String password;
String id;
ArrayList<Long> customerAllSeatsID=new ArrayList<Long>();

public Customer() {
	// TODO Auto-generated constructor stub
}
public void setAllParameters(String fN,String lN,String g,String mN,String cN,String e,String p) {
	firstName=fN;
	lastName=lN;
	gender=g;
	mobileNumber=mN;
	cnicNumber=cN;
	email=e;
	password=p;
}
public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}
}
