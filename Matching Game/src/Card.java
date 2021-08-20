
public class Card {
	
	private String n;
	private boolean flip;
	private boolean match = false;
	
	
	/**
	 * 
	 * @param name to n
	 * sets flip to false which would doesn't display the name to the box
	 */
	public Card(String name) {
		n = name;
		flip = false;
	}
	
	/**
	 * 
	 * @return a true or false if the card is faced down or faced up
	 */
	public boolean flipped() {
		if(flip == false)
		{
			flip = true;
		}
		else {
			flip = false;
		}
		return flip;
	}
	
	
	
	/**
	 * 
	 * @return nothing if the boolean flip is false and returns the name of the card if flip is false 
	 */
	
	public String getName() {
		if(flip == false) {
		return "       ";
		}
		return n;
	}
	
	public boolean isFlip() {
		return flip;
	}
	
	/**
	 * 
	 * @return name of card
	 */
	public String name() {
		return n;
	}
	

	/**
	 * changes match to true when two cards matches
	 */
	public void matchCard() {
		match = true;
	}
	
	public void reset() {
		match = false;
	}
	
	/**
	 * 
	 * @return if the card matches
	 */
	public boolean status() {
		return match;
	}
	
	
	
	
	
}
