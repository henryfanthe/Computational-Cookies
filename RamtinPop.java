/*
 * Name: Henry
 * Date: Jan 12, 2020
 * Desc: This gets rid of a single cookie and makes the cookies above it to fall into place
 */
public class RamtinPop {
	/*
	 * Method finds the cookie selected instance of a cookie and gets rid of it.
	 * Pre: the cookie is specified
	 * Post: returns a board with all instances of a cookie removed from where it was before
	 */
	public static Cookies[][] activate(int row, int col, Cookies[][] board){
		//moves that cookie
		return CheckPieces.movePiecesSingle(row, col, board);
	}
	
}
