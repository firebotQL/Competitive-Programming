import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.Integer;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int i, x, y, n, m, z;
		String[] sta;
		int[] wire = null;
		String line = null;
		while((line= reader.readLine()) != null) {
			n = Integer.parseInt(line);
			i = 0;
			wire = new int[n];
			StringTokenizer st = new StringTokenizer(reader.readLine());
			while (st.hasMoreTokens()) {
				wire[i++] = Integer.parseInt(st.nextToken());
			}
			m = Integer.parseInt(reader.readLine());
			while(m-- != 0) {
				sta = reader.readLine().split("\\s+");
				x = Integer.parseInt(sta[0]) - 1;
				y = Integer.parseInt(sta[1]);
				if (x-1 >= 0) {
					wire[x-1] += y-1;
				}
				if (x+1 < n) {
					wire[x+1] += wire[x] - y;
				}
				wire[x] = 0;
			}
			z = 0;
			while(z < n) {
				System.out.println(wire[z++]);
			}		
		}
		
		
	}
}