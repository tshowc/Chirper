import java.sql.*;
import java.util.*;


public class Query {

	Query(){
		
		statement = null;
		cmain = new ChirperMain();
	}
	public boolean QueryAdd(char type){

		switch(type){
			case 'R'://Register an account 
				boolean flag = false;

				try{	
		
				cmain.open();
				menu.displayRegisterMenu();
		
				Statement statement = cmain.conn.createStatement();
				PreparedStatement statement1; 
				System.out.print("Enter desired Username: ");
				String uname = in.next();
				System.out.print("Enter desired Password: ");
				String pword = in.next();
				ResultSet rs = statement.executeQuery("SELECT username FROM ChirpUser");
				while (rs.next()){
					String username = rs.getString("username");
					//Checks CASE SENSITIVITY
					String usernameUP = username.toUpperCase(); 
					String unameUP = uname.toUpperCase();
					
					if (unameUP.equals(usernameUP)){
						flag = true;
						System.out.println("Username exist. Please try again.");
						break;
					}}
					rs.close();
					if(!flag){
						statement1 = cmain.conn.prepareStatement("INSERT INTO ChirpUser (username, password)  VALUES(?,?)");
						statement1.setString(1, uname);
						statement1.setString(2, pword);
						int entry = statement1.executeUpdate();
						System.out.print("Enter First Name: ");
						String FN = in.next();
						System.out.print("Enter Last Name: ");
						String LN  = in.next();
						System.out.print("Enter Age: ");
						int age = in.nextInt();
						String desc;
						do{
							System.out.println("Tell us about yourself! (Max. 140)");
							String consume = in.nextLine();
							desc = in.nextLine();
						}while(desc.length() > 140);		
						PreparedStatement statement2;
						statement2 = cmain.conn.prepareStatement("INSERT INTO ChirpUserProfile (first_name, last_name, age, description) VALUES(?,?,?,?)");
						statement2.setString(1, FN);
						statement2.setString(2, LN);
						statement2.setInt(3, age);
						statement2.setString(4, desc);
						statement2.execute(); 
						if (entry != 0) System.out.println("Account Created");
						break;
					}
				} catch(SQLException sqlEx) {
					sqlEx.printStackTrace();
					System.exit(1);
				}/*  catch(ClassNotFoundException clsNotFoundEx){
					clsNotFoundEx.printStackTrace();
					System.exit(1);
				 }*/ finally{
					try{
						cmain.close();
					} catch(Exception e){
						System.exit(1);
					}		
						
				}

			
			break;
			case 'C'://Create a Chirp
			
				try{	
		
				cmain.open();
		
				statement = cmain.conn.prepareStatement("INSERT INTO Chirp(chirp, num_likes, num_rechirps, user_id)  VALUES(?, ?, ?, ?)");
				System.out.print("Enter Chirp(Max 140): ");
				String Chirp = in.next();	
				statement.setString(2, Chirp);
				statement.setInt(3, 0);
				statement.setInt(4, 0);
				statement.setInt(5,userID);	
				boolean b = statement.execute();
		
				if(b==true) System.out.println("Congratulations! You have made a Chirp");
				} catch(SQLException sqlEx) {
					sqlEx.printStackTrace();
					System.exit(1);
				}/*  catch(ClassNotFoundException clsNotFoundEx){
					clsNotFoundEx.printStackTrace();
					System.exit(1);
				 }*/ finally{
					try{
						statement.close();
						cmain.close();
					} catch(Exception e){
						System.exit(1);
					}		
						
				}

			break;
			case 'E'://Edit Profile

			break;
			case 'S'://Add a Subscriber
			
			break;
			case 'L'://Like a Chirp

			break;
			case 'P'://ReChirp

			break;
			default:
				System.out.println("Not a valid selection, please try again");	
		}
	return true;	
	}

	public boolean QueryDelete(char type){

		return true;	
	}

	public boolean QuerySearch(char type){

		boolean b = false;

		switch(type){
		
		case 'L': //Login
				
			boolean flag = false;
			try{	
		
				cmain.open();
		
				Statement statement = cmain.conn.createStatement();
				PreparedStatement statement1; 
				System.out.print("Enter Username: ");
				String uname = in.next();
				System.out.print("Enter Password: ");
				String pword = in.next();
				ResultSet rs = statement.executeQuery("SELECT user_id, username, password FROM ChirpUser");
				while (rs.next()){
					userID = rs.getInt("user_id");
					String username = rs.getString("username");
					String password = rs.getString("password");

					//Checks CASE SENSITIVITY OF USERNAME 
					String usernameUP = username.toUpperCase();
					String unameUP = uname.toUpperCase();
					if (unameUP.equals(usernameUP)&& pword.equals(password)){
						flag = true;
						System.out.println("Welcome to the System.");
						b = true;
						break;
					}}
					rs.close();
					if(!flag){
						System.out.println("Username and Password either not in the system or do not match. Please try again.");
						break;
					}
				} catch(SQLException sqlEx) {
					sqlEx.printStackTrace();
					System.exit(1);
				}/*  catch(ClassNotFoundException clsNotFoundEx){
					clsNotFoundEx.printStackTrace();
					System.exit(1);
				 }*/ finally{
					try{
						cmain.close();
					} catch(Exception e){
						System.exit(1);
					}		
						
				}
		break;

		default: 	
			System.out.println("Not a valid selection, please try again");	
	}





		return b;
	}

	public boolean QueryPrint(char type){
	
		return true;
	}
	
	private int userID;

	protected PreparedStatement statement;

	protected Connection conn;
	
	protected Menu menu = new Menu();
	
	protected ChirperMain cmain;
	
	Scanner in = new Scanner(System.in);


}
