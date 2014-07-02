import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	
	static int N, M;
	static String pair;
	static char one, two;
	static int years;
	static boolean found = false;
	static Map<Character, Node> awakeSet = new HashMap<Character, Node>();
	static Map<Character, Node> sleepSet = new HashMap<Character, Node>();
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static Map<Character, Node> awakingSet = new HashMap<Character, Node>();
	
	static class Node {
		Set<Character> adj = new HashSet<Character>();
	}

	public static void createAwakeNodes(String nodes) {
		for(int i = 0; i < nodes.length(); i++) {
			Node node = new Node();
			awakeSet.put(nodes.charAt(i), node);
		}
	}
	
	public static void addRelation(char letter1, char letter2) {
		Node node = null;
		if ((node = findSet(letter1)) == null) {
			node = createAsleepNodes(letter1);
		}
		node.adj.add(letter2);
	}
	
	public static Node createAsleepNodes(char letter1) {
		Node node = null;
		if ((node = sleepSet.get(letter1)) == null) {
			node = new Node();
			sleepSet.put(letter1, node);
		}		
		return node;
	}
	
	public static void readTestCase() throws IOException {
		N = Integer.parseInt(reader.readLine());
		M = Integer.parseInt(reader.readLine());
		
		createAwakeNodes(reader.readLine());

		while(M-- != 0) {
			pair = reader.readLine();
			one = pair.charAt(0);
			two = pair.charAt(1);
			addRelation(one, two);
			addRelation(two, one);
		}
	}
	
	public static void solve() {
		int count = 0;
		years = 0;
		found = true;
		while(found) {
			found = false;
			for(Map.Entry<Character, Node> entry : sleepSet.entrySet()) {
				Node node = entry.getValue();			
				Iterator it = node.adj.iterator();
				while (it.hasNext()) {
					Character letter = (Character)it.next();
					if (findSet(letter) != null) {
						count++;
					}
				}
				if (count >= 3) {
					awakingSet.put(entry.getKey(), node);
					found = true;
				}
				count = 0;
				
			}
			if (found) {
				years++;
				for(Map.Entry<Character, Node> entry : awakingSet.entrySet()) {					
					unionSet(entry.getKey(), entry.getValue());
				}
				awakingSet.clear();
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		do {	
			readTestCase();			
			solve();
			if (awakeSet.size() == N) {
				System.out.println("WAKE UP IN, " + years + ", YEARS");
			} else {
				System.out.println("THIS BRAIN NEVER WAKES UP");
			}
			sleepSet.clear();
			awakeSet.clear();
			awakingSet.clear();
		} while(reader.readLine() != null);
		
	}
	
	public static Node findSet(Character letter) {
		return awakeSet.get(letter);
	}
	
	public static void unionSet(Character letter, Node node) {
		awakeSet.put(letter, node);
		sleepSet.remove(letter);
	}
	
	public static void testPrintout(Map<Character, Node> anySet) {
		for(Map.Entry<Character, Node> entry : anySet.entrySet()) {
			System.out.println(entry.getKey() + "-" + entry.getValue().adj);
		}
	}
}