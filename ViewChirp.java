/**
 * ViewChirp class.
 * implements the View interface. Allows the user to view one individual tweet.
 */
public class ViewChirp //implements View
{
	//DATA MEMBERS
	int chirpID;
	String chirpMessage;
	String username;
	boolean privateMessage;
	int numLikes;
	int numRechirps;

	public ViewChirp(int cid, String chmes, String user, boolean prvt, int likes, int rechirps)
	{
		chirpID = cid;
		chirpMessage = chmes;
		username = user;
		privateMessage = prvt;
		numLikes = likes;
		numRechirps = rechirps;
	}

	public char chirpView()
	{
		char input = ' ';
		Menu menu = new Menu(); //make menu

		while (input != 'B')
		{	
			//Print the feed view
			feedView();
			//Add extra details
			System.out.print("    Likes: " + numLikes + " Rechirps: " + numRechirps);	
			//Print the menu
			boolean valid = false;
			do { 
				input = menu.displayChirpMenu();
			} while (!valid);
		}
		return input;
	}	
	
	/**
 	 * printChirp method.
	 * Prints an individual chirp from the database.
	 */ 
	public void feedView()
	{
		//Print ID
		System.out.print(chirpID);
		//do the tab thing
		int temp = chirpID;
		while (temp > 10)
		{
			System.out.print(temp + " ");
			temp = temp % 10;	
		}	
		//Print username
		System.out.print(username);
		//Print chirp text
		System.out.println("    " + chirpMessage);
	}
}
