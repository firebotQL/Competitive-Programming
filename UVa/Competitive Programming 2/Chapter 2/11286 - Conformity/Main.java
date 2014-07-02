import java.util.*;
import java.io.*;

class Main {

	public static ArrayList<Integer> get(String line) {
		int pos = 0, end, i = 0;
		ArrayList<Integer> combination = new ArrayList<Integer>();
		while((end = line.indexOf(' ', pos)) >= 0) {
			combination.add(Integer.valueOf(line.substring(pos, end)));					
			pos = end + 1;
		}
		combination.add(Integer.valueOf(line.substring(pos, line.length())));
		return combination;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line, combination;
		int froshNr, i, j, max, stud = 0;
		Integer value = null, val = null;
		Map<String, Integer> map;
		ArrayList<Integer> combinations = null;
		while(!(line = reader.readLine()).equals("0")) {
			froshNr = Integer.valueOf(line);
			max = Integer.MIN_VALUE;
			map = new HashMap<String, Integer>();
			while(froshNr-- != 0) {
				line = reader.readLine();
				combinations = get(line);
				Collections.sort(combinations);
				line = "" + combinations.get(0) + combinations.get(1) 
							+  combinations.get(2) +  combinations.get(3) 
							+  combinations.get(4);
				value = (Integer)map.get(line);
				map.put(line, value == null ? 0 : ++value);
			}
			for(Integer count : map.values()) {
				if (count > max) {
					max = count;
				}
			}
			val = 0;
			if (max != 0) {
				for (Integer v : map.values()) {
					if (v == max) {
						val += max + 1;
					}
				}
			}
			System.out.println( max == 0 ? map.size() : val);
		}
	}
}