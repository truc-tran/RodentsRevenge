package rodents_revenge;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * <code>GameDemo</code> is a driver class that initiates a game of Rodent's Revenge.
 * It prompts the user to enter a number of rows and columns (specifying how many total spaces
 * on the Board).  Both rows and columns must be > 0.
 * <p>
 * It also prompts the user to enter the number of rodent's in the classroom.  There must be at least
 * one rodent on the board, but there can be no more than the (total spaces - 1), since there must be a 
 * space for the player.
 * <p>
 * It creates a new board with the user's parameters (rows, columns and number of rodents), displays it,
 * then keeps moving all the characters until the game is over.  The game terminates when either a) The Player dies
 * from bubonic plague because a Rodent moves into their space or b) The Player evicts all Rodents (all rodents eat
 * a pellet dropped by the player).
 * 
 * @author Michael Paulding
 * @version 1.0
 *
 */
public class GameDemo {

	/**
	 * Main method initiates the Rodents' Revenge game.
	 * 
	 * @param args Command line arguments (unused in this game).
	 */
	public static void main(String[] args) {

		int numRodents, rowSize, colSize, maxRodents;
		Scanner consoleScanner = new Scanner(System.in);

		System.out.println("Welcome to THE RODENTS' REVENGE!");		
		rowSize = validateInputMin(consoleScanner, "How many rows are in the room?", 1, "Please enter a row size > 0.");
		colSize = validateInputMin(consoleScanner, "How many columns are in the room?", 1, "Please enter a column size > 0.");
		maxRodents = (rowSize * colSize) - 1;
		numRodents = validateInput(consoleScanner, "How many rodents have invaded the MBCC?", 1, maxRodents, 
				"Please enter a number of rodents > 0 and less than or equal to " + maxRodents);

		
		Board gameBoard = new Board(rowSize, colSize, numRodents);
		System.out.println("\n" + gameBoard + "\n");
		do {
			gameBoard.moveAllCharacters();
			System.out.println(gameBoard);

		} while (!gameBoard.isGameOver());

		if (gameBoard.isPlayerAlive())
			System.out.println("You win!  Congratulations evicting all the rodents from the MBCC.");
		else
			System.err.println("Player has been consumed by the bubonic plague." +
					"\nPlease save humanity and do not bring food into MBCC classrooms!");		

		
	
	}
	/**
	 * Validates user input to prompt them with a message, read an int from the consoleScanner, validate that it is in range
	 * between min and max.  If the input is valid, it is returned, otherwise a user is prompted again in a loop until valid input
	 * is entered. 
	 * @param consoleScanner Used to read user input from the console.
	 * @param message The message to display to the user.
	 * @param min The minimum value allowed.
	 * @param max The maximum value allowed.
	 * @param errorMessage The error message to display to the user if input is invalid.
	 * @return The validated input from the user.
	 */
	public static int validateInput(Scanner consoleScanner, String message, int min, int max, String errorMessage)
	{
		int input = 0;
		boolean inputError;
		do {
			try {
				inputError = false;
				System.out.print(message + " ");
				input = consoleScanner.nextInt();
				if (input < min || input > max)
					inputError = true;
			} catch (InputMismatchException e) {
				inputError = true;
				consoleScanner.next();
			}
			if (inputError)
				System.err.println(errorMessage + "\n");

		} while (inputError);
		return input;
	}
	
	/**
	 * Validates user input to prompt them with a message, read an int from the consoleScanner, validate that it is > min.  
	 * If the input is valid, it is returned, otherwise a user is prompted again in a loop until valid input
	 * is entered.  Reuses existing code from <code>isValidInput</code> giving Integer.MAX_VALUE for the maximum value (e.g. no max).
	 *  
	 * @param consoleScanner Used to read user input from the console.
	 * @param message The message to display to the user.
	 * @param min The minimum value allowed.
	 * @param errorMessage The error message to display to the user if input is invalid.
	 * @return The validated input from the user.
	 */
	public static int validateInputMin(Scanner consoleScanner, String message, int min, String errorMessage)
	{
		return validateInput(consoleScanner, message, min, Integer.MAX_VALUE, errorMessage);
	}

}
