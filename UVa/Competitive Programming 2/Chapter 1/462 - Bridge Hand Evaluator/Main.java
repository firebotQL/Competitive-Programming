import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;
import java.lang.Character;
import java.lang.Integer;

public class Main {
	static Map<Character, Integer> suitsCount = new HashMap<Character, Integer>();	
	static Map<Character, String> cardsToSuits = new HashMap<Character, String>();
	static char bidSuit = ' ';			
	static public void fillStuff() {
		suitsCount.put('S', 0);
		suitsCount.put('H', 0);
		suitsCount.put('D', 0);
		suitsCount.put('C', 0);
		cardsToSuits.put('A', "");
		cardsToSuits.put('K', "");
		cardsToSuits.put('Q', "");
		cardsToSuits.put('J', "");
		cardsToSuits.put('T', "");
		cardsToSuits.put('9', "");
		cardsToSuits.put('8', "");
		cardsToSuits.put('7', "");
		cardsToSuits.put('6', "");
		cardsToSuits.put('5', "");
		cardsToSuits.put('4', "");
		cardsToSuits.put('3', "");
		cardsToSuits.put('2', "");
	}
	
	static public void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 
		String line = null;
		while((line = reader.readLine()) != null) {
			fillStuff();
			indexCardsAndSuits(line);
			assestment();
		}
	}

	// If the hand evaluates to fewer than 14 points, then the player must pass.
	// One may open bidding in a suit if the hand evaluates to 14 or more points. 
	// Bidding is always opened in one of the suits with the most cards.
	// One may open bidding in ``no trump'' if the hand evaluates to 16 or more points ignoring
	// rules 5, 6, and 7 and if all four suits are stopped. A no trump bid is always preferred 
	// over a suit bid when both are possible.
	static void assestment() {
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
		for(int i = 0; i < line.length(); ++i) {
			// Mapping card to suits
			if (i % 3 == 0) {
				card = line.charAt(i);
				suits = cardsToSuits.get(card);
				cardsToSuits.put(card, suits + line.charAt(i+1));						
			} else if(i % 3 == 1) { // Calculating suits
				suit = line.charAt(i);
				count = suitsCount.get(suit);
				suitsCount.put(suit, ++count);
			}
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
				suitsCount.get(kingSuit) > 1) {
				stoppedCards += kingSuit;
			}
		}
		for(int i = 0; i < queenSuits.length() && stoppedCards.length() != 4; ++i) {
			char queenSuit = queenSuits.charAt(i);
			if (stoppedCards.indexOf(queenSuit) == -1 &&
				suitsCount.get(queenSuit) > 2) {
				stoppedCards += queenSuit;
			}
		}
		return stoppedCards.length() == 4;
	}	
	
	// Each ace counts 4 points. Each king counts 3 points. Each queen counts 2 points. Each jack counts one point.
	static int addCardPoints() {	
		int points = 0;
		points += 4 * cardsToSuits.get('A').length();
		points += 3 * cardsToSuits.get('K').length();
		points += 2 * cardsToSuits.get('Q').length();
		points += 1 * cardsToSuits.get('J').length();
		return points;
	}

	// Add a point for each suit in which the hand contains exactly two cards.
	// Add two points for each suit in which the hand contains exactly one card.
	// Add two points for each suit in which the hand contains no cards.
	static int addSuitPoints() {
		int points = 0;
		int max = -1;
		int count = 0;
		for(Map.Entry<Character, Integer> entry : suitsCount.entrySet()) {
			count = entry.getValue();
			if (count > max) {
				max = count;
				bidSuit = entry.getKey();
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
			count = suitsCount.get(suits.charAt(i))-1;
			if (count <= maxHold) 
				points -= 1;				
		}
		return points;	
	}
	
			
}
