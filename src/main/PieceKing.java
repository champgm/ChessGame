package main;

import java.util.Vector;

public class PieceKing extends ChessPiece{
	PieceKing(int number, char color){
		super('K',number,color);
	}

	@Override
	Vector<ChessSquare> calcPossibleMoves() {
		System.out.println("King: Calculating possible moves from "+xPos+","+yPos);
		Vector<ChessSquare> possibleMoves=new Vector<ChessSquare>();

		for(int i=xPos-1;i<xPos+2;i++){
			for(int j=yPos-1;j<yPos+2;j++){
				boolean[] emptyEnemy=EmptyEnemy(i,j);
				System.out.println("King: checking "+i+","+j);
				if(emptyEnemy[0]||emptyEnemy[1]){
					possibleMoves.add(myBoard.getSquareAt(i,j));
				}
			}
		}

		return possibleMoves;
	}
}
