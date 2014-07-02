import java.io.*;

public class Main
{
	public static char[][] grid = new char[100][100];
	public static int N;
	
	public static int sink(int x, int y)
	{
		if (x < 0 || x >= N || y < 0 || y >= N)
			return 0;
		
		if (grid[x][y] == '.')
			return 0;
		
		int ret = 0;
		
		if (grid[x][y] == 'x')
			ret = 1;
			
		grid[x][y] = '.';
		
		return ret + sink(x, y + 1) + sink(x + 1, y) + sink(x, y - 1) + sink(x - 1, y);
	}
	
	public static void main(String[] args) throws IOException
	{
		//BufferedReader reader = new BufferedReader(new FileReader("test3.in"));
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.valueOf(reader.readLine());
		for(int i = 1; i <= T; i++)
		{
			N = Integer.valueOf(reader.readLine());
			
			for(int x = 0; x < N; x++)
			{
				String line = reader.readLine();
				for(int y = 0; y < N; y++)
				{
					grid[x][y] = line.charAt(y);
				}
			}

			int sum = 0;
			
			for(int x = 0; x < N; x++)
			{
				for(int y = 0; y < N; y++)
				{
					if (sink(x, y) > 0)
					{
						sum++;
					}
				}
			}
			
			System.out.println("Case " + i + ": " + sum);
		}
		reader.close();
	}
	
}