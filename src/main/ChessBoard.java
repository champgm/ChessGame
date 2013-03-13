package main;

public class ChessBoard {
	ChessSquare[][] squaresArray=new ChessSquare[8][8];
	public ChessBoard(){
	}
	public void populateBoard(){
		for(int i=0;i<8;i++){
			for(int j=0;j<8;j++){
				squaresArray[i][j]=new ChessSquare(i,j);
				if(j==1){
					squaresArray[i][j].setPiece(new PiecePawn(i,'W'));
				}else if(j==6){
					squaresArray[i][j].setPiece(new PiecePawn(i,'B'));
				}else if(j==0){
					char color='W';
					switch(i){
						case 0: squaresArray[i][j].setPiece(new PieceRook(0,color));
							break;
						case 1: squaresArray[i][j].setPiece(new PieceKnight(0,color));
							break;
						case 2: squaresArray[i][j].setPiece(new PieceBishop(0,color));
							break;
						case 3: squaresArray[i][j].setPiece(new PieceQueen(0,color));
							break;
						case 4: squaresArray[i][j].setPiece(new PieceKing(0,color));
							break;
						case 5: squaresArray[i][j].setPiece(new PieceBishop(1,color));
							break;
						case 6: squaresArray[i][j].setPiece(new PieceKnight(1,color));
							break;
						case 7: squaresArray[i][j].setPiece(new PieceRook(1,color));
							break;
						default: 
							System.out.println("Error (1a): problem setting piece on square in array.");
							break;
					}
				}else if(j==7){
					char color='B';
					switch(i){
						case 0: squaresArray[i][j].setPiece(new PieceRook(1,color));
							break;
						case 1: squaresArray[i][j].setPiece(new PieceKnight(1,color));
							break;
						case 2: squaresArray[i][j].setPiece(new PieceBishop(1,color));
							break;
						case 3: squaresArray[i][j].setPiece(new PieceKing(1,color));
							break;
						case 4: squaresArray[i][j].setPiece(new PieceQueen(1,color));
							break;
						case 5: squaresArray[i][j].setPiece(new PieceBishop(0,color));
							break;
						case 6: squaresArray[i][j].setPiece(new PieceKnight(0,color));
							break;
						case 7: squaresArray[i][j].setPiece(new PieceRook(0,color));
							break;
						default: 
							System.out.println("Error (1b): problem setting piece on square in array.");
							break;
					}
					
				}
				if(i%2==0 && j%2==0){
					squaresArray[i][j].setWhite(true);
				}else if(i%2==0 && j%2==1){
					squaresArray[i][j].setWhite(false);
				}else if(i%2==1 && j%2==0){
					squaresArray[i][j].setWhite(false);
				}else if(i%2==1 && j%2==1){
					squaresArray[i][j].setWhite(true);
				}
				
			}
		}
	}
	public void drawYourself(){
		boolean white=true;
		for(int j=7;j>=0;j--){
			if(j%2==1){
				white=false;
			}else{
				white=true;
			}
			printUnderLineRow();
			printTopRow(white);
			printRowWithPieces(white,j);
		}
		System.out.println(" |_____|_____|_____|_____|_____|_____|_____|_____| ");
		System.out.println("    0     1     2     3     4     5     6     7    ");
	}
	void printRowWithPieces(boolean firstSquareIsWhite,int row){
		int j=row;
		System.out.print(row);
		System.out.print("|");
		for(int i=0;i<8;i++){
			if(squaresArray[i][j].isWhite()){
				System.out.print(" ");
			}else{
				System.out.print(".");
			}
			if(squaresArray[i][j].printYourself()){
			}else{
				if(squaresArray[i][j].isWhite()){
					System.out.print("   ");
				}else{
					System.out.print("...");
				}
			}
			if(squaresArray[i][j].isWhite()){
				System.out.print(" |");
			}else{
				System.out.print(".|");
			}
		}
		System.out.println("");
	}
	void printUnderLineRow(){
		System.out.println(" |_____|_____|_____|_____|_____|_____|_____|_____| ");
	}
	void printTopRow(boolean firstSquareIsWhite){
		if(firstSquareIsWhite){
			System.out.println(" |     |.....|     |.....|     |.....|     |.....|");
		}else{
			System.out.println(" |.....|     |.....|     |.....|     |.....|     |");
		}
	}
	
}
