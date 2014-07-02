import java.util.*;
import java.io.*;

class Main2 {
	static char[] in = new char[50000000];
	static int inIdx = 0;
	
	static int get() {
		int ret = 0;
		while(in[inIdx]>0 && in[inIdx] <'0') inIdx++;
		if (in[inIdx] == 0) return -1;
		while(in[inIdx]>='0') ret = ret*10 + in[inIdx++]-'0';
		return ret;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		reader.read(in, 0, in.length);
		int n, a, b, i, bitwiser;
		Stack<Integer> stack = new Stack<Integer>();
		Queue<Integer> queue = new LinkedList<Integer>();
		PriorityQueue<Integer> pqueue =  new PriorityQueue<Integer>(2048, Collections.reverseOrder());
		Map<Integer, String> map = new HashMap<Integer, String>();
		
		map.put(0, "impossible");
		map.put(1, "stack");
		map.put(10, "queue");
		map.put(100, "priority queue");
		map.put(111, "not sure");
		map.put(101, "not sure");
		map.put(011, "not sure");
		map.put(110, "not sure");
		
		boolean bs, q, pq;
		String line;
		String[] tokens;
		long start = System.nanoTime();
		while (true) {
			n = get();
			if (n == -1) break;
			bitwiser = 111;
			stack.clear();
			queue.clear();
			pqueue.clear(); 
			for(i = 0; i < n; i++) {
				a = get();
				b = get();
				if (a == 1) {
							stack.push(b);
							queue.offer(b);
							pqueue.add(b);
				} else if (a == 2) {
						bitwiser = (stack.pop() == b) ? bitwiser : bitwiser & (110);
						bitwiser = (queue.poll() == b) ? bitwiser : bitwiser & (101);
						bitwiser = (pqueue.poll() == b) ? bitwiser : bitwiser & (11);
				}
			}
		
			System.out.println(map.get(bitwiser));
			
		}
		System.out.println((System.nanoTime() - start) * 1.0e-9 + "hiho");
	}
}