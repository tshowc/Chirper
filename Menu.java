import java.util.Scanner;

/**
 * Menu class for group project. Displays a menu of choices for the user
 * to select. A method can be used to display each type of menu.
 */
public class Menu
{
	/**
	 * Default Constructor.
	 * ANYTHING NEEDED IN THE CONSTRUCTOR?
	 */
	public Menu()
	{
		//???????????????		
	}

	/**
	 * displayMain class.
	 * Displays the main menu and returns user input.
	 * @return user input
p
         */
	public String displayMain()
	{
		//Print logo
		printLogo();

		//Print title
		System.out.println("----------------------------------------------");
		System.out.println("                     MENU                     ");
		System.out.println("----------------------------------------------");
                
		//Print options
		System.out.println("\nPlease select an option:");
		System.out.println("V: View Profile");
		System.out.println("E: Edit Profile");
		System.out.println("S: Search");
		System.out.println("T: Trending");
		System.out.println("F: Return to Feed");
		System.out.println("M: Make a Post");
		System.out.println("D: Delete a Post");
		System.out.println("Q: Quit\n");

		//Get user input
		return getInput();
	}

	/**
	 * printLogo class.
	 * Prints the logo. 
	 */	
	public void printLogo()
	{
		System.out.println(" ");
		System.out.println("     _____ _   _                   .-.                ");
		System.out.println("    |     | |_|_|___ ___ ___ ___  /'v'|               ");
		System.out.println("    |   --|   | |  _| . | -_|  _|(/   |)              ");
		System.out.println("    |_____|_|_|_|_| |  _|___|_|===="+'"'+'='+"===<    ");
                System.out.println("                    |_|            |_|              \n");
	}
	
	/**
	 * displaySearchMenu method.
	 * Displays the search menu and returns the user input.
	 * @return user input
	 */
	public String displaySearchMenu()
	{
		//Print title
		System.out.println("----------------------------------------------");
		System.out.println("                    SEARCH	                  ");
		System.out.println("----------------------------------------------");

		//Print options
		System.out.println("- To search for a user, add an @ to the/nbeginning of the query.");
		System.out.println("- To search for a tag, add a # to the beginning/nof the query.");
		
		//Get user input
		return getInput();
	}
	
	/**
	 * getInput method.
	 * Gets the user's input on a menu. 
	 * @return user input
	 */
	public String getInput()
	{
		//declare Scanner object
		Scanner in = new Scanner(System.in);
		
		//Get input
		System.out.print("> ");
		String userInput = in.next();
		return userInput;
	}

	/**
	 * displayFeedMenu method.
	 * Displays the menu at the bottom of the feed and returns the user input. Can
	 * be used as a decoration for the main feed, viewing a user's profile, search 
	 * results (positive or negative), etc.
	 * MAY NEED TO TAKE IN PAGE NUMBERS AS AN INT; OTHERWISE NEED SOME METHOD TO
	 * IDENTIFY AN AVAILABLE NEXT PAGE OR AVAILABLE PREVIOUS PAGE
	 * @return user input
	 */

	public String displayFeedMenu() 
	{
		//Print options
		//IF NEXT PAGE
		System.out.println("N: Next Page");
		//IF PREVIOUS PAGE
		System.out.println("P: Previos Page");
		System.out.println("S: Select Post");
		System.out.println("B: Back");

		//Get input
		return getInput();
	}

	/**
	 * displayChirpMenu method.
	 * Displays the menu for selecting a chirp.
	 * @return user input
	 */
	public String displayChirpMenu()
	{
		//Chirp displayed above menu
		//Print options
		System.out.println("L: Like/Unlike");
		System.out.println("R: Retweet");
		//IF IT'S THEIR OWN CHIRP
		System.out.println("D: Delete Chirp"); 
		System.out.println("B: Back");

		//Get input
		return getInput();
	}
}
