package edu.orangecoastcollege.cs272.ic06;

public enum RoomType
{
    TWO_DOUBLE_BEDS, TWO_QUEEN_BEDS, KING_BED;

    public String toString()
    {
        return name().charAt(0) + name().substring(1).toLowerCase().replaceAll("_", " ");
    }
}
