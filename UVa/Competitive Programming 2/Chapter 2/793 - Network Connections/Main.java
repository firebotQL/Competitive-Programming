import java.util.*;
import java.io.*;

class Main {
		public static int[] pcSet;
		
		public static void initSet(int number) {
			pcSet = new int[number+1];
			for(int i = 1; i <= number; i++) {
				pcSet[i] = i;
			}
		}
		
		public static boolean isSameSet(int i, int j) {
			return findSet(i) == findSet(j);
		}
		
		public static int findSet(int i) {
			return (pcSet[i] == i) ? i : (pcSet[i] = findSet(pcSet[i]));
		}
		
		public static void unionSet(int i, int j) {
			pcSet[findSet(i)] = findSet(j);
		}
		
		public static void main(String[] args) throws IOException {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			String line = reader.readLine();
			int n1, n2;
			int number = Integer.parseInt(line);
			reader.readLine();	// skips empty line
			while((line = reader.readLine()) != null) {				
				initSet(Integer.parseInt(line));
				n1 = n2 = 0;
				while((line = reader.readLine()) != null && !line.isEmpty()) {
					StringTokenizer token = new StringTokenizer(line);
					switch(token.nextToken().charAt(0)) {
						case 'c':
							unionSet(Integer.parseInt(token.nextToken()), Integer.parseInt(token.nextToken()));
							break;
						case 'q':
							if (isSameSet(Integer.parseInt(token.nextToken()), Integer.parseInt(token.nextToken()))) {
								n1++;
							} else {
								n2++;
							}
							break;
					}
				}
				System.out.println(n1 + "," + n2);
				if (--number != 0) {
					System.out.println();
				}
			}
		}
}