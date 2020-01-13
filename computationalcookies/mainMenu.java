package computationalcookies;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


public class mainMenu extends JPanel{

	/**
	 * Jawad
	 * 2020-01-13
	 * This simply makes the menu card for the card layout, imports and image and draws it
	 */
	private static final long serialVersionUID = 1L;
	
	//The bufferd image taht holds the background
	private BufferedImage background;
	
	/*
	 * This contrutor simply gets the background as an image and saves it to the background varible
	 * pre: make sure the background is availble
	 * post the value of backgraound is updated
	 */
	public mainMenu() {
		
		
		try {                
	         background = ImageIO.read(new File("Images/Game Start.png"));
	       } catch (IOException e) {
	    	   System.out.print("Image Not Available");
	       }

	}
	/*
	 * This is an overide for the paint component and draws the image
	 * Pre: the background varible must have a value
	 * Post: THe backgroudn iamge will appear
	 */
	@Override
	    protected void paintComponent(Graphics g) {
	        super.paintComponent(g);
	        g.drawImage(background, 0, 0, this);
	        
	    }
}