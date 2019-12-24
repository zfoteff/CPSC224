/**
 * File contains the game logic for the Hangman game, helper functions for easier conversions
 * and comparability with the view and controller objects, and the main method for running the application
 * CPSC 224-01, Fall 2019
 * Programming Assignment #2
 * Sources:
 *
 * @author Zac Foteff
 * @version v1.0
 */

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Scanner;

public class HangmanModel
{
    /**  Target word the player must guess, selected from list of words on the player's desktop **/
    private String targetWord;
    /**
     * Array of dashes that corresponds with the length of targetWord. Letters are revealed as the user guesses
     * correct letters until a win or lose condition is triggered
     **/
    protected char[] visibleLetters;
    /** Array of every letter in the alphabet. Letters are dashed out as the user guesses letters **/
    protected char[] availableLetters;
    /**
     * Number of remaining guesses the user has to guess the target word. Having 0 guesses will trigger a lose
     * condition
     **/
    protected int guesses = 7;


    /**
     * Method converts user inputted string to a char array of the same length
     *
     * @param str String to be converted to character array
     * @return resulting character array
     */
    public char[] strToCharArray(String str)
    {
        int counter = 0;
        char newArray[] = new char[str.length()];
        while (counter < str.length())
            newArray[counter] = str.charAt(counter);

        return newArray;
    }


    /**
     * Method creates path to 'words.txt' file on user desktop, randomly selects a word from that file, and sets
     * that word as the targetWord private String the user must guess during the main game loop
     */
    public void selectWord()
    {
        int wordIndex = (int)(Math.random()*9);
        String newWord = "";
        Scanner inFile = null;

        //  creates path to words.txt on the user's desktop
        Path path = Paths.get(System.getProperty("user.home"), "Desktop", "words.txt");
        File wordFile = path.toFile();

        //  Try catch block ensures that a words.txt file exists
        try{
            inFile = new Scanner(wordFile);
        } catch(FileNotFoundException ex) {
            //  exit the program if the file does not exist
            System.out.println("File not found");
            System.exit(0);
        }

        int counter = 0;
        //  while loop reads to the randomly selected word and sets target word
        while (inFile.hasNext() && counter < wordIndex)
        {
            newWord = inFile.nextLine();
            counter++;
        }

        //  sets private member variable for manipulation with other methods
        targetWord = newWord;
        inFile.close();
    }


    /**
     * Method checks a user inputted char against each char in in the targetWord and creates an ArrayList<Integer> of
     * every index that targetChar exists in targetWord
     *
     * @param targetChar user inputted char that will be compared to each character in targetWord private member
     *                   variable
     * @return  ArrayList<Integer> of all indices of the targetChar in the targetWord private member variable
     */
    public ArrayList<Integer> findAllInstances(char targetChar)
    {
        //  ArrayList to be returned
        ArrayList<Integer> indexList = new ArrayList<>();

        for (int i = 0; i < targetWord.length(); ++i)
        {
            //  if the character at i is the same as target, add the character the indexList
            if (targetWord.charAt(i) == targetChar)
                indexList.add(i);
        }

        return indexList;
    }


    /**
     Method handles functions around a user guess. Method...
     - Checks if the guess is in the target word and whether it has already been guessed
     - Decrements remaining guesses in appropriate situations
     - Assigns userGuess to appropriate index of visibleLetters
     - Removes guessed letter from list of available letters
     *
     * @param userGuess user inputted character
     * @return userGuess if the letter is in the target word and hasn't been guessed, '+' if the letter is in the target
     *         word but has already been guessed, or '-' if the letter is not in the target word
     */
    public char guess(char userGuess)
    {
        for(int i = 0; i < targetWord.length(); ++i)
        {
            //  if userGuess is in the targetWord
            if (targetWord.charAt(i) == userGuess)
            {
                ArrayList<Integer> indexList = findAllInstances(userGuess);

                //  return guess back if letter has not been guessed, and it exists in the target word
                if (visibleLetters[i] == '-')
                {
                    for (int j = 0; j < indexList.size(); ++j)
                        visibleLetters[indexList.get(j)] = userGuess;

                    removeAvailableLetter(userGuess);
                    return userGuess;
                }

                //  return '+' if letter has already been guessed
                if (visibleLetters[i] == userGuess)
                    return '+';
            }
        }

        //  if guess is not in the target word, remove letter from guesses and return '-'
        removeAvailableLetter(userGuess);
        guesses--;
        return '-';
    }


    /**
     Method removes user specified character from array of available letters
     *
     * @param letterToRemove user specified character
     */
    public void removeAvailableLetter(char letterToRemove)
    {
        for (int i = 0; i < availableLetters.length; ++i)
        {
            if (availableLetters[i] == letterToRemove)
            {
                availableLetters[i] = '-';
                break;
            }
        }
    }


    /**
     * Method populates targetWord private character array with an amount of dashes corresponding to the target word's
     * length
     */
    public void buildVisibleLetters()
    {
        //  Initializes visibleLetters as a new list of characters with a length equal to the target word
        visibleLetters = new char[targetWord.length()];

        for (int i = 0; i < targetWord.length(); i++)
            visibleLetters[i] = '-';
    }


    /**
     * Method populates visibleLetters private character array with every character from the alphabet
     */
    public void buildAvailableLetters()
    {
        //  Initializes availableLetters as a new list of characters with every alphabetical character in it
        availableLetters = new char[26];

        for (int i = 0; i < 26; i++) {
            //  ASCII value of character = ASCII value of 'a' + index buffer
            int newASCIIValue = 97 + i;
            availableLetters[i] = (char) newASCIIValue;
        }
    }


    /**
     Method checks if every character in the visibleLetters is filled in, indicating a win condition
     *
     * @return true if win condition is met, false otherwise
     */
    public boolean checkWin()
    {
        for (char each : visibleLetters)
        {
            //  If a single character in the array is a blank character the function returns false
            if (each == '-')
                return false;
        }

        return true;
    }

    /**
     * Main method
     *
     * @param args command line arguments
     */
    public static void main(String args[])
    {
        HangmanModel m = new HangmanModel();
        HangmanController c = new HangmanController(m);
    }
}