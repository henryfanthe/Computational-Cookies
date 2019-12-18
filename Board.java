
public class Board {

	/**
	 * Random Number Generator
	 * PreCon: none
	 * Post: returns a random number 1 - 5
	 */
	public static int genNum() {
		return (int)(Math.random()*5) + 1;
	}
	
	public static int[][] makeBoard(int[][] board){
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				board[i][j] = genNum();
			}
		}
		return board;
	}
	
	public static void main(String[] args) {
		int[][] board = new int[5][5];
		board = makeBoard(board);
		
		System.out.println("I am the original");
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println("");
		}
		System.out.println("");
		
		System.out.println("Horizontal");
		board = CheckPieces.Horizontal(board);
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println("");
		}
		System.out.println("");
		
		System.out.println("Vertical");
		board = CheckPieces.Vertical(board);
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println("");
		}
		System.out.println("");
		
		System.out.println("Left Diagonal");
		board = CheckPieces.LeftDiagonal(board);
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println("");
		}
		System.out.println("");
		
		System.out.println("Right Diagonal");
		board = CheckPieces.RightDiagonal(board);
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println("");
		}
		System.out.println("");
			
	}
	
}
