package com.test;

import java.util.*;

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

    public void playTurn() {
        Player currentPlayer = players.get(currentPlayerIndex);

        // Initialize totalRoll to store the cumulative sum of dice rolls
        int totalRoll = 0;

        // Use a while loop to handle extra turns when the player rolls a 6
        while (true) {
            // Wait for the user to press Enter to roll the dice
            System.out.println(currentPlayer.getName() + ", press Enter to roll the dice.");
            scanner.nextLine();

            // Simulate dice roll
            int diceRoll = (int) (Math.random() * 6) + 1;

            // Add the current dice roll to the totalRoll
            totalRoll += diceRoll;

            // Print the individual dice roll result
            System.out.println(currentPlayer.getName() + " rolled a " + diceRoll);

            // Check if the player rolled a 6 for an extra turn
            if (diceRoll != 6) {
                break; // Exit the loop if the player did not roll a 6
            }

            System.out.println(currentPlayer.getName() + " rolled a 6 and gets an extra turn!");
        }

        // Move the player on the board using the cumulative total of dice rolls
        int newPosition = board.move(currentPlayer.getPosition(), totalRoll);
        currentPlayer.setPosition(newPosition);

        // Print the turn result
        System.out.println(currentPlayer.getName() + " rolled a total of " + totalRoll +
                " and moved to position " + newPosition);

        // Check if the player has won
        if (newPosition == board.getSize()) {
            System.out.println(currentPlayer.getName() + " has won!");
            scanner.close();
            System.exit(0); // End the game
        }

        // Move to the next player
        currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
    }
}
