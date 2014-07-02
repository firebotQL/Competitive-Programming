import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.lang.Integer;
import java.lang.String;
import java.lang.Math;

class Main {
	private static int[] rootsTable = new int[10003];
	public static void generateRootsTable() {
		for(int i = 1; i <= 100; i++) {
			rootsTable[(int)Math.pow(i, 2)] = i;
		}
	}

	public static void main(String[] args) throws IOException {
		generateRootsTable();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.parseInt(reader.readLine());
		String substring = null;
		String line = null;
		int casee = 1, median, length, i, add;
		boolean equals, squared;
		while(casee <= cases) {
			System.out.println("Case #" + casee++ + ":");
			equals = true;
			line = reader.readLine();
			line = line.replaceAll("[^a-z]", "");
			length = line.length();

			squared = rootsTable[length] != 0;
			if (squared) {
				median = length/2;
				add = length % 2;

				substring = line.substring(0, median);				
				line = line.substring(median + add, line.length());

				for(i = 0; i < median; i++) {
					if (substring.charAt(i) != line.charAt(median-1-i)) {
						equals = false;
						break;
					}
				}
			} 

			if (equals && squared) {
				System.out.println(rootsTable[length]);
			} else {
				System.out.println("No magic :(");
			}
		}
	}
}
