package edu.orangecoastcollege.cs272.p02;

import java.util.*;

public class Board
{
private Player mPlayer;
private	List<Rodent> mRodentsList;
private	List<Pellet> mPelletsList;
private	int mRowSize;
private	int mColSize;

	 public Board(int rowSize, int colSize, int numRodents)
	 {
		 mRowSize = rowSize;
		 mColSize = colSize;
		 mPlayer = new Player(mRowSize-1, mColSize-1);
		 mPelletsList = new ArrayList<>(50);

		 //TODO Issue resolved (Rodent location)
		 // Review here in case of a bug
		 mRodentsList = new ArrayList<>(50);
		 int x = 0, y = 0;
		 for(int i = 0; i < numRodents;i++)
		 {
			 mRodentsList.add(new Rodent(x,y++));
			 if(y == mColSize)
			 {
				 ++x;
				 y = 0;
			 }
		 } 
	 }

	 /**
	  *
	  * @param row of the pellet
	  * @param col of the pellet
	  * This method creates new pellet.
	  * If a pellet already existed at param
	  * this method will do nothing,
	  */
	 public void addPellet(int row, int col)
	 {
		 boolean found = false;
		 for(Pellet p : mPelletsList)
		 {
			 if(p.getRow() == row && p.getCol() == col)
			 {
				 found = true;
				 System.err.println("a pellet already exist in this location, continue");
				 break;
			 }
		 }

		 if(!found)
		 mPelletsList.add(new Pellet(row, col));
	 }

	 public boolean isInBounds(int row, int col)
	 {
		return  (row >= 0 && row < mRowSize-1) && (col >= 0 && col < mColSize-1);
	 }

	 public boolean isPlayerAlive()
	 {
		 return mPlayer != null;
	 }

	 public boolean isGameOver()
	 {
		 return !isPlayerAlive() || mRodentsList.size() == 0;
	 }

	 public void moveAllCharacters()
	 {
		 // movie player
		 mPlayer.move(this);

		 int Rodentsize = mRodentsList.size();
		 int pelletsize = mPelletsList.size();
		 for(int i = 0; i < Rodentsize;++i)
		 {
			 Rodent rObject =  mRodentsList.get(i);
			 rObject.move(this);
			 if(rObject.getRow() == mPlayer.getRow() && rObject.getCol() == mPlayer.getCol())
			 { 
				mPlayer = null;
			    break;
			 }
			 
			 for(int j = 0; j < pelletsize; ++j)
			 {
				 Pellet p = mPelletsList.get(j);
				 if(rObject.mRow == p.mRow && rObject.mCol == p.mCol)
				 {
					 mRodentsList.remove(i);
					 mPelletsList.remove(j);

					 Rodentsize = mRodentsList.size();
					 pelletsize = mPelletsList.size();
				 }

			 }
		 }
	 }

	 @Override
	 public String toString()
	 {
		 StringBuilder game = new StringBuilder();
		 for(int i = 0; i < this.mRowSize; i++)
		 {
			for(int j = 0; j < this.mColSize; j++)
			{
				// flage to check for what to go in this location.
				boolean empty = true;
				// checking for player location
				if(mPlayer != null && i == mPlayer.getRow() && j == mPlayer.getCol())
					{
						empty = false;
						game.append("P");
					}
				
				// Pellets location
				for(Pellet p : mPelletsList)
					if(empty && i == p.getRow() && j == p.getCol())
						{
							empty = false;
							game.append("*");
						}
				
				// Rodent count and location
				int countRodent = 0;
				for(Rodent r : mRodentsList)
					if(i == r.getRow() && j == r.getCol())
						countRodent++;
					if(countRodent > 0)
					{
						if( countRodent == 1)
							game.append("R");
						else
							game.append(countRodent);
						empty = false;
					}
			// none of the above existed. so it's empty		
			  if(empty)
				  game.append("-");
			 }
			// after each iteration newline
			 game.append("\n");
		 }
		 // lastly game message
		game.append("\n").append(mRodentsList.size()).append(" rodents left to evict.");
		return game.toString();
	 }
}

/*
 * {
		 String game = "";
		 for(int i = 0; i < this.mRowSize; i++)
		 {
			for(int j = 0; j < this.mColSize; j++)
			{
				// By default, the item you will concatenate to the game is "."
				String item = ".";
				
				// For every pellet, if the row and col is a pellet, then the item you will concatenate is a "*"
				for(Pellet p : mPelletsList)
					if(i == p.getRow() && j == p.getCol())
						item = "*";
				
				// If the row and col is the player, you will concatenate a "P"
				// If item was a pellet "*", it will instead be a player "P"
				if(mPlayer != null && i == mPlayer.getRow() && j == mPlayer.getCol())
					item = "P";
						
				// For every rodent, if row and col is a rodent, concatenate a "R"
				int countRodent = 0;
				for(Rodent r : mRodentsList)
					if(i == r.getRow() && j == r.getCol())
						countRodent++;
					if(countRodent > 0)
						if( countRodent == 1)
							item = "R";
						else
							item = String.valueOf(countRodent);

				// Add the final value of "item" to the game
				game += item;
			 }
			 game += "\n";
		 }
		game +=  "\n" + mRodentsList.size() + " rodents left to evict.";
		return game;
	 }
 */

