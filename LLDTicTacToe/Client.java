package com.test;

import java.util.Scanner;

public class Client {
 public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);
     int boardSize = 3;

     Board board = new Board(boardSize);

     System.out.print("Enter player 1 name: ");
     String player1Name = scanner.next();
     Player player1 = new Player(player1Name, PieceType.X);

     System.out.print("Enter player 2 name: ");
     String player2Name = scanner.next();
     Player player2 = new Player(player2Name, PieceType.O);

     Player currentPlayer = player1;

     while (true) {
         board.displayBoard();

         System.out.println(currentPlayer.getName() + ", it's your turn!");
         System.out.print("Enter row (0-" + (boardSize - 1) + "): ");
         int row = scanner.nextInt();

         System.out.print("Enter column (0-" + (boardSize - 1) + "): ");
         int col = scanner.nextInt();

         if (board.canPlacePiece(row, col, currentPlayer.getPieceType() == PieceType.X ? 'X' : 'O')) {
             // Check for win or tie
             if (checkWin(board, currentPlayer.getPieceType(), row, col)) {
                 board.displayBoard();
                 System.out.println(currentPlayer.getName() + " wins!");
                 break;
             } else if (board.isBoardFull()) {
                 board.displayBoard();
                 System.out.println("It's a tie!");
                 break;
             }

             // Switch to the other player
             currentPlayer = (currentPlayer == player1) ? player2 : player1;
         } else {
             System.out.println("Invalid move. Try again.");
         }
     }

     scanner.close();
 }

 private static boolean checkWin(Board board, PieceType pieceType, int lastMoveRow, int lastMoveCol) {
   
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
}//0 
// 0 0
// X 0 0
