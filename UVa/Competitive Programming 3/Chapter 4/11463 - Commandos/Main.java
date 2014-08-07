import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
	public static int[][] dist = new int[101][101];
	public static Set<Integer> set = new HashSet<Integer>();
	public static int N = 0;
	
	public static void main(String[] args) throws IOException
	{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			int T = Integer.parseInt(reader.readLine());
			for(int caseNr = 1; caseNr <= T; ++caseNr)
			{
				N = Integer.parseInt(reader.readLine());
				int R = Integer.parseInt(reader.readLine());
				
				initDistance();
				set.clear();
				
				for(int i = 0; i < R; ++i)
				{
					StringTokenizer token = new StringTokenizer(reader.readLine());
					int u = Integer.parseInt(token.nextToken());
					int v = Integer.parseInt(token.nextToken());
					dist[u][v] = dist[v][u] = 1;
					set.add(u);
					set.add(v);
				}
				
				floydMarshall();
				StringTokenizer token = new StringTokenizer(reader.readLine());
				int s = Integer.parseInt(token.nextToken());
				int d = Integer.parseInt(token.nextToken());
				
				System.out.println("Case " + caseNr + ": " + getResult(s, d));
			}
	}
	
	public static int getResult(int s, int d)
	{
			int result = 0;
			
			for(Integer i : set)
			{
				result = Math.max(result, dist[s][i] + dist[i][d]);
			}
			
			return result;
	}
	
	public static void floydMarshall()
	{
		for(Integer k : set)
		{
			for(Integer i : set)
			{
				for(Integer j : set)
				{
						dist[i][j] = Math.min(dist[i][k] + dist[k][j], dist[i][j]);
				}
			}
		}
	}
	
	public static void initDistance()
	{
		for(int i = 0; i < N; ++i)
		{
			for(int j = 0; j < N; ++j)
			{
				dist[i][j] = (i == j) ? 0 : (int)1e7;
			}
		}
	}
}
