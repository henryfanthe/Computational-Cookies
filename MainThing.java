
public class MainThing {
	static boolean goAgain = true;
	static int counter = 0;
	
	public static void main(String[] args) {
		double[][] board = new double[5][5];
		board = makeBoard(board);
		while (goAgain) {
			goAgain = false;
			if (CheckPieces.checkHorizontal(board)) {
				board = CheckPieces.Horizontal(board);
				goAgain = true;
			}
			if (CheckPieces.checkVertical(board)) {
				board = CheckPieces.Vertical(board);
				goAgain = true;
			}
			if (CheckPieces.checkRightDiagonal(board)) {
				board = CheckPieces.RightDiagonal(board);
				goAgain = true;
			}
			if (CheckPieces.checkLeftDiagonal(board)) {
				board = CheckPieces.LeftDiagonal(board);
				goAgain = true;
			}
		}
		
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println("");
		}
	}
	
	public static int genNum() {
		return (int)(Math.random()*5) + 1;
	}

	public static double[][] makeBoard(double[][] board){
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				board[i][j] = genNum();
			}
		}
		return board;
	}
}
