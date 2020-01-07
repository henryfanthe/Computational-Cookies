package computationalcookies;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


public class mainMenu extends JPanel implements ActionListener {

	private BufferedImage background;
	private JButton start = new JButton("PLAY");
	private JButton help = new JButton("HELP");
	private JButton store = new JButton("STORE");
	
	private int call;
	
	public mainMenu() {
		try {                
	         background = ImageIO.read(new File("Images/Game Start.png"));
	       } catch (IOException e) {
	    	   System.out.print("tEST");
	    	   
	 
	       }
			
		this.setLayout(null);
		
		this.add(start);
		start.addActionListener(this);
		
		this.add(help);
		help.addActionListener(this);
		
		this.add(store);
		store.addActionListener(this);
		
		start.setSize(150, 125);
		start.setLocation(200,300);
		
		help.setSize(150, 125);
		help.setLocation(400,300);
		
		store.setSize(150, 125);
		store.setLocation(600,300);
		
		
		

	}
		


	@Override
	    protected void paintComponent(Graphics g) {
	        super.paintComponent(g);
	        g.drawImage(background, 0, 0, this);
	        
	    }

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == start) {
			System.out.print("Start pressed");
			//Gameplay gameplay = new Gameplay()score
		}
		else if (e.getSource() == help) {
			System.out.print("help pressed");
		}
		
		else if (e.getSource() == store) {
			System.out.print("store pressed");
		}
		
	}

}


