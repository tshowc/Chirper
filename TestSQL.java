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
//	    String url = "jdbc:mysql://http://rosemary.umw.edu/phpmyadmin/:3306/cpsc348_chao/";
//	    String url = "jdbc:mysql://rosemary.umw.edu/phpmyadmin/cpsc348_chao";
//	    String username = "tchao";
//	    String password = "database1234";
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
	}
}

