import java.util.*;
import java.io.*;

class Test {
	public static void main(String[] args) throws IOException {
		Random randomGenerator = new Random();
		Random aRan = new Random();
		Random bRan = new Random();
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(2056, Collections.reverseOrder());
		int i, second, first, rand;
		for(i = 0; i < 1000; i++) {
			second = randomGenerator.nextInt(300);
			second = second  % 2 == 0 ? second : second + 1;
			first = second / 2;
			System.out.println(second);
			while (second-- != first) {
				rand = bRan.nextInt(1024);
				pq.add(rand);
				System.out.println("1 " + rand);
			}
			while (first-- != 0) {
				System.out.println("2 " + pq.poll());
			}
		}
	}
}