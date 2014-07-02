import java.io.*;
import java.util.*;
class Main {
	public static int[] array = { 1, 0, 1, 0, 1};
	public static int[] segmentTree = null;
	public static int[] propagateTree = null;
	public static int query = 1;
	
	public static void buildSegmentTree(int vertex, int L, int R) {
		if (L == R) {
			segmentTree[vertex] = array[L];
		} else {
			int leftChild = 2 * vertex;
			int rightChild = leftChild + 1;
			buildSegmentTree(leftChild, L, (L + R) / 2);
			buildSegmentTree(rightChild, (L + R) / 2 + 1, R);
			segmentTree[vertex] = segmentTree[leftChild] + segmentTree[rightChild];
		}
	}
	
	public static void updateSegmentTree(int vertex, int L, int R, int value, int pos) {
		if (L == R) {
			segmentTree[vertex] = (value == -1) ? segmentTree[vertex] ^ 1 : value;
		} else {
			int leftChild = 2 * vertex;
			int rightChild = leftChild + 1;
			int mid = (L + R) / 2;
			if (pos <= mid) 
				updateSegmentTree(leftChild, L, mid, value, pos);
			else 
				updateSegmentTree(rightChild, mid + 1, R, value, pos);
			segmentTree[vertex] = segmentTree[leftChild] + segmentTree[rightChild];
		}
	}
	
	public static void updateAndPropagate(int vertex, boolean hasChildren) {
		if (hasChildren) {
			propagateTree[2 * vertex] = propagateTree[vertex];
			propagateTree[2 * vertex + 1] = propagateTree[vertex];			
		}
		//segmentTree[vertex] = (propagateTree[vertex] >= 0) ? (segmentTree[vertex] + propagateTree[vertex]) : (segmentTree[vertex] ^= 1);
		propagateTree[vertex] = -2;
	}
	
	public static void createSegmentTree() {
		int length = (int) (2 * Math.pow(2.0, Math.floor((Math.log((double)array.length) / Math.log(2.0)) + 1)));
		segmentTree = new int[length];
		propagateTree = new int[length];
		for(int i = 0; i < length; i++) {
			segmentTree[i] = 0;
			propagateTree[i] = -2;	// -2 picked randomly
		}
		buildSegmentTree(1, 0, array.length-1);
	}
	
	public static void main(String[] args) throws IOException {
		createSegmentTree();
		System.out.println(getRMQ(1, 0, array.length-1, 1, 1));
	}
	
	public static int getRMQ(int vertex, int L, int R, int i, int j) {
		if (i > R || j < L) return -1;
		if (L >= i && R <= j) {
			updateAndPropagate(vertex, L != R);
			return segmentTree[vertex];
		}
		
		int mid = (L + R) / 2;
		int leftVertex = 2 * vertex;
		int rightVertex = leftVertex + 1;
		if (propagateTree[vertex] != -2) {
			updateAndPropagate(vertex, L != R);
		}
		
		int p1 = getRMQ(leftVertex, L, mid, i, j);
		int p2 = getRMQ(rightVertex, mid + 1, R, i, j);
		
		if (p1 == -1) return p2;
		if (p2 == -1) return p1;
		
		return p1 + p2;
	}
	
	public static int updateRange(int vertex, int L, int R, int i, int j, int value) {
		if (i > R || j < L) return -1;
		if (L >= i && R <= j) { 
			segmentTree[vertex] += value;
			propagateTree[vertex] += value;		
		}		
	}
	
	public static void convert(String pirates) {
		array = new int[pirates.length()];
		for(int i = 0; i < pirates.length(); i++) {
			array[i] = (int)pirates.charAt(i)-48;
		}
	}
	
	public static void execute(int a, int b, char cmd) {
		switch(cmd) {
			case 'F':
				mutate(a, b, 1);
				break;
			case 'E':
				mutate(a, b, 0);
				break;
			case 'I':
				mutate(a, b, -1);
				break;
			case 'S':
				System.out.println("Q" + query++ + ": " + getRMQ(1, 0, array.length-1, a, b));
				break;
		}
	}
	
	public static void mutate(int a, int b, int value) {
		for(; a <= b; a++) {
			updateSegmentTree(1, 0, array.length-1, value, a);
		}
	}
	/*
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		String pirates = null;
		int T, M, Q, cases, i, a, b;
		char cmd;
		cases = Integer.parseInt(reader.readLine());
		StringBuffer buffer = null;
		StringTokenizer token = null;
		int cs = 1;
		if (cases > 0) {
			while((line = reader.readLine()) != null) {
				M = Integer.parseInt(line);
				buffer = new StringBuffer();
				for(i = 0; i < M; i++) {
					T = Integer.parseInt(reader.readLine());
					line = reader.readLine();
					while(T-- != 0) {
						buffer.append(line);
					}
				}
				System.out.println("Case " + (cs++) + ":");
				query = 1;
				Q = Integer.parseInt(reader.readLine());
				convert(buffer.toString());
				createSegmentTree();
				while(Q-- != 0) {
					token = new StringTokenizer(reader.readLine());
					cmd = token.nextToken().charAt(0);
					a = Integer.parseInt(token.nextToken());
					b = Integer.parseInt(token.nextToken());
					execute(a, b, cmd);
				}
			}
		}
	} */
}