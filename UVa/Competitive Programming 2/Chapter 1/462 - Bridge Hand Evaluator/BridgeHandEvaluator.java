import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.lang.Character;
import java.lang.Integer;

public class Main {
	static final String defaultSuits = "SHDC";
	static final String defaultCards = "AKQJT98765432";
	static int[] suitCounter = new int[128];
	static int[] cardCounter = new int[128];
	static char bidSuit = ' ';			
	static public void resetContainers() {
		int i = 0;
		for(; i < defaultSuits.length(); i++) 
			suitCounter[defaultSuits.charAt(i)] = 0;
		for(i = 0; i < defaultCards.length(); i++) 
			cardCounter[defaultCards.charAt(i)] = 0;
	}
	
	static public void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 
		String line = null;
		while((line = reader.readLine()) != null) {
			resetContainers();
			indexCardsAndSuits(line);
			assessment();
		}
	}

	// If the hand evaluates to fewer than 14 points, then the player must pass.
	// One may open bidding in a suit if the hand evaluates to 14 or more points. 
	// Bidding is always opened in one of the suits with the most cards.
	// One may open bidding in ``no trump'' if the hand evaluates to 16 or more points ignoring
	// rules 5, 6, and 7 and if all four suits are stopped. A no trump bid is always preferred 
	// over a suit bid when both are possible.
	static void assessment() {
		int points = getPoints();
		if (points >= 16 && suitStopped()) {
			System.out.println("BID NO-TRUMP");
		} else {
			points += addSuitPoints();
			if (points >= 14) {
				System.out.println("BID " + bidSuit);				
			} else {
				System.out.println("PASS");
			}
		}
	}
	
	static int getPoints() {
		return addCardPoints() + substractPoints();
	}

	static void indexCardsAndSuits(String line) {
		int count = 0;
		char suit = ' ';
		char card = ' ';
		String suits = null;
		String[] cards = null;
		cards = line.split("\\s+");
		for(int i = 0; i < cards.length; i++) {
			card = cards[i].charAt(0);
			suit = cards[i].charAt(1);
			suits = cardCounter[card]++;
			suitCounter[suit]++;
		}
	}
	
	// A suit is stopped if it contains an ace, or if it contains a king and at least one other card,
	// or if it contains a queen and at least two other cards.
	static boolean suitStopped() {
		String aceSuits = cardsToSuits.get('A');	// Suit
		String kingSuits = cardsToSuits.get('K');  	// Suit and one other card
		String queenSuits = cardsToSuits.get('Q');	// Suit and two other cards
		String stoppedCards = "";

		stoppedCards += aceSuits;		
		
		for(int i = 0; i < kingSuits.length() && stoppedCards.length() != 4; ++i) {
			char kingSuit = kingSuits.charAt(i);
			if (stoppedCards.indexOf(kingSuit) == -1 &&
				suitCounter[kingSuit] > 1) {
				stoppedCards += kingSuit;
			}
		}
		for(int i = 0; i < queenSuits.length() && stoppedCards.length() != 4; ++i) {
			char queenSuit = queenSuits.charAt(i);
			if (stoppedCards.indexOf(queenSuit) == -1 &&
				suitCounter[queenSuit] > 2) {
				stoppedCards += queenSuit;
			}
		}
		return stoppedCards.length() == 4;
	}	
	
	// Each ace counts 4 points. Each king counts 3 points. Each queen counts 2 points. Each jack counts one point.
	static int addCardPoints() {	
		int points = 0;
		points += 4 * cardCounter['A'];
		points += 3 * cardCounter['K'];
		points += 2 * cardCounter['Q'];
		points += 1 * cardCounter['J'];
		return points;
	}

	// Add a point for each suit in which the hand contains exactly two cards.
	// Add two points for each suit in which the hand contains exactly one card.
	// Add two points for each suit in which the hand contains no cards.
	static int addSuitPoints() {
		int points = 0;
		int max = -1;
		int count = 0;
		char suit;
		for(int i = 0; i < defaultSuits.length(); i++) {
			suit = defaultSuits.charAt(i);
			count = suitCounter[suit];
			if (count > max) {
				max = count;
				bidSuit = suit;
			}
			
			if (count == 2) {				
				points += 1;
			} else if (count < 2) {
				points += 2;
			}
		}
		return points;
	}

	// Subtract a point for any king of a suit in which the hand holds no other cards.
	// Subtract a point for any queen in a suit in which the hand holds only zero or one other cards.
	// Subtract a point for any jack in a suit in which the hand holds only zero, one, or two other cards.
	static int substractPoints() {
		int points = 0;
		points += substractPointsFromCard('K', 0);
		points += substractPointsFromCard('Q', 1);		
		points += substractPointsFromCard('J', 2);
		return points;
	}

	static int substractPointsFromCard(char card, int maxHold) {
		String suits = cardsToSuits.get(card);		
		int points = 0;
		int count = 0;
		for(int i = 0; i < suits.length(); ++i) {
			count = suitCounter[suits.charAt(i)];
			if (count <= maxHold) 
				points -= 1;				
		}
		return points;	
	}
	
			
}
