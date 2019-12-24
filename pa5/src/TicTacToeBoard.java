/**
 *   This file declares a class object TicTacToe board to act as the underlying game logic in the implementation of the
 *   game of Tic-Tac-Toe
 *   CSPC 224-01, Fall 2019
 *   Programming Assignment #5
 *   Sources:
 *
 *   @author Zac Foteff
 *   @version v1.0 10/28/2019
 */

public class TicTacToeBoard
{
    /** User defined size for the game grid **/
    private int N;
    /** Grid of cell objects the game logic is based around **/
    private Cell[][] grid;

    public TicTacToeBoard(int playerN)
    {
        this.N = playerN;
        this.grid = new Cell[N][N];
        this.populateGrid(N);
    }

    /**
     * Method displays each cell in the grid as the tic tac toe game board
     */
    public void displayGrid()
    {
        String header = "  ";
        int counter = 1;

        //  loop populates header with integers from [1, N]
        while (counter <= N)
        {
            header += counter+" ";
            counter++;
        }

        System.out.println(header);

        //  loop prints out the contents of every cell in the grid
        for (int i = 0; i < N; ++i)
        {
            System.out.print((i+1)+" ");
            for (int j = 0; j < N; ++j)
            {
                System.out.print(grid[i][j].toString() + " ");
            }
            System.out.println();
        }
    }


    /**
     * Method populates grid with N number of Cell objects initialized with a '-' symbol
     *
     * @param N size of 2 dimensional cell array
     */
    public void populateGrid(int N)
    {
        int i;
        int j;
        //  set grid to a new array of cells with a length of N
        grid = new Cell[N][N];
        for (i = 0; i < N; ++i)
        {
            for(j = 0; j < N; ++j)
            {
                //  sets each empty cell with a '-' character
                grid[i][j] = new Cell(i, j, '-');
            }
        }
    }


    /**
     * Method takes a Coordinates object and checks the corresponding Cell in grid to determine if the move is valid
     * A move is valid if
     *  - The Coordinates object does not reference a cell that is already filled with a value
     *  - The Coordinates row and col 0 <= (row & col) <= N
     *
     * @param coords Coordinates object that refers to Cell in grid
     * @return boolean true if coords is a valid move, false otherwise
     */
    public boolean isValidMove(Coordinates coords)
    {
        if (coords.getRow() < 0 || coords.getRow() > N)
            return false;

        if (coords.getCol() < 0 || coords.getCol() > N)
            return false;

        if (grid[coords.getRow()][coords.getCol()].getSymbol() == '-')
            return true;

        return false;
    }


    /**
     * Method takes a Coordinates object and sets the symbol of the corresponding cell with the player's symbol
     *
     * @param coords Coordinates object that corresponds with a Cell
     * @param playerSymbol char new symbol that replaces symbol of Cell object
     */
    public void makeMove(Coordinates coords, char playerSymbol)
    {
        int row = coords.getRow();
        int col = coords.getCol();
        Cell targetCell = grid[row][col];
        targetCell.setSymbol(playerSymbol);
    }


    /**
     * Method checks each Cell of grid to determine if a winning pattern exists
     *
     * @param playerSymbol char symbol to be compared
     * @return boolean true if a win pattern is recognized, false otherwise
     */
    public boolean isWinner(char playerSymbol)
    {
        int rowCount;
        int colCount;
        int leftDiagCount = 0;
        int rightDiagCount = 0;

        //  Row iterator
        for (int row = 0; row < N; ++row)
        {
            colCount = 0;
            while (colCount < N)
            {
                if (grid[row][colCount].getSymbol() == playerSymbol)
                    colCount++;

                else
                    break;
            }

            //  if the number of items in the row that contain the playerSymbol = N, row win pattern satisfied
            if (colCount == N)
                return true;
        }

        // Column iterator
        for (int col = 0; col < N; ++col)
        {
            rowCount = 0;
            while (rowCount < N)
            {
                if (grid[rowCount][col].getSymbol() == playerSymbol)
                    rowCount++;

                else
                    break;
            }

            //  if the number of items in the column that contain the playerSymbol = N, column win pattern satisfied
            if (rowCount == N)
                return true;
        }

        //  Left diagonal iterator
        for (int i = 0; i < N; ++i)
        {
           if (grid[i][i].getSymbol() == playerSymbol)
               leftDiagCount++;
        }

        //  Right diagonal iterator
        for (int i = N; i > 0; --i)
        {
            if (grid[i-1][rightDiagCount].getSymbol() == playerSymbol)
                rightDiagCount++;

            else
                break;
        }

        //  if number of items in either diagonal that contain playerSymbol = N, diagonal win pattern satisfied
        if (leftDiagCount == N || rightDiagCount == N)
            return true;

        return false;
    }


    /**
     * Method checks each Cell of the grid to determine if a scratch game has occurred
     *  - A scratch game is where every Cell of each grid is not empty ('-'), but no win pattern has occurred
     *
     * @return boolean true if scratch game conditions are satisfied, false otherwise
     */
    public boolean isScratch()
    {
        for(int i = 0; i < N; ++i)
        {
            for (int j = 0; j < N; ++j)
            {
                //  if even a single character in a Cell is equal to the empty character '-' we know a scratch game
                //  has not occurred yet, so return false
                if (grid[i][j].getSymbol() == '-')
                    return false;

                else
                    continue;

            }
        }

        //  one last check to make sure a winning pattern doesn't appear in the grid
        if (!isWinner('X') && !isWinner('0'))
            return true;

        return false;
    }

    /**
     * Method returns player token stored in the tic-tac-toe board cell specified by the user
     *
     * @param row int user specified row in [0,2]
     * @param col int user specified col in [0,2]
     * @return String representation of the player token in the specified shell
     */
    public String getCellSymbol(int row, int col)
    {
        Cell targetCell = grid[row][col];
        return ""+targetCell.getSymbol();
    }
}
