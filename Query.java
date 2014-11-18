import java.sql.*;
import java.util.*;


public class Query {

	Query(){
		
		statement = null;
		cmain = new ChirperMain();
	}
	public boolean QueryAdd(char type){

		switch(type){
			case 'R': 
				boolean flag = false;

				try{	
		
				cmain.open();
		
				Statement statement = cmain.conn.createStatement();
				PreparedStatement statement1; 
				System.out.print("Enter desired Username: ");
				String uname = in.next();
				System.out.print("Enter desired Password: ");
				String pword = in.next();
				ResultSet rs = statement.executeQuery("SELECT username FROM ChirpUser");
				while (rs.next()){
					String username = rs.getString("username");
					
					if (uname.equals(username)){
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
						if (entry != 0) System.out.println("Account Created");
					}
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
			case 'C':
			
				/*try{	
		
				cmain.open();
		
				statement = cmain.conn.prepareStatement("INSERT INTO Chirp(chirp, num_likes, num_rechirps, user_id)  VALUES(?, ?, ?, ?)");
				System.out.print("Enter Chirp: ");
				String Chirp = in.next();	
				statement.setString(2, Chirp);
				statement.setString(3, 0);
				statement.setInt(4, 0);
				statement.setInt(5, user_id);	
				boolean b = statement.execute();
		
				if(b==true) System.out.println("Congratulations! You have made a Chirp");
				} catch(SQLException sqlEx) {
					sqlEx.printStackTrace();
					System.exit(1);
				}/*  catch(ClassNotFoundException clsNotFoundEx){
					clsNotFoundEx.printStackTrace();
					System.exit(1);
				 } finally{
					try{
						statement.close();
						cmain.close();
					} catch(Exception e){
						System.exit(1);
					}		
						
				}

			break;
			case 'E':

			break;
			case 'S':
			
			break;
			case 'L':

			break;
			case 'R':

			break;*/
			default:
				System.out.println("Not a valid selection, please try again");	
		}
	return true;	
	}

	public boolean QueryDelete(char type){

		return true;	
	}

	public boolean QuerySearch(char type){

		return true;
	}

	public boolean QueryPrint(char type){
	
		return true;
	}

	protected PreparedStatement statement;

	protected Connection conn;
	
	protected ChirperMain cmain;
	
	Scanner in = new Scanner(System.in);


}
