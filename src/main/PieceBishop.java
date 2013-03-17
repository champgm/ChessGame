package main;

import java.util.Vector;

public class PieceBishop extends ChessPiece{
	
	PieceBishop(int number, char color){
		super('B',number,color);
	}
	
	@Override
	Vector<ChessSquare> calcPossibleMoves() {
		// TODO Auto-generated method stub
		return null;
	}
}
