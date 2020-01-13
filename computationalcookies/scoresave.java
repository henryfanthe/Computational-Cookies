package computationalcookies;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class scoresave {

	static void saveScore(int score) {
		try {
			PrintWriter writer = new PrintWriter(new File("Resource/score.txt"));
			writer.write(score+ "");
			writer.println();
			writer.flush();
			writer.close();
		}catch (FileNotFoundException e) {      
		     e.printStackTrace();
		   }
		
		
	}
	
	static int RetScore() {
		int score =0;
		
		try {
			Scanner i = new Scanner(new File("Resource/score.txt"));
			score = (Integer.parseInt(i.next()));

		} catch (Exception  e){  e.printStackTrace(); }    
			
		return score;
		
	}
}
