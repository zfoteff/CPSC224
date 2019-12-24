/**
 *   This file implements a TicTacToeBoard class object and allows the user to play a text-based game
 *   of Tic Tac Toe
 *   CSPC 224-01, Fall 2019
 *   Programming Assignment #2
 *   Sources:
 *
 *   @author Zac Foteff
 *   @version v1.0 09/16/2019
 */

import java.util.*;
public class TicTacToeTester
{
    /**
     Method contains all game logic for Tic Tac Toe
        - Initializes game object state
        - Displays state
        - Takes user guess input
        - Checks if user input is valid
        - Alters game object with user guess
        - Checks if win condition has been met, or if game satifies conditions of a scratch game
     *
     * @return boolean value of true if the user wants the game loop to repeat, false to stop playing
     */
    public static boolean playGame()
    {
        TicTacToeBoard board;
        int N;
        int playerTurn = 1;

        System.out.println("Welcome to Tic Tac Toe! In this game, two players, X and O, compete to try and get N of\n" +
                "Their symbols in a row. Each player will place one symbol on the game board per turn and the game\n" +
                "will reach a win condition if N of a symbol appears uninterrupted horozonatlly, vertically, \n" +
                "or diagonally. If neither player can achieve this with the allotted spaces on the board the \n" +
                "game will be considered a scratch game.\n\n");
        System.out.println("Please specify a grid size N for a NxN sized game board");
        Scanner user = new Scanner(System.in);
        N = user.nextInt();
        //  when enter is passed at the end of next int it rolls over to the next nextLine call, which gave me
        //  an error down the line
        user.nextLine();

        while(N < 3 || N > 9)
        {
            System.out.println("Please specify N within the range [3, 9]");
            N = user.nextInt();
            user.nextLine();
        }

        board = new TicTacToeBoard(N);

        while (true)
        {
            Coordinates nextMove = new Coordinates();
            char player;

            if (playerTurn == 1)
                player = 'X';
            else
                player = 'O';

            board.displayGrid();
            System.out.println("Player "+player+", please enter the coordinates of \n" +
                    "your placement separated by a space (row column): ");

            String move = user.nextLine();

            while (move.length() != 3)
            {
                System.out.println("Please enter a row and a column separated by one space");
                move = user.nextLine();
            }

            int nextRow = Integer.parseInt(String.valueOf(move.charAt(0))) - 1;
            int nextCol = Integer.parseInt(String.valueOf(move.charAt(2))) - 1;


            while(nextRow < 0 || nextRow > N)
            {
                System.out.println("Please enter a row between 0 and "+N+": ");
                nextRow = user.nextInt();
            }

            while(nextCol < 0 || nextCol > N)
            {
                System.out.println("Please enter a column between 0 and "+N+": ");
                nextCol = user.nextInt();
            }

            nextMove.setRow(nextRow);
            nextMove.setCol(nextCol);

            while(!board.isValidMove(nextMove))
            {
                System.out.println("That is not a valid move. Please enter new coordinates: ");
                move = user.nextLine();

                nextRow = Integer.parseInt(String.valueOf(move.charAt(0))) - 1;
                nextCol = Integer.parseInt(String.valueOf(move.charAt(2))) - 1;
                nextMove.setRow(nextRow);
                nextMove.setCol(nextCol);
            }

            board.makeMove(nextMove, player);

            if (board.isWinner(player))
            {
                board.displayGrid();
                System.out.println("Player "+player+" wins!\n\n");
                break;
            }

            if (board.isScratch())
            {
                board.displayGrid();
                System.out.println("Scratch game.\n\n");
                break;
            }

            //  Change player symbol
            playerTurn *= -1;
        }

        System.out.println("Play again? Type (y) to keep playing or (n) to quit: ");
        String continueChoice = user.nextLine();

        while(continueChoice.charAt(0) != 'y' && continueChoice.charAt(0) != 'n')
        {
            System.out.println("Please enter 'y' to continue playing or 'n' to quit: ");
            continueChoice = user.nextLine();
        }

        if (continueChoice.equals("y"))
            return true;

        else
            return false;


    }

    public static void main(String[] args)
    {
        boolean keepPlaying = true;

        while(true)
        {
            keepPlaying = playGame();
            if (keepPlaying)
                continue;
            else
                break;
        }
    }
}
