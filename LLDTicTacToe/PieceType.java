package com.test;

public enum PieceType {
	X('X'), O('O');

	private char symbol;

	PieceType(char symbol) {
		this.symbol = symbol;
	}

	public char getSymbol() {
		return symbol;
	}

}
