package com.test;

public enum PieceTypeEnum {
	X('X'), O('O');

	private char symbol;

	PieceTypeEnum(char symbol) {
		this.symbol = symbol;
	}

	public char getSymbol() {
		return symbol;
	}

}
