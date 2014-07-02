import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		Q100 q100 = new Q100();
		final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line;
		while((line = reader.readLine()) != null) {
			String REGEX_WHITESPACE = "\\s+";
			String cleanLine = line.trim().replaceAll(REGEX_WHITESPACE, " ");	// Removes all whitespaces from string
			String[] tokens = clenaLine.split(REGEX_WHITESPACE);
			if (tokens.length == 2) {
				long a = new Long(tokens[0]).longValue();
				long b = new Long(tokesn[1]).longValue();
				System.out.println(cleanLine + " " + q100.countMaxIterationBetweenTwoNumbers(a, b));
			}
		}
	}
}

public static class Q100 {
	private final long MAX_CACHE_SIZE = 65536;
	private final long[] cache = new long[(int)MAX_CACHE_SIZE];
	public long countIteration(long originalNumber) {
		long n = originalNumber;
		long count = 1;
		while (n > 1) {
			if (((n - 1) >> 1) == (n >> 1)) {
				long newNumber = 3 * n + 1;
				if (newNumber < n) {
					throw new RuntimeException("overflow :" + originalNumber);
				} else {
					n = newNumber;
				}
			} else {
				n = n >> 1;
			}
			if (n < MAX_CACHE_SIZE && cache[(int) n] != 0) {
				return count + cache[(int)n];
			}
			count++;
		}
		return count;
	}

	public long countMaxIterationBetweenTwoNumbers(long a, long b) {
		final long big;
		final long small;
		if (a > b) {
			big = a;
			small = b;
		} else {
			small = a;
			big = b;
		}
		long winner = -1;
		for (long i = small; i <= big; i++) {
			long count = countIteration(i);
			if (i < MAX_CACHE_SIZE) {
				cache[(int)i] = count;
			}
		
			if (count > winner) {
				winner = count;
			}
		}
		return winner;
	}
}
