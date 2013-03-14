package main;

public class ChessSquare {
	private int xPos;
	private int yPos;
	private char xPosChar;
	private ChessPiece myPiece=null;
	private boolean iAmWhite;
	ChessBoard myBoard;
	public ChessSquare(ChessBoard board, int x, int y){
		myBoard=board;
		xPos=x;
		yPos=y;
		switch (xPos){
			case 1:  xPosChar='a'; break;
			case 2:  xPosChar='b'; break;
			case 3:  xPosChar='c'; break;
			case 4:  xPosChar='d'; break;
			case 8:  xPosChar='h'; break;
			case 5:  xPosChar='e'; break;
			case 6:  xPosChar='f'; break;
			case 7:  xPosChar='g'; break;
			default: xPosChar='x'; break;
		}
	}
	public int getXPosInt(){
		return xPos;
	}
	public char getXPosChar(){
		return xPosChar;
	}
	public int getYPos(){
		return yPos;
	}
	public boolean printYourself(){
		boolean icanprint=true;
		if (myPiece!=null){
			System.out.print(myPiece.stringRep());
		}else{
			if(iAmWhite){
				System.out.print("   ");
			}else{
				System.out.print("...");
			}
		}
		return icanprint;
	}
	public void setPiece(ChessPiece newPiece){
		myPiece=newPiece;
		if(myPiece!=null){
			myPiece.setPos(xPos,yPos);
		}
	}
	public void setWhite(boolean isWhite){
		iAmWhite=isWhite;
	}
	public boolean isWhite(){
		return iAmWhite;
	}
	public int getX(){
		return xPos;
	}
	public int getY(){
		return yPos;
	}
	public ChessPiece getPiece(){
		return myPiece;
	}
	public boolean isEmpty(){
		if(myPiece==null){
			return true;
		}
		return false;
	}
}


