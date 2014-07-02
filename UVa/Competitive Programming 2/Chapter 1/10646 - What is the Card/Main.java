import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.Integer;
import java.io.IOException;
import java.lang.Character;
import java.util.LinkedList;
import java.util.List;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.parseInt(reader.readLine());
		int y,x,i,j,z;
		List<String> tokens = null;
		char testChar = ' ';
		int size = 0;
		String line;
		for(i = 1; i <= cases; ++i) {
			line = reader.readLine();
			tokens = new LinkedList<String>(Arrays.asList(line.split(" ")));
			y = 0;
			for(j = 0; j < 3; ++j) {
				size = tokens.size() - 26;
				testChar = tokens.get(size).charAt(0);
				x = 10;
				if (Character.isDigit(testChar)) {
					x = Integer.parseInt(String.valueOf(testChar));
				}
				y += x;
				for(z = 0; z < 11-x; ++z) {
					tokens.remove(size-z);
				}
			}

			System.out.println("Case " + i + ": " + tokens.get(y-1));
		}
	}
}
