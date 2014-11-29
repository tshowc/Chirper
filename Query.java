import java.sql.*;
import java.util.*;


public class Query {

	Query(){
		
		statement = null;
		cmain = new ChirperMain();
		int counter = 0;
		try{	
	
			cmain.open();

			Statement statement = cmain.conn.createStatement();
			//Initializing HashMap for User
			ResultSet rs = statement.executeQuery("SELECT username FROM ChirpUser");
			while (rs.next()){
				counter++;
			}
			userMap = new HashMap<Integer, String>(counter);
			rs.close();
			ResultSet rs2 = statement.executeQuery("SELECT user_id, username FROM ChirpUser");
			while (rs2.next()){
				userMap.put(rs2.getInt("user_id"), rs2.getString("username"));
			}
			rs2.close();
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
						in.nextLine();
						System.out.print("Enter Last Name: ");
						String LN  = in.next();
						in.nextLine();
						System.out.print("Enter Age: ");
						int age = in.nextInt();
						in.nextLine();
						String desc;
						do{
							System.out.println("Tell us about yourself! (Max. 140)");
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
			case 'M'://Create a Chirp
			
				try{	
		
				cmain.open();
				boolean bPrivate = false;
				char input;
				statement = cmain.conn.prepareStatement("INSERT INTO Chirp(chirp, num_likes, num_rechirps, user_id, private)  VALUES(?, ?, ?, ?, ?)");
				System.out.println("Enter Chirp(Max 140): ");
				String Chirp = in.nextLine();
				statement.setString(1, Chirp);
				statement.setInt(2, 0);
				statement.setInt(3, 0);
				statement.setInt(4,userID);
				do{	
					System.out.println("Do you want to set Chirp as private? (y/n) ");
					input = in.next().charAt(0);
					input = Character.toUpperCase(input);
					in.nextLine();
				}while((input != 'Y') && (input != 'N'));
				if (input == 'Y')bPrivate = true;
				else if (input == 'N') bPrivate = false;
				statement.setBoolean(5, bPrivate);	
				int  b = statement.executeUpdate();
		
				if(b > 0) System.out.println("Congratulations! You have made a Chirp");
				Hashtag(Chirp);
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
				
				char choice = menu.displayEditProfile();	
				try{	
						cmain.open();
						PreparedStatement statement2;
						int entry = 0; 
					switch (choice){
					case 'F':
						System.out.print("Enter First Name: ");
						String FN = in.next();
						statement2 = cmain.conn.prepareStatement("UPDATE ChirpUserProfile SET first_name = ? WHERE user_id = ?" );
						statement2.setString(1, FN);
						statement2.setInt(2, userID);
						statement2.execute(); 
						if (entry != 0) System.out.println("Profile Updated!");
					break;
					case 'L':
						System.out.print("Enter Last Name: ");
						String LN  = in.next();
						statement2 = cmain.conn.prepareStatement("UPDATE ChirpUserProfile SET last_name = ? WHERE user_id = ?" );
						statement2.setString(1, LN);
						statement2.setInt(2, userID);
						statement2.execute(); 
						if (entry != 0) System.out.println("Profile Updated!");
					break;
					case 'A':
						System.out.print("Enter Age: ");
						int age = in.nextInt();
						in.nextLine();
						statement2 = cmain.conn.prepareStatement("UPDATE ChirpUserProfile SET age = ? WHERE user_id = ?" );
						statement2.setInt(1, age);
						statement2.setInt(2, userID);
						statement2.execute(); 
						if (entry != 0) System.out.println("Profile Updated");
					break;
					case 'D':
						String desc;
						do{
							System.out.println("Edit Description: ");
							desc = in.nextLine();
						}while(desc.length() > 140);		
						statement2 = cmain.conn.prepareStatement("UPDATE ChirpUserProfile SET description = ? WHERE user_id = ?" );
						statement2.setString(1, desc);
						statement2.setInt(2, userID);
						statement2.execute(); 
						if (entry != 0) System.out.println("Profile Updated");
					break;
					case 'B':
					break;
					default:
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
			case 'U'://Add a Subscriber
				System.out.println("Enter username of person you want to subscribe to: ");
				String subName = in.next();
				in.nextLine();

				try{	
		
				cmain.open();
				Statement statement = cmain.conn.createStatement();
				PreparedStatement statement1;
				PreparedStatement statement2;
				statement2 = cmain.conn.prepareStatement("SELECT user_id FROM ChirpUser WHERE username = ? ");
				statement2.setString (1, subName);
				ResultSet rs = statement2.executeQuery();
				if (rs.next()){
					int subID = rs.getInt("user_id");
					statement1 = cmain.conn.prepareStatement("INSERT INTO Subscribe (user_id, subscribed_user_id) VALUES(?, ?)");
					statement1.setInt(1, userID);
					statement1.setInt(2, subID);
					statement1.execute();		
				}
				else{
					System.out.println("User does not exist.");
				}
					
				rs.close();
				statement.close();
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
			case 'K'://Like a Chirp
				System.out.println("Please enter ChirpID: ");
				int ChirpID = in.nextInt();
				in.nextLine();

				
				try{	
		
				cmain.open();
				PreparedStatement statement2;
				statement2 = cmain.conn.prepareStatement("UPDATE Chirp SET num_likes = num_likes+1 WHERE chirp_id = ? ");
				statement2.setInt (1, ChirpID);
				statement2.execute();
				statement2 = cmain.conn.prepareStatement("INSERT INTO Likes (chirp_id, new_user_id) VALUES(?, ?)");
				statement2.setInt(1, ChirpID);
				statement2.setInt(2, userID);
				statement2.execute(); 
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
			case 'P'://ReChirp	
				System.out.println("Please enter ChirpID: ");
				ChirpID = in.nextInt();
				in.nextLine();

				
				try{	
		
				cmain.open();
				PreparedStatement statement2;
				statement2 = cmain.conn.prepareStatement("UPDATE Chirp SET num_rechirps = num_rechirps+1 WHERE chirp_id = ? ");
				statement2.setInt (1, ChirpID);
				statement2.execute();
				statement2 = cmain.conn.prepareStatement("SELECT user_id FROM Chirp WHERE chirp_id = ?");
				statement2.setInt(1, ChirpID);
				ResultSet rs = statement2.executeQuery(); 
				int chirpUserID = 0;
				if (rs.next()){
					chirpUserID = rs.getInt("user_id");
				}
				rs.close();
				System.out.println("INSERTING");
				statement2 = cmain.conn.prepareStatement("INSERT INTO Rechirp (chirp_id, orig_user_id, new_user_id) VALUES(?, ?, ?)");
				statement2.setInt(1, ChirpID);
				statement2.setInt(2, chirpUserID);
				statement2.setInt(3, userID);
				statement2.execute(); 
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
			case 'H'://Hashtag
			break;
			case 'B'://Reply to
				
				
				try{	
		
				cmain.open();
				System.out.println("Enter ChirpID to reply to: ");
				ChirpID = in.nextInt();
				in.nextLine();
				boolean bPrivate = false;
				char input;
				statement = cmain.conn.prepareStatement("INSERT INTO Chirp(chirp, num_likes, num_rechirps, user_id, private, reply_to)  VALUES(?, ?, ?, ?, ?, ?)");
				System.out.println("Enter Chirp(Max 140): ");
				String Chirp = in.nextLine();
				statement.setString(1, Chirp);
				statement.setInt(2, 0);
				statement.setInt(3, 0);
				statement.setInt(4,userID);
				statement.setInt(6, ChirpID);
				do{	
					System.out.println("Do you want to set Chirp as private? (y/n) ");
					input = in.next().charAt(0);
					input = Character.toUpperCase(input);
					in.nextLine();
				}while((input != 'Y') && (input != 'N'));
				if (input == 'Y')bPrivate = true;
				else if (input == 'N') bPrivate = false;
				statement.setBoolean(5, bPrivate);	
				int  b = statement.executeUpdate();
		
				if(b > 0) System.out.println("Congratulations! You have made a Chirp");
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

			default:
				System.out.println("Not a valid selection, please try again");	
		}
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
				//		System.out.print("EQUALS");
						flag = true;
						System.out.println("Welcome to the System.");
						in.nextLine();
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
		case 'V'://LOOKING AT YOUR OWN PROFILE
			try{	
		
				cmain.open();
		
				Statement statement = cmain.conn.createStatement();
				ResultSet rs = statement.executeQuery("SELECT first_name, last_name, age, description, num_subscribers FROM ChirpUserProfile WHERE user_id =" +userID);
				//int usrID = rs.getInt("user_id");
				
				if (rs.next()){
					String FN = rs.getString(1);
					String LN = rs.getString(2);
					int age = rs.getInt(3);
					String desc = rs.getString(4);
					int numSub = rs.getInt(5);
					
					//clear the screen
					menu.clearScreen();
					menu.makeHeader("my profile");
	
					System.out.println("User ID: " + userID);
					System.out.println("First Name: " + FN);
					System.out.println("Last Name: " + LN);
					System.out.println("Age: " + age);
					System.out.println("Description: " + desc);
					System.out.println("Number of Subscribers: " + numSub);	

					//display menu
					//menu.displayFeedMenu(0, 1);
				}			
				rs.close();
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
		case 'S'://Search Functionality
				try{	
				String searchInput = menu.displaySearchMenu();	
				cmain.open();
				Statement statement = cmain.conn.createStatement();
				PreparedStatement statement1;
				PreparedStatement statement2;
				
				if (searchInput.charAt(0) ==  '#')//Hashtag
				{
					String searchSub = searchInput.substring(1, searchInput.length());
					int hashtagID = 0;
					statement1 = cmain.conn.prepareStatement("SELECT hashtag_id FROM HashtagDB WHERE hashtag = ? ");
					statement1.setString(1, searchSub);
					ResultSet rs = statement1.executeQuery();
					if (rs.next()){
						hashtagID = rs.getInt("hashtag_id");
					}
					rs.close();
					statement1.close();
					String chirp = " ";
					statement2 = cmain.conn.prepareStatement("SELECT chirp FROM Hashtag WHERE hashtag_id = ?");
					statement2.setInt(1, hashtagID);
					rs = statement2.executeQuery();
					while(rs.next()){
						chirp = rs.getString("chirp");
				//		System.out.println(chirp);//TEMPORARY, STILL NEEDS FORMATTING CHIRP AUTHOR, ONLY PUBLIC CHIRPS SHOWN
						
					}
					rs.close();
					statement2.close();
				statement2 = cmain.conn.prepareStatement("SELECT * FROM Chirp WHERE chirp = ? ORDER BY chirp_id DESC");
				statement2.setString(1, chirp);
		//		System.out.println("WHAT IS P: " + p);
				ResultSet rs2 = statement2.executeQuery();
				int chirpID;
				int uID;
				int numLikes;
				int numRechirps;
				boolean  prvt;
				String chirpUser = " ";	
	
				//clear and make header
				menu.clearScreen();	
				menu.makeHeader("Chirps containing " + searchSub);						
		      		while(rs2.next()){
							
						//Get data from database	
						chirpID = rs2.getInt("chirp_id");
						uID = rs2.getInt("user_id");
						numLikes = rs2.getInt("num_likes");
						numRechirps = rs2.getInt("num_rechirps");
						prvt = rs2.getBoolean("private");								
						chirpUser = userMap.get(uID);	
					//	ResultSet rs3 = statement.executeQuery("SELECT username FROM ChirpUser WHERE user_id=" +uID);
					//	while(rs3.next()){
					//		chirpUser = rs3.getString("username");
					//	}

						//Print data 	
						ViewChirp messageDisplay = new ViewChirp(chirpID, chirp, chirpUser, prvt, numLikes, numRechirps);
						messageDisplay.feedView();
			        		//Display values
			        		//System.out.print("ChirpID: " + chirpID);
			        		//System.out.print(" Chirp: " + chirp);
			        		//System.out.print(" User_ID: " + uID);
			        		//System.out.println(" private: " + prvt);
				}
				statement2.close();
				rs2.close();
				}
				else if (searchInput.charAt(0) == '@')//Username
				{

					//Grab stuff from the user profile
					String searchSub = searchInput.substring(1, searchInput.length());
					int SearchID = 0;
					statement1 = cmain.conn.prepareStatement("SELECT user_id FROM ChirpUser WHERE username = ? ");
					statement1.setString(1, searchSub);
					ResultSet rs = statement1.executeQuery();
					if (rs.next()){
						SearchID = rs.getInt("user_id");
					}
					rs.close();
					statement1.close();
					statement2 = cmain.conn.prepareStatement("SELECT * FROM ChirpUserProfile WHERE user_id = ?");
					statement2.setInt(1, SearchID);
		//			System.out.println("WHAT IS P: " + p);
					ResultSet rs2 = statement2.executeQuery();
					
					if (rs2.next()){
						
						String FN = rs2.getString("first_name");
						String LN = rs2.getString("last_name");
						int age = rs2.getInt("age");
						String desc = rs2.getString("description");
						int numSub = rs2.getInt("num_subscribers");
						
						//clear the screen
						menu.clearScreen();
						menu.makeHeader( FN + " profile");
		
						System.out.println("User ID: " + SearchID);
						System.out.println("First Name: " + FN);
						System.out.println("Last Name: " + LN);
						System.out.println("Age: " + age);
						System.out.println("Description: " + desc);
						System.out.println("Number of Subscribers: " + numSub);	
	
						//display menu
						//menu.displayFeedMenu(0, 1);
					}
					statement2.close();			
					rs2.close();					
				}
				else
				{
					//Query not found
				}
				} catch(SQLException sqlEx) {
					sqlEx.printStackTrace();
					System.exit(1);
				}/*  catch(ClassNotFoundException clsNotFoundEx){
					clsNotFoundEx.printStackTrace();
					System.exit(1);
				 }*/finally{
					try{
						cmain.close();
					} catch(Exception e){
						System.exit(1);
					}		
						
				}

			 
			
		break;
		case 'T'://Trending
				
			try{	
	
			menu.makeHeader("Top 5 Trending Hashtags");
			int pos = 1;
			cmain.open();
			Statement statement = cmain.conn.createStatement();
			ResultSet rs = statement.executeQuery("SELECT hashtag FROM HashtagDB ORDER BY num_hash DESC LIMIT 5");
			while(rs.next()){
				System.out.println( pos + ". " + rs.getString("hashtag"));
				pos++;
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
		switch(type){
		case ' ':	
		break;
		default:
			int p = 0;
			char k = ' ';
			int currentPage = 0;
			try{
			cmain.open();
			Statement statement = cmain.conn.createStatement();
			ResultSet rs = statement.executeQuery("SELECT subscribed_user_id  FROM Subscribe WHERE user_id=" +userID);
			while (rs.next()){
				array.add(rs.getInt("subscribed_user_id"));
			}
							
			for(int i = 0; i < array.size(); i++){
			System.out.println("Subscribers: ");
			System.out.println(array.get(i));}

			PreparedStatement statement2;

			do{
			statement2 = cmain.conn.prepareStatement("SELECT * FROM Chirp ORDER BY chirp_id DESC LIMIT ?, 5");
			statement2.setInt(1, p);
		//	System.out.println("WHAT IS P: " + p);
			ResultSet rs2 = statement2.executeQuery();
			int chirpID;
			int uID;
			int numLikes;
			int numRechirps;
			boolean prvt;
			String chirpUser = " ";	

			//clear and make header
			menu.clearScreen();	
			menu.makeHeader("subscriber feed");						
	      		while(rs2.next()){
				for(int i=0; i< array.size(); i++){
					if(array.get(i) == rs2.getInt("user_id")){
						
						//Get data from database	
	        				String chirp  = rs2.getString("chirp");
						chirpID = rs2.getInt("chirp_id");
						uID = rs2.getInt("user_id");
						numLikes = rs2.getInt("num_likes");
						numRechirps = rs2.getInt("num_rechirps");
						prvt = rs2.getBoolean("private");								
						chirpUser = userMap.get(uID);	
					//	ResultSet rs3 = statement.executeQuery("SELECT username FROM ChirpUser WHERE user_id=" +uID);
					//	while(rs3.next()){
					//		chirpUser = rs3.getString("username");
					//	}

						//Print data 
						ViewChirp messageDisplay = new ViewChirp(chirpID, chirp, chirpUser, prvt, numLikes, numRechirps);
						messageDisplay.feedView();

		        			//Display values
		        			//System.out.print("ChirpID: " + chirpID);
		        			//System.out.print(" Chirp: " + chirp);
		        			//System.out.print(" User_ID: " + uID);
		        			//System.out.println(" private: " + prvt);
			}}}
			statement2.close();
			rs2.close();

						k = menu.displayFeedMenu(currentPage, 3);
						if(k == 'N'){
							p = p + 5;
							currentPage++;
						}
						else if(k == 'P'){
							p = p - 5;
							currentPage--;
						}
						else{
						}
			}while(k != 'B');
			array.clear();
			} catch(SQLException sqlEx) {
                                sqlEx.printStackTrace();
                                System.exit(1);
                        }finally{
                                        try{
                                                cmain.close();
                                        } catch(Exception e){
                                                System.exit(1);
                                        }
				}


			
		break;
 
	}
		return true;
	}

	public void Hashtag(String chirp){
		int h1 = chirp.indexOf("#", 0);
		int h = chirp.indexOf(" ", h1+1);
		String h2;
		boolean flag = false;
		int chirpID = 0;
		int hashtagID = 0;

		if (h1 != -1){
			if(h == -1){
				h2 = chirp.substring(h1+1);
			}
			else{
				h2 = chirp.substring(h1+1, h);
			}
		try{
			
			ResultSet rs = statement.executeQuery("SELECT hashtag FROM HashtagDB");
			while (rs.next()){
				String hashtag  = rs.getString("hashtag");
				//Checks CASE SENSITIVITY
				String hashtagUP = hashtag.toUpperCase();
				String h2UP = h2.toUpperCase();
				if (h2UP.equals(hashtagUP)){
					flag = true;
				}}
			rs.close();
			if (!flag){
			
				statement = cmain.conn.prepareStatement("INSERT INTO HashtagDB(hashtag)  VALUES(?)");
				statement.setString(1, h2);
				statement.executeUpdate();
			}
			PreparedStatement statement2;
			statement2 = cmain.conn.prepareStatement("SELECT chirp_id FROM Chirp WHERE chirp = ? ");
			statement2.setString (1, chirp);
			rs = statement2.executeQuery();
			if (rs.next()){
				chirpID  = rs.getInt("chirp_id");
			}
			rs.close();
			statement2 = cmain.conn.prepareStatement("SELECT hashtag_id FROM HashtagDB WHERE hashtag = ? ");
			statement2.setString (1, h2);
			rs = statement2.executeQuery();
			if (rs.next()){
				hashtagID  = rs.getInt("hashtag_id");
			}

			statement2 = cmain.conn.prepareStatement("UPDATE HashtagDB SET num_hash = num_hash+1 WHERE hashtag_id = ? ");
			statement2.setInt(1, hashtagID);
			statement2.execute();

			statement = cmain.conn.prepareStatement("INSERT INTO Hashtag (hashtag_id, chirp_id, chirp) VALUES(?, ?, ?)");
			statement.setInt(1, hashtagID);
			statement.setInt(2, chirpID);
			statement.setString(3, chirp); 
			statement.executeUpdate();
			} catch(SQLException sqlEx) {
				sqlEx.printStackTrace();
				System.exit(1);
			}
	}
	}
	
	
	private int userID;

	protected PreparedStatement statement;

	protected Connection conn;
	
	protected Menu menu = new Menu();
	
	protected ChirperMain cmain;
	
	Scanner in = new Scanner(System.in);

	HashMap<Integer, String> userMap;

	List<Integer> array = new ArrayList<Integer>();
}
