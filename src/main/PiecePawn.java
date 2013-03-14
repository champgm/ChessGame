package main;
import java.util.Vector;



public class PiecePawn extends ChessPiece{
	//boolean hasMoved=false;
	PiecePawn(int number, char color){
		super('P',number,color);
	}

	Vector<ChessSquare> calcPossibleMoves(){
		System.out.println("Pawn: Calculating possible moves from "+xPos+","+yPos);
		Vector<ChessSquare> possibleMoves=new Vector<ChessSquare>();
		int farY=0;
		int adjacentY=0;
		
		//check to see if I should be moving up or down the board
		if(myColor=='B'){
			adjacentY=yPos-1;
			farY=4;
		}else{
			adjacentY=yPos+1;
			farY=3;
		}
		
		//forward movement
		if(whatsAtSquare(xPos,adjacentY).equals("empty")){
			System.out.println("Pawn: Adding square at "+xPos+","+adjacentY+" to possible moves list.");
			possibleMoves.add(myBoard.getSquareAt(xPos, adjacentY));
			if(whatsAtSquare(xPos,farY).equals("empty")){
				if(!hasMoved){
					System.out.println("Pawn: Since I haven't moved yet, adding square at "+xPos+","+farY+" to possible moves list.");
					possibleMoves.add(myBoard.getSquareAt(xPos, farY));
				}
			}
		}else{
			System.out.println("Pawn: Something in front, can't move forward.");
		}
		
		//attack moves
		int testX=xPos;
		for(int i=-1;i<2;i+=2){
			testX=xPos+i;
			if(whatsAtSquare(testX,adjacentY).equals("occupied")){
				if(!(myBoard.getSquareAt(testX, adjacentY).getPiece().getColor()==myColor)){
					System.out.println("Pawn: Enemy there, adding square at "+testX+","+adjacentY+" to possible attack moves list.");
					possibleMoves.add(myBoard.getSquareAt(testX, adjacentY));	
				}else{
					System.out.println("Pawn: Friendly there.");
				}
			}else{
				System.out.println("Pawn: Square is empty.");
			}
		}
		return possibleMoves;
	}
}
