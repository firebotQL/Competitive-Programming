import java.io.*;
import java.util.*;

class Main {
	public static int maxIdx = 1000003;
	public static int[] calendar = new int[maxIdx];
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		String[] splittedLine;
		StringTokenizer st;
		int n, m, start, end, step;
		boolean overlaps = false;
		while((line = reader.readLine()) != null) {
			overlaps = false;
			clearCalendar();
			st = new StringTokenizer(line);
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			if (n != 0 || m != 0) {
				while (n-- != 0) {
					st = new StringTokenizer(reader.readLine());
					if (!overlaps) {
						start = Integer.parseInt(st.nextToken()) + 1;
						end = Integer.parseInt(st.nextToken()) + 1;
						overlaps = updateRangeIfEmpty(start, end);
						//System.out.println("read(end): " + read(end) + " read(start): " + read(start));
						//System.out.println("frequency: " + (read(end) - read(start)));
					}
				}
				
				while (m-- != 0) {
					st = new StringTokenizer(reader.readLine());
					if (!overlaps) {
						start = Integer.parseInt(st.nextToken()) + 1;
						end = Integer.parseInt(st.nextToken()) + 1;
						step = Integer.parseInt(st.nextToken());
						while (end < maxIdx && !overlaps) {
							overlaps = updateRangeIfEmpty(start, end);
							start += step; end += step;
						}
					}
				}
			
				if (overlaps) {
					System.out.println("CONFLICT");
				} else {
					System.out.println("NO CONFLICT");
				}
			}
		}
	}
	
	public static void clearCalendar() {
		for(int i = 0; i < maxIdx; i++) {
			calendar[i] = 0;
		}
	}
	
	public static void printTree() {
		for(int i = 1; i < maxIdx; i++) {
			System.out.print(calendar[i] + " ");
		}
		System.out.println();
	}
	
	public static boolean updateRangeIfEmpty(int start, int end) {
		//System.out.println("end: " + end + " start: " + start);
		int a = read(end);
		//System.out.println("r_end: " + a);
		int b = read(start);
		//System.out.println("r_start: " + b);
		if (b - a != 0) 
			return true;
		
		update(start, 2);
		//printTree();
		update(end+1, -1);
		//printTree();
		
		return false;
	}

	public static int read(int idx) {
		int sum = 0;
		while (idx > 0) {
			//System.out.println("reading: " + idx + " value: " + calendar[idx]);
			sum += calendar[idx];
			idx -= (idx & -idx);
		}
		return sum;
	}
	
	public static void update(int idx, int delta) {
		while(idx <= maxIdx) {
			//System.out.println("updating: " + idx);
			calendar[idx] += delta;
			idx += (idx & -idx);
		}
	}
}