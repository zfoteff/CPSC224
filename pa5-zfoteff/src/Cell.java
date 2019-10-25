public class Cell
{
    private Coordinates coordinates = new Coordinates();
    private char symbol;

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