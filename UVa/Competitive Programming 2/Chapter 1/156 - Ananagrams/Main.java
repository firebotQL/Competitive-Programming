import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;
import java.io.IOException;
import java.util.Collections;
import java.util.Arrays;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] lineWords = null;
		String line = null;
		int i = 0;
		int j = 0;
		String hash = "#";
		List wordsList = new ArrayList<String>();
		while((line = reader.readLine()) != null 
			&& line.compareTo(hash) != 0) {
			lineWords = line.trim().split("\\s+");
			for(i = 0; i < lineWords.length; i++) {	
				wordsList.add(lineWords[i]);	
			}		
		}
		char[] one, two;
		boolean found = false;		
		for(i = 0; i < wordsList.size(); i++) {
			one = ((String)wordsList.get(i)).toLowerCase().toCharArray();
			Arrays.sort(one);
			found = false;
			for(j = i+1; j < wordsList.size(); j++) {
				two = ((String)wordsList.get(j)).toLowerCase().toCharArray();
				Arrays.sort(two);
				if(Arrays.equals(one, two)) {
					found = true;
					wordsList.remove(j);
				}
			}
			if (found) 
				wordsList.remove(i--);
		}

		Collections.sort(wordsList);
		for(i = 0; i < wordsList.size(); i++) {
			System.out.println(wordsList.get(i));
		} 
	} 
}
