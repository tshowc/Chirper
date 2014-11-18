public class MenuTest
{
	public static void main(String[] args)
	{
		//create menu object
		Menu test = new Menu();

		//display main menu
		char mainOutput = test.displayMain();
		System.out.println(mainOutput);

		//display search menu
		String searchOutput = test.displaySearchMenu();
		System.out.println(searchOutput);

		//dispay feed menu
		char feedOutput = test.displayFeedMenu(0, 1);
		System.out.println(feedOutput);
	}
}
