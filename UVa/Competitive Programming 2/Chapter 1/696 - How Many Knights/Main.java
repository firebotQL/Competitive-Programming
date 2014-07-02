import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.lang.Integer;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String result = null;
		String line = null;
		String[] tokens = null;
		int m,n;
		while((line = reader.readLine()) != null) {
			tokens = line.split("\\s+");
			n = Integer.parseInt(tokens[0]);
			m = Integer.parseInt(tokens[1]);
			
			if (n == 0 && m == 0) 
				break;

			result = " knights may be placed on a " + n +" row " + m + " column board.";
			if (n > m) {
				n ^= m;			
				m ^= n;
				n ^= m;
			}

			switch(n) {
				case 1:
					System.out.println(m + result);
					break;
				case 2:
					System.out.println(((m+3)/4 + (m+2)/4)*2 + result);
					break;
				default:
					System.out.println((((n+1)/2)*((m+1)/2)+(n/2)*(m/2)) + result);	
			}
		}
	}
}
