package main;

import java.util.Vector;

public class PieceQueen extends ChessPiece{
	PieceQueen(int number, char color){
		super('Q',number,color);
	}

	@Override
	Vector<ChessSquare> calcPossibleMoves() {
		Vector<ChessSquare> bishopTypes=calculateBishopTypeMovement();
		Vector<ChessSquare> rookTypes=calculateRookTypeMovement();
		Vector<ChessSquare> both=new Vector<ChessSquare>();
		both.addAll(bishopTypes);
		both.addAll(rookTypes);
		return both;
	}
}
