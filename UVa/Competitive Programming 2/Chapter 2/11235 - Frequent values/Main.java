import java.util.*;
import java.io.*;

public class Main {
	public static int[] segmentTree = null;
	
	public static void buildSegmentTree(int[] a, int vertex, int L, int R) {
		System.out.println("bst (v="+vertex+",L="+L+",R="+R);
		if (L == R) {
			segmentTree[vertex] = L; 
		} else {
			int nL = 2 * vertex, nR = 2 * vertex + 1;
			System.out.println("nL = " + nL + "   nR=" + nR);
			buildSegmentTree(a, nL, L, (L + R) / 2);
			buildSegmentTree(a, nR, (L + R) / 2 + 1, R);
			int leftIndex = segmentTree[nL], rightIndex = segmentTree[nR];
			int leftValue = a[leftIndex], rightValue = a[rightIndex];
			segmentTree[vertex] = (leftValue <= rightValue) ? rightIndex : leftIndex;
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
		
		return (a[p1] <= a[p2]) ? p2 : p1;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		int n, q, z, i , j, subi, subj, comp, subRMQleft, subRMQright, tmp;
		int[] a, a_real;
		Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
		Map<Integer, Integer> endsMap = new HashMap<Integer, Integer>();
		Map<Integer, Integer> startMap = new HashMap<Integer, Integer>();
		//long startTime = System.nanoTime();
		while((line = reader.readLine()) != null && line.charAt(0) != '0') {
			StringTokenizer st = new StringTokenizer(line);
			n = Integer.parseInt(st.nextToken());
			q = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(reader.readLine());
			a = new int[n];
			a_real = new int[n];
			z = 0;
			hashMap.clear();
			startMap.clear();
			endMap.clear();
			while(st.hasMoreTokens()) {
				a[z] = Integer.parseInt(st.nextToken());
				if (hashMap.containsKey(a[z])) {
					Integer value = hashMap.get(a[z]);
					hashMap.put(a[z], ++value);
				} else {
					hashMap.put(a[z], 1);
				}				
				
				z++;
			}

			for(i = 0; i < a.length; i++) {
				a_real[i] = hashMap.get(a[i]);
			}
			
			createSegmentTree(a_real);
			StringBuffer buffer = new StringBuffer();
			while(q-- != 0) {
				st = new StringTokenizer(reader.readLine());
				i = Integer.parseInt(st.nextToken()) - 1;
				j = Integer.parseInt(st.nextToken()) - 1;
				subRMQleft = -1;
				subRMQright = -1;
				subj = i;
				tmp = 0;
				if (i != 0) {
					comp = a[i];
					for(subj = i; subj <= j; subj++) {
						if (a[subj] != comp) {
							break;
						}
					}
					subRMQleft = subj-i;
				}
				
				if (j != a.length-1) {
					comp = a[j];
					for(subi = j; subi >= i; subi--) {
						if (a[subi] != comp) {
							break;
						} 
						
					}
					subRMQright = j-subi;
					j = subi+1;
				}
				
				i = subj;
				
				if (subRMQleft == -1 || subRMQright == -1) {
					tmp = getRMQ(a_real, 0, 0, a_real.length-1, i, j);
					tmp = tmp != -1 ? tmp : 0;
				}
				
				if (subRMQright == -1) {
					subRMQright = a_real[tmp];
				} else if (subRMQleft == -1) {
					subRMQleft = a_real[tmp];
				}

				buffer.append(Math.max(subRMQleft, subRMQright)).append("\n");
			}
			System.out.print(buffer.toString());			
		}
		//System.out.println("Elapsed: " + ((System.nanoTime()-startTime)* 1e-6) + " ms.");
	}
}