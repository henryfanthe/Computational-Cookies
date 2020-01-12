import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.Image;
import java.awt.Rectangle;
import java.util.Scanner;

public class Cookies{
	
	private ImageIcon ii;
	private Image image;
	
	private ImageIcon selectedii;
	private Image selectedCookie;
	
	private Rectangle rect;

	
	private int type = 0;
	private int state = 0;
	private int xPos = 0;
	private int yPos = 0;
	private int arrayloc1 = 0;
	private int arrayloc2 = 0;
	private int moveX = 0;
	private int moveY = 0;
	private boolean selected = false;

	public Cookies(int x,int y) {
		arrayloc1= x;
		arrayloc2 = y;
	
		this.randomType();
		
		xPos = (arrayloc1 * 75) + 300;
		yPos = (arrayloc2 * 75);
				
		selectedii = new ImageIcon("Selected Cookie.jpg");
		selectedCookie = selectedii.getImage(); 

		
		if (type == 0) {
			ii = new ImageIcon("Green Cookie.jpg");
	        image = ii.getImage(); 
		}
		else if (type == 1) {
			ii = new ImageIcon("Blue Cookie.jpg");
	        image = ii.getImage(); 
		}
		else if (type == 2) {
			ii = new ImageIcon("Orange Cookie.jpg");
	        image = ii.getImage(); 
		}
		else if (type == 3) {
			ii = new ImageIcon("Purple Cookie.jpg");
	        image = ii.getImage(); 
		}
		else if (type == 4) {
			ii = new ImageIcon("Red Cookie.jpg");
	        image = ii.getImage(); 
		}
		else if (type == 5) {
			ii = new ImageIcon("Yellow Cookie.jpg");
	        image = ii.getImage(); 
		}
	}
	
	public Image getImage() {
		if (selected == false) {
			if (type == 0) {
				ii = new ImageIcon("Green Cookie.jpg");
		        image = ii.getImage(); 
			}
			else if (type == 1) {
				ii = new ImageIcon("Blue Cookie.jpg");
		        image = ii.getImage(); 
			}
			else if (type == 2) {
				ii = new ImageIcon("Orange Cookie.jpg");
		        image = ii.getImage(); 
			}
			else if (type == 3) {
				ii = new ImageIcon("Purple Cookie.jpg");
		        image = ii.getImage(); 
			}
			else if (type == 4) {
				ii = new ImageIcon("Red Cookie.jpg");
		        image = ii.getImage(); 
			}
			else if (type == 5) {
				ii = new ImageIcon("Yellow Cookie.jpg");
		        image = ii.getImage(); 
			}
			return image;
		}else {
			return selectedCookie;
		}
	}
	
	
	public Rectangle makeRect() {
		return rect;
	}
	
	public boolean getSelected() {
		return selected;
	}
	
	public void setSelected(boolean picked) {
		this.selected = picked;
	}
	
	public int getMoveX() {
		return moveX;
	}

	public void setMoveX(int moveX) {
		this.moveX = moveX;
	}

	public int getMoveY() {
		return moveY;
	}

	public void setMoveY(int moveY) {
		this.moveY = moveY;
	}
	
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


	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public void randomType() {
		this.type = (int)(Math.random()*5) + 1;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

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
	

	public void switchValues(Cookies chip) {
		int temparrayloc1 = this.arrayloc1;
		int temparrayloc2 = this.arrayloc2;
		

		this.arrayloc1 = chip.getArrayloc1();
		this.arrayloc2 = chip.getArrayloc1();
		

		chip.setArrayloc1(temparrayloc1);
		chip.setArrayloc2(temparrayloc2);
	}
	
	 public boolean equals(Cookies o) {
		 if (this.getType() ==  o.getType()) {
			 return true;
		 }
		 else {
			 return false;
		 } 	
		  
	 }
	 
	 public String toString() {
		 return this.type + "";
	 }
	 
	
	public static Cookies[][] changePieces(Cookies[][] board, int[][] cookies){
		int xloc1 = cookies[0][0];
		int yloc1 = cookies[0][1];
		int xloc2 = cookies[1][0];
		int yloc2 = cookies[1][1];
		Cookies temp = board[xloc1][yloc1];
		board[yloc1][xloc1] = board[yloc2][xloc2];
		board[yloc2][xloc2] = temp;
		return board;
	}
	
	public static Cookies[][] changePiece(Cookies[][] board, int[][] cookies) {
			//switches the two cookies
			board = changePieces(board,cookies);
			//checks if the two switched cookies make a triple
			if (CheckPieces.checkHorizontal(board) || CheckPieces.checkVertical(board)) {
				//returns the new board if it does make a triple
				return board;
			}
			else {
				//changes the board back if it doesn't
				board = changePieces(board, cookies);
				return board;
			}
	}
	public static int[][] makeCookieList(int[][] cookie,Cookies cookie1, Cookies cookie2){
		
		System.out.println("xcord 1");
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