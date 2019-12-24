/**
 *   This file declares the Model for the game logic of Tic-Tac-Toe
 *   CSPC 224-01, Fall 2019
 *   Programming Assignment #5
 *   Sources:
 *
 *   @author Zac Foteff
 *   @version v1.0 10/28/2019
 */

public class TicTacToeModel
{
    /** 3x3  tic-tac-toe board that is manipulated in the main game loop **/
    private TicTacToeBoard board = new TicTacToeBoard(3);
    /** Counter used by components of GUI to keep track of which player is interacting with the game **/
    protected int playerTurn = 1;

    /**
     * Method returns the symbol in a user specified cell in the tic-tac-toe board
     *
     * @param row int user specified row [0,2]
     * @param col int user specified col [0,2]
     * @return String of the symbol contained in the user specified shell
     */
    public String getCellSymbol(int row, int col) { return board.getCellSymbol(row, col); }

    /**
     * Method clears the tic-tac-toe board to clear the background game logic
     */
    public void clearBoard() { board.populateGrid(3); }

    /**
     * Method checks the game board to see if the conditions are met for a scratch game in the game logic
     *
     * @return true if the conditions for a scratch game are met in the game logic, false otherwise
     */
    public boolean isScratch() { return board.isScratch(); }

    /**
     * Method checks the game board to see if the conditions are met for a winning game in the game logic
     *
     * @return true if the conditions for a winning game are met
     */
    public boolean isWinner()
    {
        char playerToken = ' ';
        if (playerTurn == 1)
            playerToken = 'X';
        else
            playerToken = 'O';

        return board.isWinner(playerToken);
    }

    /**
     * Method alters the tic-tac-toe board with a new guess in the row and column corresponding with the button the user
     * pressed on the GUI
     *
     * @param row int user specified row for the new cell
     * @param col int user specified col for the new cell
     */
    public void makeMove(int row, int col)
    {
       char symbol;
       if (playerTurn == 1)
           symbol = 'X';
       else
           symbol = 'O';

       Coordinates nextMove = new Coordinates(row, col);
       board.makeMove(nextMove, symbol);
    }
}
