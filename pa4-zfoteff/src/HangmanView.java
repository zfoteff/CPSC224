import javax.swing.*;
import java.awt.*;

public class HangmanView extends JFrame
{
    private HangmanController controller;

    protected JLabel guessWord = new JLabel(" ");
    protected JLabel lettersRemaining = new JLabel("");
    protected JLabel status = new JLabel("Welcome to Hangman!");
    protected JButton sendGuess = new JButton("Guess");
    protected JButton newGame = new JButton("New Game");
    protected JTextField userGuess = new JTextField();

    public HangmanView(HangmanController c)
    {
        super("Hangman");
        this.controller = controller;

        setupUI();
        pack();


    }

    public void setupUI()
    {
        setVisible(true);
        setSize(new Dimension(3500, 1750));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel content = new JPanel();
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));

        /* Layout

            [         guess         ]
            [   lettersRemaining    ]
            [  --- guess field ---  ]
            [      Guess button     ]
            [        New Game       ]
            [         status        ]

         */

        guessWord.setAlignmentX(Component.CENTER_ALIGNMENT);
        content.add(guessWord);
        lettersRemaining.setAlignmentX(Component.CENTER_ALIGNMENT);
        content.add(lettersRemaining);
        userGuess.setAlignmentX(Component.CENTER_ALIGNMENT);
        content.add(userGuess);
        sendGuess.setAlignmentX(Component.CENTER_ALIGNMENT);
        content.add(sendGuess);
        newGame.setAlignmentX(Component.CENTER_ALIGNMENT);
        content.add(newGame);
        status.setAlignmentX(Component.CENTER_ALIGNMENT);
        content.add(status);

        getContentPane().add(content);
        userGuess.setEnabled(false);
        sendGuess.setEnabled(false);
    }
}
