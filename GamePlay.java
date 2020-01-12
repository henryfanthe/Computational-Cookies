import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
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
	
	
	private BufferedImage bg;
	
	private JPanel board = new JPanel();
	
	private Cookies[][] gameBoard = new Cookies[8][8];

	private int xValue = 0;
	private int yValue = 0;
	private int counter = 0;
	private JButton PinaColadabtn = new JButton("Pina Colada"); 
	private JButton RamtinPopbtn = new JButton("Ramtin Pop");

	public GamePlay( int score, int colda, int ramtin) {
		board.setLayout(new GridBagLayout());
		board.add(PinaColadabtn);
		board.add(RamtinPopbtn);
		this.setLayout(new BorderLayout());
		this.add(board, BorderLayout.NORTH);
		
		try {                
			bg = ImageIO.read(new File("Background.jpg"));
		} catch (IOException e) {
		   	System.out.print("Image Not Available game");
		}
		
		gameBoard = makeBoard(gameBoard);
		gameBoard = CheckPieces.testBoard(gameBoard);
		
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
		
		PinaColadabtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < gameBoard.length; i++) {
					for (int j = 0; j < gameBoard[0].length; j++) {
						if (gameBoard[i][j].getSelected()) {
							gameBoard = PinaColda.activate(gameBoard, gameBoard[i][j].getType());
							gameBoard[i][j].setSelected(false);
							gameBoard[i][j].getImage();
							gameBoard = CheckPieces.testBoard(gameBoard);
						}
					}
				}
			}
		});
		
		RamtinPopbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < gameBoard.length; i++) {
					for (int j = 0; j < gameBoard[0].length; j++) {
						if (gameBoard[i][j].getSelected()) {
							gameBoard =  RamtinPop.activate(i, j, gameBoard);
							gameBoard[i][j].setSelected(false);
							gameBoard[i][j].getImage();
							gameBoard = CheckPieces.testBoard(gameBoard);
						}
					}
				}
			}
		});

	}
	private void add(Cookies[][] gameBoard2) {
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