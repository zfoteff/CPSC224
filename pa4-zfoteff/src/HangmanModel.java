import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Scanner;

public class HangmanModel
{
    private String targetWord;
    protected char[] visibleLetters;
    protected char[] availableLetters;
    protected int guesses = 7;

    public char[] strToCharArray(String str)
    {
        int counter = 0;
        char newArray[] = new char[str.length()];
        while (counter < str.length())
            newArray[counter] = str.charAt(counter);

        return newArray;
    }

    public void resetGuesses()
    {
        guesses = 7;
    }

    public void selectWord()
    {
        int wordIndex = (int)(Math.random()*9);
        String newWord = "";
        Scanner inFile = null;
        Path path = Paths.get(System.getProperty("user.home"), "Desktop", "words.txt");
        File wordFile = path.toFile();

        try{
            inFile = new Scanner(wordFile);
        } catch(FileNotFoundException ex) {
            System.out.println("File not found");
            System.exit(0);
        }

        int counter = 0;
        while (inFile.hasNext() && counter < wordIndex)
        {
            newWord = inFile.nextLine();
            counter++;
        }

        targetWord = newWord;
        inFile.close();
    }

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
}

