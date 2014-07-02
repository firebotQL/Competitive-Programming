import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
	public static int[][] grid = new int[150][150];
	public static final long constMaxSubRect = -100*75*75;
	
	public static void main(String[] args) throws IOException
	{
		Scanner scan = new Scanner(new InputStreamReader(System.in));
		String line = null;
		String[] split = null;
		int cases, N, torusN, i, j, k, l;
		cases = scan.nextInt();
		
		long maxSubRect, subRect;
		
		while(cases-- != 0)
		{
			N = scan.nextInt();
			
			maxSubRect = constMaxSubRect;
			
			torusN = 2*N;
			
			for(i = 0; i < torusN; i++)
			{	
				for(j = 0; j < torusN; j++)
				{
					if (j < N && i < N)
					{
						grid[i][j] = grid[i+N][j] = grid[i][j+N] = grid[i+N][j+N] = scan.nextInt();
					}
					
					if (i > 0) grid[i][j] += grid[i - 1][j];
					if (j > 0) grid[i][j] += grid[i][j - 1];
					if (i > 0 && j > 0) grid[i][j] -= grid[i - 1][j - 1];
					
				}
			}
			
			
			
			for(i = 0; i < N; i++)
			{
				for(j = 0; j < N; j++)
				{
					for(k = i; k < N+i; k++)
					{
						for(l = j; l < N+j; l++)
						{
							subRect = grid[k][l];
							if (i > 0) subRect -= grid[i-1][l];
							if (j > 0) subRect -= grid[k][j-1];
							if (i > 0 && j > 0) subRect += grid[i - 1][j - 1];
							maxSubRect = Math.max(maxSubRect, subRect);
						}
					}
				}
			}

			
			System.out.println(maxSubRect);
			
		}
	}
}