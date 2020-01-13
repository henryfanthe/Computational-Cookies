package computationalcookies;

public class CheckSwitch {
	
	public static boolean checkBeside(Cookies cookie1, Cookies cookie2) {
		
		int cheak = 0;
		try {
			if (cookie1.getArrayloc2()== cookie2.getArrayloc2() + 1 || cookie1.getArrayloc2()== cookie2.getArrayloc2() - 1 ){
				cheak += 1;	
			}
			if (cookie1.getArrayloc1()== cookie2.getArrayloc1() + 1 || cookie1.getArrayloc1()== cookie2.getArrayloc1() - 1 ){
				cheak += 1;		
			}
			
			if( cheak == 1) {
				return true;
			}
			else {
				return false;
			}
		} catch (Exception NullPointerException){
			return false;
		}
	}
}
