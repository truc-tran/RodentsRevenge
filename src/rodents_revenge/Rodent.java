package rodents_revenge;

import java.util.Random;

public class Rodent extends Character{

	
	/**
	 * This method is what decided what positions the rodents could move to.
	 */
	@Override
	public void move(Board board) 
	{
		Random rngRow = new Random();
		Random rngCol = new Random();
		int row = (mRow - 1) + rngRow.nextInt((mRow + 1) - (mRow - 1) + 1);
		int col = (mCol - 1) + rngCol.nextInt((mCol + 1) - (mCol - 1) + 1);
		while(row >= (board.mRowSize) || row < 0)
		{
			row = (  mRow - 1) + rngRow.nextInt((mRow + 1) - (mRow - 1) + 1);
		}
		
		mRow = row;
		while(col >= (board.mColSize) || col < 0)
		{
			col = ( mCol - 1) + rngRow.nextInt((mCol + 1) - (mCol - 1) + 1);
		}
		
		mCol = col;
		
	}

	/**
	 * This method is overridden and prints out an R to represent the rodents on the board.
	 */
	@Override
	public String toString() {
		String mIcon = "R";
		return mIcon;
	}
	/**
	 * This is a constructor for a rodent object, with 2 parameters, row and column.
	 * @param mRow
	 * @param mCol
	 */
	public Rodent(int mRow, int mCol)
	{
		this.mRow = mRow;
		this.mCol = mCol;
	}
	
	
	
	

}
