package edu.orangecoastcollege.cs272.malaya.ic01;

import javafx.scene.paint.Color;

public class Parallelogram extends Shape2D
{
private int base;
private int height;

public Parallelogram(int x, int y, Color c, int base, int height)
{
    this.x = x;
    this.y = y;
    this.color = c;
    this.base = base;
    this.height = height;
}
    @Override
public int hashCode()
{
    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + base;
    result = prime * result + height;
    return result;
}
@Override
public boolean equals(Object obj)
{
    if (this == obj) return true;
    if (!super.equals(obj)) return false;
    if (getClass() != obj.getClass()) return false;
    Parallelogram other = (Parallelogram) obj;
    if (base != other.base) return false;
    if (height != other.height) return false;
    return true;
}
    public int getBase()
{
    return base;
}
public void setBase(int base)
{
    this.base = base;
}
public int getHeight()
{
    return height;
}
public void setHeight(int height)
{
    this.height = height;
}
    @Override
    public double calculateArea()
    {

        return (base *height);
    }

    public String toString()
    {

        String empt = "*********************************************";
        for(int i = 0; i < height; i++)
        {
            empt =" " + empt;
            System.out.println(empt);
        }
        return "The area of this Parallelogram is " + calculateArea() + "square units.";
    }
}
