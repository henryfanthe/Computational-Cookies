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
		Help help = new Help();
		//GamePlay game = new Gameplay(score, pinaColada, ramtin);
		//StoreFront store = new StoreFront(score, pinaColada, ramtin);
		//EndPage end = new EndPage();
		
		JFrame GameWindow = new JFrame("Computational Cookies");
		Container c = GameWindow.getContentPane();
		
		GameWindow.setSize(900,600);
		GameWindow.setResizable(false);
		GameWindow.setVisible(true);
		GameWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		

		while (true) {
			call = menu.getCall();
			System.out.println(call);
			while (call == 0) {
				c.removeAll();
				c.add(menu);
				c.revalidate();
				call = menu.getCall();
				if (call == 0) {
					System.out.println("Bye");
					continue;
				}
				else {
					System.out.println("HI");
					break;
				}
			}
			/*
							
			else if (call == 1) {
				c.repaint();
				c.add(game);	  
			}
	*/
			while (call == 2) {
				c.removeAll();
				c.add(help);
				c.revalidate();
				call = Help.getCall();
				if (call == 2) {
					System.out.println("Hello");
					continue;
				}
				else {
					System.out.println("Good Bye");
					break;
				}
			}
			/*
			else if (call == 3) {
				c.add(store);
			}
			*/
			
		}
			
	}
			
}