import java.lang.*;
import java.io.*;
import java.util.*;

class Main {

	static class Pair {
		int value, index;
		
		public Pair(int value, int index) {
			this.value = value;
			this.index = index;
		}
		
		public int getValue() {
			return value;
		}
		
		public int getIndex() {
			return index;
		}
		
		public void setValue(int value) {
			this.value = value;
		}
		
		public void setIndex(int index) {
			this.index = index;
		}
		
		public String toString() {
			return Integer.toString(value);
		}
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int m, n, r, i, j;
		Map<Integer, List<Pair>> adjacencyList = new HashMap<Integer, List<Pair>>();
		List<Integer> indexesList = new ArrayList<Integer>();
		while(scan.hasNextInt()) {
			m = scan.nextInt();
			n = scan.nextInt();
			for(i = 0; i < m; i++) {
				r = scan.nextInt();
				if (r != 0) {
					for(j = 0; j < r; j++) {
						indexesList.add(scan.nextInt());
					}
					List<Pair> adjacencyArray = null;
					for(j = 0; j < r; j++) {
						adjacencyArray = adjacencyList.get(indexesList.get(j));
						if (adjacencyArray == null) {
							adjacencyArray = new ArrayList<Pair>();
							adjacencyList.put(indexesList.get(j), adjacencyArray);
						}
						adjacencyArray.add( new Pair(scan.nextInt(),  i+1));	
					}
					indexesList.clear();
				}
			}
			
			System.out.println(n + " " + m);
			
			for(i = 0; i < n; i++) {
				List<Pair> adjacencyArray = adjacencyList.get(i+1);
				if (adjacencyArray != null) {
					System.out.print(adjacencyArray.size() + " ");
					
					for(j = 0; j < adjacencyArray.size(); j++) {
						System.out.print(adjacencyArray.get(j).getIndex());
						if (j+1 != adjacencyArray.size()) {
							System.out.print(" ");
						}
					}
					
					System.out.println();

					for(j = 0; j < adjacencyArray.size(); j++) {
						System.out.print(adjacencyArray.get(j).getValue());
						if (j+1 != adjacencyArray.size()) {
							System.out.print(" ");
						}
					}
					System.out.println();
				} else {
					System.out.println("0");
					System.out.println();
				}
			}
			adjacencyList.clear();
			
		}
	}
}