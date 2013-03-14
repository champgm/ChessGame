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
		//greater horizontal
		for(int i=xPos+1;i<8;i++){
			System.out.println("Rook: loop1 checking "+i+","+yPos);
			String target=whatsAtSquare(i,yPos);
			System.out.println("Piece: checking "+i+","+yPos);
			boolean quit=false;
			switch(target){
				case "empty":
					System.out.println("Piece: "+i+","+yPos+" is empty.");
					quit=false;
					possibleMoves.add(myBoard.getSquareAt(i, yPos));
					break;
				case "occupied":
					if(myBoard.getSquareAt(i, yPos).getPiece().getColor()!=myColor){
						System.out.println("Piece: "+i+","+yPos+" is occupied by enemy.");
						quit=true;
						possibleMoves.add(myBoard.getSquareAt(i, yPos));
						break;
					}else{
						System.out.println("Piece: "+i+","+yPos+" is occupied by friendly.");
						quit=true;
						break;
					}
				case "null":
					System.out.println("Piece: looking at a square off board.");
					quit=true;
			}
			if(quit){
				break;
			}
		}
		//lesser horizontal
		for(int i=xPos-1;i>-1;i--){
			System.out.println("Rook: loop2 checking "+i+","+yPos);
			String target=whatsAtSquare(i,yPos);
			System.out.println("Piece: checking "+i+","+yPos);
			boolean quit=false;
			switch(target){
				case "empty":
					System.out.println("Piece: "+i+","+yPos+" is empty.");
					quit=false;
					possibleMoves.add(myBoard.getSquareAt(i, yPos));
					break;
				case "occupied":
					if(myBoard.getSquareAt(i, yPos).getPiece().getColor()!=myColor){
						System.out.println("Piece: "+i+","+yPos+" is occupied by enemy.");
						quit=true;
						possibleMoves.add(myBoard.getSquareAt(i, yPos));
						break;
					}else{
						System.out.println("Piece: "+i+","+yPos+" is occupied by friendly.");
						quit=true;
						break;
					}
				case "null":
					System.out.println("Piece: looking at a square off board.");
					quit=true;
			}
			if(quit){
				break;
			}
		}
		//greater vertical
		for(int i=yPos+1;i<8;i++){
			System.out.println("Rook: loop3 checking "+xPos+","+i);
			String target=whatsAtSquare(xPos,i);
			System.out.println("Piece: checking "+xPos+","+i);
			boolean quit=false;
			switch(target){
				case "empty":
					System.out.println("Piece: "+xPos+","+i+" is empty.");
					quit=false;
					possibleMoves.add(myBoard.getSquareAt(xPos, i));
					break;
				case "occupied":
					if(myBoard.getSquareAt(xPos, i).getPiece().getColor()!=myColor){
						System.out.println("Piece: "+xPos+","+i+" is occupied by enemy.");
						quit=true;
						possibleMoves.add(myBoard.getSquareAt(xPos, i));
						break;
					}else{
						System.out.println("Piece: "+xPos+","+i+" is occupied by friendly.");
						quit=true;
						break;
					}
				case "null":
					System.out.println("Piece: looking at a square off board.");
					quit=true;
			}
			if(quit){
				break;
			}
		}
		//lesser vertical
		for(int i=yPos-1;i>-1;i--){
			System.out.println("Rook: loop4 checking "+xPos+","+i);
			String target=whatsAtSquare(xPos,i);
			System.out.println("Piece: checking "+xPos+","+i);
			boolean quit=false;
			switch(target){
				case "empty":
					System.out.println("Piece: "+xPos+","+i+" is empty.");
					quit=false;
					possibleMoves.add(myBoard.getSquareAt(xPos, i));
					break;
				case "occupied":
					if(myBoard.getSquareAt(xPos, i).getPiece().getColor()!=myColor){
						System.out.println("Piece: "+xPos+","+i+" is occupied by enemy.");
						quit=true;
						possibleMoves.add(myBoard.getSquareAt(xPos, i));
						break;
					}else{
						System.out.println("Piece: "+xPos+","+i+" is occupied by friendly.");
						quit=true;
						break;
					}
				case "null":
					System.out.println("Piece: looking at a square off board.");
					quit=true;
			}
			if(quit){
				break;
			}
		}
		return possibleMoves;
	}
	boolean squareOkay(int x,int y){
		
		return false;
	}
}
