package rodents_revenge;


public abstract class Character implements GameActions{
	
	
	protected int mRow;
	protected int mCol;
	
	/**
	 * Returns mRow
	 * @return mRow
	 */
	public int getRow()
	{
		return mRow;
	}
	
	/**
	 * Returns mCol
	 * @return mCol
	 */
	public int getCol()
	{
		return mCol;
	}
	
	/**
	 * Sets a new value for mRow.
	 * @param newRow
	 */
	public void setRow(int newRow)
	{
		mRow = newRow;
	}
	
	/**
	 * Sets a new value for mCol.
	 * @param newCol
	 */
	public void setCol(int newCol)
	{
		mCol = newCol;
	}

	
	/**
	 * Overridden hashcode method.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + mCol;
		result = prime * result + mRow;
		return result;
	}

	/**
	 * Overridden equals method.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Character other = (Character) obj;
		if (mCol != other.mCol)
			return false;
		if (mRow != other.mRow)
			return false;
		return true;
	}
	
	protected Character()
	{
		mRow = this.getRow();
		mCol = this.getCol();
	}
	
	
}
