import java.util.*;
import java.io.*;

class Main {
	static char[] in = new char[50000000];
	static int inIdx = 0;
	
	static String[] map = getOutputMap();
	
	static String[] getOutputMap() {
		String[] map = new String[112];
		map[0] = "impossible";
		map[1] ="stack";
		map[10] = "queue";
		map[100] = "priority queue";
		map[111] = "not sure";
		map[101] = "not sure";
		map[011] = "not sure";
		map[110] = "not sure";
		return map;
	}
	
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
		int n, a, b, bitwiser;
		Stack<Integer> stack;
		Queue<Integer> queue;
		PriorityQueue<Integer> pqueue; 
		boolean bs, bq, bpq;
		while (true) {
			n = get();
			if (n == -1) break;
			bitwiser = 111;
			stack = new Stack<Integer>(); 
			queue = new LinkedList<Integer>();
			pqueue = new PriorityQueue<Integer>(10, Collections.reverseOrder());
			while(n-- != 0) {
				a = get();
				b = get();
				if (a == 1) {
							if ((bitwiser & 1) > 0) {	
								stack.push(b);
							}
							if ((bitwiser & 10) > 0) {
								queue.offer(b);
							}
							if ((bitwiser & 100) > 0) {
								pqueue.add(b);
							}
				} else if (a == 2) {
						if ((bitwiser & 1) > 0) {
							if ((stack.size() == 0 || stack.peek() != b))  {
								bitwiser &= 110;
							}else {
								stack.pop();
							}
						}
						if ((bitwiser & 10) > 0) {
							if ((queue.size() == 0 || queue.peek() != b)) {
								bitwiser &= 101;
							} else {
								queue.poll();
							}
						}
						if ((bitwiser & 100) > 0) {
							if ((pqueue.size() == 0 || pqueue.peek() != b)) {
								bitwiser &= 11;
							} else {
								pqueue.poll();
							}
						}
				} 
			}
			System.out.println(map[bitwiser]);
			
		}
	}
}