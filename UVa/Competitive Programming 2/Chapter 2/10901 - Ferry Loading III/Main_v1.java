import java.util.*;
import java.io.*;

class Main {
	public static void printUnloadingTime(int ferry, int time) {
		while(ferry-- != 0) 
			System.out.println(time);
	}

	public static int moveFerryAndUnload(int ferry, int time, int t) {
		if (ferry > 0) {
			time += t;
			printUnloadingTime(ferry, time);
		}
		return time;
	}

	public static int ferrySide(Queue<Integer> side, int time, int n, int t) {
		int ferry = 0;
		System.out.println(side);
		while (side.size() > 0 && side.peek() <= time && ferry <= n) {
					ferry++;
					side.poll();
		}
		return ferry;
	}

	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		int c = scanner.nextInt();
		int n, t, m, time, at, ferry, currentSide;
		boolean waiting;
		String side;
		Queue<Integer> lb = new LinkedList<Integer>(), lbb = null;
		Queue<Integer> rb = new LinkedList<Integer>(), rbb = null;
		while(c-- != 0) {
			n = scanner.nextInt();
			t = scanner.nextInt();
			m = scanner.nextInt();
			while (m-- != 0) {
				at = scanner.nextInt();
				side = scanner.nextLine().trim();
				if (side.equals("left")) {
					lb.add(at);
				} else {
					rb.add(at);
				}
			}
			time = 0;
			
			
			if (lb.size() > 0 && rb.size() > 0) {
				if (lb.peek() < rb.peek()) {
					time = lb.peek();
					lbb = lb;
					rbb = rb;
				}
				else if (lb.peek() > rb.peek()) {
					time = rb.peek() + t;
					lbb = rb;
					rbb = lb;
				}
			} else if (lb.size() > 0) {
				time = lb.peek();
				lbb = lb;
				rbb = rb;
			} else if (rb.size() > 0) {
				time = rb.peek() + t;
				lbb = rb;
				rbb = lb;
			}

			System.out.println("time: " + time);
			while(lbb.size() > 0 || rbb.size() > 0) {
				ferry = ferrySide(lbb, time, n, t);
				time = moveFerryAndUnload(ferry, time, t);
				ferry = ferrySide(rbb, time, n, t);
				time = moveFerryAndUnload(ferry, time, t);
			}
			
			if (c != 0) {
				System.out.println();
			}
		}
	}
}
