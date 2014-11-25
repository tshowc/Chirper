/**
 * View interface.
 * Used to display information taken from the database into a feed. Comes as an interface
 * because many different types of feeds will be used.
 *
 * Every feed will display a MAX number of chirps  
 */

import java.util.Scanner;

public interface View
{	
	/**
	 * displayChirps method.
	 * Displays a certain number of chirps that are relevant to the criteria of the View.
	 */
	public void displayChirps(); 

	/**
 	 * printChirp method.
	 * Displays an individual chirp in a feed.
	 * @param id user id number as an integer
	 * @param num index of the chirp in the feed
	 */
	public void printChirp();
	
	/**
	 * getInput method.
	 * Gets the user's input on a menu. 
	 * @return user input
	 */
//	public char getInput()
//	{
//		//declare variables 
//		Scanner in = new Scanner(System.in);
//
//		//Get input
//		System.out.print("> ");
//		int userInput = in.nextInt();
//		//userInput = Character.toUpperCase(userInput);
//		return userInput;
//	}
}
