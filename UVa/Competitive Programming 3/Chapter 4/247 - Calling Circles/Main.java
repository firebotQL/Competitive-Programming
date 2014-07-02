import java.util.*;
import java.io.*;

public class Main
{
    public static Map<String, Integer> nameToIndex = new HashMap<String, Integer>();
    public static String[] indexToName = new String[26];
    public static Map<Integer, List<Integer>> adjMap = new HashMap<Integer, List<Integer>>();
    public static Stack<Integer> stack = new Stack<Integer>();
    public static List<List<Integer>> result = new ArrayList<List<Integer>>();
    
    public static int[] tarIndex = new int[26];
    public static int[] lowLink = new int[26];
    public static int indexCnt = 0;
    public static int time = 0;
    

    public static void main(String[] args) throws IOException
    {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
        int testCaseNr = 1;
        boolean first = true;
        
        while((line = reader.readLine()) != null)
        {
            StringTokenizer token = new StringTokenizer(line);
            int n = Integer.valueOf(token.nextToken());
            int m = Integer.valueOf(token.nextToken());
            
            if (n == 0 && m == 0)
            {
                break;
            }
            
            if (!first)
            {
                System.out.println();
            }
            
            first = false;
            indexCnt = time = 0;
    
            adjMap.clear();
            result.clear();
            stack.clear();
            nameToIndex.clear();
            
            for(int i = 0; i < n; i++)
            {
                tarIndex[i] = lowLink[i] = -1;
                indexToName[i] = "";
                adjMap.put(i, new ArrayList<Integer>());
            }

            
            while(m-- != 0)
            {
                line = reader.readLine();
                token = new StringTokenizer(line);
                String nameFrom = token.nextToken();
                String nameTo = token.nextToken();
                
                Integer indexFrom = getIndex(nameFrom);             
                Integer indexTo = getIndex(nameTo);             

                
                //if (!adjMap.get(indexFrom).contains(indexTo))
                //{
                    adjMap.get(indexFrom).add(indexTo);
                //}
            }
            
            solve(n);
            
            System.out.println("Calling circles for data set " + testCaseNr++ + ":");
            
            for(List<Integer> SCC : result)
            {
                for (int i = 0; i < SCC.size(); i++)
                {
                    System.out.print(indexToName[SCC.get(i)]);
                    
                    if(i+1 != SCC.size())
                    {
                        System.out.print(", ");
                    }
                }
                System.out.println();
            }
        }
    }
    
    public static void solve(int size)
    {
        for(int i = 0; i < size; i++)
        {
            if (tarIndex[i] == -1)
            {
                strongConnect(i);
            }
        }
    }
    
    public static void strongConnect(int vertex)
    {
        tarIndex[vertex] = lowLink[vertex] = time++;
        stack.push(vertex);
        
        List<Integer> adjList = adjMap.get(vertex);
        for(Integer successor : adjList)
        {
            if (tarIndex[successor] == -1)
            {
                strongConnect(successor);
                lowLink[vertex] = Math.min(lowLink[vertex], lowLink[successor]);
            }
            else if (stack.search(successor) != -1)
            {
                lowLink[vertex] = Math.min(lowLink[vertex], tarIndex[successor]);
            }
        }
        
        if (lowLink[vertex] == tarIndex[vertex])
        {
            List<Integer> newSCC = new ArrayList<Integer>();
            Integer successor = null;
            do
            {
                if (stack.size() != 0)
                {
                    successor = stack.pop();
                    newSCC.add(successor);
                }
            } while (successor != null && successor != vertex);
            result.add(newSCC);
        }
    }
    
    public static int getIndex(String name)
    {
        
        Integer index = nameToIndex.get(name);
                
        if (index == null)
        {
            index = indexCnt++;
            nameToIndex.put(name, index);
            indexToName[index] = name;
        }

        return index;
    }
}