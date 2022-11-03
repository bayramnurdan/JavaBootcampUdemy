//tictactoe game
//code belongs to Nurdan Emin

import java.util.Scanner;    

public class main {
	static Scanner scan = new Scanner (System.in);

	public static void main(String[] args) {
		
		
		
		
		char[][] board = {
					{'-', '-','-'},
					{'-', '-','-'},
					{'-', '-','-'}
		};
		
		printBoard(board);
		int counter;
		for (counter=0; counter<9; counter++) {  // array is 3X3 
			
			if (counter%2==0) {
				System.out.println("Turn X");
				int [] spot = askUser(board);
				board[spot[0]][spot[1]]= 'X';
				
			}else {
				System.out.println("Turn O");
				int [] spot = askUser(board);
				board[spot[0]][spot[1]]= 'O';
				
				
			}
			printBoard(board);
			
			int count = checkWin(board);  // checking winner after every turn
			if (count==3 ) {
				System.out.println("X wins!");
				break;
			}else if (count == -3) {
				System.out.println("O wins!");
				
				
				
			}
			
				
			
		}
		
			

}
	public static void printBoard(char [][] board) {
		System.out.print("\n");
		for (int i=0; i<board.length; i++) {
			System.out.print("\t");
			for (int x=0; x<board[i].length; x++) {
				
				System.out.print(board[i][x]);
				System.out.print(" ");
				
			}
			System.out.print("\n\n");
			
			
		}
		
	}
	public static int[] askUser(char [][] board) {
		
		System.out.println("Pick row and column:");
		int row = scan.nextInt();
		int column = scan.nextInt();
		
		while( board[row][column]=='X' || board[row][column]=='O') {  // if position placed before
			System.out.println("Pick row and column:");
			row = scan.nextInt();
			column = scan.nextInt();	
		}
		return new int[] {row,column};
		

		
	}
	
	public static int checkWin(char [][] board) {
		int  count = 0; 
		
		for (int i=0; i<board.length; i++) {
			for (int j=0; j<board[i].length; j++) {  //check for  each column 
				if (board[i][j]=='X') {
					count++;
					
				}
				else if  (board[i][j]=='O') {
					count --;
				
				}
			}
			if (count==3 || count==-3) {
				return count;
			}else {
				count = 0;  // reset count to 0
				
				
			}
			
			for (int x=0; x<3; x++) {   //column check
				for (int y=0; y<board.length; y++) {;
				if (board[y][x] == 'X') {
					count ++;
					
				}else if (board[y][x]=='O') {
					count --;
				}
			}
				if (count==3 || count==-3) {
					return count;
				}else {
					count = 0;
					}	
		}
			
			
	}
		
		for (int i = 0; i<board.length; i++) {   //check right diagonal 
			if (board[i][i]=='X') {
				count ++;
				
				
			}else if (board[i][i]=='O') {
				count --;
			}
			if (count==3 || count==-3) {
				return count;
			}else {
				count = 0;
				}	
		
			
		}
	
		for (int i=0; i<board.length; i++) {  //check left diagonal
			int rowIndex = 2-i;
			if (board[rowIndex][i]=='X') {
				count ++;
				
				
			}else if (board[rowIndex][i]=='O') {
				count --;
			}
			
			
			
			
			 
			
			
			
		}
		if (count==3 || count==-3) {
			return count;
		}else {
			count = 0;
			}	
	
		return count;
	}
	
		
	}
