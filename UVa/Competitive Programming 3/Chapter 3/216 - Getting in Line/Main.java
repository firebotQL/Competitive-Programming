import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
	public static int[] x = new int[9];
	public static int[] y = new int[9];
	public static int[][] dist = new int[9][9];
	public static int[][] memo = new int[9][1 << 9];
	public static int computers = 0;
	
	private static int TSP(int pos, int bitmask)
	{
		if (bitmask == (1 << (computers + 1)) - 1)		// all cities have been visited!
		{
			return dist[pos][0];
		}
		
		if (memo[pos][bitmask] != -1)		// path to this already exists
		{
			return memo[pos][bitmask];
		}
		
		int ans = Integer.MAX_VALUE;
		int sol = 0;
		for(int next = 0; next <= computers; next++) // O(n) here
		{
			if (next != pos && (bitmask & (1 << next)) == 0)		// if position/coordinate is not visited yet
			{
				sol = dist[pos][next] + TSP(next, bitmask | (1 << next));
				if (sol < ans)
				{
					ans = sol;	
				}
			}			
		}
		
		return memo[pos][bitmask] = ans;
	}
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		String[] split = null;
		int i, j;
		
		while((line = reader.readLine()) != null)
		{
			computers = Integer.valueOf(line);
			if (computers == 0)
				break;
			
			for(i = 0; i < computers; i++)
			{
				split = reader.readLine().split("\\s+");
				x[i] = Integer.valueOf(split[0]);
				y[i] = Integer.valueOf(split[1]);
			}
			
			for(i = 0; i < computers; i++)
			{
				for(j = 0; j < computers; j++)
				{
					dist[i][j] = Math.abs(x[i] - x[j]) + Math.abs(y[i] - y[j]); // Manhattan distance
				}
			}
			
			for(i = 0; i < computesr; i++)
			{
				for(j = 0; j < (1 << 9); j++)
				{
					memo[i][j] = -1;
				}
			}
			
			
		}
	}
}