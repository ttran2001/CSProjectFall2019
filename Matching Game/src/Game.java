import java.util.Scanner;
import java.util.ArrayList;
/**
 * 
 * @author tt553
 *
 */

public class Game {
	
	  Scanner kb = new Scanner(System.in);
	  int numCheck;
	  
	  /**
 	  * This for statement would create the board,
 	  * everytime it gets called it would display the cards that are flipped
 	  * and cards that are not flipped. If it's not flipped, It would display nothing 
 	  */
	 public void buildBoard(Board b1, Player p) {
		 for(int row = 1; row <=b1.row();row++){
	 	    	System.out.printf("%12d",row);
	 	    }	    	 
	    	 System.out.println();	    	
	    	 for(int col1 = 1; col1 <= b1.col(); col1++) {	    		 
	    		 System.out.print("       "+b1.printLine());	    		 
	    		 for(int topLine = 1; topLine < b1.row();topLine++) {
	    		 System.out.print("   "+b1.printLine());
	    		 }
	    		 System.out.println();
	    		 System.out.print(col1 + "     " + b1.displayCard(0, col1-1));
	    		 for(int mid = 1; mid < b1.row();mid++) {
	    		 System.out.print(" " + b1.displayCard(mid, col1-1));
	    		 }
	    		 System.out.println();
	    	 }	    	 	   	    	 
	    	 System.out.print("       "+b1.printLine());	    	 
	    	 for(int botLine = 1; botLine < b1.row();botLine++) {
	    		 System.out.print("   "+b1.printLine());
	    		 }    	 
	    	 System.out.println();      
	    	 System.out.println("		    Score: "+ p.getScore() + "    Move: "+ p.getMove());    	                     
		    System.out.println();			  
	 }
	 
	 /**
	  * 
	  * @param b1
	  * @param p
	  * @param p2
	  * Creates the board for Player vs Player, Player vs AI, and AI vs AI
	  */
	 public void buildBoard2(Board b1, Player p, Player p2) {
		 for(int row = 1; row <=b1.row();row++){
	 	    	System.out.printf("%12d",row);
	 	    }	    	 
	    	 System.out.println();
	    	 for(int col1 = 1; col1 <= b1.col(); col1++) {	    		 
	    		 System.out.print("       "+b1.printLine());
	    		 
	    		 for(int topLine = 1; topLine < b1.row();topLine++) {
	    		 System.out.print("   "+b1.printLine());
	    		 }
	    		 System.out.println();
	    		 System.out.print(col1 + "     " + b1.displayCard(0, col1-1));
	    		 for(int mid = 1; mid < b1.row();mid++) {
	    		 System.out.print(" " + b1.displayCard(mid, col1-1));
	    		 }
	    		 System.out.println();
	    	 }    	 
	    	 System.out.print("       "+b1.printLine());
	    	 
	    	 for(int botLine = 1; botLine < b1.row();botLine++) {
	    		 System.out.print("   "+b1.printLine());
	    		 }
	    	 
	    	 System.out.println();
             
	    	 System.out.println("		    P1: "+ p.getScore() + "    P2: "+ p2.getScore());
	    	                     
		    System.out.println();  
	 }
	 
	 /**
	  * Creates the board that keeps the statistics for AI vs AI
	  */
	 public void makeTable(ArrayList<Integer> num, int count) {
		 
		 int number = 0;
		
		 System.out.println("  Number of Test: " + count);
		 System.out.println(" Difference | Occurence ");
		 for(int i = -8; i <= 8; i++) {
			
	     System.out.println("--------------------------");
	     System.out.println("      "+i+ "    |     "+num.get(number) + "     ");
	     System.out.println("--------------------------");
	     number+=1;
		 
		 }
	 }
	
	/**
	 * This method start() starts the whole matching game. 
	 * It will stop when the person doesn't want to play again
	 * 
	 */
	  
	
	public void start() {
		
		// The names of the card 
	    String[] food = {"Eggroll","Bamboos","Carrots","Potatos","Shrimps","Noodles", "Snicker","Coconut","Eggroll","Bamboos","Carrots","Potatos","Shrimps","Noodles", "Snicker","Coconut"};
 		Card[] card1 = new Card[16];
 		
 		ArrayList<Integer> count = new ArrayList<>();
 		
 		int neight=0;
 		int nsev=0;
 		int nsix=0;
 		int nfive=0;
 		int nfour=0;
 		int nthree=0;
 		int ntwo=0;
 		int none=0;
 		int zero=0;
 		int one=0;
 		int two=0;
 		int three=0;
 		int four=0;
 		int five=0;
 		int six=0;
 		int sev=0;
 		int eight=0;
	
 		boolean turn = false; 
 		boolean playerTurn = true;
 		
 	
 		for(int i = 0; i < food.length; i++) {
 			card1[i] = new Card(food[i]);
 		}
 		
		//x and y coordinate for first card 
		int x1;
		int y1;
		
		//x and y coordinate for second card
		int x2;
		int y2;

        /** word1 is the first word from the first card 
         * word2 is the second word from the second card 
         */
		
	    String word1;
	    String word2;
		
	    //set the default play to true so it can start the while loop 
		boolean play = true;
		
		//Creates a player from the players class
	    Player p1 = new Player();
	    Player p2 = new Player();
	    AiPlayer a1 = new AiPlayer();
	    AiPlayer a2 = new AiPlayer();
	    
	    //Displays who's turn it is. Only for Player vs Player, Player vs AI, and AI vs AI
	    String player = "P1";
	    
	    String decide = "";
	    
	    
	    boolean move = false;
	    
	    String result = "";
	       	 
	  /**
	   * Start of the game 
	   * 
	   */
	  
    	 while(play == true) {
    		 Board b1 = new Board(card1);
    		 result = "";
    		 p1.reset();
    		 p2.reset();
    		 a1.reset();
    		 a2.reset();
    		 playerTurn = true;
    		 turn = false;
    		 move = false;
    		 System.out.println();
    		 System.out.println("Welcome to Tyler Matching Game. Which mode would you like to play?");
    		 System.out.println("1. Solo");
    		 System.out.println("2. Player vs Player");
    		 System.out.println("3. Player vs AI");
    		 System.out.println("4. AI vs AI");
    		 System.out.print("Mode: ");
    		 String word = kb.nextLine();
    		 
    		 /**
    		  * Checks if the user enter a valid number
    		  */
    		 int pick = checkNum(word);
    		 if(pick == -1) {
    			 while(pick == -1) {
    				 System.out.print("Enter a valid number: ");
    				 word = kb.nextLine();
    				 pick = checkNum(word);
    			 }
    		 }
    		 
    		 turn = false;
    		 
    		 /**
    		  * 1-Player Mode
    		  */
    		 if(pick == 1) {
	     while(p1.getScore() != 8) {
   	 
	    		     buildBoard(b1, p1);    		    
	    		    /**
	    		     * Displays if the two card are match or not.
	    		     * Display nothing on the first call. 
	    		     */
	    	  System.out.println(result);
	    		    	   	    	 
	    	 System.out.println();
	    	 	    	 
	    	/**
	    	 * Gets the coordinate of the x for the first card.
	    	 * The player could type q if he doesn't want to play anymore.
	    	 * This would break the while loop which doesn't stop unless it reaches 8 or 
	    	 * the player enters q
	    	 */
	         System.out.print("Enter a x for the first card. Enter q if you want to quit: ");
	         x1 = check(b1);
	    	 if(x1 == -1) {
	    		 break;
	    	 }
	         
	    	 /**
	    	  * Gets the coordinate of the y for the first card
	    	  * Player could enter q if he wants to stop the while loop and end the game
	    	  */
	    	 System.out.print("Enter a y for the first card: ");
	    	 y1 = check(b1);
	    	 if(y1 == -1) {
	    		 break;
	    	 }
	    	 
	       
	    	 System.out.println();
	    	
	    	 /**
	    	  * This statement would check if the card that the player enter is already
	    	  * matched. If it is, It would ask the user to enter a different coordinate
	    	  * for a card that doesn't match. It would go through the while loop until the 
	    	  * player enter a coordinate that isn't matched. 
	    	  */
   	    		 if(b1.getCard(x1-1, y1-1).status() == true) {
   	    			 while(move == false) {
   	   	 	    	 
   	   	 	    			 System.out.print("That is already match. Enter a valid number for x for the first card: ");
   	   	 	    			 x1 = check(b1);
   	   	 	    		if(x1 == -1) {
   	   		    		 break;
   	   		    	 }
	   		    	    	   	 	
   	   		   System.out.print("Enter a valid number for y for the first card: ");
   	   		      y1 = check(b1); 
   	   		    if(y1 == -1) {
	    		 break;
	    	 }
   	   	 	    	 
   	   	 	    	 if(b1.getCard(x1-1, y1-1).status() == false) {
	    					 move = true;
	 	    	    	
	 	    		 }
   	   	 	    	 
   	    		 }
   	    		 
   	    		 }	 
   	    		 
   	    		 /**
   	    		  * resets the value of move to false 
   	    		  */
   	    		 move = false;
	    	 
	    	
	    	 word1 = b1.getCard(x1-1, y1-1).name();
	    	 b1.getCard(x1-1, y1-1).flipped();
	    		    	 
	    	 buildBoard(b1, p1);
		    
		    /**
		     * Ask the user for the x coordinate for the second card and would call
		     * the check method to see if the answer the person entered is valid
		     */
		    System.out.print("Enter a x for the second card: ");
		    x2 = check(b1);
		    if(x2 == -1) {
		    	break;
		    }
	    		 
	    	 /**
	    	  * Ask for the y coordinate for the second card and would call the check
	    	  * if the answer the person entered is valid. End the while loop if the person
	    	  * entered "q".
	    	  */
	    	 System.out.print("Enter a y for the second card: ");
             y2 = check(b1);
             if(y2 == -1) {
            	 break;
             }
	    	 
	    		/**
	    		 * If the two card is already matched this will be called and would keep 
	    		 * repeating until the user enter a coordinate that not been matched yet.
	    		 */
	    		 if(b1.getCard(x2-1, y2-1).status() == true || sameCard(x1,x2,y1,y2) == true) {
   	    			 while(move == false || sameCard(x1,x2,y1,y2) == true) {
   	    				 
   	    	 System.out.println();
   	   	 	 System.out.print("That card already matched or you already called it or the same card. Enter a card an x for the second card . Enter q if you want to quit: ");
   	   	 	  x2 = check(b1);
   	   	 	  if(x2 == -1) {
   	   	 		  break;
   	   	 	  }
     	   	   	 	    	 
   	   	 	    	 System.out.print("Enter a y for the second card: ");
   	   	 	     y2 = check(b1);
   	   	 	     if(y2 == -1) {
   	   	 	    	 break;
   	   	 	     } 	    	  	    	   	   	 	
   	   	 	    	if(b1.getCard(x2-1, y2-1).status() == false) {
	    					 move = true;	 	    	    	
	 	    		 }   	    	      
   	    		 }
   	    		 }
	    		    	    		 
   	    		 move = false;
   	    		
   	    		 /**
   	    		  * Gets the name of the card to be compared with the first card
   	    		  * Flips the card to reveal the name of the card to the user.
   	    		  */
	    	 word2 = b1.getCard(x2-1, y2-1).name();
	    	 b1.getCard(x2-1, y2-1).flipped();
	    	 
	    	 buildBoard(b1, p1);
	    	
	    	 /**
		         * If the person  match the two cards. It would  add one to move, add one
		         * to score and would call the method matchCard for both card to true,
		         * so the user could not call the card again.
		         */
	        if(word1.equals(word2) == true){
	        	result = "You have a match";
		    	p1.addMove();
		    	p1.addScore();
		    	b1.getCard(x1-1, y1-1).matchCard();
		    	b1.getCard(x2-1, y2-1).matchCard();		    			    	
		    }
	        
	        /**
	         * If the person didn't match the two cards. It would only add one to move,
	         * flip back the first card and the second card to face down, and would 
	         * display/tells the user that the card didn't matched
	         */
		    else {
		    	p1.addMove();
		    	b1.getCard(x1-1, y1-1).flipped();
		    	b1.getCard(x2-1, y2-1).flipped();
		    	result = "You didn't match";
		    }		    	    	 
	    	 }
    		 
    		 
	     System.out.println();
	     
	     /**
	      * This statement would displays how many move it took the player to 
	      * finish the game. It would then ask the user if he wants to play again
	      * 
	      */
	     System.out.print("Game Over. It took you " + p1.getMove() + " moves to finish. Do you want to play again (Yes/No): ");
	     decide = kb.next();
	     
	     /**
	      * checks if the user types Yes or No. If not, it will ask the user again until the 
	      * user type something that is yes or no
	      */
	     while(p1.playAgain(decide) == false)  {
	    	 System.out.print("I didn't get that. Do you want to play again (Yes/No): ");
	    	 decide = kb.next();
    	 }
	     /**
	      * If the players types no, It would end the while and would print the statment
	      * "Game Over" 
	      */
	     if(decide.equalsIgnoreCase("No") ) {
	    	 play = false;
	     }
	     /**
	      * If the player types yes, the game would randomize the board 
	      * and would flip all the cards that are flipped back to false
	      */
	     if(decide.equalsIgnoreCase("yes")) {
	    	 for(int i = 0; i < card1.length;i++ ) {
	    		 if(card1[i].isFlip() == true) {
	    			 card1[i].flipped();
	    			 card1[i].reset();
	    		 }
	    	 }
	     }
    }
    		 
    		 /**
    		  * End of 1-Player Mode
    		  */
    		 
    		 
    		 /**
    		  * Start of 2-Player Mode
    		  */ 
    		if(pick == 2) {
    			
    			/**
    			 * keeps calling the while loop until all the card is all flipped
    			 */
    			while(b1.checkAll() == false) {
    					 buildBoard2(b1, p1, p2); 
    		    		    /**
    		    		     * Displays if the two card are match or not.
    		    		     * Display nothing on the first call. 
    		    		     */
    		    	  System.out.println(result);   		    		    
    		    	 System.out.println(); 
    		    	
    		    	 /**
    		    	 * 
    		    	 */
    		         System.out.print(player + ", Enter a x for the first card. Enter q if you want to quit: ");
    		         x1 = check(b1);
    		    	 if(x1 == -1) {
    		    		 break;
    		    	 }
    		         
    		    	 /**
    		    	  * Gets the coordinate of the y for the first card
    		    	  * Player could enter q if he wants to stop the while loop and end the game
    		    	  */
    		    	 System.out.print("Enter a y for the first card: ");
    		    	 y1 = check(b1);
    		    	 if(y1 == -1) {
    		    		 break;
    		    	 }    		        		       
    		    	 System.out.println();
    		    	 
    		    	 /**
    		    	  * This statement would check if the card that the player enter is already
    		    	  * matched. If it is, It would ask the user to enter a different coordinate
    		    	  * for a card that doesn't match. It would go through the while loop until the 
    		    	  * player enter a coordinate that isn't matched. 
    		    	  */
    	   	    		 if(b1.getCard(x1-1, y1-1).status() == true) {
    	   	    			 while(move == false) {   	   	   	 	    	 
    	   	   	 	    			 System.out.print("That is already match. Enter a valid number for x for the first card: ");
    	   	   	 	    			 x1 = check(b1);
    	   	   	 	    		if(x1 == -1) {
    	   	   		    		 break;
    	   	   		    	 }
    		   		    	    	   	 	
    	   	   		   System.out.print("Enter a valid number for y for the first card: ");
    	   	   		      y1 = check(b1); 
    	   	   		    if(y1 == -1) {
    		    		 break;
    		    	 }    	   	   	 	    	 
    	   	   	 	    	 if(b1.getCard(x1-1, y1-1).status() == false) {
    		    					 move = true;   		 	    	    	
    		 	    		 }   	   	   	 	    	 
    	   	    		 }    	   	    		 
    	   	    		 }	 
    	   	    		 
    	   	    		 /**
    	   	    		  * resets the value of move to false 
    	   	    		  */
    	   	    		 move = false;
    	   	    		 
    		    	 word1 = b1.getCard(x1-1, y1-1).name();
    		    	 b1.getCard(x1-1, y1-1).flipped();
    		    	   		    	 
    		    	 buildBoard2(b1, p1, p2);
    			    
    			    /**
    			     * Ask the user for the x coordinate for the second card and would call
    			     * the check method to see if the answer the person entered is valid
    			     */
    			    System.out.print("Enter a x for the second card: ");
    			    x2 = check(b1);
    			    if(x2 == -1) {
    			    	break;
    			    }
    		    		 
    		    	 /**
    		    	  * Ask for the y coordinate for the second card and would call the check
    		    	  * if the answer the person entered is valid. End the while loop if the person
    		    	  * entered "q".
    		    	  */
    		    	 System.out.print("Enter a y for the second card: ");
    	             y2 = check(b1);
    	             if(y2 == -1) {
    	            	 break;
    	             }
    		    	 
    		    		/**
    		    		 * If the two card is already matched this will be called and would keep 
    		    		 * repeating until the user enter a coordinate that not been matched yet.
    		    		 */
    		    		 if(b1.getCard(x2-1, y2-1).status() == true || sameCard(x1,x2,y1,y2) == true) {
    	   	    			 while(move == false || sameCard(x1,x2,y1,y2) == true) {
    	   	    				 
    	   	    	 System.out.println();
    	   	   	 	 System.out.print("That card already matched or you already called it or the same card. Enter a card an x for the second card . Enter q if you want to quit: ");
    	   	   	 	  x2 = check(b1);
    	   	   	 	  if(x2 == -1) {
    	   	   	 		  break;
    	   	   	 	  }
    	     	 
    	   	   	 	    	 
    	   	   	 	    	 System.out.print("Enter a y for the second card: ");
    	   	   	 	     y2 = check(b1);
    	   	   	 	     if(y2 == -1) {
    	   	   	 	    	 break;
    	   	   	 	     }
    	 	    	 
    	 	    	   	   	 	

    	   	   	 	    	if(b1.getCard(x2-1, y2-1).status() == false) {
    		    					 move = true;   		 	    	    	
    		 	    		 }    	   	    	      
    	   	    		 }
    	   	    		 }
    		    		    	   	    		 
    	   	    		 move = false;
    	   	    		
    	   	    		 /**
    	   	    		  * Gets the name of the card to be compared with the first card
    	   	    		  * Flips the card to reveal the name of the card to the user.
    	   	    		  */
    		    	 word2 = b1.getCard(x2-1, y2-1).name();
    		    	 b1.getCard(x2-1, y2-1).flipped();
    		    	 
    		    	 buildBoard2(b1, p1, p2);
    		    	 
    		    	 
    		    	
    		    	 /**
    			         * If turn is false, Player 1 gets a point.
    			         * First and second card becomes matched.
    			         */
    		        if(word1.equals(word2) == true && turn == false){
    		        	result = "You have a match P1";
    			    	p1.addScore();
    			    	b1.getCard(x1-1, y1-1).matchCard();
    			    	b1.getCard(x2-1, y2-1).matchCard();    			    	   			    	
    			    }
    		        
    		        /**
    		         * If turn is true, Player 2 gets a point 
    		         * first and second card becomes matched
    		         */
    		        else if(word1.equals(word2) == true && turn == true){
    		        	result = "You have a match P2";
    			    	p2.addScore();
    			    	b1.getCard(x1-1, y1-1).matchCard();
    			    	b1.getCard(x2-1, y2-1).matchCard();    			    	   			    	
    			    }
    		        
    		        /**
    		         * If the person didn't match the two cards.It would 
    		         * flip back the first card and the second card to face down, and would 
    		         * display/tells the user that the card didn't matched. if the turn is false, it will switch to true which is P2
    		         * If true then it will switch match to false which player is P2
    		         */
    			    else {
    			    	b1.getCard(x1-1, y1-1).flipped();
    			    	b1.getCard(x2-1, y2-1).flipped();
    			    	result =(player + " didn't match ");
    			    	if(turn == false) {
    			    		turn = true;
    			    		player = "P2";
    			    	}
    			    	else {
    			    		turn = false;
    			    		player = "P1";
    			    	}
    			    }
    		        if(b1.checkAll() == true) {
    		        	buildBoard2(b1, p1, p2);
    		        }
    			}
    			
    			 System.out.println();
    			 
    			 
    		     
    		     /**
    		      * This statement would displays the winner the number of matches they got. If P1 and P2 have the same amount of matches
    		      * it will display a tie statement.
    		      * 
    		      */
    			 if(p1.getScore() > p2.getScore()) {
    		     System.out.print("Game Over. P1 wins with " + (p1.getScore()) + " matches. Do you want to play again (Yes/No): ");
    		     decide = kb.next();
    			 }    			 
    			 else if(p1.getScore() < p2.getScore()){
    				 System.out.print("Game Over. P2 wins with " + (p2.getScore()) + " matches. Do you want to play again (Yes/No): ");
        		     decide = kb.next();
    			 }
    			 
    			 else {
    				 System.out.print("Game Over. It's a tie. Do you want to play again (Yes/No): ");
    				 decide = kb.next();
    			 }
    			 
    			 
    		     /**
    		      * checks if the user types Yes or No. If not, it will ask the user again until the 
    		      * user type something that is yes or no
    		      */
    		     while(p1.playAgain(decide) == false)  {
    		    	 System.out.print("I didn't get that. Do you want to play again (Yes/No): ");
    		    	 decide = kb.next();
    	    	 }
    		     /**
    		      * If the players types no, It would end the while and would print the statment
    		      * "Game Over" 
    		      */
    		     if(decide.equalsIgnoreCase("No") ) {
    		    	 play = false;
    		     }
    		     /**
    		      * If the player types yes, the game would randomize the board 
    		      * and would flip all the cards that are flipped back to false
    		      */
    		     if(decide.equalsIgnoreCase("yes")) {
    		    	 for(int i = 0; i < card1.length;i++ ) {
    		    		 if(card1[i].isFlip() == true) {
    		    			 card1[i].flipped();
    		    			 card1[i].reset();
    		    		 }
    		    	 }
    		     }
    		}   		
    		System.out.println();   		
    		/**
    		 * End of 2-Player Mode
    		 */
    		
    		/**
    		 * Start of Player vs AI
    		 */   	
    		
    		if(pick == 3) {
    			/**
    			 * while loop keeps calling till the sum of P1 and a1 score equals 8.
    			 */
    			while(p1.getScore() + a1.getScore() != 8) {
    					//builds the board2 which displays the two player.
    					 buildBoard2(b1, p1, a1); 
    					 
    					 
    		    		    /**
    		    		     * Displays if the two card are match or not.
    		    		     * Display nothing on the first call. 
    		    		     */
    		    	  System.out.println(result);   		    		    
    		    	 System.out.println(); 
    		    	
    		    	 /**
    		    	 * if playerTurn is false, it ask the AI to make a move. 
    		    	 * If it's true, player makes a move
    		    	 */
    		    	 
    		    	 if(playerTurn == false){
    		    		 
    		    		 /**
    		    		  * gets the point for the first card for AI
    		    		  */
    		    		 x1 = a1.getX();
    		    		 y1 = a1.getY();
    		    		 
    		    		 	/**
    		    		 	 * Checks if AI calls a card that hasn't been matched. Keeps asking AI for x and y 
    		    		 	 * till its valid
    		    		 	 */
    		    			 if( b1.getCard(x1, y1).status() == true) {
    		    				 while(move == false) {
    		    				 x1 = a1.getX();
    		    				 y1 = a1.getY();
    		    				 if(b1.getCard(x1, y1).status() == false) {
    		    					 move = true;
    		    				 }
    		    			 }
    		    			 
    		    		 }
    		    			 
    		    		 //switches the move to false for second card 
    		    		 move = false;
    		    		 
    		    		 /**
    		    		  * gets the string of the card that AI picked and flipped the card that
    		    		  * AI called for. 
    		    		  */
    		    		 word1 = b1.getCard(x1, y1).name();
    		    		 b1.getCard(x1, y1).flipped();
    		    		 
    		    		 //builds Board2 that has the first card flipped
    		    		 buildBoard2(b1, p1, a1); 
    		    		 
    		    		 /**
    		    		  * gets the point for the second card 
    		    		  */
    		    		 x2 = a1.getX();
    		    		 y2 = a1.getY();
    		    		 
    		    		 /**
    		    		  * Check if second card that AI called is not matched already and not the same 
    		    		  * coordinate as the first card. Will ask for AI to ask for a different point 
    		    		  * till the card x and y is valid then it will change the move to true which will get 
    		    		  * out of the while loop 
    		    		  */
    		    			 if( b1.getCard(x2, y2).status() == true || sameCard(x1,x2,y1,y2) == true) {
    		    				 while(move == false) {
    		    				 x2 = a1.getX();
    		    				 y2 = a1.getY();
    		    			 
    		    			 if(b1.getCard(x2, y2).status() == false) {
    		    				 if(sameCard(x1,x2,y1,y2) == false) {
    		    				 
    		    				 move = true;
    		    				 }
    		    			 }
    		    		 }
    		    		 }
    		    		 
    		    		//turns move to false for the first card
    		    		 move = false;
    		    		 
    		    		 /**
    		    		  * gets the point for the second card for AI and flipped the card for second card
    		    		  */
    		    		 word2 = b1.getCard(x2, y2).name();
    		    		 b1.getCard(x2, y2).flipped();
    		    		 
    		    		 //displays board2 with both card displayed
    		    		 buildBoard2(b1, p1, a1);
    		    	 }
    		    	 
    		    	 /**
    		    	  * if playerTurns is true, this statement will be called which will ask player to type for card.
    		    	  */
    		    	 else{
    		         System.out.print("Player One, Enter a x for the first card. Enter q if you want to quit: ");
    		         x1 = check(b1);
    		    	 if(x1 == -1) {
    		    		 break;
    		    	 }
    		         
    		    	 /**
    		    	  * Gets the coordinate of the y for the first card
    		    	  * Player could enter q if he wants to stop the while loop and end the game
    		    	  */
    		    	 System.out.print("Enter a y for the first card: ");
    		    	 y1 = check(b1);
    		    	 if(y1 == -1) {
    		    		 break;
    		    	 }    		        		       
    		    	 System.out.println();
    		    	 
    		    	 /**
    		    	  * This statement would check if the card that the player enter is already
    		    	  * matched. If it is, It would ask the user to enter a different coordinate
    		    	  * for a card that doesn't match. It would go through the while loop until the 
    		    	  * player enter a coordinate that isn't matched. 
    		    	  */
    	   	    		 if(b1.getCard(x1-1, y1-1).status() == true) {
    	   	    			 while(move == false) {   	   	   	 	    	 
    	   	   	 	    			 System.out.print("That is already match. Enter a valid number for x for the first card: ");
    	   	   	 	    			 x1 = check(b1);
    	   	   	 	    		if(x1 == -1) {
    	   	   		    		 break;
    	   	   		    	 }
    		   		    	    	   	 	
    	   	   		   System.out.print("Enter a valid number for y for the first card: ");
    	   	   		      y1 = check(b1); 
    	   	   		    if(y1 == -1) {
    		    		 break;
    		    	 }    	   	   	 	    	 
    	   	   	 	    	 if(b1.getCard(x1-1, y1-1).status() == false) {
    		    					 move = true;   		 	    	    	
    		 	    		 }   	   	   	 	    	 
    	   	    		 }    	   	    		 
    	   	    		 }	 
    	   	    		 
    	   	    		 /**
    	   	    		  * resets the value of move to false 
    	   	    		  */
    	   	    		 move = false;
    	   	    		 
    		    	 word1 = b1.getCard(x1-1, y1-1).name();
    		    	 b1.getCard(x1-1, y1-1).flipped();
    		    	   		    	 
    		    	 buildBoard2(b1, p1, a1);
    			    
    			    /**
    			     * Ask the user for the x coordinate for the second card and would call
    			     * the check method to see if the answer the person entered is valid
    			     */
    			    System.out.print("Enter a x for the second card: ");
    			    x2 = check(b1);
    			    if(x2 == -1) {
    			    	break;
    			    }
    		    		 
    		    	 /**
    		    	  * Ask for the y coordinate for the second card and would call the check
    		    	  * if the answer the person entered is valid. End the while loop if the person
    		    	  * entered "q".
    		    	  */
    		    	 System.out.print("Enter a y for the second card: ");
    	             y2 = check(b1);
    	             if(y2 == -1) {
    	            	 break;
    	             }
    		    	 
    		    		/**
    		    		 * If the two card is already matched this will be called and would keep 
    		    		 * repeating until the user enter a coordinate that not been matched yet.
    		    		 */
    		    		 if(b1.getCard(x2-1, y2-1).status() == true || sameCard(x1,x2,y1,y2) == true) {
    	   	    			 while(move == false || sameCard(x1,x2,y1,y2) == true) {
    	   	    				 
    	   	    	 System.out.println();
    	   	   	 	 System.out.print("That card already matched or you already called it or the same card. Enter a card an x for the second card . Enter q if you want to quit: ");
    	   	   	 	  x2 = check(b1);
    	   	   	 	  if(x2 == -1) {
    	   	   	 		  break;
    	   	   	 	  }
    	     	 
    	   	   	 	    	 
    	   	   	 	    	 System.out.print("Enter a y for the second card: ");
    	   	   	 	     y2 = check(b1);
    	   	   	 	     if(y2 == -1) {
    	   	   	 	    	 break;
    	   	   	 	     }
    	 	    	 
    	 	    	   	   	 	

    	   	   	 	    	if(b1.getCard(x2-1, y2-1).status() == false) {
    		    					 move = true;   		 	    	    	
    		 	    		 }    	   	    	      
    	   	    		 }
    	   	    		 }
    		    		    	   	    		 
    	   	    		 move = false;
    	   	    		
    	   	    		 /**
    	   	    		  * Gets the name of the card to be compared with the first card
    	   	    		  * Flips the card to reveal the name of the card to the user.
    	   	    		  */
    		    	 word2 = b1.getCard(x2-1, y2-1).name();
    		    	 b1.getCard(x2-1, y2-1).flipped();
    		    	 
    		    	 buildBoard2(b1, p1, a1);
    		    	 
    		    	 }
    		    	
    		    	
    		    	 /**
    			         * If the real person match the two cards. It would add one
    			         * to score and would call the method matchCard for both card to true,
    			         * so the user and the AI could not call the card again.
    			         */
    		         
     		        if(word1.equals(word2) == true && playerTurn == true){
     		        	result = "You have a match P1";
     			    	p1.addScore();
     			    	b1.getCard(x1-1, y1-1).matchCard();
     			    	b1.getCard(x2-1, y2-1).matchCard();    			    	   			    	
     			    }
     		        
     		        /**
     		         * If AI match two cards. It would add one to AI score and 
     		         * would call the method matchCard for both card to true,
     		         * so the user and AI couldnt call the card again
     		         */
     		        else if(word1.equals(word2) == true && playerTurn == false){
     		        	result = "AI got a match";
     			    	a1.addScore();
     			    	b1.getCard(x1, y1).matchCard();
     			    	b1.getCard(x2, y2).matchCard();    			    	   			    	
     			    }	
     		        
     		        else {
     		        
     		        	/**
     		        	 * If the card don't matched and playerTurn is true,
     		        	 * it will flipped both card to face down and would switch playerTurn to false
     		        	 * which will be AI turn
     		        	 */
    		        	if(playerTurn == true){
    		        	b1.getCard(x1-1, y1-1).flipped();
    			    	b1.getCard(x2-1, y2-1).flipped();
    			    		result = "You didn't match Player 1. It's AI turn";
    			    		playerTurn = false;
    		        	}
    		        	
    		        	/**
    		        	 * IF the card don't matched and playerTurn is false,
    		        	 * it will flip both card to face down and would switch playerTurn to true
    		        	 * which will be Player turn 
    		        	 */
    		        	else{
    			    		b1.getCard(x1, y1).flipped();
        			    	b1.getCard(x2, y2).flipped();
    			    		result = "AI didn't get a match, your turn P1";
    			    		playerTurn = true;
    			    	}
    			        	
     		        }
     		        
    			}
    			
    					buildBoard2(b1, p1, a1);
   			 System.out.println();
   		     
   		     /**
   		      * This statement would displays if AI or Player wins, else if they both have the same amount than it will call
   		      * the tie statement.
   		      * 
   		      */
   			 if(p1.getScore() > a1.getScore()) {
   		     System.out.print("Game Over. P1 wins with " + (p1.getScore()) + " matches. Do you want to play again (Yes/No): ");
   		     decide = kb.next();
   			 }    			 
   			 else if(p1.getScore() < a1.getScore()){
   				 System.out.print("Game Over. AI wins with " + (p2.getScore()) + " matches. Do you want to play again (Yes/No): ");
       		     decide = kb.next();
   			 }
   			 
   			 else {
   				 System.out.print("Game Over. It's a tie. Do you want to play again (Yes/No): ");
   				 decide = kb.next();
   			 }
   		     /**
   		      * checks if the user types Yes or No. If not, it will ask the user again until the 
   		      * user type something that is yes or no
   		      */
   		     while(p1.playAgain(decide) == false)  {
   		    	 System.out.print("I didn't get that. Do you want to play again (Yes/No): ");
   		    	 decide = kb.next();
   	    	 }
   		     /**
   		      * If the players types no, It would end the while and would print the statment
   		      * "Game Over" 
   		      */
   		     if(decide.equalsIgnoreCase("No") ) {
   		    	 play = false;
   		     }
   		     /**
   		      * If the player types yes, the game would randomize the board 
   		      * and would flip all the cards that are flipped back to false
   		      */
   		     if(decide.equalsIgnoreCase("yes")) {
   		    	 for(int i = 0; i < card1.length;i++ ) {
   		    		 if(card1[i].isFlip() == true) {
   		    			 card1[i].flipped();
   		    			 card1[i].reset();
   		    		 }
   		    	 }
   		     }
    		
    		}
	
    			/**
    			 * End of Player vs AI
    			 */
    			
    			/**
    			 * Start of AI vs AI
    			 */
    			
    			if(pick == 4) {
    				
    				/**
    				 * Ask user for a number, the number the user puts in will
    				 * run the game many time for AI vs AI
    				 */
    				System.out.print("Enter the amount of times you want the AI to go against each other or q to quit: ");
    				int num = check();
    				if(num == -1) {
    					break;
    				}
    				
    			
    				//number for first game
    				int start = 1;
    				
    				/**
    				 * Will keep being called until start is 
    				 * greater than num
    				 */
    				while(start <= num) {
    					
    					/**
    					 * resets the board every time it goes
    					 *  to the next test
    					 */
    					 Board mixedAI = new Board(card1);
    					 
    					/**
    					 * resets both AI for every test
    					 */
    					 a1.reset();
 				    	 a2.reset();
 				    	 
 				    	 /**
 				    	  * resets the turn false so first player 
 				    	  * will always start first 
 				    	  */
 				    	 turn = false;
 				    	 
 				    	 /**
 				    	  * keeps going until all card are matched
 				    	  */
    					while(mixedAI.checkAll() == false) {
    						/**
    						 * If turn is false a1 is called
    						 * otherwise a2 is called
    						 */
    						if(turn == false) {
    	    		    		 x1 = a1.getX();
    	    		    		 y1 = a1.getY();
    						}
    						else {
    							x1 =a2.getX();
    							y1 = a2.getY();
    						}
    	    		    		 
    									/**
    									 * checks if the card AI picked is matched or not 
    									 */
    	    		    			 if( mixedAI.getCard(x1, y1).status() == true) {
    	    		    				 while(move == false) {
    	    		    					 if(turn == false) {
    	    	    	    		    		 x1 = a1.getX();
    	    	    	    		    		 y1 = a1.getY();
    	    	    						}
    	    	    						else {
    	    	    							x1 =a2.getX();
    	    	    							y1 = a2.getY();
    	    	    						}
    	    		    				 if(mixedAI.getCard(x1, y1).status() == false) {
    	    		    					 move = true;
    	    		    				 }
    	    		    			 }
    	    		    			 
    	    		    		 }
    	    		    		 
    	    		    		 move = false;
    	    		    		 
    	    		    		 /**
    	    		    		  * Gets the word for AI and flips it 
    	    		    		  */
    	    		    		 word1 = mixedAI.getCard(x1, y1).name();
    	    		    		 mixedAI.getCard(x1, y1).flipped();
    	    		    		 
    	    		    		
    	    		    		 if(turn == false) {
        	    		    		 x2 = a1.getX();
        	    		    		 y2 = a1.getY();
        						}
        						else {
        							x2 =a2.getX();
        							y2 = a2.getY();
        						}
    	    		    		 
    	    		    		 /**
    	    		    		  * Checks if second card is match or not
    	    		    		  */
    	    		    			 if(mixedAI.getCard(x2, y2).status() == true || sameCard(x1,x2,y1,y2) == true) {
    	    		    				 while(move == false) {
    	    		    					 if(turn == false) {
    	            	    		    		 x2 = a1.getX();
    	            	    		    		 y2 = a1.getY();
    	            						}
    	            						else {
    	            							x2 =a2.getX();
    	            							y2 = a2.getY();
    	            						}
    	    		    			 
    	    		    			 if(mixedAI.getCard(x2, y2).status() == false) {
    	    		    				 if(sameCard(x1,x2,y1,y2) == false) {
    	    		    				 
    	    		    				 move = true;
    	    		    				 }
    	    		    			 }
    	    		    		 }
    	    		    		 }
    	    		    		 
    	    		    		 move = false;
    	    		    		 
    	    		    		 /**
    	    		    		  * gets the second card name and flips it
    	    		    		  */
    	    		    		 word2 = mixedAI.getCard(x2, y2).name();
    	    		    		 mixedAI.getCard(x2, y2).flipped();
    	    		    		
    	    		    		 /**
    	    		    		  * If words matched and turn is false, 
    	    		    		  * first AI gets the points, otherwise 
    	    		    		  * if turn is true than second AI gets the 
    	    		    		  * point
    	    		    		  */
    					if(word1.equals(word2) == true && turn == false) {
    						a1.addScore();
    						mixedAI.getCard(x1, y1).matchCard();
        			    	mixedAI.getCard(x2, y2).matchCard();   
    					}
    					else if(word1.equals(word2) == true && turn == true) {
    						a2.addScore();
    						mixedAI.getCard(x1, y1).matchCard();
        			    	mixedAI.getCard(x2, y2).matchCard();   
    					}
    					
    					/**
    					 * If the word is wrong and turn is false,
    					 * it switches to second AI and flips the first and second back
    					 * 
    					 * If turn is true than switches back to first AI
    					 * and flips the first and second card back
    					 */
    					else {
    						if(turn == false) {
    							turn = true;
    							 mixedAI.getCard(x1, y1).flipped();
    							 mixedAI.getCard(x2, y2).flipped();
    						}
    						else {
    							turn = false;
    							 mixedAI.getCard(x1, y1).flipped();
    							 mixedAI.getCard(x2, y2).flipped();
    						}
    					}
    			
    				}
    					/**
    					 * total the difference between the score for the game
    					 */
    					int number = (a1.getScore() - a2.getScore());
    					
    					System.out.println("Test " + start + ":" + number);
    					
    					/**
    					 * Check where number should be added 
    					 */
    						if(number == -8) {
    							neight++;
    						}
    						if(number == -7) {
    							nsev++;
    						}
    						if(number == -6) {
    							nsix++;
    						}
    						if(number == -5) {
    							nfive++;
    						}
    						if(number == -4) {
    							nfour++;
    						}
    						if(number == -3) {
    							nthree++;
    						}
    						if(number == -2) {
    							ntwo++;
    						}
    						if(number == -1) {
    							none++;
    						}
    						if(number == 0) {
    							zero++;
    						}
    						if(number == 1) {
    							one++;
    						}
    						if(number == 2) {
    							two++;
    						}
    						if(number == 3) {
    							three++;
    						}
    						if(number == 4) {
    							four++;
    						}
    						if(number == 5) {
    							five++;
    						}
    						if(number == 6) {
    							six++;
    						}
    						if(number == 7) {
    							sev++;
    						}
    						if(number == 8) {
    							eight++;
    						}
    					   				
    						/**
    						 * Resets the board
    						 */
    				    	 for(int r = 0; r < card1.length;r++ ) {
    				    		 if(card1[r].isFlip() == true) {
    				    			 card1[r].flipped();
    				    			 card1[r].reset();
    				    		 }
    				    	 }
    				    	 start++;
    					}
    				
    				/**
    				 * add all the variable from -8 to 8 into the count ArrayList 
    				 */
    				count.add(neight);
    				count.add(nsev);
    				count.add(nsix);
    				count.add(nfive);
    				count.add(nfour);
    				count.add(nthree);
    				count.add(ntwo);
    				count.add(none);
    				count.add(zero);
    				count.add(one);
    				count.add(two);
    				count.add(three);
    				count.add(four);
    				count.add(five);
    				count.add(six);
    				count.add(sev);
    				count.add(eight);
    				
    				makeTable(count, num);
    				
    				System.out.println();
    				System.out.print("That the result for AI vs AI. Do you want to play again: ");
    				decide = kb.nextLine();
    				
    				 while(p1.playAgain(decide) == false)  {
    	   		    	 System.out.print("I didn't get that. Do you want to play again (Yes/No): ");
    	   		    	 decide = kb.next();
    	   	    	 }
    				
    				if(decide.equalsIgnoreCase("No") ) {
    	   		    	 play = false;
    	   		     }

     }
    	/**
    	 * End of AI vs AI 		
    	 */
    			
   }
	
    	 /**
	      * displays this if the player doesn't want to play anymore or entered "no"
	      * instead of "yes"
	      */
    	 System.out.println("Game Over. Have a nice day");
  	 
    	 
 }
	
/**
 * End of the game method
 */
	
	
	
	/**
	   * 
	   * @return -1 if the person types in "q" into the statement 
	   * @return the number for row or col when the user types in a number that are displayed
	   * in the board
	   * 
	   * If the user types something other than that, It would display a message and would
	   * keep asking the user to type something in that is valid.
	   */
	public int check(Board b1) {
		numCheck = 0;
				do {
					try {
						//Gets the input from the user
						 String test = kb.next();					
						 //checks if the user enter q, if not, it would converted it to an int
						if(test.contentEquals("q"))
							return -1;
						numCheck = Integer.parseInt(test);
					}
					//catches if the user entered something that will cause an error to the program
					catch(NumberFormatException e){
						System.out.println("That's not a valid answer");
					}
					//checks if the user enter something that is display on the board.
					if(numCheck < 1 || numCheck > b1.row()) {
						System.out.print("Please enter a number that display on the board or enter q to quit: ");
					}
					
					}
				   while(numCheck < 1 || numCheck > b1.row());
				   return numCheck;
	}
	
	/**
	 * checks if the number that the user enter for mode is valid
	 * @param num
	 * @return int of mode
	 */
	public int checkNum(String num) {
		int result;
		if(num.equals("1") || num.equals("2") || num.equals("3") || num.equals("4")) {
			result = Integer.parseInt(num);
		}
		else {
			result = -1;
		}
		return result;
	}
	
	
	/**
	 * Checks if the user enter a valid number that is greater than 0 or not a string.
	 * @return integer for number of test 
	 */
	public int check() {
		numCheck = 0;
				do {
					try {
						//Gets the input from the user
						 String test = kb.next();					
						 //checks if the user enter q, if not, it would converted it to an int
						if(test.contentEquals("q"))
							return -1;
						numCheck = Integer.parseInt(test);
					}
					//catches if the user entered something that will cause an error to the program
					catch(NumberFormatException e){
						System.out.println("That's not a valid answer");
					}
					//checks if the user enter something that is display on the board.
					if(numCheck < 1) {
						System.out.print("Please enter a number greater than 0 or enter q to quit: ");
					}
					
					}
				   while(numCheck < 1);
				   return numCheck;
	}
	
	
	/**
	 * 
	 * @param args calls the start method which will start the game
	 */
	public static void main(String[] args) {
		Game g1 = new Game();
		g1.start();
	}
	
	/**
	 * C=
	 * @param x1
	 * @param x2
	 * @param y1
	 * @param y2
	 * @return the boolean if the card is the same
	 */
	public boolean sameCard(int x1, int x2, int y1, int y2) {
		if((x1 == x2) && (y1 == y2))
			return true;
		return false;
	}

}   	 
	
	
	     
 	 
	

	
    	 
