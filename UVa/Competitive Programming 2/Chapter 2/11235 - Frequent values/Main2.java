import java.util.*;
import java.io.*;

public class Main2 {
	public static int[] segmentTree = null;
	
	public static void buildSegmentTree(int[] a, int vertex, int L, int R) {
		if (L == R) {
			segmentTree[vertex] = L; 
		} else {
			int nL = 2 * vertex, nR = 2 * vertex + 1;
			buildSegmentTree(a, nL, L, (L + R) / 2);
			buildSegmentTree(a, nR, (L + R) / 2 + 1, R);
			int leftIndex = segmentTree[nL], rightIndex = segmentTree[nR];
			int leftValue = a[leftIndex], rightValue = a[rightIndex];
			segmentTree[vertex] = (leftValue >= rightValue) ? leftIndex : rightIndex;
		}
	}
	
	public static void createSegmentTree(int[] a) {
		int length = (int) (2 * Math.pow(2.0, Math.floor((Math.log((double)a.length) / Math.log(2.0)) + 1)));
		segmentTree = new int[length];
		for(int i = 0; i < length; i++) segmentTree[i] = 0;
		buildSegmentTree(a, 1, 0, (int)a.length-1);
	}
	
	public static int getRMQ(int[] a, int vertex, int L, int R, int i, int j) {
		if (i > R || j < L) return -1;
		if (L >= i && R <= j) return segmentTree[vertex];
		
		int p1 = getRMQ(a, 2 * vertex, L, (L + R) / 2, i, j);
		int p2 = getRMQ(a, 2 * vertex + 1, (L + R) / 2 + 1, R, i, j);
		
		if (p1 == -1) return p2;
		if (p2 == -1) return p1;
		
		return (a[p1] >= a[p2]) ? p1 : p2;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		int n, q, z, i , j, result;
		int[] a, a_real;
		Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();
		Map<Integer, Integer> endMap = new HashMap<Integer, Integer>();
		Map<Integer, Integer> startMap = new HashMap<Integer, Integer>();
		while((line = reader.readLine()) != null && line.charAt(0) != '0') {
			StringTokenizer st = new StringTokenizer(line);
			n = Integer.parseInt(st.nextToken());
			q = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(reader.readLine());
			a = new int[n];
			a_real = new int[n];
			z = 0;
			frequencyMap.clear();
			startMap.clear();
			endMap.clear();
			while(st.hasMoreTokens()) {
				a[z] = Integer.parseInt(st.nextToken());
				if (frequencyMap.containsKey(a[z])) {
					Integer value = frequencyMap.get(a[z]);
					frequencyMap.put(a[z], ++value);
				} else {
					frequencyMap.put(a[z], 1);
				}	
				
				if(!startMap.containsKey(a[z])) {
					startMap.put(a[z], z);
				}
				endMap.put(a[z], z);
				z++;
			}

			for(i = 0; i < a.length; i++) {
				a_real[i] = frequencyMap.get(a[i]);
			}
			
			createSegmentTree(a_real);
			StringBuffer buffer = new StringBuffer();
			while(q-- != 0) {
				st = new StringTokenizer(reader.readLine());
				i = Integer.parseInt(st.nextToken()) - 1;
				j = Integer.parseInt(st.nextToken()) - 1;
				result = 0;
				if (i == 0 && j == n - 1) {
					result = a_real[getRMQ(a_real, 1, 0, a_real.length-1, i, j)];
				} else if (a[i] == a[j]) {
					result = j - i + 1;
				} else {
					result = endMap.get(a[i]) - i + 1;
					result = Math.max(result, j - startMap.get(a[j]) + 1);
					i = endMap.get(a[i])+1;
					j = startMap.get(a[j])-1;
					if (i <= j) {
						result = Math.max(result, a_real[getRMQ(a_real, 1, 0, a_real.length-1, i, j)]);
					}

				}

				buffer.append(result).append("\n");
			}
			System.out.print(buffer.toString());			
		}
	}
}