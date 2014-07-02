import java.util.ArrayList;

public class Generator {
	static ArrayList<Character> suits = new ArrayList<Character>();	
	static ArrayList<Character> cards = new ArrayList<Character>();
	static char bidSuit = 'S';			
	static public void fillStuff() {
		suits.put('S');
		suits.put('H');
		suits.put('D');
		suits.put('C');
		cards.put('A');
		cards.put('K');
		cards.put('Q');
		cards.put('J');
		cards.put('T');
		cards.put('9');
		cards.put('8');
		cards.put('7');
		cards.put('6');
		cards.put('5');
		cards.put('4');
		cards.put('3');
		cards.put('2');
	}

	static public void main(String[] args) {
		BufferedWriter writer = new BufferedWriter(new FileWriter("test2.in"));
		fillStuff();
		for(int i = 0; i < cards.length(); ++i) {
			
		}
	}
}
