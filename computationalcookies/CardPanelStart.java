package computationalcookies;
/*
 * Name: Henry and Jawad
 * Date: Jan 11, 2020
 * Desc: Menus of the program. you start on the main menu and allows the user to switch between the menu, help store and 
 * the main game. It also allow the user to wuit the game when the hit the quit button
 */


// in java. Importing different Package. 
import java.awt.*; 
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 
import javax.swing.*; 
  
// class extends JFrame 
public class CardPanelStart extends JFrame { 
  
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Initialization the value of 
    // current card is 1 . 
    private int currentCard = 1; 
  
    // Declaration of objects  
    // of CardLayout class. 
    private CardLayout cl; 
  
    public CardPanelStart() 
    { 
  
        // Function to set visibility of JFrame 
        setTitle("Card Layout Example"); 
  
        // Function to set visibility of JFrame 
        setSize(900, 600); 
  
        // Creating Object of "Jpanel" class 
        JPanel cardPanel = new JPanel(); 
  
        // Initialization of object "c1" 
        // of CardLayout class. 
        cl = new CardLayout(); 
  
        // set the layout 
        cardPanel.setLayout(cl); 
  
        // Initialization of object  
        // "jp1" of JPanel class. 
        mainMenu menu = new mainMenu(); 
  
        // Initialization of object  
        // "jp2" of CardLayout class. 
        Help Help = new Help(); 
  
        // Initialization of object  
        // "jp3" of CardLayout class. 
        GamePlay Game = new GamePlay(1, 1);

        // Adding the cardPanel on "jp1" 
        cardPanel.add(menu, "1"); 
  
        // Adding the cardPanel on "jp2" 
        cardPanel.add(Help, "2"); 
  
        // Adding the cardPanel on "jp3" 
        cardPanel.add(Game, "3"); 
        
        // Creating Object of "JPanel" class 
        JPanel buttonPanel = new JPanel(); 
  
        // Initialization of object  
        // "firstbtn" of JButton class. 
        JButton MenuBtn = new JButton("Menu"); 
  
        // Initialization of object 
        // "nextbtn" of JButton class. 
        JButton HelpBtn = new JButton("Help"); 
  
        // Initialization of object 
        // "previousbtn" of JButton class. 
        JButton GameBtn = new JButton("Game"); 
  
        // Initialization of object  
        // "lastbtn" of JButton class. 
        JButton QuitBtn = new JButton("Quit"); 
        
        // Adding JButton "Menubtn" on JFrame. 
        buttonPanel.add(MenuBtn); 
  
        // Adding JButton "nextbtn" on JFrame. 
        buttonPanel.add(HelpBtn); 
  
        // Adding JButton "Gamebtn" on JFrame. 
        buttonPanel.add(GameBtn); 
  
        // Adding JButton "Quitbtn" on JFrame. 
        buttonPanel.add(QuitBtn); 
        
        // add firstbtn in ActionListener 
        MenuBtn.addActionListener(new ActionListener()  
        { 
            public void actionPerformed(ActionEvent arg0) 
            { 
                  
                // used first c1 CardLayout 
                cl.first(cardPanel); 
  
                // value of currentcard is 1 
                currentCard = 1; 
            } 
        }); 
  
        // add lastbtn in ActionListener 
        HelpBtn.addActionListener(new ActionListener()  
        { 
            public void actionPerformed(ActionEvent arg0) 
            { 
                // value of currentcard is 4 
                currentCard = 2; 
                
                
                // used last c1 CardLayout 
                cl.show(cardPanel, "" + (currentCard)); 
  
            } 
        }); 
  
        // add nextbtn in ActionListener 
        GameBtn.addActionListener(new ActionListener()  
        { 
            public void actionPerformed(ActionEvent arg0) 
            { 
  
                // if condition apply 
                if (currentCard < 4)  
                { 
                      
                    // increment the value of currentcard by 1 
                    currentCard = 3; 
  
                    // show the value of currentcard 
                    cl.show(cardPanel, "" + (currentCard)); 
                } 
            } 
        }); 
  
        // add previousbtn in ActionListener 
        QuitBtn.addActionListener(new ActionListener()  
        { 
            public void actionPerformed(ActionEvent arg0) 
            { 
                // if condition apply 
                if (currentCard > 1) { 
  
                    // decrement the value  
                    // of currentcard by 1 
                    currentCard = 4; 
  
                    // show the value of currentcard 
                    
                    //Saving the gameboard before the program quits
                    Cookies[][] board = Game.getGameBoard();
                    save.Save(board);
                    
                    
                
                    //Ending the task and clsoing the game
                    System.exit(0);
                } 
            } 
        }); 
  
        // used to get content pane 
        getContentPane().add(cardPanel, BorderLayout.CENTER); 
  
        // used to get content pane 
        getContentPane().add(buttonPanel, BorderLayout.SOUTH); 
    } 
  
    // Main Method 
    public static void main(String[] args) 
    { 
    	//Declaring the who audio objects
    	PlaySound player = new PlaySound();
    	Bg back = new Bg();
    
        // Creating Object of CardLayoutDemo class. 
        CardPanelStart cl = new CardPanelStart(); 

        cl.setSize(915, 675);
        cl.setResizable(false);
  
        // Function to set default operation of JFrame. 
        cl.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
  
        // Function to set vivibility of JFrame. 
        cl.setVisible(true); 

        //Getting the welcome audio snippet to play
		player.play("Sounds/WelcomeBack.wav");
		
		//starting the background music
		back.play("Sounds/CompCookiesbg.wav");
    } 
} 