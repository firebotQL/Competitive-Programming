import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;

public class Main
{
	public static BigInteger endBigInt = BigInteger.valueOf(-999999);
	
	public static void main(String[] args) throws IOException
	{
		Scanner scan = new Scanner(new InputStreamReader(System.in));
		String line = null;
		String[] split = null;
		int i = 0;
		int tmp = 0;
		BigInteger value, max_at, min_at, answer, prev_max_at, prev_min_at;

		while(scan.hasNext())
		{
			tmp = scan.nextInt();
			answer = BigInteger.valueOf(tmp);
			max_at = BigInteger.valueOf(tmp);
			min_at = BigInteger.valueOf(tmp);
			
			while((value = BigInteger.valueOf(scan.nextInt())).compareTo(endBigInt) != 0)
			{
				prev_max_at = max_at;
				prev_min_at = min_at;
				max_at = value.max(value.multiply(prev_min_at).max(value.multiply(prev_max_at)));
				min_at = value.min(value.multiply(prev_min_at).min(value.multiply(prev_max_at)));
				answer = answer.max(max_at);
			}
			System.out.println(answer);
		}
	}
}