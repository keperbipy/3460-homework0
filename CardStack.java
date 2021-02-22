/**
 *  This class contains a stack of cards (Strings).
 *
 */
public class CardStack {
	private String [] cards;	// Stack implemented as an array of Strings.
	private int top;		// accessing the top element of the stack.
	
	/* Constructor, to initialize a stack of 100 cards. */	
	public CardStack() {
		cards = new String[100];
		top = -1;
	}

	/* Push a card into the stack. You may assume that the stack size is not longer than 52. */
	public void pushCard(String card) {
		
		for(int i= 99-1; i >=0; i--) {
			cards[i+1] = cards[i];
		}
		cards[0] = card;
	}
	
	/* Pop and return the popped card from the stack. Return null if trying to pop from an empty stack. */
	public String popCard() {
		String poppedCard;
		poppedCard = cards[0];
		for (int i = 1; i < 99; i++) {
			cards[i-1] = cards[i];
		}
       return poppedCard; 
	}
	
	/* Get the top card. Return null if stack is empty. */
	public String getTopCard() {
        return cards[0];
	}
	
	/* Get the third card from the top. Return null if there are less than 3 cards in the stack. */
	public String getTop3Card() {
        if (cards.length < 3){
            return null;
        }
        else{
            return cards[2];
        }
	}

	/* Return the size of the stack. */
	public int size() {
		int counter = 0;
		for (int i = 0; i < 98; i++) {
			if(cards[i] != null)
				counter++;
		}
       return counter;       
	}
	
	/* Print the entire stack. */
	public void printCardStack() {  
        for(int i = 0; i < cards.length; i++){
            if (cards[i] != null) {
				System.out.print(" ");
				System.out.print(cards[i]);
			}
			
        }
        
	}
}
