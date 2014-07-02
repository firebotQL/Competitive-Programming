import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
	private static int[][] grid = new int[101][101];
	private static boolean[][] visited = new boolean [101][101];	
	private static int[] xStack = new int[1000000];
	private static int[] yStack = new int[1000000];
	
	private static int i, j;
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int T, W, R, C, M, N, caseNr = 1, even, odd, newX, newY, gridVal, stackPointer, tx, ty, isize;
		T = Integer.valueOf(reader.readLine());
		String[] line = null;		
		int[][] inc = null;
		
		while(T-- != 0)
		{
			
			line = reader.readLine().split("\\s+");
			R = Integer.valueOf(line[0]);
			C = Integer.valueOf(line[1]);
			M = Integer.valueOf(line[2]);
			N = Integer.valueOf(line[3]);
			
			W = Integer.valueOf(reader.readLine());
			
			if (N == M)
			{
				inc = new int[][] { { N, M }, { N, -M}, {-N, M}, {-N, -M} };
			}
			else if (N == 0 || M == 0)
			{
				inc = new int[][] { { N, M }, { N, -M}, {M, N}, {-M, N} };
			}
			else 
			{
				inc = new int[][] { { N, M }, { N, -M}, {-N, M}, {-N, -M}, {M, N}, {M, -N}, {-M, N} , {-M, -N} };
			}
			
			while(W-- != 0)
			{
				line = reader.readLine().split("\\s+");
				grid[Integer.valueOf(line[0])][Integer.valueOf(line[1])] = -1;
			}
			
			even = odd = stackPointer = 0;

			xStack[stackPointer] = 0;
			yStack[stackPointer] = 0;
			
			isize = inc.length;
			
			while(stackPointer != -1)
			{
				tx = xStack[stackPointer];
				ty = yStack[stackPointer];
				stackPointer--;
				
				if (!visited[tx][ty])
				{
					visited[tx][ty] = true;
					
					for(i = 0; i < isize; i++)
					{
						newX = tx + inc[i][0]; 
						newY = ty + inc[i][1];
						
						if (newX >= 0 && newX < R && newY >= 0 && newY < C && grid[newX][newY] != -1)
						{
							grid[newX][newY]++;
							stackPointer++;
							xStack[stackPointer] = newX;
							yStack[stackPointer] = newY;
						}
					}
				}
			}
			
			for(i = 0; i < R; i++)
			{
				for(j = 0; j < C; j++)
				{
					gridVal = grid[i][j];

					if (gridVal > 0 || (i == 0 && j == 0))
					{
						if (gridVal % 2 == 0)
						{
							even++;
						}
						else
						{
							odd++;
						}
					}
					
					grid[i][j] = 0;
					visited[i][j] = false;
				}
			}
			
			System.out.printf("Case %d: %d %d%n", caseNr++, even, odd);
		}
		
	}
}