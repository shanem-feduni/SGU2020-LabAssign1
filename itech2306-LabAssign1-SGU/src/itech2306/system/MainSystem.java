package itech2306.system;

import java.util.Scanner;

// The following class will be the one to run for the main menu-based program.

public class MainSystem {
	private Scanner console;
	private int choice;
	private boolean stillRunning;

	private final static String SYSTEM_TITLE = "Customer Management and Billing System\n" +
			                                   "======================================";	

	public static void main(String[] args)
	{
		MainSystem system = new MainSystem();
		system.setup();				// Set up the system to be ready for menu operations.
		system.operateMenu();		// Commence using the menu to direct the flow of the program.
	}

	public void setup()
	{
		// Insert here relevant code to do any necessary setting-up of the system

		
		
		System.out.println("System is now set-up and ready for use.");
	}
	
	public void operateMenu()
	{
		console = new Scanner(System.in);
		
		stillRunning = true;		// in order to commence program
		
		while (stillRunning)		// in order to know when the program should end (because stillRunning should become false then).
		{
			showMainMenu();
			choice = getUserSelection(0,5);
			processChoiceMainMenu(choice);
		}
		console.close();		
	}

	private void showMainMenu()
	{
		System.out.println();		// ensure a break between previous output and the menu
		System.out.println(SYSTEM_TITLE);
		System.out.println();
		System.out.println("What would you like to do?");
		System.out.println("1.  Menu Option 1");
		System.out.println("2.  Menu Option 2");
		System.out.println("3.  Menu Option 3");
		System.out.println("4.  Menu Option 4");
		System.out.println("5.  Menu Option 5");
		System.out.println("0.  Exit Program");

	}


	private void processChoiceMainMenu(int choice) 
	{
		// This method should determine which choice was selected from Main Menu,
		// and then call some other method to do the actual steps for that method.
		switch (choice)
		{
			case 1:
				// Call a method that deals with this menu option
				break;
			case 2:
				// Call a method that deals with this menu option
				break;
			case 0:
				System.out.println("Exiting the system...");
				stillRunning = false;		  // causes the main loop of program to end (i.e. quits)
				break;
			default:
				System.out.println("Unexpected selection made. Doing nothing.");
				break;
		}
	}

	/** This method will ask the user to enter a number from 'lower' to 'upper', and strictly wait until a number is entered
	 *  that fits that range.
	 * @param lower  The lowest acceptable number the user can enter
	 * @param upper  The highest acceptable number the user can enter
	 * @return  The number that the user enters, or 0 if there was a problem with the parameters.
	 */
	private int getUserSelection(int lower, int upper) 
	{
		if (lower > upper)
			return 0;
		int userInput;
		do {
			System.out.print("Enter a selection ("+lower + "-" + upper+"):");
			if (!console.hasNextInt())
				userInput = upper+1;
			else
				userInput = console.nextInt();	// obtain the input
			console.nextLine();					// gets rid of the newline after the number we just read
			if (userInput < lower || userInput > upper)
				System.out.println("Invalid choice.");
		} while (userInput < lower || userInput > upper);
		System.out.println();		// put a space before the next output	
		return userInput; 

	}
}
