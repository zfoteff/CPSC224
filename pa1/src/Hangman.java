/**
*   This program allows the user to play a text-based game of hangman
*   CSPC 224-01, Fall 2019
*   Programming Assignment #1
*   Sources:
*
*   @author Zac Foteff
*   @version v1.0 09/04/2019
*/

import java.util.*;
public class Hangman
{
    private static String[] wordBank = {"zephyr", "gonzaga", "animal", "portland", "spokane", "python", "umlaut",
                                        "lacrosse", "soprano", "oregon"};

    private static char[] visibleLetters;

    private static char[] availableLetters;

    /**
    Method takes an array and returns a string containing all contents of of the array
    *
    * @return string representation of all contents of the array
     */
    public static String printArr(char[] array)
    {
        String arrayString = "";

        for (int i = 0; i < array.length; i++)
            arrayString += array[i];

        return arrayString;
    }

    /**
     Method finds all instances of a character in a string
     *
     * @param str string to be iterated through
     * @param target character to parse string for
     * @return Array list of integers corresponding to indices target character exists in
     */
    public static ArrayList<Integer> findAllInstances(String str, char target)
    {
        //  Array list to be returned
        ArrayList<Integer> indexList = new ArrayList<>();

        for (int i = 0; i < str.length(); i++)
        {
            //  If character at index i is the same as the target, character is added to indexList
            if (str.charAt(i) == target)
                indexList.add(i);
        }

        return indexList;
    }


    /**
    Method uses a java.util Random class object to randomly select a string from the list
    *
    * @return random string from wordBank private member string array
     */
    public static String selectWord()
    {
        Random rand = new Random();
        //  Generates random number in range 0 to 9
        int randomIndex = rand.nextInt(10);

        return wordBank[randomIndex];
    }


    /**
    Method populates visibleLetters private character array with an amount of dashes corresponding to the target word's
    length
    *
    * @param word target word user must guess in primary game loop
     */
    public static void buildVisibleLetters(String word)
    {
        //  Initializes visibleLetters as a new list of characters with a length equal to the target word
        visibleLetters = new char[word.length()];

        for(int i = 0; i< word.length(); i++)
           visibleLetters[i] = '-';
    }


    /**
    Method populates availableLetters private character array with every character from the alphabet
    */
    public static void buildAvailableLetters()
    {
        //  Initializes availableLetters as a new list of characters with every alphabetical character in it
        availableLetters = new char[26];

        for (int i = 0; i < 26; i++)
        {
            //  ASCII value of character = ASCII value of 'a' + index buffer
            int newASCIIValue = 97 + i;
            availableLetters[i] = (char)newASCIIValue;
        }
    }


    /**
     Method removes user specified character from array of available letters
     *
     * @param letterToRemove user specified character
     */
    public static void removeAvailableLetter(char letterToRemove)
    {
        for (int i = 0; i < availableLetters.length; i++)
        {
            if (availableLetters[i] == letterToRemove)
            {
                availableLetters[i] = '-';
                break;
            }
        }
    }


    /**
    Method displays the state of the game. This includes displaying:
        - user guesses in the form of a blank line that is slowly filled in as letters are guessed
        - available letters for guessing
        - remaining guesses
    *
    * @param guesses number of player guesses remaining
     */
    public static void displayState(int guesses)
    {
        /*
        *  Layout:
        *      ------------
        *      Available Letters: ...
        *      # Guesses Remaining
        */

        String hiddenWord = printArr(visibleLetters);
        String alphabet = printArr(availableLetters);

        String state = hiddenWord+"\nAvailable letters: "+alphabet+"\n"+guesses+" Guesses Remaining\n";
        System.out.println(state);
    }

    /**
     Method checks if every character in the visibleLetters is filled in, indicating a win condition
     *
     * @return true if win condition is met, false otherwise
     */
    public static boolean checkWin()
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
     Method handles functions around a user guess. Method...
        - Checks if the guess is in the target word and whether it has already been guessed
        - Decrements remaining guesses in appropriate situations
        - Assigns userGuess to appropriate index of visibleLetters
        - Removes guessed letter from list of available letters
     *
     * @param userGuess user inputted character
     * @param targetWord target word the user is trying to guess
     * @return userGuess if the letter is in the target word and hasn't been guessed, '+' if the letter is in the target
     *         word but has already been guessed, or '-' if the letter is not in the target word
     */
    public static char guess(char userGuess, String targetWord)
    {
        /*
        *   Loop checks every character of the target word and compares them to the user guessed character
        *   If the character is in the target word and that letter hasn't already been guessed, the user guess is
        *   returned, otherwise a blank character is returned.
        *   If the character has already been guessed a + is returned
        */
        for (int i = 0; i < targetWord.length(); i++)
        {
            //  If the userGuess is in the targetWord
            if (targetWord.charAt(i) == userGuess)
            {
                ArrayList<Integer> indexList = findAllInstances(targetWord, userGuess);

                //  If letter has not been guessed, return the guess back
                if (visibleLetters[i] == '-')
                {
                   for (int j = 0; j < indexList.size(); j++)
                       visibleLetters[indexList.get(j)] = userGuess;

                   removeAvailableLetter(userGuess);
                   return userGuess;
                }

                //  If the letter has already been guessed, return a +
                if (visibleLetters[i] == userGuess)
                    return '+';
            }
        }

        //   Default return statement
        removeAvailableLetter(userGuess);
        return '-';
    }


    /**
     Method handles main game loop. Method...
        - Initializes game state (remaining guesses, available letters, target word)
        - Displays state of game
        - Lets user input a guess
        - Checks if guess exists in target word
        - Checks if win condition has been met
     *
      * @return true if win condition has been met and the user want to keep playing, false otherwise
     */
    public static boolean playGame()
    {
        Scanner user = new Scanner(System.in);
        String word = selectWord();
        buildVisibleLetters(word);
        buildAvailableLetters();
        int guesses = 7;
        boolean winCondition = false;

        // Main gameplay loop
        while (!winCondition && guesses > 0)
        {
            displayState(guesses);
            String guess = user.nextLine();
            char userChar = guess.charAt(0);
            char newGuess = guess(userChar, word);

            //  If the guessed character exists in the target word
            if (newGuess == userChar)
                System.out.println("That guess is correct!");

            //  If the character exists, but has already been guessed, run through main game loop again
            else if (newGuess == '+')
                System.out.println("That letter has already been guessed");

            //  If guess does not exist in target word, decrement guesses by one
            else if (newGuess == '-')
            {
                guesses--;
                System.out.println("Wrong Guess");
            }

            winCondition = checkWin();
        }

        System.out.println("\n\n-------------------------------");
        System.out.println("You win! Play again? (y) (n): ");
        String userDecision = user.nextLine();
        char decision = userDecision.charAt(0);

        //  Input checking loop
        while (decision != 'y' && decision != 'n')
        {
            System.out.println("Please type a lowercase y to keep\nplaying, or a lowercase no to quit");
            String newDecision = user.nextLine();
            decision = newDecision.charAt(0);
        }

        //  If the user wants to keep playing they should type 'y' and a true value is returned to the main loop
        if (decision == 'y')
            return true;

        // Base return. If user wants to quit the game they type 'n' and a false value is returned to the main loop
        return false;
    }


    public static void main (String[] args)
    {
        boolean keepPlaying = true;

        // Game loop
        while (true)
        {
            keepPlaying = playGame();
            if (keepPlaying)
                continue;

            else
                break;
        }
    }
}
