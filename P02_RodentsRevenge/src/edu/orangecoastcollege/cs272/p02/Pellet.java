package edu.orangecoastcollege.cs272.p02;

public class Pellet extends Character {

	public Pellet(int row, int col)
	{super(row, col);}

	@Override
	public void move(Board board) {}

	@Override
public String toString()
{return "*";}
}
