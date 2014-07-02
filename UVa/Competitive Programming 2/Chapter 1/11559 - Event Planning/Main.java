import java.util.Scanner;
import java.lang.String;
import java.lang.Integer;

class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N, B, H, W, p, a, min, i, j;
		boolean search;
		while(scanner.hasNext()) {
			N = scanner.nextInt();
			B = scanner.nextInt();
			H = scanner.nextInt();
			W = scanner.nextInt();
			min = Integer.MAX_VALUE;
			for(i = 0; i < H; ++i) {
				p = scanner.nextInt();
				search = false;
				if (p * N <= B && p < min) {
					search = true;
				}
				for(j = 0; j < W; ++j) {
					a = scanner.nextInt();
					if (search && N <= a) {
						min = p;
						search = false;
					}		
				}
			}
			if (min != Integer.MAX_VALUE) {
				System.out.println(N*min);
			} else {
				System.out.println("stay home");
			}
		}
	}
}
