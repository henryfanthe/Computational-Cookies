package computationalcookies;

// Java program to show Example of CardLayout. 
// in java. Importing different Package. 
import java.awt.*; 
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 
import javax.swing.*; 
  
// class extends JFrame 
public class CardPanelStart extends JFrame { 
  
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
       GamePlay game = new GamePlay(1,1,1);
  
        // Initialization of object 
        // "jp4" of CardLayout class. 
        JPanel jp4 = new JPanel();  
        // Initialization of object  
        // "jl3" of JLabel class. 
  
        // Initialization of object  
        // "jl4" of JLabel class. 
        JLabel jl4 = new JLabel("Card4"); 
        
        
        // Adding JPanel "jp4" on JFrame. 
        jp4.add(jl4); 
  
        // Adding the cardPanel on "jp1" 
        cardPanel.add(menu, "1"); 
  
        // Adding the cardPanel on "jp2" 
        cardPanel.add(Help, "2"); 
  
        // Adding the cardPanel on "jp3" 
        cardPanel.add(game, "3"); 
  
        // Adding the cardPanel on "jp4" 
        cardPanel.add(jp4, "4"); 
  
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
  
        // Adding JButton "firstbtn" on JFrame. 
        buttonPanel.add(MenuBtn); 
  
        // Adding JButton "nextbtn" on JFrame. 
        buttonPanel.add(HelpBtn); 
  
        // Adding JButton "previousbtn" on JFrame. 
        buttonPanel.add(GameBtn); 
  
        // Adding JButton "lastbtn" on JFrame. 
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
                    cl.show(cardPanel, "" + (currentCard)); 
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
  
        // Creating Object of CardLayoutDemo class. 
        CardPanelStart cl = new CardPanelStart(); 
  
        // Function to set default operation of JFrame. 
        cl.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
  
        // Function to set vivibility of JFrame. 
        cl.setVisible(true); 
    } 
} 