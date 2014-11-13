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

				try{	
		
				cmain.open();
		
				statement = cmain.conn.prepareStatement("INSERT INTO ChirpUser VALUES(?,?)");
				System.out.print("Enter desired Username: ");
				String uname = in.next();
				System.out.print("Enter desired Password: ");
				String pword = in.next();
				statement.setString(1, uname);
				statement.setString(2, pword);	
				boolean b = statement.execute();
		
				if(b==true) System.out.println("Congratulations! You have made a Chirper account");
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
		/*	case 'T':
			
			break;
			case 'E':

			break;
			case 'S':
			
			break;
			case 'L':

			break;
			//case 'R':

			//break;*/
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
