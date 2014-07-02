import java.lang.Integer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Scanner;

class Billboards {
	static int getWordMaxLength(String[] line) {
		int max = Integer.MIN_VALUE;
		for(String word: line) {
			max = word.length() > max ? word.length() : max;
		}
		return max;
	}
	
	static int getCharMaxLength(int wc, int hc) {
		return wc > hc ? wc : hc;
	}

	static boolean canFitBillboard(int r, int c, String[] S) {
		int i = 0;
		int j = 0;
		while(j < S.length && i < r) {
			int lsum = 0;
			while(j < S.length && (lsum + S[j].length()) <= c) {
				lsum += S[j].length();
				lsum += (lsum < c - 1) ? 1 : 0;
				j++;
			}
			i++;
		}
		return j == S.length && i <= r;
	}
	
	static int getMaximumCharSize(int mc, int H, int W, String[] S) {
		int r,c;
		while(mc > 0) {
			r = H/mc;
			c = W/mc;
			
			if (canFitBillboard(r, c, S))
				return mc;
			mc--;
		}
		return 0;
	}

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int caseCnt = 0;
		int charSize, W, H, maxWord, maxChar, result;
		String[] S;
		while(T != caseCnt) {
			W = sc.nextInt();
			H = sc.nextInt();
			S = sc.nextLine().trim().split("\\s+");

			maxWord = getWordMaxLength(S);

			maxChar = getCharMaxLength(W/maxWord, H/S.length);

			result = getMaximumCharSize(maxChar, H, W, S);
			
			System.out.println("Case #"+ ++caseCnt + ": " + result);
		}
	}
}
