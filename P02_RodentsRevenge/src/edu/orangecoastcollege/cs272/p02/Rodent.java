package edu.orangecoastcollege.cs272.p02;

import java.util.Random;

public class Rodent extends Character
{

	public Rodent(int row, int col)
	{super(row, col);}

	//TODO No issue just test more, no loop needed

	@Override
	public void move(Board board)
	{
		Random rand = new Random();
		int  randRow,  randCol,
		currentRow = mRow , currentCol = mCol;
		
        boolean inBounds = board.isInBounds(currentRow, currentCol);
			// Random row number, handle three cases
			// case at the first row
			 if(currentRow == 0)
			randRow = rand.nextInt(2);
			 // Between the first and last
			 else if(inBounds)
			//else if(currentRow > 0 && currentRow < board.mRowSize -1)
			randRow = rand.nextInt((currentRow + 3) - (currentRow)) + currentRow-1;
			 // at the last row
			else
			randRow = rand.nextInt((currentRow + 2) - (currentRow)) + currentRow-1;

			// Random col number, handle three cases.
			if(currentCol == 0)
				randCol = rand.nextInt(2);
			 else if(inBounds)
			//else if(currentCol > 0 && currentCol < board.mColSize -1)
				randCol = rand.nextInt((currentCol + 3) - (currentCol)) + currentCol-1;
			else
				randCol = rand.nextInt((currentCol + 2) - (currentCol)) + currentCol-1;
		setCol(randCol);
		setRow(randRow);
	}
	@Override
	public String toString()
	{return "R";}
}