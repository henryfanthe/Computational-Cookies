/*
 * Name: Henry
 * Date: Jan 11, 2020
 * Desc: Checks for three of the same  values in a row
 */
public class CheckPieces {
	/*
	 * Method for checking Horizontal
	 * Pre: none
	 * Post: Returns true of false based on weather or not there are three of the same
	 * 		 values in a row
	 */
	public static boolean checkHorizontal(int[][] board) {
		//nested loop to check each needed place
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length - 2; j++) {
				//checks for three pieces in a row
				if (board[i][j] == board[i][j + 1] && 
						board[i][j] == board[i][j + 2]) {
					//returns true if there is a triple
					return true;
				}
				//moves on to the next spot
				else {
					continue;
				}
			}
		}
		//returns false when there are no triples
		return false;
	}
	
	/*
	 * Method for checking Vertical
	 * Pre: none
	 * Post: Returns true of false based on weather or not there are three of the same
	 * 		 values in a row
	 */
	public static boolean checkVertical(int[][] board) {
		//nested loop to check each needed place
		for (int i = 0; i < board.length-2; i++) {
			for (int j = 0; j < board[0].length; j++) {
				//checks for three pieces in a row
				if (board[i][j] == board[i+ 1][j] && 
						board[i][j] == board[i + 2][j]) {
					//returns true if there is a triple
					return true;
				}
				else {
					//moves on to the next spot
					continue;
				}
			}
		}
		//returns false when there are no triples
		return false;
	}
	
	/*
	
	Following code was not used
	
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
	*/
	
	/*
	 * Method to find where the start of the triple is located when it is Horizontal
	 * Pre: Called when there is a three in a row
	 * Post: returns a board with the triple removed and the numbers above it
	 * 		 moved down into their place
	 */
	public static int[][] Horizontal(int[][] board) {
		//nested loop to check each needed place
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length - 2; j++) {
				//checks for a triple
				if (board[i][j] == board[i][j + 1] && 
						board[i][j] == board[i][j + 2]) {
					//calls the method to switch the number's places
					return movePiecesHorizontal(i, j, board);
				}
				else {
					//moves on to the next spot
					continue;
				}
			}
		}
		//removes possibility of not being able to return anything error
		return board;
	}
	
	/*
	 * Method to find where the start of the triple is located when it is Vertical
	 * Pre: Called when there is a three in a row
	 * Post: returns a board with the triple removed and the numbers above it
	 * 		 moved down into their place
	 */
	public static int[][] Vertical(int[][] board) {
		//nested loop to check each needed place
		for (int i = 0; i < board.length-2; i++) {
			for (int j = 0; j < board[0].length; j++) {
				//checks for a triple
				if (board[i][j] == board[i+ 1][j] && 
						board[i][j] == board[i + 2][j]) {
					//calls the method to switch the number's places
					return movePiecesVertical(i, j, board);
				}
				else {
					//moves on to the next spot
					continue;
				}
			}
		}
		//removes possibility of not being able to return anything error
		return board;
	}
	
	
	/*
	 
	 Following code was not used
	 
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
	*/
	
	/*
	 * Method remove the triple and cause other numbers for "Fall" into their place
	 * Pre: gets sent the location of the first number in the triple
	 * Post: returns a board with the triple removed and the numbers above it
	 * 		 moved down into their place
	 */
	public static int[][] movePiecesHorizontal(int row, int col, int[][] board){
		//repeats for moving the one number
		for (int j = 0; j < 3; j++) {
			//repeats until it reaches the "Top"
			for (int i = row; i >= 1; i --) {
				//moves the number down one place
				board[i][col + j] = (int)board[i - 1][col + j];
			}
			//generates a new random number at the top
			board[0][col + j] = MainThing.genNum();
		}
		//sends back the new board
		return board;
	}
	
	/*
	 * Method remove the triple and cause other numbers for "Fall" into their place
	 * Pre: gets sent the location of the first number in the triple
	 * Post: returns a board with the triple removed and the numbers above it
	 * 		 moved down into their place
	 */
	public static int[][] movePiecesVertical(int row, int col, int[][] board){
		//repeats for moving the one number
		for (int j = 0; j < 3; j++) {
			//repeats until it reaches the "Top"
			for(int i = row + 2; i >= 1; i--) {
				//moves the number down one place
				board[i][col] = board[i - 1][col];
			}
			//generates a new random number at the top
			board[0][col] = MainThing.genNum();
		}
		//sends back the new board
		return board;
	}
	
	/*
	 
	 code was not used
	 
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

*/
}

