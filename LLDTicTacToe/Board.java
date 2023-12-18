package com.test;

import java.util.ArrayList;
import java.util.List;



public class Board {
	

	 private final int size;
	 public int getSize() {
		return size;
	}

	private char[][] grid;

	 public Board(int size) {
	     this.size = size;
	     this.grid = new char[size][size];
	     initializeBoard();
	 }

	 private void initializeBoard() {
	     for (int i = 0; i < size; i++) {
	         for (int j = 0; j < size; j++) {
	             grid[i][j] = ' ';
	         }
	     }
	 }

	 public void displayBoard() {
	     for (int i = 0; i < size; i++) {
	         for (int j = 0; j < size; j++) {
	             System.out.print(grid[i][j]);
	             if (j < size - 1) {
	                 System.out.print(" | ");
	             }
	         }
	         System.out.println();
	         if (i < size - 1) {
	             System.out.println("---------");
	         }
	     }
	 }

	 public boolean canPlacePiece(int row, int col, char piece) {
	     if (row < 0 || row >= size || col < 0 || col >= size || grid[row][col] != ' ') {
	         return false;
	     }

	     grid[row][col] = piece;
	     return true;
	 }

	 public boolean isBoardFull() {
	     for (int i = 0; i < size; i++) {
	         for (int j = 0; j < size; j++) {
	             if (grid[i][j] == ' ') {
	                 return false;
	             }
	         }
	     }
	     return true;
	 }
	 
	 public char[][] getGrid() {
	        return grid;
	    }

}

