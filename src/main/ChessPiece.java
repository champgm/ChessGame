package main;

import java.util.Vector;

public abstract class ChessPiece {
	boolean hasMoved;
	char myType;
	int  myNumber;
	char myColor;
	int xPos;
	int yPos;
	ChessSquare mySquare;
	ChessBoard myBoard;

	abstract Vector<ChessSquare> calcPossibleMoves();
	
	boolean canMoveTo(ChessSquare newSquare){
		Vector<ChessSquare> possibleMoves=calcPossibleMoves();
		if(possibleMoves.contains(newSquare)){
			return true;
		}	
		return false;
	}
	boolean[] ValidBreak(int x, int y){
		//this function is for pieces which have long, linear ranges
		//possible results for this are
		//10
		//11
		//01
		boolean[] validBreak={false,false};
		boolean[] loopEE=EmptyEnemy(x,y);
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
	boolean[] EmptyEnemy(int x, int y){
		boolean[] emptyEnemy={false,false};
		System.out.println("Piece: EmptyEnemy on "+x+","+y);
		String target=whatsAtSquare(x,y);
		switch(target){
			case "empty":
				System.out.println("Piece: "+x+","+y+" is empty.");
				emptyEnemy[0]=true;
				break;
			case "occupied":
				if(myBoard.getSquareAt(x, y).getPiece().getColor()!=myColor){
					System.out.println("Piece: "+x+","+y+" is occupied by enemy.");
					emptyEnemy[0]=false;
					emptyEnemy[1]=true;
					break;
				}else{
					System.out.println("Piece: "+x+","+y+" is occupied by friendly.");
					emptyEnemy[0]=false;
					emptyEnemy[1]=false;
					break;
				}
			case "null":
				System.out.println("Piece: looking at a square off board.");
		}
	
		return emptyEnemy;
	}
	String whatsAtSquare(int x, int y){
		ChessSquare possibleSquare;
		possibleSquare=myBoard.getSquareAt(x, y);
		if(possibleSquare!=null){
			if(possibleSquare.isEmpty()){
				System.out.println("Piece: Square "+x+","+y+" is empty");
				return "empty";
			}else{
				System.out.println("Piece: Square "+x+","+y+" is occupied");
				return "occupied";
			}
		}else{
			System.out.println("Piece: Square "+x+","+y+" is off-board");
			return "null";
		}
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
	
	int getX(){
		return xPos;
	}
	
	int getY(){
		return yPos;
	}


}
