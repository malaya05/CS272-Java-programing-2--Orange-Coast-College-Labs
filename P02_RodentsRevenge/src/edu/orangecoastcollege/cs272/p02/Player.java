package edu.orangecoastcollege.cs272.p02;

import java.util.Scanner;

//TODO a better way to handle the move metohd, if switch better than if else if
public class Player extends Character
{

	public Player(int row, int col)
	{super(row, col);}

	@Override
	public void move(Board board)
	{
		/*
		 * What action would you like the player to take?
		   U: Move Up D: Move Down L: Move Left R: Move Right P: Pellet
		 */
		Scanner cin = new Scanner(System.in);
		String choice;

		System.out.println("What action would you like the player to take?");
		System.out.println("U: Move Up\nD: Move Down\nL: Move Left\nR: Move Right\nP: Pellet");
		choice = cin.next();
		System.out.println();

		if(choice.charAt(0) == 'u' || choice.charAt(0) == 'U')
		{
		   if(mRow > 0)
			   mRow--;
		   else
			   System.err.println("Player currently cannot move UP and loses turn.");
		}
		else if(choice.charAt(0) == 'd' || choice.charAt(0) == 'D')
		{
			//if(mRow  < board.mRowSize -1)
			if(board.isInBounds(mRow,0))
				   mRow++;
			   else
				   System.err.println("Player currently cannot move DOWN and loses turn.");
		}
		else if(choice.charAt(0) == 'l' || choice.charAt(0) == 'L')
		{
			if(mCol > 0)
				mCol--;
			   else
				   System.err.println("Player currently cannot move Left and loses turn.");
		}
		else if(choice.charAt(0) == 'r' || choice.charAt(0) == 'R')
		{
			//if(mCol < board.mColSize -1)
			if(board.isInBounds(0,mCol))
				mCol++;
			   else
				   System.err.println("Player currently cannot move Right and loses turn.");
		}
		else if(choice.charAt(0) == 'p' || choice.charAt(0) == 'P')
		{
			board.addPellet(mRow,mCol);
		}
		else
		  System.err.println("Unrecognized action, please enter U, D, L, R or P. Player loses turn.");
	}
@Override
public String toString()
{return "P";}
}
