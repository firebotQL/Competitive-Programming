import java.io.*;
import java.util.*;
import java.lang.*;

class Main {

	private class Cmd {
		public int qnum;
		public int value;
		public int period;
		public Cmd(int qnum, int value, int period) {
			this.qnum = qnum;
			this.value = value;
			this.period = period;
		}
	}
	
	public static class CmdComparator implements Comparator<Cmd> {
		@Override
		public int compare(Cmd e1, Cmd e2) {
			if (e1.value == e2.value) {
				return e1.qnum < e2.qnum ? -1 : 1;
			} else {
				return e1.value < e2.value ? -1 : 1;
			}
		}
	}
	
	public void calculate() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		int qnum, period;
		PriorityQueue<Cmd> pq1 = new PriorityQueue<Cmd>(10, new CmdComparator());
		PriorityQueue<Cmd> pq2 = new PriorityQueue<Cmd>(10, new CmdComparator());
		
		while((line = reader.readLine()) != null && line.charAt(0) != '#') {
			String[] split = line.split("\\s+");
			qnum = Integer.parseInt(split[1]);
			period = Integer.parseInt(split[2]);
			pq1.add(new Cmd(qnum, period, period));
		}
		
		int n = Integer.parseInt(reader.readLine());
	
		while(n > pq2.size()) {
			Cmd c = pq1.poll();
			pq2.add(new Cmd(c.qnum, c.value, c.period));
			c.value += c.period;
			pq1.add(c);
		}
		
		while(n-- != 0) {
			System.out.println(pq2.poll().qnum);
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		Main test = new Main();
		test.calculate();
	}
}