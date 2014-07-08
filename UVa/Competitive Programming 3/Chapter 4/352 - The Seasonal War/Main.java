import java.util.*;
import java.io.*;

public class Main
{
	public static char[][] photo = new char[25][25];
	public static boolean[][] visited = new boolean[25][25];
	public static int N;
	public static int[] dr = { 0, 1, 1, 1, 0, -1, -1, -1 };
	public static int[] dc = { -1, -1, 0, 1, 1, 1, 0, -1 };
	
	public static void flood(int r, int c)
	{
		if (visited[r][c] || photo[r][c] != '1') return;
		
		visited[r][c] = true;
		
		for(int i = 0; i < 8; i++)
		{
			int nr = r + dr[i]; int nc = c + dc[i];
			if (nr >= 0 && nr < N && nc >= 0 && nc < N) flood(nr, nc);
		}
	}
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line = null;	
		int photoCnt = 1;
		while((line = reader.readLine()) != null)
		{
			N = Integer.parseInt(line);
			for(int i = 0; i < N; ++i)
			{
				line = reader.readLine();
				for(int j = 0; j < N; ++j)
				{
					photo[i][j] = line.charAt(j);
					visited[i][j] = false;
				}
			}
			
			int eagleCnt = 0;
			
			for(int i = 0; i < N; ++i)
			{
				for(int j = 0; j < N; ++j)
				{
					if (!visited[i][j] && photo[i][j] == '1')
					{
						eagleCnt++;
						flood(i, j);
					}
				}
			}
			
			System.out.println("Image number " + photoCnt++ + " contains " + eagleCnt + " war eagles.");
		}
	}
}