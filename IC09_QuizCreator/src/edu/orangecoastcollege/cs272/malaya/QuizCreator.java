package edu.orangecoastcollege.cs272.malaya;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class QuizCreator
{

    public static void main(String arg[])
{
    // create a quiz database table
        try
        {
            Class.forName("org.sqlite.JDBC");
        }
        catch (ClassNotFoundException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // crete database table

        try(Connection connection = DriverManager.getConnection("Jdbc:sqlite:quiz.db");
                Statement stmt = connection.createStatement();)
           {
               //create statment
                StringBuilder sb = new StringBuilder("CREATE TABLE IF NOT EXISTS questions(");
                sb.append("_id INTEGER PRIMARY KEY, ");
                sb.append("question TEXT, ");
                sb.append("choice_a TEXT, ");
                sb.append("choice_b TEXT, ");
                sb.append("choice_c TEXT, ");
                sb.append("choice_d TEXT, ");
                sb.append("answer TEXT)");

               //EXCuter the update
               stmt.executeUpdate(sb.toString());

               // loop through the text file Quiz.txt and populate the DB
               Scanner cin = new Scanner(new File("Quiz.txt"));

               String q, chA, chB, chC, chD, answer;
               while(cin.hasNextLine())
               {
                   q = cin.nextLine();
                   chA = cin.nextLine();
                   chB = cin.nextLine();
                   chC = cin.nextLine();
                   chD = cin.nextLine();
                   answer = cin.nextLine();
                   sb = new StringBuilder("INSERT INTO questions(question, choice_a, choice_b"
                           + ", choice_c, choice_a, answer)");
                   sb.append("VALUES('")
                   .append(q).append("','")
                   .append(chA).append("','")
                   .append(chB).append("','")
                   .append(chC).append("','")
                   .append(chD).append("','")
                   .append(answer).append("')");

                   // Read a blank line
                   cin.nextLine();
                   System.out.println(sb.toString());

                   stmt.executeUpdate(sb.toString());
               }
           }
           catch(SQLException e)
           {
               System.err.println(e.getMessage());
           }
        catch (FileNotFoundException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
}

}
