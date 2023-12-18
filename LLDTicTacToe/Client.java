package com.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Client {
 public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);
     int boardSize = 3;

     Board board = new Board(boardSize);

     System.out.print("Enter player 1 name: ");
     String player1Name = scanner.next();
     Player player1 = new Player(player1Name, PieceTypeEnum.X);

     System.out.print("Enter player 2 name: ");
     String player2Name = scanner.next();
     Player player2 = new Player(player2Name, PieceTypeEnum.O);

     List<Player> PlayersList = new ArrayList<>();
     PlayersList.add(player1);
     PlayersList.add(player2);
     
     Game game = new Game(board,PlayersList);

     while (true) {
        game.startGame();
 }
 }
 
}
