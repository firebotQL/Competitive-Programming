import java.util.Scanner;
import java.io.IOException;
import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;

class Main {
	public static List circle = new ArrayList<Character>();

	public static int[] precalculated = new int[14];

	public static void resetCircle(int size) {
		circle.clear();
		int i = 0;
		for(i = 0; i < size; ++i) {
			circle.add(new Character('g'));
		}
		for(i = 0; i < size; ++i) {
			circle.add(new Character('b'));
		}
	}

	public static void precalculate() {
		int m, i;
		boolean found = false;
		for(int k = 1; k < 14; ++k) {
			m = 0;
			i = 0;
			found = false;
			do {
				resetCircle(k);
				found = true;
				i = 0;
				while (circle.size() != k) { 
					i += m;
					i %= circle.size();
					if ((Character)circle.get(i) == 'g') {
						found = false;
						break;
					} 
					circle.remove(i);					
				}			
				if (found) {
					precalculated[k] = m+1;
					break;
				}
			} while (m++ >= 0);
		}
	}

	public static void main(String[] args) throws IOException{
		Scanner scanner = new Scanner(System.in);
		int k, m, i;
		precalculate();
		while((k = scanner.nextInt()) != 0) {
			System.out.println(precalculated[k]);
		}
	}
}
