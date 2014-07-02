import java.util.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		int N;
		long sum, cost;
		PriorityQueue<Long> queue;
		while ((N = scan.nextInt()) != 0) {
			queue = new PriorityQueue<Long>(N);
			sum = cost = 0;
			while(N-- != 0) {
				queue.add(scan.nextLong());
			}
			while(queue.size() != 1) {
				sum = queue.poll() + queue.poll();
				queue.add(sum);
				cost += sum;
			}
			System.out.println(cost);
		}
	}
}