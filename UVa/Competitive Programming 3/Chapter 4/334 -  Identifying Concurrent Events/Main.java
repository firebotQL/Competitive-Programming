import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
	public static boolean[][] graph = new boolean[200][200];
	public static Map<String, Integer> map = new HashMap<String, Integer>();
	public static List<String> names = new ArrayList<String>();
	
	public static class Pair{
		public int i, j;
		
		public Pair(int i, int j)
		{
			this.i = i;
			this.j = j;
		}
	}
	
	public static int getId(String token)
	{					
		Integer id = map.get(token);
					
		if (id == null)
		{
			id = names.size();
			map.put(token, id);
			names.add(token);
		}
		
		return id;
	}
	
	public static void transitiveClosureOrHull()
	{
		for(int k = 0; k < names.size(); ++k)
		for(int i = 0; i < names.size(); ++i)
		for(int j = 0; j < names.size(); ++j)
			graph[i][j] = graph[i][j] || (graph[i][k] && graph[k][j]);
	}
	
	public static List<Pair> getResult()
	{
		List<Pair> pairs = new ArrayList<Pair>();
		
		for(int i = 0; i < names.size(); ++i)
		for(int j = i + 1; j < names.size(); ++j)
			if (!graph[i][j] && !graph[j][i])
				pairs.add(new Pair(i, j));
		
		return pairs;
	}
	
	public static void main(String[] args) throws IOException
	{
		Scanner scanner = new Scanner(new InputStreamReader(System.in));
		int caseNr = 1;
		
		while(scanner.hasNextInt())
		{
			int NC = scanner.nextInt();
			names.clear();
			map.clear();
			for(boolean[] row : graph)
				Arrays.fill(row, false);
			
			if (NC == 0)
			{
				break;
			}
			
			while(NC-- != 0)
			{
				int NE = scanner.nextInt();
				
				for(int i = 0, id1 = -1; i < NE ; ++i)
				{
					int id2 = getId(scanner.next());
					
					if (i != 0)	graph[id1][id2] = true;
					
					id1 = id2;
				}
				
			}
			
			int NM = scanner.nextInt();
			
			while(NM-- != 0)
			{
				int id1 = getId(scanner.next());
				int id2 = getId(scanner.next());
				graph[id1][id2] = true;
			}
			
			transitiveClosureOrHull();
			
			List<Pair> result = getResult();
			
			if (result.isEmpty())
			{
				System.out.println("Case " + caseNr++ + ", no concurrent events.");
			}
			else
			{
				System.out.println("Case " + caseNr++ + ", " + result.size() + " concurrent events:");
				String printResult = "";
				for (int i = 0; i < result.size() && i < 2; i++) 
				{
					Pair pair = result.get(i);
					printResult += "(" + names.get(pair.i) +"," + names.get(pair.j) + ") ";
				}
				System.out.println(printResult);
			}
		}
	}
}