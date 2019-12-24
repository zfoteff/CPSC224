/**
 * This file defines a HangmanView object, which extends JFrame, to create the UI for the Hangman game
 *
 * @author Zac Foteff
 * @version v1.0
 */

import javax.swing.*;
import java.awt.*;

public class HangmanView extends JFrame
{
    /**  private controller that can access details of each JElement **/
    private HangmanController controller;

    /**  representation of the target word with the letters dashed out **/
    protected JLabel guessWord = new JLabel(" ");
    /**  String of all 26 characters of the alphabet that will be crossed off as the user guesses more letters **/
    protected JLabel lettersRemaining = new JLabel("");
    /**  displays how many guesses the user has to guess the correct word before a lose condition is triggered **/
    protected JLabel guessesRemaining = new JLabel("");
    /**  displays how user input has interacted with game logic (eg. "Correct! <letter> was in the word!") **/
    protected JLabel status = new JLabel("Welcome to Hangman!");
    /**  button that sends an input to the controller to trigger the logic for a guess **/
    protected JButton sendGuess = new JButton("Guess");
    /**  button that prompts the user to start a new game **/
    protected JButton newGame = new JButton("New Game");
    /**  text field the user will input their single character guess into **/
    protected JTextField userGuess = new JTextField();

    /**
     * Constructor for HangmanView that creates all elements of the UI, and sets up the UI
     *
     * @param c HangmanController that will handel communications between the view and the model
     */
    public HangmanView(HangmanController c)
    {
        super("Hangman");
        this.controller = c;

        setupUI();
    }

    /**
     * Method constructs UI using JPanel and the elements of the HangmanView
     */
    public void setupUI()
    {
        setVisible(true);
        setSize(new Dimension(300, 175));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel content = new JPanel();
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));

        /* Layout

            [         guess         ]
            [    lettersRemaining   ]
            [    guessesRemaining   ]
            [  --- guess field ---  ]
            [      Guess button     ]
            [        New Game       ]
            [         status        ]

         */
        guessWord.setAlignmentX(Component.CENTER_ALIGNMENT);
        content.add(guessWord);
        lettersRemaining.setAlignmentX(Component.CENTER_ALIGNMENT);
        content.add(lettersRemaining);
        guessesRemaining.setAlignmentX(Component.CENTER_ALIGNMENT);
        content.add(guessesRemaining);
        userGuess.setAlignmentX(Component.CENTER_ALIGNMENT);
        content.add(userGuess);
        sendGuess.setAlignmentX(Component.CENTER_ALIGNMENT);
        content.add(sendGuess);
        newGame.setAlignmentX(Component.CENTER_ALIGNMENT);
        content.add(newGame);
        status.setAlignmentX(Component.CENTER_ALIGNMENT);
        content.add(status);

        //  adds content JPanel to JFrame
        getContentPane().add(content);

        //  disables user input by default
        userGuess.setEnabled(false);
        sendGuess.setEnabled(false);
    }
}
