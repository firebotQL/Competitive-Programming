import java.util.*;
import java.io.*;

// Probably to optimize:
//		1. need to buffer result and then printitout in the end :)
//		2. need to create hashmap with proper size so its doesnt resize and remap values when its full
class Main {
	public static Map<String, String> parent = new HashMap<String, String>();
	public static Map<String, Integer> rank = new HashMap<String, Integer>();

	public static void union(String key1, String key2) {
		String parentKey1 = find(key1);
		String parentKey2 = find(key2);
		
		if (parentKey1 == parentKey2) {
			printRank(parentKey1);
			return;			
		}
		
		if (rank.get(parentKey1) > rank.get(parentKey2)) {
			setRanks(parentKey1, parentKey2);
		} else {
			setRanks(parentKey2, parentKey1);
		} 		
	}
	
	public static void setRanks(String parentKey1, String parentKey2) {
		parent.put(parentKey2, parentKey1);
		rank.put(parentKey1, rank.get(parentKey1) + rank.get(parentKey2));
		printRank(parentKey1);
	}
	
	public static void printRank(String key) {
		System.out.println(rank.get(key));
	}
	
	public static String find(String key) {
		if (parent.get(key) != key)  {
			parent.put(key, find(parent.get(key)));
		}
		return parent.get(key);
	}
	
	public static void createSet(String key) {
		if (!parent.containsKey(key)) {
			parent.put(key, key);
			rank.put(key, 1);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(reader.readLine());
		int F;
		StringTokenizer tokenizer = null;
		String key1, key2;
		while(testCases-- != 0) {
			parent.clear();
			rank.clear();
			F = Integer.parseInt(reader.readLine());
			for(int i = 0; i < F; i++) {
				tokenizer = new StringTokenizer(reader.readLine());
				key1 = tokenizer.nextToken();
				key2 = tokenizer.nextToken();
				createSet(key1);
				createSet(key2);
				union(key1, key2);
				//System.out.println(rank.get(parent.get(key2)));
			}
		}
	}
}