package computationalcookies;
/*
 * Name: Henry and Jawad
 * Date: Jan 12, 2020
 * Desc: Main code for the game
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GamePlay extends JPanel implements MouseListener {
	

	static PlaySound player = new PlaySound();
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
	//Powerup Values
	private int ramtinnum;
	private int coladanum;

	//The Images for the various buttons
	ImageIcon RamtinImage = new ImageIcon("Images/Ramtin.png");
	ImageIcon PinaColadaImage= new ImageIcon("Images/Pina Colda.png");
	ImageIcon PlusImage = new ImageIcon("Images/Plus.png");

	
	//cookies to change
	private Cookies cookie1, cookie2;
	//power buttons
	private JButton PinaColadabtn = new JButton(PinaColadaImage); 
	private JButton RamtinPopbtn = new JButton(RamtinImage);
	
	private JButton morePina = new JButton(PlusImage);
	private JButton moreRamtin = new JButton(PlusImage);
	
	JLabel numPina = new JLabel(1 + "");
	JLabel numRamtin = new JLabel(1 + "");
	JLabel ScoreLabel = new JLabel("0");



	/*
	 * This method contains the code for what to do when a button or cookie is clicked
	 * Pre: none
	 * Post: Gives a game for the user to play
	 */
	public GamePlay(int colda, int ramtin) {
		
		
		this.coladanum = colda;
		this.ramtinnum = ramtin;
		
		//puts on the buttons
		this.setLayout(null);
		this.add(board);
		this.add(PinaColadabtn);
		this.add(RamtinPopbtn);
		this.add(morePina);
		this.add(moreRamtin);
		this.add(numPina);
		this.add(numRamtin);
		this.add(ScoreLabel);
		
		board.setLayout(null);
		PinaColadabtn.setSize(100,100);
		RamtinPopbtn.setSize(100,100);
		morePina.setSize(28, 28);
		moreRamtin.setSize(28,28);
		numPina.setSize(28,  28);
		numRamtin.setSize(28, 28);
		ScoreLabel.setSize(100,40);
		
		numPina.setForeground(Color.WHITE);
		numPina.setBackground(Color.BLACK);
		numPina.setOpaque(true);
		
		numRamtin.setForeground(Color.WHITE);
		numRamtin.setBackground(Color.BLACK);
		numRamtin.setOpaque(true);
		
		
		PinaColadabtn.setLocation(60,500);
		RamtinPopbtn.setLocation(60,375);
		morePina.setLocation(180, 565);
		moreRamtin.setLocation(180, 445);
		numPina.setLocation(180, 500);
		numRamtin.setLocation(180, 385);
		ScoreLabel.setLocation(100, 260);
		
		ScoreLabel.setAlignmentX(CENTER_ALIGNMENT);
		
		Font labelFont = ScoreLabel.getFont();
		String labelText = ScoreLabel.getText();

		int stringWidth = ScoreLabel.getFontMetrics(labelFont).stringWidth(labelText);
		int componentWidth = ScoreLabel.getWidth();

		// Find out how much the font can grow in width.
		double widthRatio = (double)componentWidth / (double)stringWidth;

		int newFontSize = (int)(labelFont.getSize() * widthRatio);
		int componentHeight = ScoreLabel.getHeight();

		// Pick a new font size so it will not be larger than the height of label.
		int fontSizeToUse = Math.min(newFontSize, componentHeight);

		// Set the label's font size to the newly determined size.
		ScoreLabel.setFont(new Font(labelFont.getName(), Font.PLAIN, fontSizeToUse));
		
		PinaColadabtn.setOpaque(false);
		PinaColadabtn.setContentAreaFilled(false);
		PinaColadabtn.setBorderPainted(false);
		
		RamtinPopbtn.setOpaque(false);
		RamtinPopbtn.setContentAreaFilled(false);
		RamtinPopbtn.setBorderPainted(false);

		
		//sets up the background
		try {                
			bg = ImageIO.read(new File("Images/Background.png"));
		} catch (IOException e) {
		   	System.out.print("Image Not Available game");
		}
		
		
		//sets up the gameboard that the user sees
		gameBoard = makeBoard(gameBoard);
		//checks for any triples		
		if (CheckPieces.checkHorizontal(gameBoard)|| CheckPieces.checkVertical(gameBoard)) {
			gameBoard = CheckPieces.testBoard(gameBoard);
		}
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
						ScoreLabel.setText(score + "");
						
						if (CheckPieces.checkHorizontal(gameBoard) || CheckPieces.checkVertical(gameBoard)) {
							//looks for any triples made from removing triples
							gameBoard = CheckPieces.testBoard(gameBoard);
						}
					}
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
		
		morePina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (score >= 300) {
					score -= 300;
					coladanum ++;
					numPina.setText(coladanum + "");
					ScoreLabel.setText(score + "");
				}
			}
		});
		
		moreRamtin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (score >= 100) {
					score -= 100;
					ramtinnum ++;
					numRamtin.setText(ramtinnum + "");
					ScoreLabel.setText(score + "");
				}
			}
		});
		//when the Pina Colada button is selected
		PinaColadabtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (coladanum > 0) {
				coladanum --;
				numPina.setText(coladanum + "");
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
			}
		});
		//when the Ramtin Pop button is clicked
		RamtinPopbtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (ramtinnum > 0) {
				ramtinnum --;
				numRamtin.setText(ramtinnum + "");
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
		try {
		 	gameBoard = save.Retrive();
		 	System.out.print("Old board");
		 }
		catch (Exception e) {
		
			for (int i = 0; i < gameBoard.length; i++) {
				for (int j = 0; j < gameBoard[0].length; j++) {
					gameBoard[i][j] = new Cookies(i,j);
			}
		}
		System.out.print("New Board");
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
	
	public Cookies[][] getGameBoard() {
		return gameBoard;
	}
	
}