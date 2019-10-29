/**
 *   This file declares the class object Cell that represents a cell on a Tic Tac Toe board
 *   CSPC 224-01, Fall 2019
 *   Programming Assignment #5
 *   Sources:
 *
 *   @author Zac Foteff
 *   @version v1.0 10/28/2019
 */
public class Cell
{
    /** Coordinates object representing the Cell's location on the game board **/
    private Coordinates coordinates = new Coordinates();
    /** char that represents a play token in this location on the game board, if there is one **/
    private char symbol;

    /**
     * Constructor for a Cell object with user specified row, column, and symbol
     *
     * @param playerRow int user specified row on the game board
     * @param playerCol int user specified col on the game board
     * @param playerSymbol char player token
     */
    public Cell(int playerRow, int playerCol, char playerSymbol)
    {
        this.coordinates.setRow(playerRow);
        this.coordinates.setCol(playerCol);
        this.symbol = playerSymbol;
    }

    /**
     * Method returns a string containing the Cell's symbol
     *
     * @return String containing the assigned symbol
     */
    @Override
    public String toString()
    {
        return ""+symbol;
    }


    /**
     * Method returns the value of the private member variable symbol
     *
     * @return char value of private member variable symbol
     */
    public char getSymbol()
    {
        return symbol;
    }


    /**
     * Method sets private member variable symbol to user specified value
     *
     * @param newSymbol new char to replace old value in symbol
     */
    public void setSymbol(char newSymbol) { this.symbol = newSymbol; }
}