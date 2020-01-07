package computationalcookies;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Game {
	
	private static int call = 0;
	private static boolean run = true;
	
	private static int score;
	private static int pinaColada;
	private static int ramtin;
	

	public static void main(String[] args) {
		
		mainMenu menu = new mainMenu() ;
		//GamePlay game = new Gameplay(score, pinaColada, ramtin);
		//StoreFront store = new StoreFront(score, pinaColada, ramtin);
		//EndPage end = new EndPage();
		
		JFrame GameWindow = new JFrame("Computational Cookies");
		Container c = GameWindow.getContentPane();
		
		GameWindow.setSize(900,600);
		GameWindow.setResizable(false);
		GameWindow.setVisible(true);
		GameWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		

		while (call < 4) {
			
			if (call == 0) {
				c.add(menu);
				menu.getCall();
			}
			/*
							
			else if (call == 1) {
				c.repaint();
				c.add(game);	  
			}
	
			else if (call == 2) {
				c.repaint();
				c.add(store);
			}
			else if (call == 3) {
				c.repaint();
				c.add(end);
			}
			*/
			
		}
			
	}
			
}

