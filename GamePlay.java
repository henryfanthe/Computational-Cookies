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
	
	private Cookies[][] gameBoard = new Cookies[8][8];

	private int xValue = 0;
	private int yValue = 0;
	private int counter = 0;
	


	public GamePlay( int score, int colda, int ramtin) {
		

		try {                
			bg = ImageIO.read(new File("Background.jpg"));
		} catch (IOException e) {
		   	System.out.print("Image Not Available game");
		}
	
	
		
		gameBoard = makeBoard(gameBoard);
		gameBoard = CheckPieces.testBoard(gameBoard);
		
		for (int i = 0; i < gameBoard.length; i++) {
			for (int j = 0; j < gameBoard[0].length; j++) {
				System.out.print(gameBoard[i][j] + " ");
			}
			System.out.println("");
		}
		
		this.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				xValue = e.getX();
				yValue = e.getY();
				
				for (int i = 0; i < gameBoard.length; i++) {
					for (int j = 0; j < gameBoard[0].length; j++) {
						if ((xValue > gameBoard[i][j].getxPos() && xValue < gameBoard[i][j].getxPos()+75) && 
								(yValue > gameBoard[i][j].getyPos() && yValue < gameBoard[i][j].getyPos()+75)) {
							System.out.print("Mouse Clicked");
							gameBoard[i][j].setSelected(true);
							counter ++;
							System.out.println(counter);
						}		
					}
				}
				if (counter == 2) {
					
					counter = 0;
				}
			}
		});

	}
	private void add(Cookies[][] gameBoard2) {
		// TODO Auto-generated method stub
		
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
	
	private Cookies[][] makeBoard(Cookies[][] gameBoard){
		for (int i = 0; i < gameBoard.length; i++) {
			for (int j = 0; j < gameBoard[0].length; j++) {
				gameBoard[i][j] = new Cookies(i,j);
			}
		}
	return gameBoard;
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