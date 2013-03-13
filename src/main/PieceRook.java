package main;

public class PieceRook extends ChessPiece{
	PieceRook(int number, char color){
		super('R',number,color);
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
	
}
