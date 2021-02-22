/**
 * This class generates random
 */
 
import java.util.Scanner;

public class CardSolo {
	
	public static boolean matchCard (String cardA, String cardB) {
		
		if ( (cardA != cardB)&&(cardA != null && cardB != null)&&(cardA.charAt(0) == cardB.charAt(0) || cardA.charAt(1) == cardB.charAt(1))) {
			return true;
		}
		else
			return false;
	}
	
	public static void main(String [] args) {
		
		// Need 2 stacks.
		CardStack A = new CardStack();
		CardStack B = new CardStack();
	
		Scanner inputScanner = new Scanner(System.in);
        String inputCard;
		
		while (inputScanner.hasNext()) {
			inputCard = inputScanner.next();
            
			//start out the first card
			if (A.getTopCard() == null)
			{
				A.pushCard(inputCard);
			}
			//while matches are still available
			while (matchCard(A.getTop3Card(), inputCard) || matchCard(A.getTopCard(), inputCard)) {
				//check for 3rd card first
				if (matchCard(A.getTop3Card(), inputCard)) {
					
					B.pushCard(A.popCard());
					B.pushCard(A.popCard());
					A.popCard();
				}
				//otherwise its should be first card
				else if (matchCard(A.getTopCard(), inputCard)) {
					A.popCard();	
				}
			}
			//at the end, always put input card regardless of match or not
			B.pushCard(inputCard);
			//put the rest of the stack with the "computation" stack
			while (B.getTopCard() != null){
				A.pushCard(B.popCard());
			}
		}
		//puts the stack back in right order
		while (A.getTopCard() != null){
			B.pushCard(A.popCard());
		}

		System.out.print("Number of piles is " + B.size() + ":");
		B.printCardStack();
		System.out.println();
	}
}




