import java.lang.Math;
public class StartBoard {
	private static Object[][] board = new Object[5][5];
	private static int ranNum;
	
	public static int genNum() {
		return (int)(Math.random()*5) + 1;
	}
	
	public static Object genCookie() {
		ranNum = genNum();
		System.out.println(ranNum);
		if (ranNum == 1) {
			SzeCookie NewCookie = new SzeCookie();
			return NewCookie;
		}
		else if (ranNum == 2) {
			AnthonyCookie NewCookie = new AnthonyCookie();
			return NewCookie;
		}
		else if (ranNum == 3) {
			RamtinCookie NewCookie = new RamtinCookie();
			return NewCookie;
		}
		else if (ranNum == 4) {
			TajalliCookie NewCookie = new TajalliCookie();
			return NewCookie;
		}
		else {
			KathradaCookie NewCookie = new KathradaCookie();
			return NewCookie;
		}
	}
	
	public static void main(String[] args) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				board[i][j] = genCookie();
			}
		}
		
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				System.out.println(board[i][j]);
			}
		}
	}
}
