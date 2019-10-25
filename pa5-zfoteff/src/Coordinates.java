/**
 *   This file declares a class object Coordinates
 *   CSPC 224-01, Fall 2019
 *   Programming Assignment #2
 *   Sources:
 *
 *   @author Zac Foteff
 *   @version v1.0 09/16/2019
 */

public class Coordinates
{
    private int row;
    private int col;

    public Coordinates()
    {
        this.row = -1;
        this.col = -1;
    }

    public Coordinates(int playerRow, int playerCol)
    {
        this.row = playerRow;
        this.col = playerCol;
    }

    /**
     * Method returns a string representation of a Coordinates object
     *
     * @return String representation of Coordinates object
     */
    @Override
    public String toString()
    {
        return "["+row+", "+col+"]";
    }


    /**
     * Method returns value stored in private member variable row
     *
     * @return int row of Coordinate object
     */
    public int getRow()
    {
        return row;
    }


    /**
     * Method returns value stored in private member variable col
     *
     * @return int column of Coordinate object
     */
    public int getCol()
    {
        return col;
    }


    /**
     * Method sets private member variable row to new user specified row
     *
     * @param row new value to replace old value stored in row
     */
    public void setRow(int row)
    {
        this.row = row;
    }


    /**
     * Method sets private member variable col to new user specified column
     *
     * @param col new value to replace old value stored in col
     */
    public void setCol(int col)
    {
        this.col = col;
    }
}
