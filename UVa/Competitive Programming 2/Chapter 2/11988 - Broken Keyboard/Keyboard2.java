import java.util.*;
import java.io.*;

class Keyboard2 {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line, subline;
		ArrayDeque<Character> list = new ArrayDeque<Character>();
		int i, idx;
		char prev, cur;
		long start = System.currentTimeMillis();
		while((line = reader.readLine()) != null) {
			list.clear();
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
					list.addLast(cur);
				} else {
					list.addFirst(cur);
				}				
			}
			while(list.size() != 0)
				System.out.print(c);
			System.out.println();
		}
		long end = System.currentTimeMillis();
		System.out.println(end-start + " ms.");
	}
}
