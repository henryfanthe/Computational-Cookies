package computationalcookies;

import java.awt.Component;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class GamePlay extends JPanel implements MouseListener {
	
	
	private BufferedImage bg;
	
	private JPanel board = new JPanel();
	
	private Cookie[][] gameBoard = new Cookie[8][8];


	private int xValue = 0;
	private int yValue = 0;
	


	public GamePlay( int score, int colda, int ramtin) {
		

		try {                
			bg = ImageIO.read(new File("Images/Background.png"));
		} catch (IOException e) {
		   	System.out.print("Image Not Available game");
		}
	
	
		
		gameBoard = makeBoard(gameBoard);
		
		
		
		this.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				xValue = e.getX();
				yValue = e.getY();
				
				for (int i = 0; i < gameBoard.length; i++) {
					for (int j = 0; j < gameBoard[0].length; j++) {
						if ((xValue > gameBoard[i][j].getxPos() && xValue < gameBoard[i][j].getxPos()+75) && 
								(yValue > gameBoard[i][j].getyPos() && yValue < gameBoard[i][j].getyPos()+75)) {
							System.out.print("Mous Clicked");
							gameBoard[i][j].setSelected(true);
						}		
					}
				}
			}
		});

		
		for (int i = 0; i < gameBoard.length; i++) {
			for (int j = 0; j < gameBoard[0].length; j++) {
				System.out.print(gameBoard[i][j] + " ");
			}
			System.out.println("");
		}

		
	}
	@Override
	protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(bg, 0, 0, this);
        for (int i = 0; i < gameBoard.length; i++) {
    		for (int j = 0; j < gameBoard[0].length; j++) {
    			
    			g.drawImage(gameBoard[i][j].getImage(), gameBoard[i][j].getxPos(), gameBoard[i][j].getyPos(), this);
    			repaint();
    		
    			
    		}
    			
    	}
	}
	
	private Cookie[][] makeBoard(Cookie[][] board){
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				board[i][j] = new Cookie(i,j);
			}
		}
	return board;
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
