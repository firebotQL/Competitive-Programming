import java.util.*;
import java.io.*;

class Main {
	public static class Friend {
		Integer networkSum = 1;
		Friend parent = null;
	}
	
	public static void printMap(Map<String, Friend> set) {
		for(Map.Entry<String, Friend> entry : set.entrySet()) {
			System.out.print(entry.getKey() + "=" + entry.getValue().parent.networkSum + " ");
		}
		System.out.println();
	}
	
	public static int union(Map<String, Friend> set, String key1, String key2) {
		Friend friend1 = null, friend2 = null;
		
		friend1 = set.get(key1);
		if (friend1 == null) {
			friend1 = new Friend();
			friend1.parent = friend1;
			set.put(key1, friend1);
		}
		
		friend2 = set.get(key2);
		if (friend2 == null) {
			friend2 = new Friend();
			friend2.parent = friend2;
			set.put(key2, friend2);
		}
		
		if (friend1.parent != friend2.parent) {			
			friend1.parent.networkSum += friend2.parent.networkSum;
			friend2.parent = friend1.parent;
		}
		System.out.println("Key1: " + key1 + " Key2: " + key2);
		printMap(set);
		return friend1.parent.networkSum;				
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(reader.readLine());
		int F;
		StringTokenizer tokenizer = null;
		Map<String, Friend> set = new HashMap<String, Friend>();
		while(testCases-- != 0) {
			F = Integer.parseInt(reader.readLine());
			for(int i = 0; i < F; i++) {
				tokenizer = new StringTokenizer(reader.readLine());
				System.out.println(union(set, tokenizer.nextToken(), tokenizer.nextToken()));	
			}
			reader.readLine();
		}
	}
}