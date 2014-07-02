import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
	public static char[][] grid = new char[51][51];
	public static int C, R, M, cells, i, j, z, k, newR, newC, emptyCells;
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		String[] split = null;
		int T = Integer.valueOf(reader.readLine());
		
		boolean possible;
		
		for(int caseNr = 1; caseNr <= T; caseNr++)
		{
			possible = false;
			split = reader.readLine().split("\\s+");
			R = Integer.valueOf(split[0]);
			C = Integer.valueOf(split[1]);
			M = Integer.valueOf(split[2]);
			
			cells = R * C;
			
			if (R == 1 || C == 1)
			{
				possible = true;
			}
			else 
			{
				if (cells - 4 >= M)
				{
					possible = true;
				}
				else
				{
					possible = false;
				}
			}
			
			System.out.println("Case #" + caseNr + ":");
			emptyCells = cells - M;
			
			if (possible)
			{
				for(i = 0; i < R; i++)
				{
					for(j = 0; j < C; j++)
					{
						grid[i][j] = '*';
					}
				}
				newR = emptyCells / 2 + emptyCells % 2;
				newC = emptyCells / 2;
				
				for(i = 0; i < newR; i++)
				{
					for(j = 0; j < newC; j++)
					{
						if (emptyCells > 0 && grid[i][j] != '.')
						{
							grid[i][j] = '.';
							emptyCells--;
						}
					}
				}
				/*for(k = 0 ; k < R * 2 ; k++ ) {
					for(j = 0 ; j <= k ; j++ ) {
						i = k - j;
						if( i < R && j < C ) {
							if (emptyCells > 0 && grid[i][j] != '.')
							{
								grid[i][j] = '.';
								emptyCells--;
							}
						}
					}
				}*/
				//fillEmptyCells(0, 0);
				
				grid[0][0] = 'c';
				
				for(i = 0; i < R; i++)
				{
					for(j = 0; j < C; j++)
					{
						System.out.print(grid[i][j]);
					}
					System.out.println();
				}
			}
			else
			{
				System.out.println("Impossible");
			}
		}
	}
	
	public static void fillEmptyCells(int i, int j)
	{
		if (emptyCells == 0)
		{
			return;
		}
		
		if (i > R || j > C)
		{
			return;
		}
		
		if (emptyCells > 0 && grid[i][j] != '.')
		{
			grid[i][j] = '.';
			emptyCells--;
		}
		
		if (emptyCells > 0 && i+1 < R && grid[i+1][j] != '.') 
		{
			grid[i+1][j] = '.';
			emptyCells--;
		}
		
		if (emptyCells > 0 && j+1 < C && grid[i][j+1] != '.')
		{
			grid[i][j+1] = '.';
			emptyCells--;
		}
		
		if (emptyCells > 0 && j+1 < C && i+1 < R && grid[i+1][j+1] != '.')
		{
			grid[i+1][j+1] = '.';
			emptyCells--;
		}
		
		fillEmptyCells(i + 1, j);
		fillEmptyCells(i + 1, j + 1);
		fillEmptyCells(i, j + 1);
	}
}