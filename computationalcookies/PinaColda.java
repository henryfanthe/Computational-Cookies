package computationalcookies;
/*
 * Name: Henry
 * Date: Jan 12, 2020
 * Desc: This gets rid of every single instance of a type of cookie and makes the cookies above it to fall into place
 */
public class PinaColda {

	/*
	 * Method finds all instance of a cookie and gets rid of it
	 * Pre: the type of cookie is specified
	 * Post: returns a board with all instances of a cookie removed from where it was before
	 */
	public static Cookies[][] activate(Cookies[][] board, int type){
		//nested loop to find every instance of a cookie
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j].getType() == type) {
					//replaces that single coookie found
					CheckPieces.movePiecesSingle(i, j, board);
					GamePlay.addScore10();
				}
			}
		}
		//returns new board
		return board;
	}
}
