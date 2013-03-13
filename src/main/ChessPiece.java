package main;

public abstract class ChessPiece {
	char myType;
	int  myNumber;
	char myColor;
	int xPos;
	int yPos;

	public ChessPiece(char type, int number, char color){
		myType=type;
		myNumber=number;
		myColor=color;
	}
	void printYourself(){
		System.out.print(myType);
		System.out.print(myNumber);
		System.out.print(myColor);
	}
	void setPos(int x, int y){
		xPos=x;
		yPos=y;
	}
	
}
