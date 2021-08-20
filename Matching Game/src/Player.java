
public class Player {
	private int score;
	private int moves;
	
	
	/**
	 * sets score to 0
	 * sets moves to 0
	 */
	public Player() {
		score =  0;
		moves = 0;
	}
	
	
	/**
	 * adds one to move every time it's called
	 */
	public void addMove() {
		moves++;
	}
	
	/**
	 * adds one to score every time it's called
	 */
	public void addScore() {
		score++;
	}
	
	
    public void reset() {
		score = 0;
		moves = 0;
	}
	
	/**
	 * 
	 * @return number of score 
	 */
	public int getScore() {
		return score;
	}
	
	/**
	 * 
	 * @return number of moves
	 */
	public int getMove() {
		return moves;
	}
	
	
	
	/**
	 * 
	 * @param decide
	 * @return the boolean if the person enter yes or no. If they didn't it would return
	 * a false, activating the while loop.
	 */
	public boolean playAgain(String decide) {
		if(decide.equalsIgnoreCase("Yes") == true) {
			return true ;
		}
		if(decide.equalsIgnoreCase("No") == true) {
			return true;
		}
		return false;
	}
	
	
	
}
