/*
 * Name: Henry
 * Date: Jan 11, 2020
 * This program displays basic help info for how to play the game
 */

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class Help extends JPanel {
	//labels that tell the use how to play
	private JLabel title = new JLabel("Help");
	private JLabel howToPlay = new JLabel("Click on one cookie then click on another next to it to change their places");
	private JLabel howToPlay2 = new JLabel("Combine three in a row to clear them and get points");
	private JLabel howToPlay3 = new JLabel("Get as many points as you can");
	//creates a variable for the background
	private BufferedImage background;
	
	/*
	 * Constructor
	 * Pre: none
	 * Post: Creates a JPanel that has text displayed with an image for a background.
	 */
	public Help() {
		//sets the background
		try {
			background = ImageIO.read(new File("Help Screen.png"));
		} catch (IOException e) {
			System.out.print("Image Not Available");
		}
		//sets the layouts to stak on top of each other.
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		//centers the text
		title.setAlignmentX(CENTER_ALIGNMENT);
		howToPlay.setAlignmentX(CENTER_ALIGNMENT);
		howToPlay2.setAlignmentX(CENTER_ALIGNMENT);
		howToPlay3.setAlignmentX(CENTER_ALIGNMENT);
		//adds the text to the JFrame
		this.add(title);
		this.add(howToPlay);
		this.add(howToPlay2);
		this.add(howToPlay3);
	}
	
@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, 0, 0, this);
        
    }
}
