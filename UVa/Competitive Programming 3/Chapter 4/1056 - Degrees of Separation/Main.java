import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
	public static int[][] dist = null;
	public static Map<String, Integer> map = new HashMap<String, Integer>();	
	
	public static int getId(String token)
	{					
		Integer id = map.get(token);
					
		if (id == null)
		{
			id = map.size();
			map.put(token, id);
		}
		
		return id;
	}
	
	public static void solve()
	{
		for(int k = 0; k < dist.length; k++)
			for(int i = 0; i < dist.length; i++)
				for(int j = 0; j < dist.length; j++)
					dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
	}
	
	public static int getResult()
	{	
		int max = 0;
		for(int i = 0; i < dist.length; i++)
			for(int j = i + 1; j < dist.length; j++)
				max = Math.max(max, dist[i][j]);
		
		return max;
	}
	
	public static void main(String[] args) throws IOException
	{
		Scanner scanner = new Scanner(new InputStreamReader(System.in));
		int networkNr = 1;
		
		while(true)
		{
			int P = scanner.nextInt();
			int R = scanner.nextInt();
			
			if (P == 0 && R == 0)
			{
				break;
			}
			
			dist = new int[P][P]; 
			
			map.clear();
			
			for(int[] row : dist)
				Arrays.fill(row, 127);	
				
			for(int i = 0; i < dist.length; i++)
				dist[i][i] = 0;
				
			while(R-- != 0)
			{
				int id1 = getId(scanner.next());
				int id2 = getId(scanner.next());
				dist[id1][id2] = dist[id2][id1] = 1;
			}
			
			solve();
			
			int result = getResult();
			
			if (result != 127)
			{
				System.out.printf("Network %d: %d\n\n", networkNr++, result);
			}
			else
			{
				System.out.printf("Network %d: DISCONNECTED\n\n", networkNr++);
			}
		}
	}
}