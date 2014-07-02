import java.lang.*;
import java.io.*;
import java.util.*;

public class Main
{
	public static Set<Character> visited = new HashSet<Character>();
	public static Map<Character, List<Character>> edges = new HashMap<Character, List<Character>>();
	public static List<Character> list = new ArrayList<Character>();
	public static int nodesCount = 0;
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int caseCnt = Integer.valueOf(reader.readLine());

		while(caseCnt-- != 0)
		{
			reader.readLine();
			StringTokenizer token = new StringTokenizer(reader.readLine());
			list.clear();
			nodesCount = 0;
			while(token.hasMoreTokens())
			{
				list.add(token.nextToken().charAt(0));
				nodesCount++;
			}
			
			token = new StringTokenizer(reader.readLine());
			edges.clear();
			
			while(token.hasMoreTokens())
			{
				String eq = token.nextToken();
				char u = eq.charAt(0);
				char v = eq.charAt(2);
				List<Character> adjList = edges.get(u);
				
				if (adjList == null)
				{
					adjList = new ArrayList<Character>();
				}
				
				adjList.add(v);
				
				edges.put(u, adjList);
			}
			
			visited.clear();
			
			if (!visit("", 0))
			{
				System.out.println("NO");
			}
			
			if(caseCnt != 0)
			{
				System.out.println();
			}
		}
	}
	
	public static boolean valid(char node)
	{
		List<Character> adjList = edges.get(node);
		for(int i = 0; adjList != null && i < adjList.size(); i++)
		{
			if (visited.contains(adjList.get(i)))
			{
				return false;
			}
		}
		return true;
	}
	
	public static boolean visit(String result, int rNodeCount)
	{		
		if (rNodeCount == nodesCount)
		{
			System.out.println(result.substring(1, result.length()));
			return true;
		}
		
		boolean answer = false;
		
		for(int i = 0; i < list.size(); i++)
		{
			char ch = list.get(i);
			if (!visited.contains(ch))
			{
				if (valid(ch))
				{
						visited.add(ch);
						answer |= visit(result + " " + ch, rNodeCount + 1);
						visited.remove(ch);
				}
			}
		}
		
		return answer;
	}
}