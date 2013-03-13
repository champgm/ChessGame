package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ChessGame {
	public static void main(String[] args){
		ChessBoard aChessBoard=new ChessBoard();
		aChessBoard.populateBoard();
		aChessBoard.drawYourself();
		while(true){
			interact(aChessBoard);
		}
	}
	public static void interact(ChessBoard chessBoard){
		System.out.print("Move (T#C to X,Y): ");
		String command="";
		try{
		    BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
		    command = bufferRead.readLine();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		String pieceRep=command.substring(0,3);
		int x=Character.getNumericValue(command.charAt(7));
		int y=Character.getNumericValue(command.charAt(9));
		chessBoard.movePiece(pieceRep,x,y);
		
		
		
	}
}
