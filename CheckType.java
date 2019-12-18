
public class CheckType {
	
	static SzeCookie HI = new SzeCookie();
	static SzeCookie HI2 = new SzeCookie();
	public static boolean checkType() {
		if ( HI.getType() == HI2.getType()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(checkType());
	}
}
