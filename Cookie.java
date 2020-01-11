/*
 * Name: Henry and Jawad
 * Date: Jan 11, 2020
 * Desc: Gets the place of cookies to be changed and changes their places if it doesn't create a triple
 * 		 sends it back as it was before.
 */
public class Cookie {
	/*
	 * Method to switch the places of two cookies in the board
	 * Pre: loaction of the two cookies is in the cookie array
	 * Post: returns the board after the cookies has been switched
	 */
	public static int[][] changePieces(int[][] board, int[][] cookies){
		//switches the board
		int temp = board[cookies[0][0]][cookies[0][1]];
		board[cookies[0][1]][cookies[0][0]] = board[cookies[1][1]][cookies[1][0]];
		board[cookies[1][1]][cookies[1][0]] = temp;
		//returns the board
		return board;
	}
	
	/*
	 * Method to switch the places of two cookies in the board
	 * Pre: loaction of the two cookies is in the cookie array
	 * Post: returns the board after the cookies has been switched
	 */
	public static int[][] changePiece(int[][] board, int[][] cookies) {
		//switches the two cookies
		board = changePieces(board,cookies);
		//checks if the two switched cookies make a triple
		if (CheckPieces.checkHorizontal(board) || CheckPieces.checkVertical(board)) {
			//returns the new board if it does make a triple
			return board;
		}
		else {
			//changes the board back if it doesn't
			board = changePieces(board, cookies);
			return board;
		}
	}
	/*
	 * Method for the location of the cookies to be switched
	 * Pre: none
	 * Post: return a 2d array with the location of two cookies to be switched
	 */
	public static int[][] makeCookieList(int[][] cookie){
		
		System.out.println("xcord 1");
		cookie[0][0] = 

		System.out.println("ycord 1");
		cookie[0][1] = 
		
		System.out.println("xcord 2");
		cookie[1][0] = 

		System.out.println("ycord 2");
		cookie[1][1] = 
		
		return cookie;
	}
}