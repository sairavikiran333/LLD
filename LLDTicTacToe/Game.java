package com.test;

import java.util.List;
import java.util.Scanner;

public class Game {

	private Board board;
    private List<Player> players;
    private int currentPlayerIndex;
    private Scanner scanner;

    public Game(Board board, List<Player> players) {
        this.board = board;
        this.players = players;
        this.currentPlayerIndex = 0;
        this.scanner = new Scanner(System.in);
    }
    
    private static boolean checkWin(Board board, PieceTypeEnum pieceType,
   		 int lastMoveRow, int lastMoveCol) {
      
        boolean winInRow = true;
        for (int j = 0; j < board.getSize(); j++) {
       	    if (board.getGrid()[lastMoveRow][j] != pieceType.getSymbol()) {
       	        winInRow = false;
       	        break;
       	    }
       	}

        boolean winInCol = true;
        for (int i = 0; i < board.getSize(); i++) {
            if (board.getGrid()[i][lastMoveCol] != pieceType.getSymbol()) {
                winInCol = false;
                break;
            }
        }

        boolean winInDiagonal = false;
        if (lastMoveRow == lastMoveCol || lastMoveRow + lastMoveCol == board.getSize() - 1) {
            winInDiagonal = true;
            for (int i = 0; i < board.getSize(); i++) {
                if (board.getGrid()[i][i] != pieceType.getSymbol() && board.getGrid()[i][board.getSize() - 1 - i] != pieceType.getSymbol()) {
                    winInDiagonal = false;
                    break;
                }
            }
        }

        return winInRow || winInCol || winInDiagonal;
    }

	public void startGame() {

        while (true) {
            int boardSize = board.getSize();
            Player currentPlayer = players.get(currentPlayerIndex);

            board.displayBoard();

            System.out.println(currentPlayer.getName() + ", it's your turn!");
            System.out.print("Enter row (0-" + (boardSize - 1) + "): ");
            int row = scanner.nextInt();

            System.out.print("Enter column (0-" + (boardSize - 1) + "): ");
            int col = scanner.nextInt();

            if (board.canPlacePiece(row, col, currentPlayer.getPieceType().getSymbol())) {
                // Place the piece on the board
                 // Check for win or tie
                if (checkWin(board, currentPlayer.getPieceType(), row, col)) {
                    board.displayBoard();
                    System.out.println(currentPlayer.getName() + " wins!");
                    scanner.close();
                    System.exit(0);
                } else if (board.isBoardFull()) {
                    board.displayBoard();
                    System.out.println("It's a tie!");
                    scanner.close();
                    System.exit(0);
                }

                currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }
	}
}
