import java.util.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line, subline;
		LinkedList<Character> list = new LinkedList<Character>();
		int i, idx;
		char ch;
		long start = System.currentTimeMillis();
		while((line = reader.readLine()) != null) {
			list.clear();
			for(i = 0, idx = 0; i < line.length(); i++) {
				ch = line.charAt(i);
				switch(ch) {
					case '[':
						idx = 0;
						continue;
					case ']':
						idx = list.size();
						continue;
				}
				list.add(idx++, ch);
			}
			for(Character c: list)
				System.out.print(c);
			System.out.println();
		}
		long end = System.currentTimeMillis();
		System.out.println("Execution time was" + (end - start) + " ms.");
	}
}