/* 
*  Author: Matt Parker
*  Author: Terena Chao
*  Author: Mary Clark
*/
import java.sql.*;
import java.util.*;

public class ChirperMain {


	public static void main(String[] argv) {
		ChirperMain cmain = new ChirperMain();
		Query query = new Query();
		Menu menu = new Menu();
	//	cmain.open();	
		cmain.run(query, menu);
	//	cmain.close();
	//	q.QueryAdd(type);
	
	}
	
	public void open(){

	System.out.println("-------- MySQL JDBC Connection Testing ------------");
	try {
	Class.forName("com.mysql.jdbc.Driver");
	 } catch (ClassNotFoundException e) {
	
	System.out.println("Where is your MySQL JDBC Driver?");
	    e.printStackTrace();
	    return;
	}
	
	System.out.println("MySQL JDBC Driver Registered!");
	conn = null;
	
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

	}


	public void run(Query query, Menu menu){	
		char type = menu.displayWelcomeMenu();
/*		String username;
		String password;
		char choice;

		do{

		System.out.println("Would you like to login or register?");	
		System.out.println("Enter R to register or L to login.");
		System.out.println("To quit, enter Q.");
		choice = Character.toUpperCase(in.next().charAt(0));*/

		switch(type){
			case 'R': 
				System.out.println("Welcome to Registration!");
				query.QueryAdd(type);	
				
				
			break;
			case 'L':
		/*		do{
				System.out.println("Please Login!");
				System.out.println("Please enter Username: ");
				username = in.next();
				System.out.println("Please enter Password: ");
				password = in.next();
				}while(!cmain.login(username, password));

			*/	
			break;
			case 'Q': 
			break;
			default: System.out.println("Invalid Character. Try Again.");


		}
	//	}while(choice != 'Q'); 


	}


	public void registr(String un, String pw){


		//DATABASE STUFF



	}


	public boolean login(String un, String pw){

		//DATABASE STUFF

		return false;
	}

	
	




	
	public void close(){
	if(conn != null){
		try { 
			conn.close();
			System.out.println("You closed the database!");
		} catch (SQLException e){
			System.out.println("Database cannot be closed, try again!");
	}
	}}
	public Connection conn;
	Scanner in = new Scanner(System.in);
}
