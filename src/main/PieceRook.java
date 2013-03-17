package main;

import java.util.Vector;

public class PieceRook extends ChessPiece{
	PieceRook(int number, char color){
		super('R',number,color);
	}
	
	@Override
	Vector<ChessSquare> calcPossibleMoves() {
		System.out.println("Rook: Calculating possible moves from "+xPos+","+yPos);
		Vector<ChessSquare> possibleMoves=new Vector<ChessSquare>();
		possibleMoves=calculateRookTypeMovement();
		return possibleMoves;
	}
	/*
	@Override
	Vector<ChessSquare> calcPossibleMoves() {
		System.out.println("Rook: Calculating possible moves from "+xPos+","+yPos);
		Vector<ChessSquare> possibleMoves=new Vector<ChessSquare>();
		//greater horizontal
		for(int i=xPos+1;i<8;i++){
			int x=i;
			int y=yPos;
			System.out.println("Rook: loop1 checking "+x+","+y);
			boolean[] validBreak=ValidBreak(x,y);
			if(validBreak[0]){
				possibleMoves.add(myBoard.getSquareAt(x, y));
				if(validBreak[1]){
					break;
				}
			}else{
				break;
			}
		}
		//lesser horizontal
		for(int i=xPos-1;i>-1;i--){
			int x=i;
			int y=yPos;
			System.out.println("Rook: loop2 checking "+x+","+y);
			boolean[] validBreak=ValidBreak(x,y);
			if(validBreak[0]){
				possibleMoves.add(myBoard.getSquareAt(x, y));
				if(validBreak[1]){
					break;
				}
			}else{
				break;
			}
		}
		//greater vertical
		for(int i=yPos+1;i<8;i++){
			int x=xPos;
			int y=i;
			System.out.println("Rook: loop3 checking "+x+","+y);
			boolean[] validBreak=ValidBreak(x,y);
			if(validBreak[0]){
				possibleMoves.add(myBoard.getSquareAt(x, y));
				if(validBreak[1]){
					break;
				}
			}else{
				break;
			}
		}
		//lesser vertical
		for(int i=yPos-1;i>-1;i--){
			int x=xPos;
			int y=i;
			System.out.println("Rook: loop4 checking "+x+","+y);
			boolean[] validBreak=ValidBreak(x,y);
			if(validBreak[0]){
				possibleMoves.add(myBoard.getSquareAt(x, y));
				if(validBreak[1]){
					break;
				}
			}else{
				break;
			}
		}
		return possibleMoves;
	}
	*/
}
