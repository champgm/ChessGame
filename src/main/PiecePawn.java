package main;
import java.util.Vector;



public class PiecePawn extends ChessPiece{
	boolean hasMoved=false;
	PiecePawn(int number, char color){
		super('P',number,color);
	}
	boolean moveTo(ChessSquare newSquare){
 
		System.out.println("Piece: I am currently at "+xPos+","+yPos);
		if(newSquare!=null){
			if(canMoveTo(newSquare)){
				mySquare.setPiece(null);
				if(!newSquare.isEmpty()){
					myBoard.deadPieces.add(newSquare.getPiece());
					System.out.println("Piece: Killed piece at "+newSquare.getX()+","+newSquare.getY());
				}
				newSquare.setPiece(this);
				mySquare=newSquare;
				hasMoved=true;
				return true;
			}else{
				System.out.println("Piece: Could not move to "+newSquare.getX()+","+newSquare.getY());
				return false;
			}
		}
		System.out.println("Piece: That square doesn't exist.");
		return false;
	}
	boolean canMoveTo(ChessSquare newSquare){
		Vector<ChessSquare> possibleMoves=calcPossibleMoves();
		if(possibleMoves.contains(newSquare)){
			return true;
		}	
		return false;
	}
	String whatsAtSquare(int x, int y){
		ChessSquare possibleSquare;
		System.out.println("Pawn: Looking at "+x+","+y+"...");
		possibleSquare=myBoard.getSquareAt(x, y);
		if(possibleSquare!=null){
			if(possibleSquare.isEmpty()){
				System.out.println("Pawn: Square is empty");
				return "empty";
			}else{
				System.out.println("Pawn: Square is occupied");
				return "occupied";
			}
		}else{
			System.out.println("Pawn: Square off-board");
			return "null";
		}
		
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
