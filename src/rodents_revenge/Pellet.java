package rodents_revenge;

public class Pellet extends Character {

	@Override
	public void move(Board board) {
		
	}

	/**
	 * Overridden toString method that prints a * as a symbol for a pellet.
	 */
	@Override
	public String toString() {
		String mIcon = "*";
		return mIcon;
	}
	
	/**
	 * Constructor for a pellet object with parameters for a row and column value
	 * @param mRow
	 * @param mCol
	 */
	public Pellet(int mRow, int mCol)
	{
		this.mRow = mRow;
		this.mCol = mCol;
	}
	

}
