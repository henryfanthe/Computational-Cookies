package computationalcookies;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ramsave {


	
	static void saveRamtin(int ramtin) {
		try {
			PrintWriter writer = new PrintWriter(new File("Resource/ramtin.txt"));
			writer.write(ramtin+ "");
			writer.println();
			writer.flush();
			writer.close();
		}catch (FileNotFoundException e) {      
		     e.printStackTrace();
		   }
	}
	static int RetRam() {
		int ramtin = 0;
		
		try {
			Scanner o = new Scanner(new File("Resource/ramtin.txt"));
			ramtin = (Integer.parseInt(o.next()));
			
		} catch (Exception  e){  e.printStackTrace(); }    
		
		return ramtin;
	}

}
