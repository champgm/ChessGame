package main;
import java.util.Vector;



public class PiecePawn extends ChessPiece{
	boolean hasMoved=false;
	PiecePawn(int number, char color){
		super('P',number,color);
	}
	boolean moveTo(ChessSquare newSquare){
		//ahhh shit, implement this later:
		//Pawns may not use the initial two-square advance to jump over an occupied square, or to capture. 
		System.out.println("Piece: I am currently at "+mySquare.getX()+","+mySquare.getY());
		if(newSquare!=null){
			if(canMoveTo(newSquare)){
				mySquare.setPiece(null);
				if(!newSquare.isEmpty()){
					myBoard.deadPieces.add(newSquare.getPiece());
				}
				newSquare.setPiece(this);
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
	Vector<ChessSquare> calcPossibleMoves(){
		int validX=0;
		int validY=0;
		Vector<ChessSquare> possibleMoves=new Vector<ChessSquare>();
		ChessSquare possibleSquare;
		System.out.println("Pawn: Calculating possible moves from "+xPos+","+yPos);
		if(!hasMoved){
			validX=xPos;
			if(myColor=='B'){
				validY=4;
			}else{
				validY=3;
			}
			System.out.println("Pawn: Looking at "+validX+","+validY+"...");
			possibleSquare=myBoard.getSquareAt(validX, validY);
			if(possibleSquare!=null){
				System.out.println("Pawn: I haven't moved yet, so "+validX+","+validY+" is a valid move");
				if(possibleSquare.isEmpty()){
					possibleMoves.add(possibleSquare);
					System.out.println("Pawn: Adding that square to the possibles list.");
				}else{
					System.out.println("Pawn: But there's something already there");
				}
			}
		}
		validX=xPos;
		if(myColor=='B'){
			validY=yPos-1;
		}else{
			validY=yPos+1;
		}
		System.out.println("Pawn: Looking at "+validX+","+validY+"...");
		possibleSquare=myBoard.getSquareAt(validX, validY);
		if(possibleSquare!=null){
			System.out.println("Pawn: "+validX+","+validY+" is a valid move");
			if(possibleSquare.isEmpty()){
				System.out.println("Pawn: And it's empty, adding that square to the possibles list.");
				possibleMoves.add(possibleSquare);
			}else{
				System.out.println("Pawn: But there's something already there");
			}
		}
		for(int i=-1;i<2;i+=2){
			validX=xPos+i;
			if(myColor=='B'){
				validY=yPos-1;
			}else{
				validY=yPos+1;
			}
			System.out.println("Pawn: Looking at "+validX+","+validY+"...");
			possibleSquare=myBoard.getSquareAt(validX, validY);
			if(possibleSquare!=null){
				System.out.println("Pawn: Attacking? "+validX+","+validY+" is a valid attack move");
				if(!possibleSquare.isEmpty()){
					System.out.println("Pawn: And there is something there to attack...");
					if(possibleSquare.getPiece().getColor()!=myColor){
						System.out.println("Pawn: And there it's an enemy!");
						possibleMoves.add(possibleSquare);
					}else{
						System.out.println("Pawn: But it's one of our guys.");
					}
				}
			}
		}
		return possibleMoves;
	}
}
