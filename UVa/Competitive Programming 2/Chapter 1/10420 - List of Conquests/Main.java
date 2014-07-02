import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.FileReader;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.Iterator;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line = reader.readLine();
		int LineNumber = Integer.valueOf(line.trim());
		SortedMap<String, Integer> gioLoved = new TreeMap<String, Integer>();
		String REGEX_WHITESPACE = "\\s+";
		while(LineNumber-- != 0) {
			line = reader.readLine();
			String cleanLine = line.trim().replaceAll(REGEX_WHITESPACE, " ");
			String[] tokens = cleanLine.split(REGEX_WHITESPACE);
			if (gioLoved.containsKey(tokens[0]))
				gioLoved.put(tokens[0], gioLoved.get(tokens[0]) + 1); 
			else
				gioLoved.put(tokens[0], 1);
		}
		Iterator iter = gioLoved.entrySet().iterator();
		while(iter.hasNext()) {
			SortedMap.Entry pairs = (SortedMap.Entry)iter.next();
			System.out.println(pairs.getKey() + " " + pairs.getValue());
		}
	}
}
