import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class TicTacToeView extends JFrame
{
    /** Private controller that can access elements of each JElement **/
    private TicTacToeController controller;

    protected String p1Name = "";
    protected String p2Name = " ";
    protected int p1Wins = 0;
    protected int p2Wins = 0;
    protected int p1Losses = 0;
    protected int p2Losses = 0;

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
    protected JTextArea p1Stats = new JTextArea("Name:\t\t"+p1Name+"\nWins:\t\t"+p1Wins+"\nLosses:\t\t"+p1Losses
            ,3, 1);
    protected JTextArea p2Stats = new JTextArea("Name:\t\t"+p2Name+"\nWins:\t\t"+p2Wins+"\nLosses:\t\t"+p2Losses,
            3, 1);
    protected JLabel status = new JLabel("Tic-Tac-Toe");
    protected JButton cell0 = new JButton(" ");
    protected JButton cell1 = new JButton(" ");
    protected JButton cell2 = new JButton(" ");
    protected JButton cell3 = new JButton(" ");
    protected JButton cell4 = new JButton(" ");
    protected JButton cell5 = new JButton(" ");
    protected JButton cell6 = new JButton(" ");
    protected JButton cell7 = new JButton(" ");
    protected JButton cell8 = new JButton(" ");
    protected JButton reset = new JButton("Reset Names and Stats");


    public TicTacToeView(TicTacToeController c)
    {
        super("Tic-Tac-Toe");
        this.controller = c;

        setupUI();
    }

    /**
     * Method constructs UI using JPanels and the elements of the TicTacToe view
     */
    public void setupUI()
    {
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
        gridButtons.add(cell0);
        gridButtons.add(cell1);
        gridButtons.add(cell2);
        gridButtons.add(cell3);
        gridButtons.add(cell4);
        gridButtons.add(cell5);
        gridButtons.add(cell6);
        gridButtons.add(cell7);
        gridButtons.add(cell8);

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
     * @param isOn boolean value. True disables all of the elements. False enables all the elements
     */
    public void disableElements(boolean isOn)
    {
        if(isOn)
        {
            reset.setEnabled(false);
            cell0.setEnabled(false);
            cell1.setEnabled(false);
            cell2.setEnabled(false);
            cell3.setEnabled(false);
            cell4.setEnabled(false);
            cell5.setEnabled(false);
            cell6.setEnabled(false);
            cell7.setEnabled(false);
            cell8.setEnabled(false);
        }

        else
        {
            reset.setEnabled(true);
            cell0.setEnabled(true);
            cell1.setEnabled(true);
            cell2.setEnabled(true);
            cell3.setEnabled(true);
            cell4.setEnabled(true);
            cell5.setEnabled(true);
            cell6.setEnabled(true);
            cell7.setEnabled(true);
            cell8.setEnabled(true);
        }
    }

    public void updatePlayerInformation()
    {
        p1Stats.setText("Name:\t\t"+p1Name+"\nWins:\t\t"+p1Wins+"\nLosses:\t\t"+p1Losses);
        p2Stats.setText("Name:\t\t"+p2Name+"\nWins:\t\t"+p2Wins+"\nLosses:\t\t"+p2Losses);
    }

    public String getP1Name() { return p1Name; }

    public void setP1Name(String p1Name) { this.p1Name = p1Name; }

    public String getP2Name() { return p2Name; }

    public void setP2Name(String p2Name) { this.p2Name = p2Name; }

    public int getP1Wins() { return p1Wins; }

    public void setP1Wins(int p1Wins) { this.p1Wins = p1Wins; }

    public int getP2Wins() { return p2Wins; }

    public void setP2Wins(int p2Wins) { this.p2Wins = p2Wins; }

    public int getP1Losses() { return p1Losses; }

    public void setP1Losses(int p1Losses) { this.p1Losses = p1Losses; }

    public int getP2Losses() { return p2Losses; }

    public void setP2Losses(int p2Losses) { this.p2Losses = p2Losses; }
}
