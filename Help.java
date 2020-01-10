import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
public class Help extends JPanel implements ActionListener {
	private JButton back = new JButton("Back");
	private JLabel title = new JLabel("Help");
	private JLabel howToPlay = new JLabel("Click on one cookie then click on another next to it to change their places");
	private JLabel howToPlay2 = new JLabel("Combine three in a row to clear them and get points");
	private JLabel howToPlay3 = new JLabel("Get as many points as you want");
	private static int call = 2;
	
	public Help() {
		try {
			BufferedImage background = ImageIO.read(new File("Game Start.png"));
		} catch (IOException e) {
			System.out.print("Image Not Available");
		}
		setCall();
		this.setLayout(new GridLayout(5, 1, 50, 50));
		this.add(title);
		this.add(howToPlay);
		this.add(howToPlay2);
		this.add(howToPlay3);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == back) {
			System.out.println("Back");
			call = 0;
		}
	}
	@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.blue);
        
    }
	public static int getCall() {
		return call;
	}
	
	public void setCall() {
		call = 2;
	}
}
