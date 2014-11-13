import java.sql.*;
import java.util.*;


public class Query {

	Query(){

		statement = null;
		cmain = new ChirperMain();
	}

	
	public boolean QueryAdd(){

		try{	

		cmain.open();

		statement = cmain.conn.prepareStatement("INSERT INTO ChirpUser VALUES(?,?)");

		statement.setString(1, "Jim");
		statement.setString(2, "Jen");
		
		boolean b = statement.execute();

		if(b==true) System.out.println("One record inserted");
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
	

}
