import java.util.Scanner;
public class Cookie {
	public static int[][] changePieces(int[][] board, int[][] cookies){
		int xloc1 = cookies[0][0];
		int yloc1 = cookies[0][1];
		int xloc2 = cookies[1][0];
		int yloc2 = cookies[1][1];
		int temp = board[xloc1][yloc1];
		board[yloc1][xloc1] = board[yloc2][xloc2];
		board[yloc2][xloc2] = temp;
		return board;
	}
	
	public static int[][] changePiece(int[][] board, int[][] cookies) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println("");
		}
		System.out.println(" ");
		board = changePieces(board,cookies);
		
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println("");
		}
		return board;
	}
	public static int[][] makeCookieList(int[][] cookie){
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("xcord 1");
		cookie[0][0] = scanner.nextInt() - 1;

		System.out.println("ycord 1");
		cookie[0][1] = scanner.nextInt() - 1;
		
		System.out.println("xcord 2");
		cookie[1][0] = scanner.nextInt() - 1;

		System.out.println("ycord 2");
		cookie[1][1] = scanner.nextInt() - 1;
		
		return cookie;
	}
}