package main;

import java.util.Vector;

public class PieceKnight extends ChessPiece{
	PieceKnight(int number, char color){
		super('N',number,color);
	}

	@Override
	Vector<ChessSquare> calcPossibleMoves() {
		System.out.println("Knight: Calculating possible moves from "+xPos+","+yPos);
		Vector<ChessSquare> possibleMoves=new Vector<ChessSquare>();
		for(int i=-2;i<3;i++){
			if(i!=0){
				int testX=xPos+i;
				int testY=0;
				if(i%2==0){
					for(int j=-1;j<2;j+=2){
						testY=yPos+j;
						boolean[] testEE=EmptyEnemy(testX,testY);
						System.out.println("Knight: Testing "+testX+","+testY);
						if(testEE[0]||testEE[1]){
							System.out.println("Knight: Empty or enemy, adding "+testX+","+testY+" to list.");
							possibleMoves.add(myBoard.getSquareAt(testX,testY));
						}
					}
				}else{
					for(int j=-2;j<3;j+=4){
						testY=yPos+j;
						boolean[] testEE=EmptyEnemy(testX,testY);
						System.out.println("Knight: Testing "+testX+","+testY);
						if(testEE[0]||testEE[1]){
							System.out.println("Knight: Empty or enemy, adding "+testX+","+testY+" to list.");
							possibleMoves.add(myBoard.getSquareAt(testX,testY));
						}
					}
				}
			}
		}
	return possibleMoves;
	}
}
