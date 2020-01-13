/*
 * Name: Henry and Jawad
 * Date: Jan 12, 2020
 * Desc: Main code for the game
 */

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

public class GamePlay extends JPanel implements MouseListener {
	
	//background
	private BufferedImage bg;
	//panel containing special powers
	private JPanel board = new JPanel();
	//gameboard
	private Cookies[][] gameBoard = new Cookies[8][8];
	//starting values
	private int xValue = 0;
	private int yValue = 0;
	//click counter
	private int counter = 0;
	//score counter
	private static int score = 0;
	//cookies to change
	private Cookies cookie1, cookie2;
	//power buttons
	private JButton PinaColadabtn = new JButton("Pina Colada"); 
	private JButton RamtinPopbtn = new JButton("Ramtin Pop");

	/*
	 * This method contains the code for what to do when a button or cookie is clicked
	 * Pre: none
	 * Post: Gives a game for the user to play
	 */
	public GamePlay(int colda, int ramtin) {
		//puts on the buttons
		board.setLayout(new GridBagLayout());
		board.add(PinaColadabtn);
		board.add(RamtinPopbtn);
		this.setLayout(new BorderLayout());
		this.add(board, BorderLayout.NORTH);
		//sets up the background
		try {                
			bg = ImageIO.read(new File("Background.jpg"));
		} catch (IOException e) {
		   	System.out.print("Image Not Available game");
		}
		//sets up the gameboard that the user sees
		gameBoard = makeBoard(gameBoard);
		//checks for any triples
		gameBoard = CheckPieces.testBoard(gameBoard);
		
		//what to do when the mouse is clicked
		this.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				//gets the location of the click
				xValue = e.getX();
				yValue = e.getY();
				//finds the cookie that was clicked
				for (int i = 0; i < gameBoard.length; i++) {
					for (int j = 0; j < gameBoard[0].length; j++) {
						if ((xValue > gameBoard[i][j].getxPos() && xValue < gameBoard[i][j].getxPos()+75) && 
								(yValue > gameBoard[i][j].getyPos() && yValue < gameBoard[i][j].getyPos()+75)) {
							//makes the cookie that was clicked to be set to selected
							gameBoard[i][j].setSelected(true);
							//click counter goes up
							counter ++;
						}		
					}
				}
				//makes a copy of the first cookie that was clicked
				if (counter == 1) {
					for (int i = 0; i < gameBoard.length; i++) {
						for (int j = 0; j < gameBoard[0].length; j++) {
							if (gameBoard[i][j].getSelected()){
								cookie1 = gameBoard[i][j];
							}
						}
					}
				}
				//makes a copy of the second cookie clicked
				else if (counter == 2) {
					for (int i = 0; i < gameBoard.length; i++) {
						for (int j = 0; j < gameBoard[0].length; j++) {
								if (gameBoard[i][j].getSelected()){
									//finds the first cookie that was clicked
									if (cookie1.getType() == gameBoard[i][j].getType()) {
										continue;
									}
									//second cookie was found
									else {
										cookie2 = gameBoard[i][j];
									}
								}
							}
						}
					//checks if the cookies we next to each other
					if (CheckSwitch.checkBeside(cookie1, cookie2)) {
						//switches the cookies that was selected
						gameBoard = Cookies.boardChangePiece(gameBoard, cookie1, cookie2);
						//looks for any triples made from removing triples
						gameBoard = CheckPieces.testBoard(gameBoard);
					}
					else {}
					//resets all cookies to not be seleceted
						for (int i = 0; i < gameBoard.length; i++) {
							for (int j = 0; j < gameBoard[0].length; j++) {
								if (gameBoard[i][j].getSelected()){
									gameBoard[i][j].setSelected(false);
								}
							}
						}
						//resets click counter
						counter = 0;
					}
				}
			}
		);
		//when the Pina Colada button is selected
		PinaColadabtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//finds selected cookie
				for (int i = 0; i < gameBoard.length; i++) {
					for (int j = 0; j < gameBoard[0].length; j++) {
						if (gameBoard[i][j].getSelected()) {
							//removes all instance of selected cookie
							gameBoard = PinaColda.activate(gameBoard, gameBoard[i][j].getType());
							//set selected spot to be unselected
							gameBoard[i][j].setSelected(false);
							//resets the image of all cookies
							gameBoard[i][j].getImage();
							//tests for triples
							gameBoard = CheckPieces.testBoard(gameBoard);
						}
					}
				}
			}
		});
		//when the Ramtin Pop button is clicked
		RamtinPopbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//searched for the selected cookie
				for (int i = 0; i < gameBoard.length; i++) {
					for (int j = 0; j < gameBoard[0].length; j++) {
						//found selected cookie
						if (gameBoard[i][j].getSelected()) {
							//removes that cookie
							gameBoard =  RamtinPop.activate(i, j, gameBoard);
							//resets selected cookie
							gameBoard[i][j].setSelected(false);
							gameBoard[i][j].getImage();
							//checks for triples
							gameBoard = CheckPieces.testBoard(gameBoard);
						}
					}
				}
			}
		});

	}
	@Override
	/*
	 * This method sets the background of the game and the image of the cookies
	 * Pre:none
	 * Post: displays amazing things
	 */
	protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(bg, 0, 0, this);
        //draws each cookie
        for (int i = 0; i < gameBoard.length; i++) {
    		for (int j = 0; j < gameBoard[0].length; j++) {
    			
    			g.drawImage(gameBoard[i][j].getImage(), gameBoard[i][j].getxPos(), gameBoard[i][j].getyPos(), this);
    			repaint();
    		
    			
    		}
    			
    	}
	}
	/*
	 * This method makes a 2d array of cookies
	 * Pre: none
	 * Post: Returns a 2d array of cookies
	 */
	private Cookies[][] makeBoard(Cookies[][] gameBoard){
		for (int i = 0; i < gameBoard.length; i++) {
			for (int j = 0; j < gameBoard[0].length; j++) {
				gameBoard[i][j] = new Cookies(i,j);
			}
		}
	return gameBoard;
	}
	/*
	 * Adds 100 to the score
	 * Pre: a triple has formed
	 * Post: adds 100 to score
	 */
	public static void addScore100() {
		score += 100;
	}
	
	/*
	 * adds 10 to the score
	 * Pre: the user uses a powerup
	 * Post: 10 is added to the score
	 */
	public static void addScore10() {
		score += 10;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}