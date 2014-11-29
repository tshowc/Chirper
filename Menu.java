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
		//clear the screen
		clearScreen();

		//Print header
		makeHeader("Main Menu");
                
		//Print options
		System.out.println("Please select an option:");
		System.out.println("V: View Profile");
		System.out.println("E: Edit Profile");
		System.out.println("S: Search");
		System.out.println("T: Trending");
		System.out.println("F: View Feed");
		System.out.println("M: Make a Chirp");
		System.out.println("U: Subscribe to User");
		System.out.println("K: Like a Chirp");
		System.out.println("P: Rechirp a Chirp");
		System.out.println("B: Reply to a Chirp");
		System.out.println("L: Logout");

		//Get user input
		boolean valid = false;
		char input;
		do {
			input = getInput();
			//vvv this part down here looks pretty gross. Let me know if there's a better way to check for a vaid character.
			//Other possibilties: switch statements? Exceptions?
			if ((input == 'V') || (input == 'E') || (input == 'S') || (input == 'T') || (input == 'F') || (input == 'M') || (input ==  'L') || (input == 'U') || (input == 'K') || (input == 'P') || (input == 'B'))
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
	private void printLogo()
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
		clearScreen();

		//Print header
		makeHeader("Search");

		//Print options
		System.out.println("- To search for a user, add an @ to the beginning of the query.");
		System.out.println("- To search for a tag, add a # to the beginning of the query.");
		System.out.println("- Please keep search query at one work (ex: #chirpExample, @usernameExample)");
		//System.out.println("- To exit out of search please type Q.")		

		//Get user input

		boolean valid = false;
		String input;
		Scanner in = new Scanner(System.in);
		do {
			System.out.print("\n> ");
			input = in.next();
			in.nextLine();
			//Testing substring
			//System.out.println(input.substring(0, 1));
			if (input.charAt(0) ==  '#')
			{
				valid = true;
			}
			else if (input.charAt(0) == '@')
			{
				valid = true;	
			}
		/*	//Allows user to quit out of loop
			else if (input.equals("q") || input.equals("Q")){
				valid = true;
			}*/
			else
			{
				System.out.println("We encountered an error processing your search!");
				System.out.println("Please ensure that your criteria complies with the search instructions.");
			}
		} while (!valid);
		return input;
	}

	public void makeHeader(String header)
	{
		//Print logo
		printLogo();

		//Make it caps
		header = header.toUpperCase();

		//print header
		System.out.println("----------------------------------------------");
		for (int i = 0; i < ((46 - header.length()) / 2); i++)
			System.out.print(" ");	
		System.out.println(header);
		System.out.println("----------------------------------------------\n");
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
		System.out.print("\n> ");
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
		System.out.println("L: Like Post");
		System.out.println("R: Rechirp Post");
		System.out.println("M: Reply to Post");
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
			else if ((input == 'N') || (input == 'P') || (input == 'S') || (input == 'B') || (input == 'L') || (input == 'R') || (input == 'M'))
			{
				valid = true;
			}
			else
			{
				System.out.println("Please enter a valid character.");
			}
		} while(!valid);

		//Return input
		return input;
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
		//System.out.println("L: Like/Unlike");
		//System.out.println("R: Rechirp"); 
		System.out.println("B: Back");

		//Get input
		char input;
		boolean valid = false;
		do {
			input = getInput();
			if ((input == 'L') || (input == 'R') || (input == 'B'))
				valid = true;
			else 
				System.out.println("Please enter a valid character.");
		} while (!valid);

		//Return input
		return input;
	}

	/**
	 * displayLoginmenu method.
	 * Displays the login or register menu.
	 * @return user input
	 */
	public char displayWelcomeMenu()
	{
		clearScreen();

		//Print header
		makeHeader("welcome");
	
		//Print message and options
		System.out.println("Welcome! Would you like to Login or Register?");
		System.out.println("L: Login");
		System.out.println("R: Register\n");
		System.out.println("Q: Quit");
	
		//Get input
		boolean valid = false;
		char input;
		do {
			input = getInput();
			if ((input == 'L') || (input == 'R') || (input == 'Q'))
				valid = true;
			else
				System.out.println("Please enter a valid character.");
		} while (!valid);

		//Return input
		return input;
	}

	public void displayLoginMenu()
	{
		clearScreen();
		//Print title
		makeHeader("login");		
	
		//Print options
		//System.out.print("Username: ");
		//String userName = in.next();
		//NEED TO DOUBLE CHECK PASSWORD
		//System.out.print("Password: ");
		//String password1 = in.next();
	}

	public void displayRegisterMenu()
	{
		//clear screen
		clearScreen();

		//Print header
		makeHeader("register");
	
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
		//clear the screen
		clearScreen();

		//Print header
		makeHeader("Edit profile");
	
		//Print message and options
		System.out.println("What would you like to edit?");
		System.out.println("F: First Name");
		System.out.println("L: Last Name");
		System.out.println("A: Age");
		System.out.println("D: Description");
		System.out.println("B: Back");

		//Get user input
		boolean valid = false;
		char input;
		do {
			input = getInput();
			if ((input == 'F') || (input == 'L') || (input == 'A') || (input == 'D') || (input == 'B'))
				valid = true;
			else
				System.out.println("Please enter a valid character.");
		} while (!valid);

		//Return input
		return input;
	}
	
	public void clearScreen()
	{	
		//clear the screen
		//System.out.print("\033[H\033[2J");
		//System.out.flush();
	}
}
