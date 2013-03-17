package main;

import java.util.Vector;

public class PieceQueen extends ChessPiece{
	PieceQueen(int number, char color){
		super('Q',number,color);
	}

	@Override
	Vector<ChessSquare> calcPossibleMoves() {
		// TODO Auto-generated method stub
		return null;
	}
}
