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
         */
	public char displayMain()
	{
		//Print logo
		printLogo();

		//Print title
		System.out.println("----------------------------------------------");
		System.out.println("                 MAIN  MENU                   ");
		System.out.println("----------------------------------------------\n");
                
		//Print options
		System.out.println("Please select an option:");
		System.out.println("V: View Profile");
		System.out.println("E: Edit Profile");
		System.out.println("S: Search");
		System.out.println("T: Trending");
		System.out.println("F: Return to Feed");
		System.out.println("M: Make a Post");
		System.out.println("D: Delete a Post");
		System.out.println("Q: Quit\n");

		//Get user input
		boolean valid = true;
		do {
			char input = getInput();
			//vvv this part down here looks pretty gross. Let me know if there's a better way to check for a vaid character.
			if (input == 'V' || input == 'E' || input == 'S' || input == 'T' || input == 'F' || input == 'M' || input == 'D' || input ==  'Q'input)
			{
				return input;
			}
			else
				System.out.println("Please enter a valid character.");
		} while (!valid)
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
		System.out.println("    |_____|_|_|_|_| |  _|___|_|===="+'"'+"="+'"'+"===<    ");
                System.out.println("                    |_|            |_|              \n");
	}
	
	/**
	 * displaySearchMenu method.
	 * Displays the search menu and returns the user input.
	 * @return user input
	 */
	public char displaySearchMenu()
	{
		//Print title
		System.out.println("----------------------------------------------");
		System.out.println("                    SEARCH	                  ");
		System.out.println("----------------------------------------------\n");

		//Print options
		System.out.println("- To search for a user, add an @ to the\nbeginning of the query.");
		System.out.println("- To search for a tag, add a # to the beginning\nof the query.\n");
		
		//Get user input
		return getInput();
	}
	
	/**
	 * getInput method.
	 * Gets the user's input on a menu. 
	 * @return user input
	 */
	public char getInput()
	{
		//declare variables 
		Scanner in = new Scanner(System.in);
		boolean valid = false;		

		//Get input
		System.out.print("> ");
		char userInput = in.next().charAt(0);
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

	public char displayFeedMenu() 
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
	public char displayChirpMenu()
	{
		//Chirp displayed above menu
		//Print options
		System.out.println("L: Like/Unlike");
		System.out.println("R: Rechirp");
		//IF IT'S THEIR OWN CHIRP
		System.out.println("D: Delete Chirp"); 
		System.out.println("B: Back");

		//Get input
		return getInput();
	}

	public char displayLoginMenu()
	{
		//Print logo
		printLogo();
		
		//Print message and options
		System.out.println("Welcome! Would you like to Login or Register?");
		System.out.println("L: Login");
		System.out.println("R: Register\n");

		//Get user input
		return getInput();
	}
}
