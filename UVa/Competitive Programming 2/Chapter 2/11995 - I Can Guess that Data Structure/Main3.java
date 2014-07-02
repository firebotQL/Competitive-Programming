import java.util.*;
import java.io.*;

class Main {
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
		int n, a, b, bitwiser;
		Stack<Integer> stack;
		Queue<Integer> queue;
		PriorityQueue<Integer> pqueue; 
		boolean bs, bq, bpq;
		while (true) {
			n = get();
			if (n == -1) break;
			bs = bq = bpq = true;
			stack = new Stack<Integer>(); 
			queue = new LinkedList<Integer>();
			pqueue = new PriorityQueue<Integer>(10, Collections.reverseOrder());
			while(n-- != 0) {
				a = get();
				b = get();
				if (a == 1) {
					if (bs) {	
						stack.push(b);
					}
					if (bq) {
						queue.offer(b);
					}
					if (bpq) {
						pqueue.add(b);
					}
				} else if (a == 2) {
						if (bs) {
							if ((stack.size() == 0 || stack.peek() != b))  {
								bs = false;
							}else {
								stack.pop();
							}
						}
						if (bq) {
							if ((queue.size() == 0 || queue.peek() != b)) {
								bq = false;
							} else {
								queue.poll();
							}
						}
						if (bpq) {
							if ((pqueue.size() == 0 || pqueue.peek() != b)) {
								bpq = false;
							} else {
								pqueue.poll();
							}
						}
				} 
			}
			if (!bs && !bq && !bpq) {
				System.out.println("impossible");
			} else if (bs && !bq && !bpq) {
				System.out.println("stack");
			} else if (!bs && bq && !bpq) {
				System.out.println("queue");
			} else if (!bs && !bq && bpq) {
				System.out.println("priority queue");
			} else  {
				System.out.println("not sure");
			}			
		}
	}
}