/* 
*  Author: Matt Parker
*  Author: Terena Chao
*  Author: Mary Clark
*/
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class TestSQL {

	public static void main(String[] argv) {
	
	System.out.println("-------- MySQL JDBC Connection Testing ------------");
	
	try {
	Class.forName("com.mysql.jdbc.Driver");
	 } catch (ClassNotFoundException e) {
	
	System.out.println("Where is your MySQL JDBC Driver?");
	    e.printStackTrace();
	    return;
	}
	
	System.out.println("MySQL JDBC Driver Registered!");
	Connection conn = null;
	
        String url = "jdbc:mysql://localhost/cpsc348_chao";
        String username = "tchao";
        String password = "database1234";
	try {

	    conn = DriverManager.getConnection(url, username, password);

	} catch (SQLException e) {
	    System.out.println("Connection Failed! Check output console");
	    e.printStackTrace();
	    return;
	}
	
	if (conn != null) {
	    System.out.println("You made it, take control your database now!");
	} else {
	    System.out.println("Failed to make connection!");
	}

<<<<<<< HEAD
	public static void main(String[] args) {
		System.out.println("MySQL Connect Example.");
		Connection conn = ;
		String url = "jbdc:mysql://localhost:3306/";
		String dbName = "jdbctutorial";
		String driver = "com.mysql.jdbc.Driver";
		String userName = "root"; 
  		String password = "root";
  		try {
  		Class.forName(driver).newInstance();
  		conn = DriverManager.getConnection(url+dbName,userName,password);
  		System.out.println("Connected to the database");
  		conn.close();
  		System.out.println("Disconnected from database");
  		} catch (Exception e) {
  		e.printStackTrace();
 		}
=======
>>>>>>> 82a67a06f7bf48c5fcf17d5190c6b7455dc9612e
	}
}
