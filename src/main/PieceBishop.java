package main;

import java.util.Vector;

public class PieceBishop extends ChessPiece{
	
	PieceBishop(int number, char color){
		super('B',number,color);
	}
	
	@Override
	Vector<ChessSquare> calcPossibleMoves() {
		System.out.println("Bishop: Calculating possible moves from "+xPos+","+yPos);
		Vector<ChessSquare> possibleMoves=new Vector<ChessSquare>();
		//northeast
		for(int i=1;i<8;i++){
			int x=xPos+i;
			int y=yPos+i;
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
		//southeast
		for(int i=1;i<8;i++){
			int x=xPos+i;
			int y=yPos-i;
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
		//southwest
		for(int i=1;i<8;i++){
			int x=xPos-i;
			int y=yPos-i;
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
		//northwest
		for(int i=1;i<8;i++){
			int x=xPos-i;
			int y=yPos+i;
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
		
		
		return possibleMoves;
	}
}
