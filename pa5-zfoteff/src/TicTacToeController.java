import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class TicTacToeController
{
    private TicTacToeModel model;
    private TicTacToeView view;

    public TicTacToeController(TicTacToeModel m)
    {
        this.model = m;
        this.view = new TicTacToeView(this);

        //  Initial Name:
        String p1InitialName = JOptionPane.showInputDialog("Enter a name for player 1");
        String p2InitialName = JOptionPane.showInputDialog("Enter a name for player 2");
        view.setP1Name(p1InitialName);
        view.setP2Name(p2InitialName);
        view.updatePlayerInformation();
        view.disableElements(false);

        //  Action listener for all of the cell buttons users can enter to place their token
        ActionListener buttonClicked = new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                if actionEvent.getActionCommand().equals("cell0")
                {

                }
            }
        };

        view.cell0.addActionListener(buttonClicked);
        view.cell1.addActionListener(buttonClicked);
        view.cell2.addActionListener(buttonClicked);
        view.cell3.addActionListener(buttonClicked);
        view.cell4.addActionListener(buttonClicked);
        view.cell5.addActionListener(buttonClicked);
        view.cell6.addActionListener(buttonClicked);
        view.cell7.addActionListener(buttonClicked);

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

                    view.setP1Wins(0);
                    view.setP2Wins(0);
                    view.setP1Losses(0);
                    view.setP2Losses(0);

                    view.updatePlayerInformation();
                    view.disableElements(false);
                }
            }
        });
    }



    public static void main(String[] args)
    {
        TicTacToeModel m = new TicTacToeModel();
        TicTacToeController c = new TicTacToeController(m);
    }
}
