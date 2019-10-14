import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HangmanController
{
    private HangmanModel model;
    private HangmanView view;

    public HangmanController(HangmanModel m)
    {
        this.model = m;
        this.view = new HangmanView(this);


        //  Action listener that handles inputting a new guess
        view.sendGuess.addActionListener(new ActionListener()
        {
           @Override
           public void actionPerformed(ActionEvent e)
           {
               String text = view.userGuess.getText();
               if (text.length() > 1 || text.length() < 0)
               {
                   view.status.setText("Please enter 1 character");
                   view.userGuess.setText("");
                   return;
               }


               char letter = text.charAt(0);
               char result = '-';
               boolean valid;
               boolean winCondition = false;

               do
               {
                   valid = true;
                   try {
                       result = model.guess(letter);
                   } catch (NumberFormatException ex) {
                       valid = false;
                       view.status.setText("Invalid guess, Please enter 1 character");
                   }
               } while(!valid || text.length() != 1);

               //   Guess was in target word
               if (result == letter)
               {
                   //   take guessed letters out of the list of available letters
                   view.lettersRemaining.setText(new String(model.availableLetters));
                   //   reveal guessed letter(s) in the hidden word
                   view.guessWord.setText(new String(model.visibleLetters));
                   //   display new status message
                   view.status.setText("Correct! Guesses: "+model.guesses);
                   //   clear text field
                   view.userGuess.setText("");
                   winCondition = model.checkWin();
               }

               if (result == '+')
               {
                   view.lettersRemaining.setText(new String(model.availableLetters));
                   view.guessWord.setText(new String(model.visibleLetters));
                   view.status.setText("Letter already guessed. Guesses: "+model.guesses);
                   view.userGuess.setText("");
               }

               if (result == '-')
               {
                   view.lettersRemaining.setText(new String(model.availableLetters));
                   view.guessWord.setText(new String(model.visibleLetters));
                   view.status.setText("Wrong guess. Guesses: "+model.guesses);
                   view.userGuess.setText("");
               }

               //   lose and win condition checking
               if (model.guesses == 0)
               {
                   view.sendGuess.setEnabled(false);
                   view.userGuess.setEnabled(false);
                   view.status.setText("You lose...");
               }

               if (winCondition)
               {
                   //   disables user input
                   view.sendGuess.setEnabled(false);
                   view.userGuess.setEnabled(false);
                   view.status.setText("You win!");
               }
           }
        });

        //  Action listener that initializes a new game
        view.newGame.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                int choice = JOptionPane.showConfirmDialog(view,
                        "Are you sure you want to start a new game?", " ",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null);

                //  If the user decides to start a new game:
                //  - reset available letters
                //  - select new word
                //  - reset amount of guesses
                if (choice == JOptionPane.YES_OPTION)
                {
                    model.selectWord();
                    model.buildVisibleLetters();
                    model.buildAvailableLetters();
                    model.resetGuesses();
                    view.lettersRemaining.setText(new String(model.availableLetters));
                    view.guessWord.setText(new String(model.visibleLetters));
                    view.status.setText("Guesses: 7");
                    //  enables user input
                    view.userGuess.setEnabled(true);
                    view.sendGuess.setEnabled(true);
                }
            }
        });
    }
}
