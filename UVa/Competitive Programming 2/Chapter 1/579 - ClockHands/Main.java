import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.lang.Integer;
import java.lang.Math;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int H,M;
		double degree;
		String[] clock = reader.readLine().split(":");
		H = Integer.parseInt(clock[0]);
		M = Integer.parseInt(clock[1]);
		while (H != 0 || M != 0) {
			degree = Math.abs(H * 30 - (11.0 * M)/2);
			System.out.format("%.3f\n", degree > 180 ? 360 - degree : degree);
			clock = reader.readLine().split(":");
			H = Integer.parseInt(clock[0]);
			M = Integer.parseInt(clock[1]);
		}
	}
}
