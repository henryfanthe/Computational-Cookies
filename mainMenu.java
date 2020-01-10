import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


public class mainMenu extends JPanel{

	private BufferedImage background;
	
	private int call = 0;
	public mainMenu() {
		
		
		try {                
	         background = ImageIO.read(new File("Game Start.jpg"));
	       } catch (IOException e) {
	    	   System.out.print("Image Not Available");
	       }

	}
	@Override
	    protected void paintComponent(Graphics g) {
	        super.paintComponent(g);
	        g.drawImage(background, 0, 0, this);
	        
	    }

	public int getCall() {
		return call;
	}
}