/*
 * Name: Henry and Jawad
 * Date: Jan 11, 2020
 * Desc: main place for the game to run in the backgground
 */
public class MainThing {
	static boolean goAgain = true;
	static int counter = 0;
	
	//starts the game
	public static void main(String[] args) {
		int[][] board = new int[5][5];
		int[][] cookie = new int[2][2];
		board = makeBoard(board);
		
		while(true) {
			System.out.println(" ");
			testBoard(board);
			printBoard(board);
			Cookie.makeCookieList(cookie);
			Cookie.changePieces(board,cookie);
			System.out.println(" ");
		}
		
	}
	/*
	 * Method to make a random number
	 * Pre: none
	 * Post: returns a number between 1 - 5
	 */
	public static int genNum() {
		return (int)(Math.random()*5) + 1;
	}
	
	/*
	 * Method to make a board and populate it with numbers
	 * Pre: none
	 * Post: returns a 2d array populated with a number between 1 - 5
	 */
	public static int[][] makeBoard(int[][] board){
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				board[i][j] = genNum();
			}
		}
		return board;
	}
	/*
	 * Method to make print out the board
	 * Pre: none
	 * Post: prints the board for testing
	 */
	public static void printBoard(int[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println("");
		}
	}
	/*
	 * Method to test for a triple
	 * Pre: none
	 * Post: runs through checking for and replacing triples until there are none left
	 */
	public static int[][] testBoard(int[][]board){
		goAgain = true;
		while (goAgain) {
			System.out.println("Hello");
			goAgain = false;
			if (CheckPieces.checkHorizontal(board)) {
				System.out.println("1");
				board = CheckPieces.Horizontal(board);
				goAgain = true;
			}
			if (CheckPieces.checkVertical(board)) {
				System.out.println("2");
				board = CheckPieces.Vertical(board);
				goAgain = true;
			}
		}
		return board;
	}
}
