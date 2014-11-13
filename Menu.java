import java.util.Scanner;

/**
 * Menu class for group project. Displays a menu of choices for the user
 * to select. A method can be used to display each type of menu.
 */
public class Menu
{
	//DATA VALUES
	protected Scanner in = new Scanner(System.in);

	/**
	 * Default Constructor
	 */
	public Menu()
	{
		
	}

	/**
	 * displayMain class.
	 * Displays the main menu and returns user input.
	 * @return user input
         */
	String public displayMain()
	{
		//Print logo
		Sysetm.out.println("	 _____ _   _                   .-.        ");
		System.out.println("    |     | |_|_|___ ___ ___ ___  /'v'\       ");
		System.out.println("    |   --|   | |  _| . | -_|  _|(/   \)      ");
		System.out.println(" 	|_____|_|_|_|_| |  _|___|_|===="="===<    ");
                System.out.println("                    |_|            |_|      \n");

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
		System.out.print("> ");
		String userInput = in.next();
		return userInput;
	}

	/**
	 * Displays the search menu
	 */
	public displaySearch()
	{
		
	}
}
