import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
        //  exception: an event that occurs during runtime that disrupts the normal program instruction flow

        //  2 types of exception
        //  1. unchecked exception: errors and runtime exceptions
        //  2. checked exceptions: an exceptions that you have to handle or acknowledge the exception (checked by
        //  compiler)

        //  runtime example
        try
        {
            int x = 5 / 0;
        } catch (ArithmeticException e) {
            //  e is an object reference
            e.printStackTrace();    // Command prints the error thrown in the try block
        }
        System.out.println("Program execution continues");

        Scanner inFile;

        //  try and open an input stream to read from a file that doesn't exist
        try {
            inFile = new Scanner(new File("dne.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            //  executes not matter what happens in the try/catch block
            //  You would use this to free up space and resources
            System.out.println("Hello from finally");
        }

        //  file input

        //  Using try catch blocks are great ways to make sure io files open correctly
        try {
            inFile = new Scanner(new File("myFile.txt"));
            //  read line by line from infile
            while (inFile.hasNextLine())
            {
                System.out.println(inFile.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Complete");
        }

        //  file output

        Scanner user = new Scanner(System.in);

        try {
            PrintStream outFile = new PrintStream(new File("out.txt"));
            String newStr = user.nextLine();
            while (!newStr.equals("q"))
            {
                outFile.println(newStr);
                newStr = user.nextLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Complete");
        }

    }
}
