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

//	System.out.println("-------- MySQL JDBC Connection Testing ------------");
	try {
	Class.forName("com.mysql.jdbc.Driver");
	 } catch (ClassNotFoundException e) {
	
	System.out.println("Where is your MySQL JDBC Driver?");
	    e.printStackTrace();
	    return;
	}
	
//	System.out.println("MySQL JDBC Driver Registered!");
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
//	    System.out.println("You made it, take control your database now!");
	} else {
	    System.out.println("Failed to make connection!");
	}

	}


	public void run(Query query, Menu menu){	
		char type;
		do{
			type = menu.displayWelcomeMenu();
/*			String username;
			String password;
			char choice;
	
			do{
	
				System.out.println("Would you like to login or register?");	
			System.out.println("Enter R to register or L to login.");
			System.out.println("To quit, enter Q.");
			choice = Character.toUpperCase(in.next().charAt(0));*/
			switch(type){
				case 'R'://Register
					menu.displayRegisterMenu(); 
						query.QueryAdd(type);	
					
					
				break;
				case 'L'://Login
					menu.displayLoginMenu();
					char choice;
					if(query.QuerySearch(type)){
						do{
						choice = menu.displayMain();
						if (choice == 'M'){//Create a Chirp
							query.QueryAdd(choice);
						}
						else if (choice == 'E'){//Edit Profile
							query.QueryAdd(choice);
								
						}
						else if (choice == 'V'){//View Your Own Profile
							query.QuerySearch(choice);
						}
						else if (choice == 'U'){//Subscirbe
							query.QueryAdd(choice);
						}
						else if (choice == 'K'){//Like a Chirp
							query.QueryAdd(choice);
						}
						else if (choice == 'P'){//ReChirp
							query.QueryAdd(choice);
						}
						else if (choice == 'B'){//Reply To
							query.QueryAdd(choice);
						}
						else if (choice == 'F'){//Feed
							query.QueryPrint(choice);
						}
						else if (choice == 'S'){//Search for a user or a hashtag
							query.QuerySearch(choice);
						}
						else if (choice == 'T'){//Trending
							query.QuerySearch(choice);
						}
						}while(choice != 'L');//Logout
					if (choice == 'L'){
				//		System.out.println("Reset ID");
						query.resetUserID();
					}
						
				
					}
				break;
				case 'S': //Search Publically
					query.QuerySearch('S');
				break;
				case 'P'://Public Feed
					query.QueryPrint('P');

				break;	
				case 'Q': //Do nothing 
				break;
				default: System.out.println("Invalid Character. Try Again.");
			
			
			}
		}while(type != 'Q'); 


	}

	
	public void close(){
	if(conn != null){
		try { 
			conn.close();
//			System.out.println("You closed the database!");
		} catch (SQLException e){
			System.out.println("Database cannot be closed, try again!");
	}
	}}
	public Connection conn;
	Scanner in = new Scanner(System.in);
}
