import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.lang.Integer;
import java.util.Iterator;
import java.lang.NumberFormatException;

public class Main {
	public static String[] suits = new String[] { "Clubs", "Diamonds", "Hearts", "Spades" };
	public static String[] values = new String[] { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" };

	public static List<String> generateCardDeck() {
		List<String> deck = new ArrayList<String>();
		for(int i = 0; i < suits.length; ++i) {
			for(int j = 0; j < values.length; ++j) {
				deck.add(values[j] + " of " + suits[i]);
			}
		}
		return deck;
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		List<String> defaultDeck = generateCardDeck();	
		List<String> deck = null;
		List<String> newDeck = new LinkedList<String>();
		List<List<Integer>> shuffles = new ArrayList<List<Integer>>();
		List<Integer> currentShuffle = null;
		int shufflesNr = 0;
		int k = 0;
		String line = null;
		while(testCases-- != 0) {
			shufflesNr = in.nextInt();
			while(shufflesNr-- != 0) {
				currentShuffle = new ArrayList<Integer>();
				for(int i = 0; i < 52; ++i) {
					currentShuffle.add(in.nextInt()-1);
				}
				shuffles.add(currentShuffle);
			}
			
			k = 0;
			deck = defaultDeck;

			in.nextLine();
			while(in.hasNextLine() && 
				!(line = in.nextLine()).isEmpty()) {
				k = Integer.parseInt(line);
				currentShuffle = shuffles.get(k-1);

				for(int i = 0; i < 52; ++i) {
					newDeck.add(deck.get(currentShuffle.get(i)));
				}

				deck = new ArrayList<String>();
				deck.addAll(newDeck);	
				newDeck.clear();
			}

			shuffles.clear();
			for(String card : deck) {
					System.out.println(card);
			} 
			
			if (testCases != 0)
				System.out.println();
		}
		
	}
	
}
