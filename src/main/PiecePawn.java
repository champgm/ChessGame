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
		int validX=0;
		int validY=0;
		Vector<ChessSquare> possibleMoves=new Vector<ChessSquare>();
		System.out.println("Pawn: Calculating possible moves from "+xPos+","+yPos);
		if(!hasMoved){
			//Pawns may not use the initial two-square advance to jump over an occupied square, or to capture.
			int intermediateY=0;
			validX=xPos;
			if(myColor=='B'){
				validY=4;
				intermediateY=5;
			}else{
				validY=3;
				intermediateY=2;
			}
			if(whatsAtSquare(validX,validY).equals("empty")){
				if(whatsAtSquare(validX,intermediateY).equals("empty")){
					System.out.println("Pawn: Adding square at "+validX+","+validY+" to possible moves list.");
					possibleMoves.add(myBoard.getSquareAt(validX, validY));
				}else{
					System.out.println("Pawn: Something is between me and there.");
				}
			}else{
				System.out.println("Pawn: Not a valid move.");
			}
		}
		
		validX=xPos;
		if(myColor=='B'){
			validY=yPos-1;
		}else{
			validY=yPos+1;
		}
		if(whatsAtSquare(validX,validY).equals("empty")){
			System.out.println("Pawn: Adding square at "+validX+","+validY+" to possible moves list.");
			possibleMoves.add(myBoard.getSquareAt(validX, validY));
		}else{
			System.out.println("Pawn: Not a valid move.");
		}
		
		for(int i=-1;i<2;i+=2){
			validX=xPos+i;
			if(myColor=='B'){
				validY=yPos-1;
			}else{
				validY=yPos+1;
			}
			if(whatsAtSquare(validX,validY).equals("occupied")){
				System.out.println("Pawn: Adding square at "+validX+","+validY+" to possible attack moves list.");
				possibleMoves.add(myBoard.getSquareAt(validX, validY));
			}else{
				System.out.println("Pawn: Not a valid attack move.");
			}
		}
		return possibleMoves;
	}
}
