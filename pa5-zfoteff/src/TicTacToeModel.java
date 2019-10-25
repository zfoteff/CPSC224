public class TicTacToeModel
{
    private TicTacToeBoard board = new TicTacToeBoard(3);
    int playerTurn = 1;

    public boolean isWinner(char player)
    {
        return board.isWinner(player);
    }

    public void makeMove()
    {
        return;
    }
}
