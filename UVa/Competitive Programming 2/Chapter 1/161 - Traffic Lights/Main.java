import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

class Main {
	public static boolean increment(List<Integer> signals, List<Integer> steps) {
		for(int i = 0; i < signals.size(); i++) {
			signals.set(i, signals.get(i) + steps.get(i) + 5);
			if (signals.get(i) > 300) 
				return false;
		}
		return true;
	}

	public static boolean overlap(List<Integer> signals, List<Integer> steps) {
		int i, j, startA, startB, stepA, stepB;
		for(i = 0; i < signals.size(); i++) {
			startA = signals.get(i);
			stepA = steps.get(i);
			for(j = i+1; j < signals.size(); j++) {
				startB = signals.get(j);
				stepB = steps.get(j);
				if (startA <= startB+stepB && startA+stepA >= startB)
					return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		int value, startA, startB, endA, endB;
		List<Integer> signals = new ArrayList<Integer>();
		List<Integer> steps = new ArrayList<Integer>();
		boolean overlaps;
		int count = 0;
		while(scanner.hasNext()) {		
			overlaps = false;
			signals.clear();
			steps.clear();
			while ((value = scanner.nextInt()) != 0) {
				signals.add(value);	
				steps.add(value-5);			
			}
			if (signals.size() > 0) {
				count = 0;
				do {
					overlaps = overlap(signals, steps);
				} while(!overlaps && increment(signals, steps));

				if (overlaps) {
					System.out.println(overlaps);
				} else {
					System.out.println("Signals fail to synchronise in 5 hours");
				}
			}
			
			if (count != 3) {
				count++;
			} else {
				break;
			}
						
		}
	}
}
