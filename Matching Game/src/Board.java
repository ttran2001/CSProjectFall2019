import java.util.ArrayList;

public class Board {
	
	private final int row = 4;
	private final int col = 4;
	private Card board[][] = new Card[row][col]; 
	private Card c1;
	private int num;
	private int counter = 16;
	
	
	/**
	 * 
	 * @param Randomize the card in the board and would store it in the double array that
	 * takes in cards.
	 */
	public Board(Card[] names) {
		ArrayList<Card> card1 = new ArrayList<Card>();
		for(int i = 0; i < names.length; i++) {
		card1.add(names[i]);
		}
		
		for(int x = 0; x< board.length; x++) {
			for(int y = 0; y <board[0].length;y++) {
				        num = (int)(Math.random()*counter);
						c1  = card1.get(num);
						board[x][y] = c1;
						card1.remove(num);
						counter--;
					}
			}
		}
	
	public boolean checkAll() {
		
		for(int x = 0; x < board.length; x++) {
			for(int y = 0; y < board[0].length; y++) {
				if(board[x][y].status() == false ) {
					return false;
				}
			}
		}
		return true;
	}
	
	
	
	/**
	 * 
	 * @param x
	 * @param y
	 * @return a card of the x and y of board[][]
	 */
	public Card getCard(int x, int y) {
		Card card = board[x][y]; 
		return card;
	}
	

	
	/**
	 * 
	 * @return the number of row
	 */
	public int row() { //
		return row;
		}
	
	/**
	 * 
	 * @return the number of column 
	 */
	public int col() {
		return col;
	}
	
	
	/**
	 * 
	 * @return the top or bottom of the card
	 */
	public String printLine() { 
		return "---------";
	}
	
	/**
	 * 
	 * @param x
	 * @param y
	 * @return the name and the side of the card
	 */
	public String displayCard(int x, int y) {
		return "| " + board[x][y].getName()  + " |"; //prints the side and the name of the card.
	}
	
	
	
	
	
	
	
}
