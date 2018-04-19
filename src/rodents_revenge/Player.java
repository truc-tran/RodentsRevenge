package rodents_revenge;

import java.util.Scanner;

/**
 * @author 
 *
 */
public class Player extends Character {

	/**
	 * This function is the actions that the player is able to take while moving through the board,
	 * such as moving UP, DOWN, LEFT, RIGHT, and dropping a pellet.
	 */
	@Override
	public void move(Board board) {
		Scanner input = new Scanner(System.in);
		System.out.println();
		System.out.println("What action will you like the player to take? ");
		System.out.println("U: Move Up");
		System.out.println("D: Move Down");
		System.out.println("L: Move Left");
		System.out.println("R: Move Right");
		System.out.println("P: Pellet");
		String action = input.next();
		action = action.toUpperCase();
		if(action.equals("U"))
		{
			if(mRow - 1 < 0)
				System.out.println("Player currently cannot move up"
						+ " and loses turn");
			else
				mRow -= 1;
		}
		else if(action.equals("D"))
		{
			if(mRow + 1 >= board.mRowSize)
				System.out.println("Player currently cannot move down"
					+ " and loses turn");
			else
				mRow +=1;
		}
		else if(action.equals("L"))
		{
			if(mCol - 1 < 0)
				System.out.println("Player currently cannot move left"
					+ " and loses turn");
			else
				mCol -= 1;
		}
		else if(action.equals("R"))
		{
			if(mCol + 1 >= board.mColSize)
				System.out.println("Player currently cannot move right"
					+ " and loses turn");
			else
				mCol += 1;
		}
		else if(action.equals("P"))
		{
			board.addPellet(mRow, mCol);
		}
		else 
			System.out.println("Unrecognized action, please enter U, D, L, R or P. Player loses turn.");
	
		
	}
	public Player()
	{
		super();
	}
	
	
	/**
	 * This method is an overriden toString method that returns the letter P as a symbol for the player.
	 */
	@Override
	public String toString() {
		String mIcon = "P";
		return mIcon;
	}
	
	
	

}
