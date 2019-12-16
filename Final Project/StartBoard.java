import java.lang.Math;
public class StartBoard {
	private Object[][] board = new Object[5][5];
	private int ranNum;
	
	public int genNum() {
		return (int)Math.random()*5 + 1;
	}
	
	public Object genA1(Object[][] board, int posx, int posy) {
		ranNum = genNum();
		if (ranNum == 1) {
			SzeCookie Cookie = new SzeCookie();
		}
		else if (ranNum == 2) {
			AnthonyCookie Cookie = new AnthonyCookie();
		}
		else if (ranNum == 3) {
			RamtinCookie Cookie = new RamtinCookie();
		}
		else if (ranNum == 4) {
			TajalliCookie Cookie = new TajalliCookie();
		}
		else {
			KathradaCookie Cookie = new KathradaCookie();
		}
		
		Cookie.setX(posx);
	}
}
