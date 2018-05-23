package edu.orangecoastcollege.cs272.p02;

public abstract class Character implements GameActions
{
protected int mRow;
protected int mCol;
	
	protected Character(int row, int col)
	{
		mRow = row;
		mCol = col;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + mCol;
		result = prime * result + mRow;
		return result;
	}

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

	public int getRow() {
		return mRow;
	}

	public void setRow(int row) {
		mRow = row;
	}

	public int getCol() {
		return mCol;
	}

	public void setCol(int col) {
		mCol = col;
	}
}
