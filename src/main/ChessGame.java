package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ChessGame {
	static boolean quit=false;
	static ChessBoard aChessBoard=null;
	public static void main(String[] args){
		aChessBoard=new ChessBoard();
		aChessBoard.populateBoard();	
		while(!quit){
			interact(aChessBoard);
		}
	}
	public static void interact(ChessBoard chessBoard){
		aChessBoard.drawYourself();
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
		if(command.equals("printpieces")){
			aChessBoard.printPieces();
		}else if(command.equals("printpieces")){
			quit=true;
		}else{
			try{
			String pieceRep=command.substring(0,3);
			int x=Character.getNumericValue(command.charAt(7));
			int y=Character.getNumericValue(command.charAt(9));
			chessBoard.movePiece(pieceRep,x,y);
			}
			catch(StringIndexOutOfBoundsException SIOOBE){
				System.out.println("Wait... What? I don't even...");
			}
		}
	}
}
