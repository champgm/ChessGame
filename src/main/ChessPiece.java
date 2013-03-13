package main;

public abstract class ChessPiece {
	char myType;
	int  myNumber;
	char myColor;
	int xPos;
	int yPos;
	ChessSquare mySquare;
	ChessBoard myBoard;

	abstract boolean canMoveTo(ChessSquare newSquare);
	abstract boolean moveTo(ChessSquare newSquare);
	public ChessPiece(char type, int number, char color){
		myType=type;
		myNumber=number;
		myColor=color;
	}
	String stringRep(){
		String representation="";
		representation+=myType;
		representation+=myNumber;
		representation+=myColor;
		return representation;
	}
	void setPos(int x, int y){
		xPos=x;
		yPos=y;
	}
	void setSquare(ChessSquare newSquare){
		mySquare=newSquare;
	}
	void setBoard(ChessBoard board){
		myBoard=board;
	}
	char getColor(){
		return myColor;
	}
	
	
}
