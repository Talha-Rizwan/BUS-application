package application;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class MySql {
	MySql object;
	public MySql()  throws IOException{
		
	}
	public void getCustomersFromDatabase() {
		try {
			String firstName;
			String lastName;
			String gender;
			String mobileNumber;
			String Cnic;
			String email;
			String pass;
			String query="SELECT * FROM customer";
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/person","root","bocoX9");
			Statement ps = con.createStatement();
			ResultSet rs = ps.executeQuery(query);
			SystemController Box=SystemController.getInstance();
			while(rs.next()) {
				firstName= rs.getString(1);
				lastName = rs.getString(2);
				gender = rs.getString(3);
				mobileNumber = rs.getString(4);
				Cnic = rs.getString(5);
				email = rs.getString(6);
				pass = rs.getString(7);
				Customer c = new Customer();
				c.setAllParameters(firstName, lastName, gender, mobileNumber, Cnic,email, pass);
				Box.appCustomers.add(c);
				//System.out.println(number+id+capacity+avgSpeed+driver+occupied);
			}
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			System.out.print("Driver not found\n");
		}
		catch (SQLException e) {
			// TODO: handle exception
			System.out.print("Connection Not Established\n");
		}
	}
	public void updateSeats(DaewooBus bus) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/person","root","bocoX9");
			// create the java mysql update preparedstatement
		      String query = "update daewoobus set occupied = ? where id = ?";
		      PreparedStatement preparedStmt = con.prepareStatement(query);
		      preparedStmt.setInt   (1, bus.getOccupied());
		      preparedStmt.setString(2, bus.getId());
		      // execute the java preparedstatement
		      preparedStmt.executeUpdate();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			System.out.print("Driver not found\n");
		}
		catch (SQLException e) {
			// TODO: handle exception
			System.out.print("Connection Not Established\n");
		}
	}
	public void updateBookedSeat(Long bookingID) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/person","root","bocoX9");
			// create the java mysql update preparedstatement
		      String query = "update bookedseats set bought = ? where bookingId = ?";
		      PreparedStatement preparedStmt = con.prepareStatement(query);
		      preparedStmt.setString(1, "true");
		      preparedStmt.setLong(2, bookingID);
		      // execute the java preparedstatement
		      preparedStmt.executeUpdate();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			System.out.print("Driver not found\n");
		}
		catch (SQLException e) {
			// TODO: handle exception
			System.out.print("Connection Not Established\n");
		}
	}
	public void insertBookedSeat(long bookingID,int seatNumber,String bool ) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/person","root","bocoX9");
			PreparedStatement ps = con.prepareStatement("insert into bookedseats (bookingId,busSeatNumber,bought) values(?,?,?)");
			ps.setLong(1, bookingID);//bookingId
			ps.setInt(2, seatNumber);//busSeatNumber
			ps.setString(3, bool);//bought
			int x = ps.executeUpdate();
			if(x>0) {
				System.out.println("Successfully added.");
			}
			else {
				System.out.println("Couldnt added.");
			}
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			System.out.print("Driver not found\n");
		}
		catch (SQLException e) {
			// TODO: handle exception
			System.out.print("Connection Not Established\n");
		}
	}
	public void insertCustomer(String firstName,String lastName,String gende,String mobileNumber,String Cnic,String email_,String pass) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/person","root","bocoX9");
			PreparedStatement ps = con.prepareStatement("insert into customer (firstName,lastName,gender,mobileNumber,cnicNumber,email,password) values(?,?,?,?,?,?,?)");
			ps.setString(1, firstName);//firstName
			ps.setString(2, lastName);//lastName
			ps.setString(3, gende);//gender
			ps.setString(4, mobileNumber);//mobilenumber
			ps.setString(5, Cnic);//cnicNumber
			ps.setString(6, email_);//email
			ps.setString(7, pass);//password
			int x = ps.executeUpdate();
			if(x>0) {
				System.out.println("Successfully added.");
			}
			else {
				System.out.println("Couldnt added.");
			}
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			System.out.print("Driver not found\n");
		}
		catch (SQLException e) {
			// TODO: handle exception
			System.out.print("Connection Not Established\n");
		}
	}
	public void insertRoute(String routeStart, String routeEnd, double fare, String routeId,DATE d) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/person","root","bocoX9");
			PreparedStatement ps = con.prepareStatement("insert into route (routeId,routeStart,routeEnd,fare,date,time) values(?,?,?,?,?,?)");
			ps.setString(1, routeId);//routeId
			ps.setString(2, routeStart);//routeStart
			ps.setString(3, routeEnd);//routeEnd
			ps.setDouble(4, fare);//fare
			ps.setString(5, d.getDate());//date
			ps.setString(6, "5:00 - 9:00pm");//time
			int x = ps.executeUpdate();
			if(x>0) {
				System.out.println("Successfully added.");
			}
			else {
				System.out.println("Couldnt added.");
			}
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			System.out.print("Driver not found\n");
		}
		catch (SQLException e) {
			// TODO: handle exception
			System.out.print("Connection Not Established\n");
		}
	}
	public void insertBus(String number, String id, int capacity, double avgSpeed, String driver,int occupied) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/person","root","bocoX9");
			PreparedStatement ps = con.prepareStatement("insert into daewoobus (number,id,capacity,avgSpeed,driver,occupied) values(?,?,?,?,?,?)");
			ps.setString(1, number);//number
			ps.setString(2, id);//id
			ps.setInt(3, capacity);//capacity
			ps.setDouble(4, avgSpeed);//avgspeed
			ps.setString(5, driver);//driver
			ps.setInt(6, occupied);//occupied
			int x = ps.executeUpdate();
			if(x>0) {
				System.out.println("Successfully added.");
			}
			else {
				System.out.println("Couldnt added.");
			}
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			System.out.print("Driver not found\n");
		}
		catch (SQLException e) {
			// TODO: handle exception
			System.out.print("Connection Not Established\n");
		}
	}
	public void setRoutes() {
		try {
			String routeId,routeStart,routeEnd,fare,date,time;
			ArrayList<DaewooBus> temp2;
			DATE d = new DATE(3,12,2021);
			SystemController Box = SystemController.getInstance();
			temp2=getBuses();//from database
			String query="SELECT * FROM route";
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/person","root","bocoX9");
			Statement ps = con.createStatement();
			ResultSet rs = ps.executeQuery(query);
			int i=0;
			while(rs.next()) {
				routeId= rs.getString(1);
				routeStart = rs.getString(2);
				routeEnd = rs.getString(3);
				fare = rs.getString(4);
				date = rs.getString(5);
				time = rs.getString(6);
				Route r1 = new Route(routeStart,routeEnd,temp2.get(i),Double.parseDouble(fare),routeId,d);
				i=i+1;
				Box.allRoutes.add(r1);
			}
			con.close();
			
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			System.out.print("Driver not found\n");
		}
		catch (SQLException e) {
			// TODO: handle exception
			System.out.print("Connection Not Established\n");
		}
	}
	public ArrayList<DaewooBus> getBuses() {
		try {
			ArrayList<DaewooBus> temp=new ArrayList<DaewooBus>();
			String number, id;
			String capacity;
			String avgSpeed;
			String driver;
			String occupied;
			String query="SELECT * FROM daewoobus";
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/person","root","bocoX9");
			Statement ps = con.createStatement();
			ResultSet rs = ps.executeQuery(query);
			while(rs.next()) {
				number= rs.getString(1);
				id = rs.getString(2);
				capacity = rs.getString(3);
				avgSpeed = rs.getString(4);
				driver = rs.getString(5);
				occupied = rs.getString(6);
				DaewooBus tempBus2=new DaewooBus(number,id,Integer.valueOf(capacity),Double.valueOf(avgSpeed),driver,Integer.valueOf(occupied));
				temp.add(tempBus2);
				//System.out.println(number+id+capacity+avgSpeed+driver+occupied);
			}
			con.close();
			return temp;
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			System.out.print("Driver not found\n");
			return null;
		}
		catch (SQLException e) {
			// TODO: handle exception
			System.out.print("Connection Not Established\n");
			return null;
		}
	}
}
