import java.lang.Integer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.lang.Math;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line = reader.readLine();
		int N = Integer.parseInt(line);
		long X, i, j, sqrtX, count, part, cases = 0;
		while(N != cases) {
			line = reader.readLine();
			X = Integer.parseInt(line);
			sqrtX = (long)Math.sqrt(X);
			count = 0;
			for(i = sqrtX; i > 0; i--) {
				part = X - (i*i);
				j = (long)Math.sqrt(part);
				if (j > i) break;
				for(; j >= 0; j--) {
					if ((i*i+j*j) == X) {
						count++;
					}
				}
			}
			System.out.println("Case #"+ (cases+1) + ": " + count);
			cases++;
		}
	}
}
