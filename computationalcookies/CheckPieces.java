package computationalcookies;

/*
 * Name: Henry
 * Date: Jan 11, 2020
 * Desc: Checks for three of the same  values in a row
 */
public class CheckPieces {
	
	static PlaySound player = new PlaySound();
	/*
	 * Method for checking Horizontal
	 * Pre: none
	 * Post: Returns true of false based on weather or not there are three of the same
	 * 		 values in a row
	 */
	public static boolean checkHorizontal(Cookies[][] board) {
		//nested loop to check each needed place
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length - 2; j++) {
				//checks for three pieces in a row
				if (board[i][j].getType() == board[i][j + 1].getType() && 
						board[i][j].getType() == board[i][j + 2].getType()) {
					//returns true if there is a triple
					return true;
				}
				//moves on to the next spot
				else {
					continue;
				}
			}
		}
		//returns false when there are no triples
		return false;
	}
	
	/*
	 * Method for checking Vertical
	 * Pre: none
	 * Post: Returns true of false based on weather or not there are three of the same
	 * 		 values in a row
	 */
	public static boolean checkVertical(Cookies[][] board) {
		//nested loop to check each needed place
		for (int i = 0; i < board.length-2; i++) {
			for (int j = 0; j < board[0].length; j++) {
				//checks for three pieces in a row
				if (board[i][j].getType() == board[i+ 1][j].getType() && 
						board[i][j].getType() == board[i + 2][j].getType()) {
					//returns true if there is a triple
					return true;
				}
				else {
					//moves on to the next spot
					continue;
				}
			}
		}
		//returns false when there are no triples
		return false;
	}
	
	
	/*
	 * Method to find where the start of the triple is located when it is Horizontal
	 * Pre: Called when there is a three in a row
	 * Post: returns a board with the triple removed and the numbers above it
	 * 		 moved down into their place
	 */
	public static Cookies[][] Horizontal(Cookies[][] board) {
		//nested loop to check each needed place
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length - 2; j++) {
				//checks for a triple
				if (board[i][j].getType() == board[i][j + 1].getType() && 
						board[i][j].getType() == board[i][j + 2].getType()) {
					//calls the method to switch the number's places
					return movePiecesHorizontal(i, j, board);
				}
				else {
					//moves on to the next spot
					continue;
				}
			}
		}
		//removes possibility of not being able to return anything error
		return board;
	}
	
	/*
	 * Method to find where the start of the triple is located when it is Vertical
	 * Pre: Called when there is a three in a row
	 * Post: returns a board with the triple removed and the numbers above it
	 * 		 moved down into their place
	 */
	public static Cookies[][] Vertical(Cookies[][] board) {
		//nested loop to check each needed place
		for (int i = 0; i < board.length-2; i++) {
			for (int j = 0; j < board[0].length; j++) {
				//checks for a triple
				if (board[i][j].getType() == board[i+ 1][j].getType() && 
						board[i][j].getType() == board[i + 2][j].getType()) {
					//calls the method to switch the number's places
					return movePiecesVertical(i, j, board);
				}
				else {
					//moves on to the next spot
					continue;
				}
			}
		}
		//removes possibility of not being able to return anything error
		return board;
	}
	
	
	
	/*
	 * Method remove the triple and cause other numbers for "Fall" into their place
	 * Pre: gets sent the location of the first number in the triple
	 * Post: returns a board with the triple removed and the numbers above it
	 * 		 moved down into their place
	 */
	public static Cookies[][] movePiecesHorizontal(int row, int col, Cookies[][] board){
		//repeats for moving the one number
		for (int j = 0; j < 3; j++) {
			//repeats until it reaches the "Top"
			for (int i = row; i >= 1; i --) {
				//moves the number down one place
				board[i][col + j].setType(board[i-1][col + j].getType());
				board[i][col + j].getImage();
			}
			//generates a new random number at the top
			board[0][col + j].setType((int)(Math.random()*5) + 1);
			board[0][col + j].getImage();
		}
		GamePlay.addScore100();
		
		//randomly generating a number of the sound to play
		int sound = (int)(Math.random()*2) + 1;
		
		if(sound == 1) {
			player.play("Sounds/Beep.wav");
		}
		
		else if(sound == 2) {
			player.play("Sounds/Boop.wav");
		}
		
		//Generting a number and playing one of the various vocal soundtracks
		int voicesound = (int)(Math.random()*4) + 1;
		if (voicesound == 1) {
			player.play("Sounds/Awesome.wav");
		}
		else if (voicesound == 2) {
			player.play("Sounds/Excellent.wav");
		}
		else if (voicesound == 3) {
			player.play("Sounds/Spec.wav");
		}
		//sends back the new board
		return board;
	}
	
	/*
	 * Method remove the triple and cause other numbers for "Fall" into their place
	 * Pre: gets sent the location of the first number in the triple
	 * Post: returns a board with the triple removed and the numbers above it
	 * 		 moved down into their place
	 */
	public static Cookies[][] movePiecesVertical(int row, int col, Cookies[][] board){
		//repeats for moving the one number
		for (int j = 0; j < 3; j++) {
			//repeats until it reaches the "Top"
			for(int i = row + 2; i >= 1; i--) {
				//moves the number down one place
				board[i][col].setType(board[i - 1][col].getType());
				board[i][col].getImage();
			}
			//generates a new random number at the top
			board[0][col].setType((int)(Math.random()*5) + 1);
			board[0][col].getImage();
		}
		//adding the score to the scroeboard
		GamePlay.addScore100();
		
		//Randomly making a number and playing one fo the starting sounds 
		int sound = (int)(Math.random()*2) + 1;
		
		if(sound == 1) {
			player.play("Sounds/Beep.wav");
		}
		
		else if(sound == 2) {
			player.play("Sounds/Boop.wav");
		}
		
		//Randomly genrating a number and playing one of the vocal tracks for it 
		int voicesound = (int)(Math.random()*4) + 1;
		if (voicesound == 1)
			player.play("Sounds/Awesome.wav");
		
		else if (voicesound == 2) {
			player.play("Sounds/Excellent.wav");
		}
		else if (voicesound == 3) {
			player.play("Sounds/Spec.wav");
		}
		//sends back the new board
		return board;
	}
	
	
	/*
	 * Method to test for a triple
	 * Pre: none
	 * Post: runs through checking for and replacing triples until there are none left
	 */
	
	public static Cookies[][] movePiecesSingle(int row, int col, Cookies[][] board){

		//repeats until it reaches the "Top"
		for(int i = col; i >= 1; i--) {
			//moves the number down one place
			board[row][i].setType(board[row][i - 1].getType());
			board[row][i].getImage();
		}
		//generates a new random number at the top
		board[row][0].setType((int)(Math.random()*5) + 1);
		board[row][0].getImage();
	//sends back the new board
		return board;
	}
	public static Cookies[][] testBoard(Cookies[][]board){
		boolean goAgain = true;
		while (goAgain) {
			goAgain = false;
			// going throug board and mgettign rid of any triples made as a result of the swtich
			if (CheckPieces.checkHorizontal(board)) {
				board = CheckPieces.Horizontal(board);
				goAgain = true;
			}
			if (CheckPieces.checkVertical(board)) {
				board = CheckPieces.Vertical(board);
				goAgain = true;
			}
		}
		//Returning the edited board
		return board;
	}
}

