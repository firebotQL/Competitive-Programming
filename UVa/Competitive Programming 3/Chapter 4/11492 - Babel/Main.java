import java.util.*;
import java.io.*;

public class Main
{
	public static Map<String, Integer> nameToId = new HashMap<String, Integer>();
	public static Map<Integer, List<Edge>> adjMap = new HashMap<Integer, List<Edge>>();
	public static int[][] sum = new int[4002][4002];
	
	public static PriorityQueue<Language> pq = new PriorityQueue<Language>();
	public static int idCnt = 0;
	
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
	
	public static int addId(String str)
	{
		Integer id = nameToId.get(str);
                
		if (id == null)
		{
			id = idCnt++;
		}
		
		nameToId.put(str, id);
		
		return id;
	}
	
	public static void addEdge(int fromId, int toId, String word)
	{
		List<Edge> adjList = adjMap.get(fromId);
                
		if (adjList == null)
		{
			adjList = new ArrayList<Edge>();
		}
		
		adjList.add(new Edge(toId, word));
		
		adjMap.put(fromId, adjList);
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
            String startLanguage = token.nextToken();
            String endLanguage = token.nextToken();
            
			idCnt = 0;
            nameToId.clear();
            adjMap.clear();
            pq.clear();
            
            for(int i = 0; i < M; ++i)
            {
                token = new StringTokenizer(reader.readLine());
                String fromLanguage = token.nextToken();
                String toLanguage = token.nextToken();
                String word = token.nextToken();
                
                int fromId = addId(fromLanguage);                
                int toId = addId(toLanguage);
                
                addEdge(fromId, toId, word);
                addEdge(toId, fromId, word);

                sum[fromId][toId] = sum[toId][fromId] = Integer.MAX_VALUE;
            }
            
            Integer startId = nameToId.get(startLanguage);
            Integer endId = nameToId.get(endLanguage);
    
            int distance = Integer.MAX_VALUE;
            
            if (startId != null && endId != null && startId != endId)
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
                        if (adjEdge.to != cur.id && adjEdge.word.charAt(0) != cur.previousWord.charAt(0))
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
                
                for(int i = 0; i <= idCnt; i++)
                {
                    for(int j = 0; j <= idCnt; j++)
                    {
                        sum[i][j] = Integer.MAX_VALUE;
                    }
                }
                
                pq.clear();
                
                pq.offer(new Language(endId, 0, " "));
                
                int distance2 = Integer.MAX_VALUE;
                
                while(!pq.isEmpty())
                {
                    Language cur = pq.poll();
                    
                    if (cur.id == startId)
                    {
                        distance = cur.distance;
                        break;
                    }
                    
                    for(Edge adjEdge : adjMap.get(cur.id))
                    {
                        if (adjEdge.to != cur.id && adjEdge.word.charAt(0) != cur.previousWord.charAt(0))
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
                
                distance = Math.min(distance, distance2);
            }
            
            if (startId == endId && startId != null && endId != null)	// Same language
            {
                System.out.println(0);
            }
            else if (distance != Integer.MAX_VALUE)						// Found distance
            {
                System.out.println(distance);
            }
            else														// Either distance not found or language doesn't exist in dictionary
            {
                System.out.println("impossivel");
            }
        }
    }
}
