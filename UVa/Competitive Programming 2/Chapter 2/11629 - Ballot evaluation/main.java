import java.util.*;
import java.io.*;

class Main {

	public static ArrayList<String> get(String line) {
		int pos = 0, end;
		ArrayList<String> values = new ArrayList<String>();
		while((end = line.indexOf(' ', pos)) >= 0) {
			values.add(line.substring(pos, end));					
			pos = end + 1;
		}
		values.add(line.substring(pos, line.length()));
		return values;
	}
	
	public static boolean compareFunction(String value, int sum, int guess ) {
		if (value.equals("<")) {
			if (sum < guess) {
				 return true;
			}
		} else if (value.equals(">")) {
			if (sum > guess) {
				return true;
			}
		} else if (value.equals("<=")) {
			if (sum <= guess) {
				return true;
			}
		} else if (value.equals(">=")) {
			if (sum >= guess) {
					return true;
			}
		} else if (value.equals("=")) {
			if (sum == guess) {
					return true;
			}
		} 
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<String> values = get(reader.readLine());
		ArrayList<String> pLine;
		String gLine;
		Integer percentage, sum, guess;
		int p = Integer.valueOf(values.get(0));
		int g = Integer.valueOf(values.get(1));
		Map<String, Integer> map = new HashMap<String, Integer>();
		boolean result;
		while(p-- != 0) {
			pLine = get(reader.readLine());
			map.put(pLine.get(0), (int)(10*Double.valueOf(pLine.get(1))));
		}
		for(int i = 0; i < g; i++) {
			values = get(reader.readLine());
			sum = 0;
			result = false;
			for(String value : values) {
				if (!value.equals("+")) {
					percentage = map.get(value);
					if (percentage != null) {
						sum += percentage;
					} else {
						guess = 10*Integer.valueOf(values.get(values.size()-1));
						result = compareFunction(value, sum, guess);
						break;
					}
				}
			}
			if (result) {
				System.out.println("Guess #" + (i+1) + " was correct.");
			} else {
				System.out.println("Guess #" + (i+1) + " was incorrect.");
			}
			
		}
	}
}