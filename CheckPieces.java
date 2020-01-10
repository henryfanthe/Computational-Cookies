
public class CheckPieces {

	public static boolean checkHorizontal(int[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length - 2; j++) {
				if (board[i][j] == board[i][j + 1] && 
						board[i][j] == board[i][j + 2]) {
					
					return true;
				}
				else {
					continue;
				}
			}
		}
		return false;
	}
	
	public static boolean checkVertical(int[][] board) {
		for (int i = 0; i < board.length-2; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == board[i+ 1][j] && 
						board[i][j] == board[i + 2][j]) {
					return true;
				}
				else {
					continue;
				}
			}
		}
		return false;
	}
	
	public static boolean checkRightDiagonal(int[][] board) {
		for (int i = 0; i < board.length-2; i++) {
			for (int j = 0; j < board[0].length-2; j++) {
				if (board[i][j] == board[i+ 1][j + 1] && 
						board[i][j] == board[i + 2][j + 2]) {
					return true;
				}
				else {
					continue;
				}
			}
		}
		return false;
	}
	
	public static boolean checkLeftDiagonal(int[][] board) {
		for (int i = 0; i < board.length - 2; i++) {
			for (int j = 2; j < board[0].length; j++) {
				if (board[i][j] == board[i + 1][j - 1] && 
						board[i][j] == board[i + 2][j - 2]) {
					return true;
				}
				else {
					continue;
				}
			}
		}
		return false;
	}
	
	public static int[][] Horizontal(int[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length - 2; j++) {
				if ((int)board[i][j] == (int)board[i][j + 1] && 
						(int)board[i][j] == (int)board[i][j + 2]) {
					
					return movePiecesHorizontal(i, j, board);
				}
				else {
					continue;
				}
			}
		}
		return board;
	}
	
	public static int[][] Vertical(int[][] board) {
		for (int i = 0; i < board.length-2; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == board[i+ 1][j] && 
						board[i][j] == board[i + 2][j]) {
					return movePiecesVertical(i, j, board);
				}
				else {
					continue;
				}
			}
		}
		return board;
	}
	
	public static int[][] RightDiagonal(int[][] board) {
		for (int i = 0; i < board.length-2; i++) {
			for (int j = 0; j < board[0].length-2; j++) {
				if (board[i][j] == board[i+ 1][j + 1] && 
						board[i][j] == board[i + 2][j + 2]) {
					return movePiecesRightDiagonal(i, j, board);
				}
				else {
					continue;
				}
			}
		}
		return board;
	}
	
	public static int[][] LeftDiagonal(int[][] board) {
		for (int i = 0; i < board.length - 2; i++) {
			for (int j = 2; j < board[0].length; j++) {
				if (board[i][j] == board[i + 1][j - 1] && 
						board[i][j] == board[i + 2][j - 2]) {
					return movePiecesLeftDiagonal(i, j, board);
				}
				else {
					continue;
				}
			}
		}
		return board;
	}
	
	public static int[][] movePiecesHorizontal(int row, int col, int[][] board){
		System.out.println("HI");
		for (int j = 0; j < 3; j++) {
			for (int i = row; i >= 1; i --) {
				board[i][col + j] = (int)board[i - 1][col + j];
			}
			board[0][col + j] = MainThing.genNum();
		}
		return board;
	}
	
	public static int[][] movePiecesVertical(int row, int col, int[][] board){
		System.out.println("HI");
		for (int j = 0; j < 3; j++) {
			for(int i = row + 2; i >= 1; i--) {
				board[i][col] = board[i - 1][col];
			}
			board[0][col] = MainThing.genNum();
		}
		return board;
	}
	
	public static int[][] movePiecesRightDiagonal(int row, int col, int[][] board){
		System.out.println("HI");
		for (int j = 0; j < 3; j++) {
			for (int i = row + j; i >= 1; i--) {
				board[i][col + j] = board[i - 1][col + j];
			}
			board[0][col + j] = MainThing.genNum();
		}
		
		return board;
	}
	
	public static int[][] movePiecesLeftDiagonal(int row, int col, int[][] board){
		System.out.println("HI");
		for (int j = 0; j < 3; j++) {
			for (int i = row + j; i >= 1; i--) {
				board[i][col - j] = board[i - 1][col - j];
			}
			board[0][col] = MainThing.genNum();
		}
		return board;
	}

}

