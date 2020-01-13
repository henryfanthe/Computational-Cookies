import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class scoreSave {


	static void Save(int score){
	
		 try {
		    PrintWriter writer = new PrintWriter(new File("Resource/score.txt"));
		    writer.write(score + " ");
	
		    writer.flush();  //flush the writer
		    writer.close();  //close the writer      
	
	
	
		   } catch (FileNotFoundException e) {      
		     e.printStackTrace();
		   }
		 
		}
	

	
	static int Retrive(){
		
		int score = 0;
		 try {
		    Scanner scan = new Scanner(new File("Resource/score.txt"));
	
		//Retrieve

		     score =(Integer.parseInt(scan.next()));

		     scan.close(); //close the resource file you opened
	                   
		  
		  } catch (FileNotFoundException e){  e.printStackTrace(); }    
	
		return score;
		}//end of method
	
}