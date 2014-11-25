import java.util.Scanner;

public class ViewFeed implements View
{
	public ViewFeed()
	{

	}

	public ViewFeed()
	{
	
	}

	public void displayChirps() 
	{
		//DATA MEMBERS
		Menu menu = new Menu();
		final int MAX = 5;
		int totalPages;
		int numResults;
		char input;	
		int currentPage = 1;

		//Search for chirps needed and count number	
		{
			//Increment the number of results
			numResults = 0; //CHANGE LATER
		}
		
		//Set the number of pages needed to the number of search results divided
		//by MAX.
		totalPages = numResults/MAX;	
		int id = 0;	
		do {
			//Display the MAX per page number of chirps		
			for (int i = 0; i < MAX; i++)
			{
				//Find next newest chirp
				
				//Get id number of chirp
				
				//Print chirp	
				printChirp(i+1);
			}

			//Print menu at the bottom
			input = menu.displayFeedMenu(currentPage, totalPages);
			if (input == 'N')
				currentPage++;
			else if (input == 'P')
				currentPage--;
			else if (input == 'S')
			{
				int selectNum = 0;
				do {
					System.out.println("Which post would you like to select?");
					selectNum  = getInput();	
				} while ((selectNum > MAX) || (selectNum <= 0)); //MAKE SURE THEY CAN'T SELECT A POST THAT DOESN'T EXIST
				//What if there are fewer than the MAX posts on a page?
				
				//Get data for that chirp
				id = 0;
				int num = 0;
				//IF OWN CHIRP, SET TO TRUE
				boolean ownChirp = false; 
				//Go to chirp menu
				ViewChirp chirp = new ViewChirp(id, num, ownChirp);
			}	
		} while (input != 'B');
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
		//Find at set username using user id
		String username = " "; 
		System.out.println(username);
		//Print chirp text
		String chirpText = " ";
		System.out.println("  " + chirpText);
	}
	
	/**
	 * getInput method.
	 * Gets the user's input on a menu. 
	 * @return user input
	 */
	public int getInput()
	{
		//declare variables 
		Scanner in = new Scanner(System.in);

		//Get input
		System.out.print("> ");
		int userInput = in.nextInt();
		//userInput = Character.toUpperCase(userInput);
		return userInput;
	}

}
