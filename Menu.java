import java.util.Scanner;

/**
 * Menu class for group project. Displays a menu of choices for the user
 * to select. A method can be used to display each type of menu and the user can select
 * options from this menu that will be returned as a character.
 * 
 * However, there are exceptions to this. The search menu will return a string object that
 * is the user's search criteria. This must be taken into account when processing the 
 * return types of these methods.
 * 
 * Some methods also need additional parameters to determine certain actions in the menu. For
 * example, the menu for a feed requires that some input be given for the number of pages
 * so the "Next page" option won't appear when there are no other pages.
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
		boolean valid = false;
		char input;
		do {
			input = getInput();
			//vvv this part down here looks pretty gross. Let me know if there's a better way to check for a vaid character.
			//Other possibilties: switch statements? Exceptions?
			if ((input == 'V') || (input == 'E') || (input == 'S') || (input == 'T') || (input == 'F') || (input == 'M') || (input == 'D') || (input ==  'Q'))
			{
				valid = true;
			}
			else
				System.out.println("Please enter a valid character.");
		} while (!valid);
		
		//Return result
		return input;
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
	 * NOTE: Most methods return a primitive char, but this method returns a String object.
	 * This is because the method is taking a search item; it is not selecting an item in 
	 * a menu.
	 * @return user input
	 */
	public String displaySearchMenu()
	{
		//Print title
		System.out.println("----------------------------------------------");
		System.out.println("                    SEARCH	                  ");
		System.out.println("----------------------------------------------\n");

		//Print options
		System.out.println("- To search for a user, add an @ to the\nbeginning of the query.");
		System.out.println("- To search for a tag, add a # to the beginning\nof the query.\n");
		System.out.println("Please keep search query at one work (ex: #chirpExample, @usernameExample)");		

		//Get user input
		boolean valid = false;
		String input;
		Scanner in = new Scanner(System.in);
		do {
			System.out.print("> ");
			input = in.next();
			//Testing substring
			//System.out.println(input.substring(0, 1));
			if (input.substring(0, 1).equals( "#"))
			{
				valid = true;
			}
			else if (input.substring(0, 1).equals("@"))
			{
				valid = true;	
			}
			else
			{
				System.out.println("We encountered an error processing your search!");
				System.out.println("Please ensure that your criteria complies with the search instructions.");
			}
		} while (!valid);
		return input;
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
		userInput = Character.toUpperCase(userInput);
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

	public char displayFeedMenu(int currentPage, int totalPages) 
	{
		//Print options
		//IF NEXT PAGE
		if (currentPage < totalPages)
			System.out.println("N: Next Page");
		//IF PREVIOUS PAGE
		if (currentPage != 0)
			System.out.println("P: Previous Page");
		System.out.println("S: Select Post");
		System.out.println("B: Back");

		//Get input
		char input;
		boolean valid = false;
		do {
			input = getInput();
			if ((input == 'N') && (currentPage >= totalPages))
			{
				System.out.println("Cannot go to next page!");	
			}
			else if ((input == 'P') && (currentPage == 0))
			{
				System.out.println("Cannot go to previous page!");
			}
			else if ((input == 'N') || (input == 'P') || (input == 'S') || (input == 'B'))
			{
				valid = true;
			}
			else
			{
				System.out.println("Please enter a valid character.");
			}
		} while(!valid);

		//Return result
		return input;
	}

	/**
	 * displayChirpMenu method.
	 * Displays the menu for selecting a chirp.
	 * @return user input
	 */
	public char displayChirpMenu(boolean isUserChirp)
	{
		//Chirp displayed above menu
		//Print options
		System.out.println("L: Like/Unlike");
		System.out.println("R: Rechirp");
		//IF IT'S THEIR OWN CHIRP (need an if statement)
		System.out.println("D: Delete Chirp"); 
		System.out.println("B: Back");

		//Get input
		char input;
		boolean valid = false;
		do {
			input = getInput();
			if ((input == 'D') && !isUserChirp)
				System.out.print("You can't delete someone else's chirp!");
			else if ((input == 'L') || (input == 'R') || (input == 'D') || (input == 'B'))
				valid = true;
			else 
				System.out.println("Please enter a valid character.");
		} while (!valid);
		return input;
	}

	/**
	 * displayLoginmenu method.
	 * Displays the login or register menu.
	 * @return user input
	 */
	public char displayWelcomeMenu()
	{
		//Print logo
		printLogo();
		
		//Print title
		System.out.println("----------------------------------------------");
		System.out.println("                  WELCOME                     ");
		System.out.println("----------------------------------------------\n");
	
		//Print message and options
		System.out.println("Welcome! Would you like to Login or Register?");
		System.out.println("L: Login");
		System.out.println("R: Register\n");
		System.out.println("Q: Quit");
	
		//Get user input
		boolean valid = false;
		char input;
		do {
			input = getInput();
			if ((input == 'L') || (input == 'R') || (input == 'Q'))
				valid = true;
			else
				System.out.println("Please enter a valid character.");
		} while (!valid);
		return input;
	}

	public void displayLoginMenu()
	{
		//Create new scanner
		Scanner in = new Scanner(System.in);
		
		//Print title
		System.out.println("----------------------------------------------");
		System.out.println("                   LOGIN                      ");
		System.out.println("----------------------------------------------");
			
		//Print options
		//System.out.print("Username: ");
		//String userName = in.next();
		//NEED TO DOUBLE CHECK PASSWORD
		//System.out.print("Password: ");
		//String password1 = in.next();
	}

	public void displayRegisterMenu()
	{
		//Print title
		System.out.println("----------------------------------------------");
		System.out.println("                 REGISTER                     ");
		System.out.println("----------------------------------------------");
		
		//Print options
		//NEED TO CHECK IF USERNAME IS ALREADY TAKEN
		//System.out.print("Username: ");
		//String userName = in.next();
		//NEED TO DOUBLE CHECK PASSWORD
		//System.out.print("Password: ");
		//String password1 = in.next();
		//System.out.print("Please verify password: ");
		//String password2 = in.next();
	}

	/**
	 * displayEditProfile method.
	 * Displays the menu for editing a profile.
	 */
	public char displayEditProfile()
	{
		//Print Title
		System.out.println("---------------------------------------------");
		System.out.println("                 EDIT PROFILE                ");
		System.out.println("---------------------------------------------\n");
		
		//Print message and options
		System.out.println("What would you like to edit?");
		System.out.println("F: First Name");
		System.out.println("L: Last Name");
		System.out.println("A: Age");
		System.out.println("D: Description");
		System.out.println("B: Back");

		//Get user input
		return getInput();
	}
}
