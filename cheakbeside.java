package computationalCookies;

public boolean cheakBeside(Cookies swithes) {
	
	int cheak = 0;
	if (this.getArrayloc2()== swithes.getArrayloc2() + 1 || this.getArrayloc2()== swithes.getArrayloc2() - 1 ){
		cheak += 1;	
	}
	if (this.getArrayloc1()== swithes.getArrayloc1() + 1 || this.getArrayloc1()== swithes.getArrayloc1() - 1 ){
		cheak += 1;		
	}
	
	if( cheak == 1) {
		return true;
	}
	else {
		return false;
	}class cheakbeside 