import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
	public static char[][] grid = new char[20][20];
	public static boolean[][] visited = new boolean[20][20];
	public static int M, N;
	
	public static char land;
	
	public static int  calc(int X, int Y)
	{
		if (X < 0 || X >= M)
			return 0;
		
		if (visited[X][Y] || grid[X][Y] != land)
			return 0;
			
		visited[X][Y] = true;
		
		return 1 + calc(X + 1, Y)
					+ calc(X, (Y + 1 + N) % N) 
					+ calc(X - 1, Y) 
					+ calc(X, (Y - 1 + N) % N);
	}
	
	public static void main(String[] args) throws IOException
	{
		//BufferedReader reader = new BufferedReader(new FileReader("test3.in"));
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		while((line = reader.readLine()) != null)
		{
			StringTokenizer token = new StringTokenizer(line);
			M = Integer.valueOf(token.nextToken());
			N = Integer.valueOf(token.nextToken());
			
			for(int i = 0; i < M; i++)
			{
				line = reader.readLine();
				
				for(int j = 0; j < N; j++)
				{
					grid[i][j] = line.charAt(j);
					visited[i][j] = false;
				}
			}
			
			token = new StringTokenizer(reader.readLine());
			int X = Integer.valueOf(token.nextToken());
			int Y = Integer.valueOf(token.nextToken());
			
			land = grid[X][Y];
			//System.out.println(land);
			calc(X, Y);
			
			int max = 0;
			
			for(int i = 0; i < M; i++)
			{
				for(int j = 0; j < N; j++)
				{
					if (grid[i][j] == land && !visited[i][j])
					{
						max = Math.max(max, calc(i, j));
					}
				}
			}
			
			System.out.println(max);	
			reader.readLine();
		}
	}
}
