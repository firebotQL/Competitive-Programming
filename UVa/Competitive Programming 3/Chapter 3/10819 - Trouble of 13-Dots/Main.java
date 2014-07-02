import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
	public static int[] itemPrice = new int[101];
	public static int[] itemIndex = new int[101];
	public static int[][] dp = new int[101][15000];
	public static int f, m, m1, index2;
	
	public static int solve(int i, int w)
	{
		if (w > m && m < 1800) return -10000;
		
		if (w > m + 200) return -10000;
		
		if (i == f)
		{
			if (w > m && w <= 2000) return -10000;
			return 0;
		}
		
		if (dp[i][w] != -1) return dp[i][w];
		
		return dp[i][w] = Math.max(solve(i + 1, w), itemIndex[i] + solve(i + 1, w + itemPrice[i]));
		
	}
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int i;
		String line = null;
		String[] split = null;
		while((line = reader.readLine()) != null)
		{
			split = line.split("\\s+");
			m = Integer.valueOf(split[0]);
			f = Integer.valueOf(split[1]);
			
			for(i = 0; i < f; i++)
			{
				split = reader.readLine().split("\\s+");
				itemPrice[i] = Integer.valueOf(split[0]);
				itemIndex[i] = Integer.valueOf(split[1]);
			}
			
			for(int[] row : dp)
			{
				Arrays.fill(row, -1);
			}
			
			System.out.println(solve(0, 0));
		}
	}
}