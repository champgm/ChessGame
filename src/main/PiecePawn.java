package main;
import java.util.Iterator;
import java.util.Vector;



public class PiecePawn extends ChessPiece{
	boolean hasMoved=false;
	PiecePawn(int number, char color){
		super('P',number,color);
	}
	boolean moveTo(ChessSquare newSquare){
		if(canMoveTo(newSquare)){
			mySquare.setPiece(null);
			if(newSquare.getPiece()!=null){
				myBoard.deadPieces.add(newSquare.getPiece());
			}
			newSquare.setPiece(this);
			return true;
		}else{
			return false;
		}
	}
	boolean canMoveTo(ChessSquare newSquare){
		Vector<ChessSquare> possibleMoves=calcPossibleMoves();
		Iterator<ChessSquare> iterator=possibleMoves.iterator();
		while(iterator.hasNext()){
			if(iterator.next().equals(newSquare)){
				return true;
			}
		}	
		return false;
	}
	Vector<ChessSquare> calcPossibleMoves(){
		Vector<ChessSquare> possibleMoves=new Vector<ChessSquare>();
		ChessSquare possibleSquare;
		int validX=0;
		int validY=0;
		if(!hasMoved){
			validX=xPos;
			if(myColor=='B'){
				validY=4;
			}else{
				validY=3;
			}
			possibleSquare=myBoard.getSquareAt(validX, validY);
			if(possibleSquare.getPiece()==null){
				possibleMoves.add(possibleSquare);
			}
		}
		validX=xPos;
		if(myColor=='B'){
			validY=yPos-1;
		}else{
			validY=yPos+1;
		}
		possibleSquare=myBoard.getSquareAt(validX, validY);
		if(possibleSquare.getPiece()==null){
			possibleMoves.add(possibleSquare);
		}
		for(int i=-1;i<2;i+=2){
			validX=xPos+i;
			if(myColor=='B'){
				validY=yPos-1;
			}else{
				validY=yPos+1;
			}
			possibleSquare=myBoard.getSquareAt(validX, validY);
			if(possibleSquare.getPiece()!=null){
				if(possibleSquare.getPiece().getColor()!=myColor){
					possibleMoves.add(possibleSquare);
				}
			}
		}
		return possibleMoves;
	}
}
