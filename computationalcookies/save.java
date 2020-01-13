package computationalcookies;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class save {


	static void Save(Cookies[][] a){
	
		 try {
		    PrintWriter writer = new PrintWriter(new File("Resource/board.txt"));
	
		    for(int i=0; i<a.length; i++){
		        for(int j=0; j<a[i].length; j++){
	
		             writer.write(a[i][j].getType() + "\n");
		        }
		       writer.println(); //leave one line 
		    }
	
		    writer.flush();  //flush the writer
		    writer.close();  //close the writer      
	
	
	
		   } catch (FileNotFoundException e) {      
		     e.printStackTrace();
		   }
		 
		}
	

	
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