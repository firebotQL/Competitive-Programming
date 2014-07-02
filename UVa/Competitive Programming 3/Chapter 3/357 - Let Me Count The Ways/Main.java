import java.util.*;
import java.lang.*;
import java.io.*;

public class Main 
{
	public static final int MAX = 30002;
	public static long[] sum = new long[MAX];
	public static int[] V = { 1, 5, 10, 25, 50 };
	public static void main(String[] args) throws IOException
	{
		Scanner scan = new Scanner(new InputStreamReader(System.in));
		
		int n, i, j;
		long result;
		Arrays.fill(sum, Long.MAX_VALUE);
		sum[0] = 0;
		
		for(i = 1; i < MAX; i++)
		{
			for(j = 0; j < 5; j++)
			{
				if (V[j] <= i && sum[i-V[j]] + 1 < sum[i])
				{
					sum[i] = sum[i-V[j]] + 1;
				}
			}
		}
		
		while(scan.hasNext())
		{
			n = scan.nextInt();
			result = sum[n];
			if (result == 1)
			{
				System.out.println("There is only 1 way to produce " + n + " cents change.");
			}
			else
			{
				System.out.println("There are " + result + " ways to produce " + n + " cents change.");
			}
		}
	}
}