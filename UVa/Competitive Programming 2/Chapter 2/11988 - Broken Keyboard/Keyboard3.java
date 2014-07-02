import java.util.*;
import java.io.*;

class Keyboard3 {
	public static void addToList(int idx, LinkedList<String> list, String[] array, char prev) {
			if (prev == ']') {
				list.addLast(array[idx]);
			} else {
				list.addFirst(array[idx]);
			}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line, subline;
		LinkedList<String> list = new LinkedList<String>();
		String[] array;
		int i, idx;
		char prev;
		long start = System.currentTimeMillis();
		while((line = reader.readLine()) != null) {
			list.clear();
			prev = ' ';
			array = line.split("[]");
			for(i = 0, idx = 0; i < line.length(); i++) {
				switch( line.charAt(i)) {
					case '[':
						addToList(idx++,list, array, prev);
						prev = '[';
						break;
					case ']':
						addToList(idx++, list, array, prev);
						prev = ']';
						break;
				}
			}
			
			addToList(idx, list, array, prev);

			for(String c: list)
				System.out.print(c);
			System.out.println();
		}
		long end = System.currentTimeMillis();
		System.out.println("Time: " + (end-start) + " ms.");
	}
}