import java.util.*;
import java.io.*;
import java.lang.*;

public class Main
{
	public static long[][] table = new long[101][101];
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N, K, i, j;
		long x, y;
		String line = null;
		String[] split = null;
		
		for(long[] row : table)
		{
			Arrays.fill(row, -1);
		}
		
		table[0][0] = 1;
		
		while((line = reader.readLine()) != null)
		{
			split = line.split("\\s+");
			N = Integer.valueOf(split[0]);
			K = Integer.valueOf(split[1]);
			
			if (N == 0 && K == 0)
			{
				break;
			}

			System.out.println(count(N, K));
		}
	}
	
	public static long count(int N, int K)
	{
		if (N < 0 || K < 0)
		{
			return 0;
		}
		
		if (table[N][K] != -1)
		{
			return table[N][K];
		} 
		else 
		{
			long nrWays = 0;
		
			for(int i = 0; i <=	N; i++)
			{
				nrWays += (count(N-i, K-1) % 1000000);
			}
			
			return table[N][K] = nrWays % 1000000;
		}
	}
}