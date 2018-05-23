package edu.orangecoastcollege.cs272.malaya.ic01;

import javafx.scene.paint.Color;

public class Rectangle  extends Shape2D
{
private int width;
private int height;

public Rectangle(int x, int y, Color color, int w, int h)
{
this.x = x;
this.y = y;
this.color = color;
width = w;
height = h;
}
    @Override
public int hashCode()
{
    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + height;
    result = prime * result + width;
    return result;
}

@Override
public boolean equals(Object obj)
{
    if (this == obj) return true;
    if (!super.equals(obj)) return false;
    if (getClass() != obj.getClass()) return false;
    Rectangle other = (Rectangle) obj;
    if (height != other.height) return false;
    if (width != other.width) return false;
    return true;
}

    public int getWidth()
{
    return width;
}
public void setWidth(int width)
{
    this.width = width;
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

        return width * height;
    }

    @Override
    public String toString()
    {
        for (int w = 0; w < width; w++)
        {
            for (int h = 0; h < height; h++)
            {
                System.out.print("*");
            }
            System.out.println();
        }
        return "The area of this rectangle is " + calculateArea() + "square units.";
    }

}
