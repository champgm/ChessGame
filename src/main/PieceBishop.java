package main;

public class PieceBishop extends ChessPiece{
	
	PieceBishop(int number, char color){
		super('B',number,color);
	}
	public boolean canMove(ChessSquare newSquare){
		boolean validMove=false;
		
		return validMove;
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
