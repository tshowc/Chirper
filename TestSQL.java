/* 
*  Author: Matt Parker
*  Author: Terena Chao
*  Author: Mary Clark
*/
public class TestingSQL {

	public static void main(String[] args) {
		System.out.println("MySQL Connect Example.");
		Connection conn = null;
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
	}
}
