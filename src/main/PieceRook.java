package main;

import java.util.Vector;

public class PieceRook extends ChessPiece{
	PieceRook(int number, char color){
		super('R',number,color);
	}
	boolean testSquare(int x, int y){
		
		return false;
	}
	Boolean[] ValidBreak(int x, int y){
		Boolean[] validBreak={false,false};
		Boolean[] loopEE=EmptyEnemy(x,y);
		if(loopEE[0]){
			System.out.println("Piece: "+x+","+y+" is empty.");
			validBreak[0]=true;
		}else if(loopEE[1]){
			System.out.println("Piece: "+x+","+y+" is occupied by enemy.");
			validBreak[0]=true;
			validBreak[1]=true;
		}else{
			System.out.println("Piece: "+x+","+y+" is occupied by friendly.");
			validBreak[0]=false;
			validBreak[1]=true;
		}
		return validBreak;
	}
	@Override
	Vector<ChessSquare> calcPossibleMoves() {
		System.out.println("Rook: Calculating possible moves from "+xPos+","+yPos);
		Vector<ChessSquare> possibleMoves=new Vector<ChessSquare>();
		//greater horizontal
		for(int i=xPos+1;i<8;i++){
			int x=i;
			int y=yPos;
			System.out.println("Rook: loop1 checking "+x+","+y);
			Boolean[] loopEE=EmptyEnemy(x,y);
			if(loopEE[0]){
				System.out.println("Piece: "+x+","+y+" is empty.");
				possibleMoves.add(myBoard.getSquareAt(x, y));
			}else if(loopEE[1]){
				System.out.println("Piece: "+x+","+y+" is occupied by enemy.");
				possibleMoves.add(myBoard.getSquareAt(x, y));
				break;
			}else{
				System.out.println("Piece: "+x+","+y+" is occupied by friendly.");
				break;
			}
		}
		//lesser horizontal
		for(int i=xPos-1;i>-1;i--){
			int x=i;
			int y=yPos;
			System.out.println("Rook: loop2 checking "+x+","+y);
			Boolean[] loopEE=EmptyEnemy(x,y);
			if(loopEE[0]){
				System.out.println("Piece: "+x+","+y+" is empty.");
				possibleMoves.add(myBoard.getSquareAt(x, y));
			}else if(loopEE[1]){
				System.out.println("Piece: "+x+","+y+" is occupied by enemy.");
				possibleMoves.add(myBoard.getSquareAt(x, y));
				break;
			}else{
				System.out.println("Piece: "+x+","+y+" is occupied by friendly.");
				break;
			}
		}
		//greater vertical
		for(int i=yPos+1;i<8;i++){
			int x=xPos;
			int y=i;
			System.out.println("Rook: loop3 checking "+x+","+y);
			Boolean[] loopEE=EmptyEnemy(x,y);
			if(loopEE[0]){
				System.out.println("Piece: "+x+","+y+" is empty.");
				possibleMoves.add(myBoard.getSquareAt(x, y));
			}else if(loopEE[1]){
				System.out.println("Piece: "+x+","+y+" is occupied by enemy.");
				possibleMoves.add(myBoard.getSquareAt(x, y));
				break;
			}else{
				System.out.println("Piece: "+x+","+y+" is occupied by friendly.");
				break;
			}
		}
		//lesser vertical
		for(int i=yPos-1;i>-1;i--){
			int x=xPos;
			int y=i;
			System.out.println("Rook: loop4 checking "+x+","+y);
			Boolean[] loopEE=EmptyEnemy(x,y);
			if(loopEE[0]){
				System.out.println("Piece: "+x+","+y+" is empty.");
				possibleMoves.add(myBoard.getSquareAt(x, y));
			}else if(loopEE[1]){
				System.out.println("Piece: "+x+","+y+" is occupied by enemy.");
				possibleMoves.add(myBoard.getSquareAt(x, y));
				break;
			}else{
				System.out.println("Piece: "+x+","+y+" is occupied by friendly.");
				break;
			}
		}
		return possibleMoves;
	}
	boolean squareOkay(int x,int y){
		
		return false;
	}
}
