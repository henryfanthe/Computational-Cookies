package computationalcookies;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/*
 * Desc: This save class is response for saving the piece positions of the current board so it can be brough back 
 * onto the screen when a new game is started
 */
public class save {
	
	/*
	 * This method will save a cookie array into a txt file 
	 * Pre:it needs to be passed a cookie array, which sould always be gameboard
	 * Post: the gameboard will be saved a txt file into the directory can be called upon to make a new board latter
	 * 
	 */
	static void Save(Cookies[][] a){
	
		 try {
			//decalrign the writer
		    PrintWriter writer = new PrintWriter(new File("Resource/board.txt"));
		    
		    //going through tkhe baord and wrting all the types
		    for(int i=0; i<a.length; i++){
		        for(int j=0; j<a[i].length; j++){
	
		             writer.write(a[i][j].getType() + "\n");
		        }
		       writer.println(); //leave one line 
		    }
		    //getting rid of the writer
		    writer.flush();  //flush the writer
		    writer.close();  //close the writer      
	
	
		    //catching any excpetions
		   } catch (FileNotFoundException e) {      
		     e.printStackTrace();
		   }
		 
		}
	

	/*
	 * Decs:find the cookeis txt file and returns it as a 2d array that can be used to maek the new board
	 * Pre:Old board needs to exist
	 * POst:a 2d array will be returned
	 * 
	 */
	static Cookies[][] Retrive(){
		
		Cookies[][] cookies = new Cookies[8][8];
		 try {
		    Scanner scan = new Scanner(new File("Resource/board.txt"));
	
		//Retrieve
		        for(int i=0; i<cookies.length;  i++) {
		          for(int j=0; j<cookies[i].length; j++){
		        	cookies[i][j] = new Cookies(i,j);
		            cookies[i][j].setType(Integer.parseInt(scan.next()));
		            System.out.print(cookies[i][j].getType()); 
		          }
		         System.out.println("");
		        }
	
		     scan.close(); //close the resource file you opened
	                   
		  
		  } catch (FileNotFoundException e){  e.printStackTrace(); }    
	
		return cookies;
		}//end of method
	
}