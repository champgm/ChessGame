package main;

import java.util.Vector;

public class PieceRook extends ChessPiece{
	PieceRook(int number, char color){
		super('R',number,color);
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
