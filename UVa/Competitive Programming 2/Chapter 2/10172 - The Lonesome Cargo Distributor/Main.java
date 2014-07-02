import java.util.*;
import java.io.*;

class Main {
	public static boolean facilityIsEmpty(Map<Integer, Queue<Integer>> facility, int N) {
		for(int i = 1; i <= N; i++) {
			if (facility.get(i).size() > 0) 
				return false;
		}
		return true;
	}
	public static int getCompletionTimeInMinutes(Map<Integer, Queue<Integer>> facility, int N, int S, int Q) {
		int minutes = 0;
		Queue<Integer> platB;
		Stack<Integer> carrier = new Stack<Integer>();
		int cargo;
		int i = 1;
		while(!facilityIsEmpty(facility, N) || !carrier.empty()) {
				i = i % N + 1;
				minutes += 2;
				platB = facility.get(i);

				// If carrier is not empty and top can fit to A or B then unload
				while(!carrier.empty() && (carrier.peek() == i || platB.size() < Q)) {
					cargo = carrier.pop();
					if (cargo != i) {
						platB.add(cargo);
					}  
					minutes++;
				}

				// Load carrier if B has cargos and carrier has free space
				while (platB.size() > 0 && carrier.size() < S) {
					carrier.push(platB.poll());
					minutes++;
				}
		}
		return (minutes == 0 ? minutes : minutes - 2);
	}
	
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		int SET = scanner.nextInt();
		int N, S, Q, qu;
		Map<Integer, Queue<Integer>> facility;
		while(SET-- != 0) {
			N = scanner.nextInt();
			S = scanner.nextInt();
			Q = scanner.nextInt();
			facility = new HashMap<Integer, Queue<Integer>>();
			for(int i = 1; i <= N; i++) {
				qu = scanner.nextInt();
				facility.put(i, new LinkedList());
				for(int j = 0; j < qu; j++) {
					facility.get(i).add(scanner.nextInt());
				}
			}
			System.out.println(getCompletionTimeInMinutes(facility, N, S, Q));
		}

	}
}

