import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
	public static String[] dict = new String[200];
	public static Map<String, Integer> nameToIndex = new HashMap<String, Integer>();
	public static Map<Integer, List<Integer>> adjMap = new HashMap<Integer, List<Integer>>();
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        int N = Integer.parseInt(reader.readLine());
        reader.readLine();
		
        for(int cases = 0; cases < N; ++cases)
        {
            int index = 0;
            adjMap.clear();
            nameToIndex.clear();
            
            if (cases != 0)
            {
                System.out.println();
            }
            
            while((line = reader.readLine()) != null && !(line.length() == 1 && line.charAt(0) == '*'))
            {
                dict[index] = line;
                nameToIndex.put(line, index);
                adjMap.put(index++, new ArrayList<Integer>());
            }
            
            for(int i = 0; i < index; ++i)
            {
                for(int j = i + 1; j < index; ++j)
                {
                    if (isAdjacent(dict[i], dict[j]))
                    {
                        adjMap.get(i).add(j);
                        adjMap.get(j).add(i);
                    }
                }
            }
            
            while((line = reader.readLine()) != null && !line.isEmpty())
            {
                StringTokenizer token = new StringTokenizer(line);
                int firstIndex = nameToIndex.get(token.nextToken());
                int secondIndex = nameToIndex.get(token.nextToken());
                
                System.out.println(line + " " + bfs(firstIndex, secondIndex));
            }
            
        }
        
    }
    
    public static int bfs(int start, int end)
    {
        Queue<Integer> currentLevel = new LinkedList<Integer>();
        Queue<Integer> nextLevel = new LinkedList<Integer>();
        Set<Integer> V = new HashSet<Integer>();
        
        currentLevel.add(start);        
        V.add(start);
        
        int levelCounter = 0;
        
        while(!currentLevel.isEmpty())
        {
            int t = currentLevel.poll();
            
            if (t == end)
            {
                return levelCounter;
            }
            
            List<Integer> adjVertices = adjMap.get(t);
            
            for(Integer adjVertex : adjVertices)
            {
                if (V.add(adjVertex))
                {
                    nextLevel.add(adjVertex);
                }
            }
            
            if (currentLevel.isEmpty())
            {
                levelCounter++;
                Queue<Integer> tmpLevel = currentLevel;
                currentLevel = nextLevel;
                nextLevel = tmpLevel;
            }
        }
        
        return levelCounter;
    }
    public static boolean isAdjacent(String one, String two)
    {
        if (one.length() == 0 || two.length() == 0 || one.length() != two.length())
        {
            return false;
        }
        
        int diffCnt = 0;
        for(int i = 0; i < one.length() && diffCnt <= 1; ++i)
        {
            if (one.charAt(i) != two.charAt(i))
            {
                diffCnt++;
            }
        }
        
        return diffCnt == 1;
    }
}