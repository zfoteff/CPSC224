import javax.swing.*;
import java.awt.*;

public class View extends JFrame
{
    private Controller controller;

    protected JLabel guessWord = new JLabel("");
    protected JLabel lettersRemaining = new JLabel("abcdefghijklmnopqrstuvwxyz");
    protected JLabel status = new JLabel("Welcome to Hangman!");
    protected JButton sendGuess = new JButton("Guess");
    protected JTextField userGuess = new JTextField();

    public View(Controller c)
    {
        super("Hangman");
        this.controller = controller;

        setupUI();
    }

    public void setupUI()
    {
        setVisible(true);
        setSize(new Dimension(1000, 500));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel content = new JPanel();
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));

        /* Layout

            [         guess         ]
            [   lettersRemaining    ]
            [  --- guess field ---  ]
            [      Guess button     ]
            [        status         ]

         */

        guessWord.setAlignmentX(Component.CENTER_ALIGNMENT);
        content.add(guessWord);
        lettersRemaining.setAlignmentX(Component.CENTER_ALIGNMENT);
        content.add(lettersRemaining);
        userGuess.setAlignmentX(Component.CENTER_ALIGNMENT);
        content.add(userGuess);
        sendGuess.setAlignmentX(Component.CENTER_ALIGNMENT);
        content.add(sendGuess);
        status.setAlignmentX(Component.CENTER_ALIGNMENT);
        content.add(status);

        getContentPane().add(content);
        pack();
    }
}
