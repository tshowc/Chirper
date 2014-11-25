/**
 * ViewChirp class.
 * implements the View interface. Allows the user to view one individual tweet.
 */
public class ViewChirp implements View
{
	//DATA MEMBERS
	int chirpID;
	int numIndex;

	public ViewChirp(int id, int num)
	{
		chirpID = id;
		numIndex = num;
	}

	public void displayChirps()
	{
		char input = ' ';
		Menu menu = new Menu();
		while (input != 'B')
		{
			//Find the chirp with the given ID
			
			//Print the chirp
			printChirp(numIndex);
			//Print the menu
			boolean valid = false;
			do { 
				input = menu.displayChirpMenu(ownChirp);
				if (input == 'L')
				{
					//Like the chirp	
				}
				else if (input == 'R')
				{
					//Retweet the chirp
				}
			} while (!valid);
		}
	}	
	
	/**
 	 * printChirp method.
	 * Prints an individual chirp from the database.
	 */ 
	public void printChirp(int num)
	{
		//Print number
		System.out.print(num + " ");
		//Print username
		String username = " "; 
		System.out.println(username);
		//Print chirp text
		String chirpText = " ";
		System.out.println("  " + chirpText);
	}
}
