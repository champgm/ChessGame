package main;

import java.util.Vector;

public class PieceKing extends ChessPiece{
	PieceKing(int number, char color){
		super('K',number,color);
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
