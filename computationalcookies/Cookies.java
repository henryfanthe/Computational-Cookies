package computationalcookies;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.Image;
import java.awt.Rectangle;
import java.util.Scanner;

public class Cookies{
	//Decalring the various Varibles
	
	//Soundplayer
	private static PlaySound player = new PlaySound();
	
	//Imageicones for the cookies
	private ImageIcon ii;
	private Image image;
	
	//Selected cookiespng
	private ImageIcon selectedii;
	private Image selectedCookie;
	
	private Rectangle rect;

	//Declaring the various varaibles
	//The type of cookie 
	private int type = 0;
	
	//Decalrinbg the position varible
	private int xPos = 0;
	private int yPos = 0;
	
	//Declaring the arraylocation for the stuff
	private int arrayloc1 = 0;
	private int arrayloc2 = 0;
	
	//Determining if its selected or not
	private boolean selected = false;
	
	/*
	 * This creates a cookies, by taking in an x and y
	 */
	public Cookies(int x,int y) {
		arrayloc1= x;
		arrayloc2 = y;
	
		this.randomType();
		
		//Getting the location of the cookie on the panel, thorugh the array location
		xPos = (arrayloc1 * 75) + 300;
		yPos = (arrayloc2 * 75);
		
		//finiding the selected cookie image
		selectedii = new ImageIcon("Images/Selected Cookie.png");
		selectedCookie = selectedii.getImage(); 

		//assingin cookie image based on its type
		if (type == 0) {
			ii = new ImageIcon("Images/Green Cookie.png");
	        image = ii.getImage(); 
		}
		else if (type == 1) {
			ii = new ImageIcon("Images/Blue Cookie.png");
	        image = ii.getImage(); 
		}
		else if (type == 2) {
			ii = new ImageIcon("Images/Orange Cookie.png");
	        image = ii.getImage(); 
		}
		else if (type == 3) {
			ii = new ImageIcon("Images/Purple Cookie.png");
	        image = ii.getImage(); 
		}
		else if (type == 4) {
			ii = new ImageIcon("Images/Red Cookie.png");
	        image = ii.getImage(); 
		}
		else if (type == 5) {
			ii = new ImageIcon("Images/Yellow Cookie.png");
	        image = ii.getImage(); 
		}
	}
	
	/*
	 * This method is used to update the image based on if its selected or not
	 * Pre: non, images should be avaible
	 * Post: the image of the cookie will be updated
	 */
	public Image getImage() {
		if (selected == false) {
			if (type == 0) {
				ii = new ImageIcon("Images/Green Cookie.png");
		        image = ii.getImage(); 
			}
			else if (type == 1) {
				ii = new ImageIcon("Images/Blue Cookie.png");
		        image = ii.getImage(); 
			}
			else if (type == 2) {
				ii = new ImageIcon("Images/Orange Cookie.png");
		        image = ii.getImage(); 
			}
			else if (type == 3) {
				ii = new ImageIcon("Images/Purple Cookie.png");
		        image = ii.getImage(); 
			}
			else if (type == 4) {
				ii = new ImageIcon("Images/Red Cookie.png");
		        image = ii.getImage(); 
			}
			else if (type == 5) {
				ii = new ImageIcon("Images/Yellow Cookie.png");
		        image = ii.getImage(); 
			}
			return image;
		}else {
			return selectedCookie;
		}
	}
	
	

	//Setting and getter for it being selected
	public boolean getSelected() {
		return selected;
	}
	
	public void setSelected(boolean picked) {
		this.selected = picked;
	}
	
	//setters and getter for is the array locations
	public int getArrayloc1() {
		return arrayloc1;
	}

	public void setArrayloc1(int arrayloc1) {
		this.arrayloc1 = arrayloc1;
	}

	public int getArrayloc2() {
		return arrayloc2;
	}
	public void setArrayloc2(int arrayloc2) {
		this.arrayloc2 = arrayloc2;
	}

	//Setters adn getter for the type
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public void randomType() {
		this.type = (int)(Math.random()*5) + 1;
	}
	
	//getters adn getter for the x and y positions
	public int getxPos() {
		return xPos;
	}

	public void setxPos(int xPos) {
		this.xPos = xPos;
	}

	public int getyPos() {
		return yPos;
	}

	public void setyPos(int yPos) {
		this.yPos = yPos;
	}
	
	//overriding equals
	public boolean equals(Cookies o) {
		 if (this.getType() ==  o.getType()) {
			 return true;
		 }
		 else {
			 return false;
		 } 	
		  
	 }
	 
	//overiding the to srting
	 public String toString() {
		 return this.type + "";
	 }
	 
	 public static Cookies[][] changePieces(Cookies[][] board, Cookies cookie1, Cookies cookie2){
			//switches the board
			int temp = cookie1.getType();
			board[cookie1.getArrayloc1()][cookie1.getArrayloc2()].setType(cookie2.getType());
			board[cookie2.getArrayloc1()][cookie2.getArrayloc2()].setType(temp);
			//returns the board
			return board;
		}
		
		/*
		 * Method to switch the places of two cookies in the board
		 * Pre: loaction of the two cookies is in the cookie array
		 * Post: returns the board after the cookies has been switched
		 */
		public static Cookies[][] boardChangePiece(Cookies[][] board, Cookies cookie1, Cookies cookie2) {
			//switches the two cookies
			board = changePieces(board, cookie1, cookie2);
			//checks if the two switched cookies make a triple
			if (CheckPieces.checkHorizontal(board) || CheckPieces.checkVertical(board)) {
				//returns the new board if it does make a triple
				
				return board;
			}
			else {
				//changes the board back if it doesn't
				board = changePieces(board, cookie1, cookie2);
				return board;
			}
		}
		/*
		 * Method for the location of the cookies to be switched
		 * Pre: none
		 * Post: return a 2d array with the location of two cookies to be switched
		 */
		public static int[][] makeCookieList(int[][] cookie, Cookies cookie1, Cookies cookie2){
			cookie[0][0] = cookie1.getArrayloc1();

			System.out.println("ycord 1");
			cookie[0][1] = cookie1.getArrayloc2();
			
			System.out.println("xcord 2");
			cookie[1][0] = cookie2.getArrayloc1();

			System.out.println("ycord 2");
			cookie[1][1] = cookie2.getArrayloc2();
			
			return cookie;
		}
}