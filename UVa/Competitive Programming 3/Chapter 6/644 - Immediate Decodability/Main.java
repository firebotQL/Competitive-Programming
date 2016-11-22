import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String record = null;
		List<String> group = new ArrayList<String>();
		boolean decodeable = true;
		int set = 1;
		while((record = reader.readLine()) != null) {
			if (record.equals("9")) {
				String result = "";
				if (!decodeable) {
					result = " not";
				}
				System.out.println(String.format("Set %d is%s immediately decodable", set++, result));
				decodeable = true;
				group = new ArrayList<String>();
			}
			if (decodeable) {
				for(String symbol : group) {
					if (symbol.startsWith(record) || record.startsWith(symbol)) {
						decodeable = false;
					}
				}
				group.add(record);
			}
			
		}
	}
}
