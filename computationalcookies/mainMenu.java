package computationalcookies;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


public class mainMenu extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private BufferedImage background;
	public mainMenu() {
		
		
		try {                
	         background = ImageIO.read(new File("Images/Game Start.png"));
	       } catch (IOException e) {
	    	   System.out.print("Image Not Available");
	       }

	}
	@Override
	    protected void paintComponent(Graphics g) {
	        super.paintComponent(g);
	        g.drawImage(background, 0, 0, this);
	        
	    }
}