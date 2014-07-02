import java.util.*;
import java.io.*;

class Keyboard4 {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line, subline;
		LinkedList<Character> list = new LinkedList<Character>();
		int i, idx;
		char prev, cur;
		long start = System.currentTimeMillis();
		String result;
		
		while((line = reader.readLine()) != null) {
			list.clear();
			result = "";
			for(i = 0, idx = -1; i < line.length(); i++) {
				cur = line.charAt(i);
				if (cur == '[') {
					idx = 0;
					continue;
				} else if (cur == ']') {
					idx = -1;
					continue;
				}
				if (idx == -1) {
					list.add(list.size(), cur);
				} else {
					list.add(idx++, cur);
				}				
			}
			
			for(Character c : list) {
				result += c;
			}
			
			System.out.println(result);
		}
		long end = System.currentTimeMillis();
		System.out.println("Time: " + (end-start) + " ms.");
	}
}
