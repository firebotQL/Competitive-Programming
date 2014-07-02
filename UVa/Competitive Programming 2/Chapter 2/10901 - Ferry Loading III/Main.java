import java.util.*;
import java.io.*;

class Main {
	public static int currentSide = 0, t, time, n;

	public static void printUnloadingTime(int ferry, int time) {
		while(ferry-- != 0) 
			System.out.println(time);
	}

	public static int sideCheck(Queue<Integer> side1, Queue<Integer> side2, int moveSide) {
		int ferry = 0;
		while(side1.size() > 0 && side1.peek() <= time && ferry <= n) {
						ferry++; side1.poll();
		}
		if (ferry>0) {
			time += t;
			currentSide = moveSide;
			printUnloadingTime(ferry, time);
			ferry = 0;
		} else {
			if (side1.size() > 0&& side2.size() > 0) {
				if (side1.peek() <= side2.peek()) {
					time = side1.peek();
				} else {
					time += (side2.peek() > time ? side2.peek() : 0) + t;
					currentSide = 1;
				}
			} else if (side1.size() > 0) {
				time = side1.peek();
			} else if (side2.size() > 0) {
				time += (side2.peek() > time ? side2.peek() : 0) + t;
				currentSide = moveSide;
			}
		}
		return time;
	}

	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		int c = scanner.nextInt();
		int m, at;
		boolean waiting;
		String side;
		Queue<Integer> lb = new LinkedList<Integer>();
		Queue<Integer> rb = new LinkedList<Integer>();
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
			time = currentSide = 0;
			
			while(lb.size() > 0 || rb.size() > 0) {
				if (currentSide == 0) {
					sideCheck(lb, rb, 1);
				} else {
					sideCheck(rb, lb, 0);
				}
			}
			
			if (c != 0) {
				System.out.println();
			}
		}
	}
}
