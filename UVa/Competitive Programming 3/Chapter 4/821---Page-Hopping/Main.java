import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
	public static int[][] dist = new int[101][101];
	public static Set<Integer> set = new HashSet<Integer>();
	
	public static void main(String[] args) throws IOException
	{
		Scanner scanner = new Scanner(new InputStreamReader(System.in));
		String line = null;
		int caseNr = 1;

		while(scanner.hasNextInt())
		{			
			int cnt = 0;
			set.clear();
			
			initDistances();
			
			while(scanner.hasNextInt())
			{
				int a = scanner.nextInt();
				int b = scanner.nextInt();
				if (a == 0 && b == 0)
				{
					break;
				}
				cnt++;
				dist[a][b] = 1;
				set.add(a);
				set.add(b);
			}
			
			if (cnt == 0)
			{
				break;
			}
			
			floidMarshall();
			
			System.out.printf("Case %d: average length between pages = %.3f clicks\n", caseNr++, getResult());
		}
		
	}
	
	public static double getResult()
	{
			double result = 0;
			int nodesToConsider = 0;
			
			for(Integer i : set)
			{
				for(Integer j : set)
				{
					if (i != j && dist[i][j] != Integer.MAX_VALUE)
					{
						nodesToConsider++;
						result += dist[i][j];
					}
				}
			}
		return result / nodesToConsider;
	}
	
	public static void floidMarshall()
	{
		for(Integer k : set)
		{
			for(Integer i : set)
			{
				for(Integer j : set)
				{
					if (dist[i][k] != Integer.MAX_VALUE
							&& dist[k][j] != Integer.MAX_VALUE)
					{
						int sum = dist[i][k] + dist[k][j];
						
						if (sum < dist[i][j])
						{
							dist[i][j] = sum;
						}
					}
				}
			}
		}
	}
	
	public static void initDistances()
	{
		for(int i = 0; i < 101; ++i)
		{
			for(int j = 0; j < 101; ++j)
			{
				if (i != j)
				{
					dist[i][j] = Integer.MAX_VALUE;
				}
				else
				{
					dist[i][j] = 0;
				}
			}
		}
	}
}
