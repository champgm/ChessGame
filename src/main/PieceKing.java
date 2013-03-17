package main;

import java.util.Vector;

public class PieceKing extends ChessPiece{
	PieceKing(int number, char color){
		super('K',number,color);
	}

	@Override
	Vector<ChessSquare> calcPossibleMoves() {
		// TODO Auto-generated method stub
		return null;
	}
}
