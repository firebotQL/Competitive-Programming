import java.util.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		long sum = 0;
		List<Integer> d = new ArrayList<Integer>();
		int temp, k;
		boolean not = false;
		while((line = reader.readLine()) != null) {
			Scanner scanner = new Scanner(line);
			int n = scanner.nextInt();
			sum = 0;
			not = false;
			
			if (n == 0) {
				return;
			}
			
			for(int i = 0; i < n; i++) {
				temp = scanner.nextInt(); 
				sum += temp;
				d.add(temp);
			}
			
			Collections.sort(d, Collections.reverseOrder());
			
			if (sum % 2 == 0) {
				for(int i = 0; i < n; i++) {
					k = i + 1;
					if (sum(i, d) > ((k*(k-1)) + minSum(i, d))) {
						not = true;
						break;
					}
				}
			} else {
				not = true;
			}
			
			d.clear();
			if (not) {
				System.out.println("Not possible");
			} else {
				System.out.println("Possible");
			}
		}
	}
	
	public static long sum(int k, List<Integer> d) {
		long sum = 0;
		for(int i = 0; i <= k; i++) {
			sum += d.get(i);
		}
		return sum;
	}
	
	public static long minSum(int k, List<Integer> d) {
		long sum = 0;
		int n = d.size();
		for(int i = k+1; i < n; i++) {
			sum += Math.min(d.get(i), k+1); 
		}
		return sum;
	}
}