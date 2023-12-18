package com.test;

import java.util.Map;

public class Board {
    private int size;
    private Map<Integer, Integer> snakes; // Map head to tail
    private Map<Integer, Integer> ladders; // Map bottom to top

    public Board(int size, Map<Integer, Integer> snakes, Map<Integer, Integer> ladders) {
        this.size = size;
        this.snakes = snakes;
        this.ladders = ladders;
    }

    public int getSize() {
        return size;
    }

    public int move(int currentPosition, int diceRoll) {
        int newPosition = currentPosition + diceRoll;

        // Check if the new position has a snake or ladder
        if (snakes.containsKey(newPosition)) {
            newPosition = snakes.get(newPosition);
        } else if (ladders.containsKey(newPosition)) {
            newPosition = ladders.get(newPosition);
        }

        // Ensure the new position is within the board
        return Math.min(newPosition, size);
    }
}

