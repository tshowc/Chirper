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

	public char chirpView(int likes, int rechirps)
	{
		char input = ' ';
		Menu menu = new Menu(); //make menu

		while (input != 'B')
		{	
			//Print the feed view
			feedView();
			//Add extra details
			System.out.println("    Likes: " + likes + " Rechirps: " + rechirps);	
			//Print the menu
			 
			input = menu.displayChirpMenu();
			input = Character.toUpperCase(input);
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
		System.out.print("\n" + chirpID);
		//Print username
		System.out.printf("  " + "%-4s", username);
		//Print chirp text
		System.out.println();
		if (Integer.toString(chirpID).length() > 1){
			System.out.printf("    " + "%-4s", chirpMessage);}
		else{
			System.out.printf("   " + "%-4s", chirpMessage);}
		System.out.println();
		
	}
}
