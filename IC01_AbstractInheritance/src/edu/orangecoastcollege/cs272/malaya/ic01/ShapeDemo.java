package edu.orangecoastcollege.cs272.malaya.ic01;

import java.util.ArrayList;

public class ShapeDemo {

    public static void main(String[] args)
    {
        javafx.scene.paint.Color green = javafx.scene.paint.Color.GREEN;
        ArrayList<Shape2D> arr = new ArrayList<>();

        Rectangle r = new Rectangle(4,4,green,5,4);

        Triangle t = new Triangle(4,4,green,5,5);

        Parallelogram p = new Parallelogram(4,4,green,40,10);

        arr.add(r);
        arr.add(t);
        arr.add(p);

        for(int i = 0; i < arr.size(); i++)
        {
            System.out.println(arr.get(i).toString());
            System.out.println(arr.get(i).calculateArea());
            System.out.println();
        }
    }
}