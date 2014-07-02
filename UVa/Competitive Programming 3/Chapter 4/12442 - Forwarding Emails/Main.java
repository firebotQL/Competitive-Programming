import java.util.*;
import java.io.*;
import java.lang.*;

public class Main
{
	public static int[] graph = new int[50001];
	public static int[] sum = new int[50001];
	public static boolean[] visited = new boolean[50001];
	
	public static int dfs(int u)
	{
		visited[u] = true;
		int total = 0;
		if (graph[u] != -1 && !visited[graph[u]])
		{
			total += 1 + dfs(graph[u]);
		}
		visited[u] = false;
		return sum[u] = total;
	}
	
	public static void main(String[] args) throws IOException
	{
		//long t1 = System.nanoTime();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));	
		StringTokenizer tokenizer = null;
		
		int T = Integer.valueOf(reader.readLine());		
		for(int i = 1; i <= T; i++)
		{
			int N = Integer.valueOf(reader.readLine());

			for(int j = 0 ; j < N; j++)
			{
				tokenizer = new StringTokenizer(reader.readLine());
				int u = Integer.valueOf(tokenizer.nextToken());
				int v = Integer.valueOf(tokenizer.nextToken());
				graph[u] = v;
				visited[u] = false;
				sum[u] = -1;
			}
			
			int bestLen = 0, answer = 0;
			
			for(int z = 1; z <= N; z++)
			{
				if (sum[z] == -1) dfs(z);
				if (sum[z] > bestLen)
				{
					bestLen = sum[z];
					answer = z;
				}
			}
			System.out.println("Case " + i + ": " + answer);
		}
		
		//long t2 = System.nanoTime();
		//System.out.println("Execution time: " + ((t2 - t1) * 1e-6) + " milliseconds");
	}
}