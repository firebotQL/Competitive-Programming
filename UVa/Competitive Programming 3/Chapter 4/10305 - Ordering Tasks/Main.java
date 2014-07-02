import java.lang.*;
import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		Set<Integer> set = new HashSet<Integer>();
		Map<Integer, List<Integer> > adj = new HashMap<Integer, List<Integer> >();
		
		while((line = reader.readLine()) != null)
		{
			StringTokenizer token = new StringTokenizer(line);
			int n = Integer.valueOf(token.nextToken());
			int m = Integer.valueOf(token.nextToken());
			
			if (n == 0 && m == 0)
			{
				break;
			}
			
			adj.clear();
			set.clear();
			
			for(int i = 0; i < n; i++)
			{
				set.add(i);
			}

			for(int i = 0; i < m; i++)
			{
				token = new StringTokenizer(reader.readLine());
				int u = Integer.valueOf(token.nextToken());
				int v = Integer.valueOf(token.nextToken());
				
				List<Integer> adjList = adj.get(u - 1);
				
				if (adjList == null)
				{
					adjList = new ArrayList<Integer>();
				}
				
				adjList.add(v - 1);
				adj.put(u - 1, adjList);				
				set.remove(v - 1);
			}
			
			List<Integer> result = new ArrayList<Integer>();
			Queue<Integer> S = new LinkedList<Integer>(set);
			//System.out.println(S);
			while(S.size() > 0)
			{
				int node = S.poll();
				result.add(node + 1);
				List<Integer> adjList = adj.get(node);
				
				if (adjList != null)
				{
					for(Iterator<Integer> it = adjList.iterator(); it.hasNext(); )
					{
						Integer el = it.next();
						it.remove();
						boolean found = false;
						
						for (Map.Entry<Integer, List<Integer>> entry : adj.entrySet()) 
						{
							List<Integer> value = entry.getValue();
							if (value != null && value.contains(el))
							{
								found = true;
								break;
							}
						}
						
						if (!found)
						{
							S.add(el);
						}
					}
				}
				
			}
			
			for(int i = 0; i < result.size(); i++)
			{
				if (result.size() == i + 1)
				{
					System.out.println(result.get(i));
				}
				else
				{
					System.out.print(result.get(i) + " ");
				}
			}
		}
	}
}