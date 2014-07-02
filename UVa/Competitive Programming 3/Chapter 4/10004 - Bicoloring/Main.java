import java.util.*;
import java.io.*;
import java.lang.*;

public class Main
{
	public static Map<Integer, List<Integer> > edges = new HashMap<Integer, List<Integer> >();
	public static int[] vertColors = new int[200];
	
	public static boolean color(int color, int vertice)
	{
		vertColors[vertice] = color;
		List<Integer> adjList = edges.get(vertice);
		boolean result = true;
		
		if (adjList != null)
		{
			
			for(Integer adjVertice : adjList)
			{
				if (vertColors[adjVertice] != -1 && vertColors[adjVertice] != (1 - color))
				{
					return false;
				}
				
				if (vertColors[adjVertice] == -1)
				{
					result &= color(1 - color, adjVertice);
				}
			}
		}
		return result;
	}
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		while((line = reader.readLine()) != null)
		{
			int nodeCnt = Integer.valueOf(line);
			if (nodeCnt == 0)
			{
				break;
			}
			
			Arrays.fill(vertColors, 0, nodeCnt, -1);
		
			int edgesCnt = Integer.valueOf(reader.readLine());
			edges.clear();
			
			int startEdge = -1;
			
			while(edgesCnt-- != 0)
			{
				StringTokenizer token = new StringTokenizer(reader.readLine());
				int u = Integer.valueOf(token.nextToken());
				int v = Integer.valueOf(token.nextToken());
				
				if (startEdge == -1)
				{
					startEdge = u;
				}
				
				List<Integer> adjList = edges.get(u);
				
				if (adjList == null)
				{
					adjList = new ArrayList<Integer>();
				}
				adjList.add(v);
				edges.put(u, adjList);
			}
			
			if (color(1, startEdge))
			{
				System.out.println("BICOLORABLE.");
			}
			else
			{
				System.out.println("NOT BICOLORABLE.");
			}
		}
	}
}