import java.lang.Integer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.lang.Math;
import java.util.Scanner;

class Alphabet {
	public static int getNextProductPrice(int A, int B, int M, int P) {
		return ((A*P + B) % M) + 1;
	}

	public static int getNextProductWeight(int C, int D, int K, int W) {
		return ((C*W + D) % D) + 1; 
	}

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		int caseCnt = 0;
		long N;
		int P, W, A, B, C, D;
		while(cases != caseCnt) {
			// Read line
			N = sc.nextLong();
			P = sc.nextInt();
			W = sc.nextInt();
			M = sc.nextInt();
			K = sc.nextInt();
			A = sc.nextInt();
			B = sc.nextInt();
			C = sc.nextInt();
			D = sc.nextInt();
			
		}
	}
}
