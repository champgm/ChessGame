package main;

public class PieceKnight extends ChessPiece{
	PieceKnight(int number, char color){
		super('N',number,color);
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
