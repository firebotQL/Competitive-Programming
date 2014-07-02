import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.Integer;
import java.util.Scanner;
import java.io.IOException;

class Main {

	static int minimumFigures(int x, int y) {
		return x < y ? x : y;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int i = Integer.parseInt(reader.readLine());
		int n,m;
		char figure;
		while(i-- != 0) {
			Scanner scan = new Scanner(reader.readLine());
			while (!scan.hasNext()) {
				scan = new Scanner(reader.readLine());
			}
			figure = scan.next().charAt(0);
			n = scan.nextInt();
			m = scan.nextInt();
			switch(figure) {
				case 'r':
					System.out.println(minimumFigures(n,m));
					break;
				case 'k':
					System.out.println((m*n+1)/2);	
					break;
				case 'Q':
					System.out.println(minimumFigures(n,m));
					break;
				case 'K':
					System.out.println(((m+1) / 2) * ((n+1) / 2));
					break;
			}
		}
	}
}
