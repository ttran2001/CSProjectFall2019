
public class AiPlayer extends Player{
	
	private int row =4;
	private int col =4;	
	
	/**
	 * 
	 * @return number for x for AI
	 */
	public int getX() {
			return (int)(Math.random()*row);
	}

	/**
	 * 
	 * @return number for y for AI
	 */
	public int getY() {	
			return (int)(Math.random()*col);							
}
	
}
