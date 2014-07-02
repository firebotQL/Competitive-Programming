import java.util.Scanner;

public class Main {
	static public void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		int N, max, c = 0;
		int counter = 1;
		while(T-- != 0) {
			max = 0;
			N = scanner.nextInt();
			while (N-- != 0) {
				c = scanner.nextInt();
				if (c > max) {
					max = c;
				}
			}
			System.out.println("Case " + counter++ + ": " + max);
		}
	}
}
