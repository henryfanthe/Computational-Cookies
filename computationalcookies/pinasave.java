package computationalcookies;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class pinasave {

	static void savePina(int pina) {
		try {
			PrintWriter writer = new PrintWriter(new File("Resource/pina.txt"));
			writer.write(pina+ "");
			writer.println();
			writer.flush();
			writer.close();
		}catch (FileNotFoundException e) {      
		     e.printStackTrace();
		   }
	}
	
	static int RetPina() {
		int pina = 0;
		
		try {
			Scanner p = new Scanner(new File("Resource/pina.txt"));
			pina = (Integer.parseInt(p.next()));
	
		} catch (Exception e){  e.printStackTrace(); }    
			
		return pina;
	}
}
