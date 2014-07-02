import java.util.*;

class Generator {
	public static int offset = 100000;
	public static void main(String[] args) {
		int n, q, i, j;
		n = q = offset;
		Random rand = new Random();
		System.out.println(n + " " + q);
		while (n-- != 0) {
			System.out.print(rand.nextInt(offset*2)-offset);
			if (n-1 != 0) {
				System.out.print(" ");
			}
		}
		System.out.println();
		
		while(q-- != 0) {
			i = rand.nextInt(offset);
			j = rand.nextInt(offset-i+1)+i;
			System.out.println(i + " " + j);
		}
		System.out.println(0);
	}
}