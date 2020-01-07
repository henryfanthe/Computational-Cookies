package computationalcookies;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Game {
	
	private static boolean run = false;

	public static void main(String[] args) {
		
	
		mainMenu menu = new mainMenu() ;
		
		JFrame GameWindow = new JFrame("Computational Cookies");
		Container c = GameWindow.getContentPane();
		
		GameWindow.setSize(900,600);
		GameWindow.setResizable(false);
		GameWindow.setVisible(true);
		GameWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		run = true;
		while (run) {
			c.add(menu);
		}
			
	}

}
