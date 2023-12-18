package com.test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Client {

	public static void main(String[] args) {
		// Set up the board with snakes and ladders
		int boardSize = 10;

		// Initialize snakes and ladders
		// Initialize snakes and ladders
        Map<Integer, Integer> snakes = new HashMap<>();
        snakes.put(2, 1);
        snakes.put(9, 3);
        // Add more snakes as needed...
        

        Map<Integer, Integer> ladders = new HashMap<>();
        ladders.put(1, 10);
        ladders.put(3, 8);

		Board board = new Board(boardSize, snakes, ladders);

		// Set up players
		List<Player> players = new ArrayList<>();
		players.add(new Player("Player 1"));
		players.add(new Player("Player 2"));

		// Create the game
		Game game = new Game(board, players);

		// Play the game
		while (true) {
			game.playTurn();
		}
	}
}
