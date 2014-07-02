import java.util.*;
import java.io.*;

class Main {
	public static void addToList(int idx, int curidx, LinkedList<String> list, String line, char prev) {
		if (idx != curidx) {
			if (prev == ']') {
				list.addLast(line.substring(idx, curidx));
			} else {
				list.addFirst(line.substring(idx, curidx));
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
	
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line, subline;
		LinkedList<String> list = new LinkedList<String>();
		int i, idx;
		char prev;
		char[] result = new char[10000000];
		while((line = reader.readLine()) != null) {
			list.clear();
			prev = ' ';
			for(i = 0, idx = 0; i < line.length(); i++) {
				switch( line.charAt(i)) {
					case '[':
						addToList(idx, i, list, line, prev);
						idx = i+1;
						prev = '[';
						break;
					case ']':
						addToList(idx, i, list, line, prev);
						idx = i+1;
						prev = ']';
						break;
				}
			}
			
			if (idx != i) {
				addToList(idx, i, list, line, prev);
			}
			
			idx = 0;
			for(String str: list) {
				for(i = 0; i < str.length(); i++) {
					result[idx++] = str.charAt(i);
				} 
			}
			System.out.println(new String(result, 0, idx));
		}
	}
}
