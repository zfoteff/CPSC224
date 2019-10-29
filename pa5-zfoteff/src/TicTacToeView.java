/**
 *   This file declares the View GUI the user interacts with to alter the model during the main gam loop
 *   CSPC 224-01, Fall 2019
 *   Programming Assignment #5
 *   Sources:
 *
 *   @author Zac Foteff
 *   @version v1.0 10/28/2019
 */

import javax.swing.*;
import java.awt.*;

public class TicTacToeView extends JFrame
{
    /** Private controller that can access elements of each JElement **/
    private TicTacToeController controller;
    /** String representing the 1st player's name **/
    protected String p1Name = "";
    /** String representing the 2nd player's name **/
    protected String p2Name = " ";
    /** int representing the 1st player's wins **/
    protected int p1Wins = 0;
    /** int representing the 2nd player's wins **/
    protected int p2Wins = 0;
    /** int representing the 1st player's losses **/
    protected int p1Losses = 0;
    /** int representing the 2nd player's losses **/
    protected int p2Losses = 0;
    /** Array of JButtons that will contain all the buttons the players can press during the main game loop **/
    protected JButton buttonList[] = new JButton[9];
    /** JTextArea that contains all information about player 1 including: name, wins, and losses **/
    protected JTextArea p1Stats = new JTextArea("Name:\t\t"+p1Name+"\nWins:\t\t"+p1Wins+"\nLosses:\t\t"+p1Losses,
            3, 1);
    /** JTextArea that contains all information about player 2 including: name, win, and losses **/
    protected JTextArea p2Stats = new JTextArea("Name:\t\t"+p2Name+"\nWins:\t\t"+p2Wins+"\nLosses:\t\t"+p2Losses,
            3, 1);
    /** JLabel that displays game information like player turns **/
    protected JLabel status = new JLabel("Tic-Tac-Toe");
    /** JButton that will reset the game and all player information and statistics **/
    protected JButton reset = new JButton("Reset Names and Stats");

    /** TicTacToeView defualt constructor **/
    public TicTacToeView(TicTacToeController c)
    {
        super("Tic-Tac-Toe");
        this.controller = c;

        for(int i = 0; i < 9; ++i)
            buttonList[i] = new JButton(" ");

        setupUI();
    }

    /** Method constructs UI using JPanels and the elements of the TicTacToe view **/
    public void setupUI()
    {
        //  GUI components
        /*
                        Layout
            player1 status |  player2 status
                      status label
            cell0        cell1         cell2
            cell3        cell4         cell5
            cell6        cell7         cell8
                      reset button
        */

        setPreferredSize(new Dimension(500, 300));

        JPanel masterPanel = (JPanel) getContentPane();
        JPanel players = new JPanel();
        JPanel p1Info = new JPanel();
        JPanel p2Info = new JPanel();
        JPanel statusPanel = new JPanel();
        JPanel gridButtons = new JPanel();
        JPanel resetPanel = new JPanel();

        masterPanel.setLayout(new BoxLayout(masterPanel, BoxLayout.PAGE_AXIS));  //  Overall GUI will have a box
                                                                                 //  layout so each panel is stacked
                                                                                 //  on the panel after it and it is
                                                                                 //  easy to resize
        //  Set up top panel: player information and status label
        players.setLayout(new BorderLayout());
        players.setPreferredSize(new Dimension(500, 100));
        //  Setting up each player's panel for greater player pane
        p1Info.add(p1Stats);
        p1Info.setPreferredSize(new Dimension(250, 25));
        p1Info.setBorder(BorderFactory.createTitledBorder("Player 1 (X)"));
        p2Info.add(p2Stats);
        p2Info.setPreferredSize(new Dimension(250, 25));
        p2Info.setBorder(BorderFactory.createTitledBorder("Player 2 (O)"));
        //  Setting up status panel and status label
        statusPanel.add(status);
        statusPanel.setPreferredSize(new Dimension(500, 25));
        //  Adding to Player pane
        players.add(p1Info, BorderLayout.LINE_START);
        players.add(p2Info, BorderLayout.LINE_END);
        players.add(statusPanel, BorderLayout.PAGE_END);

        //  Setting up grid pane of buttons players can select from
        gridButtons.setLayout(new GridLayout(3, 3));
        gridButtons.setPreferredSize(new Dimension(500, 200));
        for (int i = 0; i < 9; ++i)
        {
            gridButtons.add(buttonList[i]);
        }

        //  Setting up reset button panes
        resetPanel.add(reset);
        resetPanel.setPreferredSize(new Dimension(500, 50));

        //  Adding all components to master panel
        masterPanel.add(players);
        masterPanel.add(gridButtons);
        masterPanel.add(resetPanel);

        //  Disables all elements by default until the model changes this
        disableElements(true);

        setVisible(true);
        setSize(new Dimension(500, 400));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Helper method enables and disables all elements the user can interact with
     *
     * @param isOff boolean value. True disables all of the elements. False enables all the elements
     */
    public void disableElements(boolean isOff)
    {
        if(isOff)
        {
            reset.setEnabled(false);
            for (int i = 0; i < 9; ++i)
                buttonList[i].setEnabled(false);
        }

        else
        {
            reset.setEnabled(true);
            for (int i = 0; i < 9; ++i)
                buttonList[i].setEnabled(true);
        }
    }

    /** Method updates each player's statistic with updated information **/
    public void updatePlayerInformation()
    {
        p1Stats.setText("Name:\t\t"+p1Name+"\nWins:\t\t"+p1Wins+"\nLosses:\t\t"+p1Losses);
        p2Stats.setText("Name:\t\t"+p2Name+"\nWins:\t\t"+p2Wins+"\nLosses:\t\t"+p2Losses);
    }

    /** Method clears all text from the grid buttons **/
    public void clearGrid()
    {
        for (int i = 0; i < 9; ++i)
            buttonList[i].setText(" ");
    }

    /**
     * Method returns player 1's name
     *
     * @return String of player 1's name
     */
    public String getP1Name() { return p1Name; }

    /**
     * Method sets player 1's name
     *
     * @param p1Name String user inputted name for player 1
     */
    public void setP1Name(String p1Name) { this.p1Name = p1Name; }

    /**
     * Method returns player 2's name
     *
     * @return String of player 2's name
     */
    public String getP2Name() { return p2Name; }

    /**
     * Method sets player 2's name
     *
     * @param p2Name String user inputted name for player 2
     */
    public void setP2Name(String p2Name) { this.p2Name = p2Name; }

    /**
     * Method returns player 1's wins
     *
     * @return int representation of player 1's wins
     */
    public int getP1Wins() { return p1Wins; }

    /**
     * Method sets player 1's wins
     *
     * @param p1Wins int user inputted wins for player 1
     */
    public void setP1Wins(int p1Wins) { this.p1Wins = p1Wins; }

    /**
     * Method returns player 2's wins
     *
     * @return int representation of player 2's wins
     */
    public int getP2Wins() { return p2Wins; }

    /**
     * Method sets player 2's wins
     *
     * @param p2Wins int user inputted wins for player 2
     */
    public void setP2Wins(int p2Wins) { this.p2Wins = p2Wins; }

    /**
     * Method returns player 1's losses
     *
     * @return int representation of player 1's losses
     */
    public int getP1Losses() { return p1Losses; }

    /**
     * Method sets player 1's losses
     *
     * @param p1Losses int user inputted losses for player 1
     */
    public void setP1Losses(int p1Losses) { this.p1Losses = p1Losses; }

    /**
     * Method returns player 2's losses
     *
     * @return int representation of player 2's losses
     */
    public int getP2Losses() { return p2Losses; }

    /**
     * Method sets player 2's losses
     *
     * @param p2Losses int user inputted losses for player 2
     */
    public void setP2Losses(int p2Losses) { this.p2Losses = p2Losses; }
}
