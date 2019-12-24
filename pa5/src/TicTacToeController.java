/**
 *   This file declares the Controller that handles interactions between the View and Model, as well as containing
 *   the main method for the whole program
 *   CSPC 224-01, Fall 2019
 *   Programming Assignment #5
 *   Sources:
 *
 *   @author Zac Foteff
 *   @version v1.0 10/28/2019
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class TicTacToeController
{
    /** TicTacToeModel that will be manipulated by user inputs in the view **/
    private TicTacToeModel model;
    /** TicTacToeView the user can interact with to manipulate the model **/
    private TicTacToeView view;

    /**
     * Constructor for TicTacToeController that takes a model and initializes a new view
     *
     * @param m TicTacToeModel to be manipulated during the main game loop
     */
    public TicTacToeController(TicTacToeModel m)
    {
        this.model = m;
        this.view = new TicTacToeView(this);

        //  Initial Name:
        String p1InitialName = JOptionPane.showInputDialog("Enter a name for player 1");
        String p2InitialName = JOptionPane.showInputDialog("Enter a name for player 2");
        view.setP1Name(p1InitialName);
        view.setP2Name(p2InitialName);
        view.status.setText(view.p1Name+", your turn");
        view.updatePlayerInformation();
        view.disableElements(false);

        //  Action listener for all of the cell buttons users can enter to place their token
        ActionListener buttonClicked = new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                if (actionEvent.getActionCommand().equals("c0"))
                {
                    model.makeMove(0, 0);
                    view.buttonList[0].setText(model.getCellSymbol(0,0));
                    view.buttonList[0].setEnabled(false);

                    if (model.isWinner())
                        winCondition();

                    if (model.isScratch())
                        scratchCondition();
                }

                else if (actionEvent.getActionCommand().equals("c1"))
                {
                    model.makeMove(0,1);
                    view.buttonList[1].setText(model.getCellSymbol(0, 1));
                    view.buttonList[1].setEnabled(false);

                    if (model.isWinner())
                        winCondition();

                    if (model.isScratch())
                        scratchCondition();
                }

                else if (actionEvent.getActionCommand().equals("c2"))
                {
                    model.makeMove(0,2);
                    view.buttonList[2].setText(model.getCellSymbol(0, 2));
                    view.buttonList[2].setEnabled(false);

                    if (model.isWinner())
                        winCondition();

                    if (model.isScratch())
                        scratchCondition();
                }

                else if (actionEvent.getActionCommand().equals("c3"))
                {
                    model.makeMove(1,0);
                    view.buttonList[3].setText(model.getCellSymbol(1, 0));
                    view.buttonList[3].setEnabled(false);

                    if (model.isWinner())
                        winCondition();

                    if (model.isScratch())
                        scratchCondition();
                }

                else if (actionEvent.getActionCommand().equals("c4"))
                {
                    model.makeMove(1,1);
                    view.buttonList[4].setText(model.getCellSymbol(1, 1));
                    view.buttonList[4].setEnabled(false);

                    if (model.isWinner())
                        winCondition();

                    if (model.isScratch())
                        scratchCondition();
                }

                else if (actionEvent.getActionCommand().equals("c5"))
                {
                    model.makeMove(1,2);
                    view.buttonList[5].setText(model.getCellSymbol(1, 2));
                    view.buttonList[5].setEnabled(false);

                    if (model.isWinner())
                        winCondition();

                    if (model.isScratch())
                        scratchCondition();
                }

                else if (actionEvent.getActionCommand().equals("c6"))
                {
                    model.makeMove(2,0);
                    view.buttonList[6].setText(model.getCellSymbol(2, 0));
                    view.buttonList[6].setEnabled(false);

                    if (model.isWinner())
                        winCondition();

                    if (model.isScratch())
                        scratchCondition();
                }

                else if (actionEvent.getActionCommand().equals("c7"))
                {
                    model.makeMove(2,1);
                    view.buttonList[7].setText(model.getCellSymbol(2, 1));
                    view.buttonList[7].setEnabled(false);

                    if (model.isWinner())
                        winCondition();

                    if (model.isScratch())
                        scratchCondition();
                }

                else if (actionEvent.getActionCommand().equals("c8"))
                {
                    model.makeMove(2,2);
                    view.buttonList[8].setText(model.getCellSymbol(2, 2));
                    view.buttonList[8].setEnabled(false);

                    if (model.isWinner())
                        winCondition();

                    if (model.isScratch())
                        scratchCondition();
                }

                if (model.playerTurn == 1)
                    view.status.setText(view.p1Name+", your turn");

                else
                    view.status.setText(view.p2Name+", your turn");

                model.playerTurn *= -1;
            }
        };

        //  Loop sets action listener for each button and assigns each a command name
        for (int i = 0; i < 9; ++i)
        {
            view.buttonList[i].addActionListener(buttonClicked);
            view.buttonList[i].setActionCommand("c"+i);
        }

        //  This action listener watches for the user to press reset and handles all logic for that
        view.reset.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                int choice = JOptionPane.showConfirmDialog(view, "Are you sure you want to reset?",
                        "Reset",
                        JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION)
                //  If the user decides to reset the names, the controller should
                //  prompt user for new names, and reset wins and losses
                {
                    boolean valid = true;
                    do
                    {
                        try
                        {
                            String newP1Name = JOptionPane.showInputDialog("Enter a name for player 1");
                            view.setP1Name(newP1Name);
                        } catch (NumberFormatException ex) {
                            valid = false;
                        }
                    } while (!valid);

                    do
                    {
                        try
                        {
                            String newP2Name = JOptionPane.showInputDialog("Enter a name for player 2");
                            view.setP2Name(newP2Name);
                        } catch (NumberFormatException ex) {
                            valid = false;
                        }
                    } while (!valid);

                    refresh();
                    model.playerTurn = 1;
                    view.setP1Wins(0);                      //  resets player statistics
                    view.setP2Wins(0);
                    view.setP1Losses(0);
                    view.setP2Losses(0);


                }
            }
        });
    }

    /** Method contains the actions required to refresh the GUI elements for a new game **/
    public void refresh()
    {
        view.updatePlayerInformation();         //  resets player panels
        view.disableElements(false);      //  turns all elements back on
        model.clearBoard();                     //  clears the game logic board
        model.playerTurn = -1;                  //  resets player tokens
        view.clearGrid();                       //  clears the button grid of player tokens
    }

    /** Method prompts the user to play again, and updates game statistics  **/
    public void winCondition()
    {
        //  Method should
        //  - Update win count for whichever player won
        //  - Prompt the user to play again
        //  - Reset the game logic
        String winner;
        if (model.playerTurn == 1)
            winner = view.p1Name;
        else
            winner = view.p2Name;

        int choice = JOptionPane.showConfirmDialog(view, "Congratulations "+winner+", you won! Play again?",
                "Game Over", JOptionPane.YES_NO_OPTION);

        if (choice == JOptionPane.YES_OPTION)
        {
            if (model.playerTurn == 1) {
                view.setP1Wins(view.getP1Wins() + 1);
                view.setP2Losses(view.getP2Losses() + 1);
            } else {
                view.setP2Wins(view.getP2Wins() + 1);
                view.setP1Losses(view.getP1Losses() + 1);
            }

            refresh();
        }

        else
            System.exit(0);
    }

    /** Method resets the game in the result of a scratch game **/
    public void scratchCondition()
    {
        int choice = JOptionPane.showConfirmDialog(view, "Scratch game. Play again?", "Scratch Game",
                JOptionPane.YES_NO_OPTION);

        if (choice == JOptionPane.YES_OPTION)
            refresh();

        else
            System.exit(0);
    }

    /** Main method **/
    public static void main(String[] args)
    {
        TicTacToeModel m = new TicTacToeModel();
        TicTacToeController c = new TicTacToeController(m);
    }
}
