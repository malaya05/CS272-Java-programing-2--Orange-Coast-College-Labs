package edu.orangecoastcollege.cs272.idinh1.ic04;

/**
 * @author idinh1
 */
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Reading and processing text files.
 *
 * Reads a text file, line by line, counts the number of words per line, prints
 * out each line of the poem, preceded by number of the number of words in that
 * line.
 *
 */
public class WordCounter
{
    public void countWords(String inputFile, String outputFile)
    {
        // 1. Construct the Scanner and PrintWriter objects
        // TODO: your work here
       // Use Scanner to open a file for reading (input)

        String line;
        String[] words;
        int count;
        // try-with-resources = automatically closes for you (files, databases)
        try (Scanner fileScanner = new Scanner(new File(inputFile)))
        {
            try (PrintWriter fileWriter = new PrintWriter(new File(outputFile)))
            {
                while (fileScanner.hasNextLine())
                {
                    // Read the line
                    line = fileScanner.nextLine();
                    // split = divides a String into an array of words
                    // wherever a certain character is found
                    words = line.split(" ");
                    count = words.length;

                    // write to the file
                    fileWriter.println(count + "   " + line);
                }
            }
        // 2. Read the input file, writing the output for each line

        }
        catch (IOException e)
        {

        }
        // 3. Close all files

    }

    /**
     * Run as an application like this.
     */
    public static void main(String[] args)
    {
        WordCounter app = new WordCounter();
        // Set up the input and output file names (hard-coded for this problem)
        app.countWords("Peter.txt", "output.txt");
    }
}
