import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
	public static Map<String, Integer> nameToId = new HashMap<String, Integer>();
	public static Map<Integer, List<Edge>> adjMap = new HashMap<Integer, List<Edge>>();
	public static int[][] sum = new int[2000][2000];
	public static Set<Integer> visited = new HashSet<Integer>();
	
	public static PriorityQueue<Language> pq = new PriorityQueue<Language>();
	
	public static class Edge
	{
		public int to;
		public String word;
		
		public Edge(int to, String word)
		{
			this.to = to;
			this.word = word;
		}
	}
	
	public static class Language implements Comparable<Language>
	{
		public int id;
		public int distance;
		public String previousWord;
		
		public Language(int id, int distance, String previousWord)
		{
			this.id = id;
			this.distance = distance;
			this.previousWord = previousWord;
		}
		
		public int compareTo(Language lang)
		{
			return distance - lang.distance;
		}
	}
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		while((line = reader.readLine()) != null)
		{
			int M = Integer.parseInt(line);
			
			if (M == 0)
			{
				break;
			}
			
			StringTokenizer token = new StringTokenizer(reader.readLine());
			String startLanguage= token.nextToken();
			String endLanguage = token.nextToken();
			
			int idCnt = 0;
			
			nameToId.clear();
			adjMap.clear();
			visited.clear();
			pq.clear();
			
			for(int i = 0; i < M; ++i)
			{
				token = new StringTokenizer(reader.readLine());
				String fromLanguage = token.nextToken();
				String toLanguage = token.nextToken();
				String word = token.nextToken();
				
				Integer fromId = nameToId.get(fromLanguage);
				
				if (fromId == null)
				{
					fromId = idCnt++;
				}
				
				nameToId.put(fromLanguage, fromId);
				
				Integer toId = nameToId.get(toLanguage);
				
				if (toId == null)
				{
					toId = idCnt++;
				}
				
				nameToId.put(toLanguage, toId);
				
				Edge edgeOne = new Edge(toId, word);
				Edge edgeTwo = new Edge(fromId, word);
				
				List<Edge> adjList = adjMap.get(fromId);
				
				if (adjList == null)
				{
					adjList = new ArrayList<Edge>();
				}
				
				adjList.add(edgeOne);
				adjList.add(edgeTwo);
				
				adjMap.put(fromId, adjList);
				
				adjList = adjMap.get(toId);
				
				if (adjList == null)
				{
					adjList = new ArrayList<Edge>();
				}
				
				adjList.add(edgeOne);
				adjList.add(edgeTwo);
				
				adjMap.put(toId, adjList);
				sum[fromId][toId] = sum[toId][fromId] = Integer.MAX_VALUE;
			}
			
			Integer startId = nameToId.get(startLanguage);
			Integer endId = nameToId.get(endLanguage);
	
			int distance = Integer.MAX_VALUE;
			
			if (startId != endId && startId != null && endId != null)
			{
				pq.offer(new Language(startId, 0, " "));
				while(!pq.isEmpty())
				{
					Language cur = pq.poll();
					
					if (cur.id == endId)
					{
						distance = cur.distance;
						break;
					}
					
					for(Edge adjEdge : adjMap.get(cur.id))
					{
						if (adjEdge.word.charAt(0) != cur.previousWord.charAt(0))
						{
							
							int altSum = cur.distance + adjEdge.word.length();
							
							if (altSum < sum[cur.id][adjEdge.to])
							{
								pq.offer(new Language(adjEdge.to, altSum, adjEdge.word));
								sum[cur.id][adjEdge.to] = altSum;
							}
						}
					}
				}
			}
			if (distance != Integer.MAX_VALUE)
			{
				System.out.println(distance);
			}
			else
			{
				System.out.println("impossivel");
			}
		}
	}
}