package rodents_revenge;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Board {
	
	//1)
	Player mPlayer = new Player();
	List<Rodent> mRodentsList = new ArrayList<>();
	List<Pellet> mPelletList = new ArrayList<>();
	int mRowSize;
	int mColSize;
	
	//2) Create a constructor
	public Board(int rowSize, int colSize, int numRodents)
	{
		mRowSize = rowSize;
		mColSize = colSize;
		
		Player newPlayer = new Player();
		newPlayer.setRow(rowSize - 1);
		newPlayer.setCol(colSize - 1);
		mPlayer.setRow(newPlayer.mRow);
		mPlayer.setCol(newPlayer.mCol);
		
		int tempRow = 0;
		int tempCol = 0;
		for(int i = 0; i < numRodents; i++)
		{
			mRodentsList.add(new Rodent(tempRow, tempCol));
			if(tempCol == mColSize - 1){
				tempCol = 0;
				tempRow++;
			}
			else
				tempCol++;
		}
	
		
		List<Pellet> emptyP = new ArrayList<>();
			
	}
	
	/**
	 * This methods adds a pellet to mPelletList via the current row and column of the player.
	 * @param row
	 * @param col
	 */
	public void addPellet(int row, int col)
	{
		mPelletList.add(new Pellet(row, col));
	}
	
	/**
	 * This method checks if the current object is in bounds of the boards row and column size.
	 * @param row
	 * @param col
	 * @return true or false
	 */
	public boolean isInBounds(int row, int col)
	{
		return (row >= 0 && col >= 0 && row < mRowSize && col < mColSize);
	}
	
	/**
	 * This method checks if the player is alive or dead. If the player is dead then it 
	 * returns false, otherwise it returns true.
	 * @return true or false
	 */
	public boolean isPlayerAlive()
	{
		
		if(mPlayer == null)
			return false;
		else
			return true;
	}
	
	/**
	 * This method determines if the game is over by seeing if the player is dead or there are no more rodents
	 * in mRodentsList.
	 * @return
	 */
	public boolean isGameOver()
	{
		if(this.isPlayerAlive() == false || mRodentsList.size() == 0 )
			return true;
		else
			return false;
	}
		
	/**
	 * This method moves all characters on the board, which are all rodents and the player.
	 */
	public void moveAllCharacters()
	{
		mPlayer.move(this);
		//checking if pellet and rat have same position
		
		for(int x = 0; x < mRowSize; x++)
		{
			for(int y = 0; y < mColSize; y++)
			{
				
				for(int c = 0; c < mRodentsList.size(); c++)
				{
					for(int p = 0; p < mPelletList.size(); p++)
					{
						if(mRodentsList.get(c).getRow() == x && mPelletList.get(p).getRow() == x && 
								mRodentsList.get(c).getCol() == y && mPelletList.get(p).getCol()  == y)
						{
							mPelletList.remove(p);
							mRodentsList.remove(c);
						}
					}
				}
			
			}
		}
		
		
		for(int i = 0; i < mRodentsList.size(); i++)
		{
			mRodentsList.get(i).move(this);
			if(mPlayer == null)
				continue;
			if(mRodentsList.get(i).getRow() == mPlayer.getRow() && mRodentsList.get(i).getCol() == mPlayer.getCol() && mPlayer != null)
					mPlayer = null;
		}
	}

	/**
	 * This method prints the player, rodents, and pellets onto the board using their current row and column.
	 */
	@Override
	public String toString() {
		//l Loop through all the rows and columns on the board
		int rodents = 0;
		
		for(int i = 0; i < mRowSize; i++)
		{
			
			for(int j = 0; j < mColSize; j++)
			{
				if(mPlayer == null)
				{
					continue;
				}
			
				else if(mPlayer.getRow() == i && mPlayer.getCol() == j)
				{
					System.out.print(mPlayer.toString());
					continue;
				}
				
				
				int pellets = 0;
				for(int p = 0; p < mPelletList.size(); p++)
				{
					if(mPelletList.get(p).getRow() == i && mPelletList.get(p).getCol() == j)	
					{
						System.out.print(mPelletList.get(p).toString());
						pellets++;
					}
				}
				
				
				 
				for(int s = 0; s < mRodentsList.size(); s++)
				{
					if(mRodentsList.get(s).getRow() == i && mRodentsList.get(s).getCol() == j)	
					{
						rodents++;
					}
					if(rodents == 1 && s == mRodentsList.size() - 1)
					{
						System.out.print(mRodentsList.get(s).toString());
					}
					else if(s == mRodentsList.size() - 1 && rodents > 1)
					{
						System.out.print(rodents);
					}
					else if(rodents == 0 && pellets == 0 && s == mRodentsList.size() - 1)
					{
						System.out.print(".");
					}
					
				}
				
				pellets = 0;
				rodents = 0;
				
			}
			System.out.println();
		}
		return mRodentsList.size() + " rodents left to evict.";
	}
	
	
}
