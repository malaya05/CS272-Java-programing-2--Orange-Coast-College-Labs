package edu.orangecoastcollege.cs272.malaya.ic01;

import javafx.scene.paint.Color;

public abstract class Shape2D
{
    protected int x;
    protected int y;
    protected Color color;

    // getters
    public int getX() {return x;}
    public int getY() {return y;}
    public Color getColor() {return color;}

    // setters
    public void setX(int x) {this.x = x;}
    public void setY(int y) {this.y =  y;}
    public void setColor( Color color) {this.color = color;}

    // method to be implemented in all decentededs
    public abstract double calculateArea();

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((color == null) ? 0 : color.hashCode());
        result = prime * result + x;
        result = prime * result + y;
        return result;
    }
    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Shape2D other = (Shape2D) obj;
        if (color == null)
        {
            if (other.color != null) return false;
        }
        else if (!color.equals(other.color)) return false;
        if (x != other.x) return false;
        if (y != other.y) return false;
        return true;
    }

}
