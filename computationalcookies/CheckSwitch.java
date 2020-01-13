package computationalcookies;

public class CheckSwitch {
	/*
	 * Jawad
	 * 2020-01-12
	 * This code checks if the cookies it us called upon are beside eachother
	 */
	public static boolean checkBeside(Cookies cookie1, Cookies cookie2) {
		//A vartible to track if the cookies are beside eachother
		int cheak = 0;
		try {
			
			//adding 1 to the cheak if the second cookie is either bellow/above or left/right of the selcted cookie
			if (cookie1.getArrayloc2()== cookie2.getArrayloc2() + 1 || cookie1.getArrayloc2()== cookie2.getArrayloc2() - 1 ){
				cheak += 1;	
			}
			if (cookie1.getArrayloc1()== cookie2.getArrayloc1() + 1 || cookie1.getArrayloc1()== cookie2.getArrayloc1() - 1 ){
				cheak += 1;		
			}
			
			//The code above cheaks if the second cookies is 1 above and below AND 1 left and right so it could return true
			// if the cookies are at a digonal, this prevents that
			if( cheak == 1) {
				return true;
			}
			else {
				return false;
			}
			
		//incase the -1/+1 extend beyond the bounds of the array holding the cookies
		} catch (Exception NullPointerException){
			return false;
		}
	}
}
