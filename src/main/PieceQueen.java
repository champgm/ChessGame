package main;

import java.util.Vector;

public class PieceQueen extends ChessPiece{
	PieceQueen(int number, char color){
		super('Q',number,color);
	}

	@Override
	boolean canMoveTo(ChessSquare newSquare) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	boolean moveTo(ChessSquare newSquare) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	Vector<ChessSquare> calcPossibleMoves() {
		// TODO Auto-generated method stub
		return null;
	}
}
