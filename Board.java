
public class Board {
	static int[][] temp = new int[5][5];
	static boolean goAgain = true;
	static int counter = 0;
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
		
			temp = CheckPieces.Horizontal(board);
			for (int i = 0; i < temp.length; i++) {
				for (int j = 0; j < temp[0].length; j++) {
					if (temp[i][j] != board[i][j]) {
						board = replaceBoard(temp, board);
						break;
					}
				}
			}
		}
		
		for (int i = 0; i < temp.length; i++) {
			for (int j = 0; j < temp[0].length; j++) {
				System.out.print(board[i][j]);
				}
			}
		System.out.println(" ");
	}
	public static int[][] replaceBoard(int[][] temp, int[][] board) {
		for (int i = 0; i < temp.length; i++) {
			for (int j = 0; j < temp[0].length; j++) {
				board[i][j] = temp[i][j];
				}
			}
		return board;
		}
	}

