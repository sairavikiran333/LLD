package com.test;

public class Player {
	
	private String name;
    private PieceTypeEnum pieceType;

    public Player(String name, PieceTypeEnum pieceType) {
        this.name = name;
        this.pieceType = pieceType;
    }

    public String getName() {
        return name;
    }

    public PieceTypeEnum getPieceType() {
        return pieceType;
    }
}

