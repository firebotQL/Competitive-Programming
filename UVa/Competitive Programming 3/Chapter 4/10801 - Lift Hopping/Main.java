import java.util.*;
import java.io.*;

public class Main
{
    public static int[] cost = new int[5];
    public static boolean[][] visited = new boolean[5][100];
    public static Map<Integer, List<Integer>> adjMap = new HashMap<Integer, List<Integer>>();
    public static boolean[][] levels = new boolean[5][100];
    public static int[][] levelsToNr = new int[5][100];
    public static int[][] sum = new int[5][100];
    
    public static int[] di = { 1, -1 };
    
    public static PriorityQueue<Level> pq = new PriorityQueue<Level>();
    
    public static class Level implements Comparable<Level>
    {
        int elevator;
        int nr;
        int level;
        int distance;
        public Level(int elevator, int nr, int level, int distance)
        {
            this.elevator = elevator;
            this.nr = nr;
            this.level = level;
            this.distance = distance;
        }
        
        public int compareTo(Level level)
        {
            return this.distance - level.distance;
        }
    }
    
    public static void main(String[] args) throws IOException
    {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        while((line = reader.readLine()) != null)
        {
            StringTokenizer token = new StringTokenizer(line);
            int n = Integer.parseInt(token.nextToken());
            int k = Integer.parseInt(token.nextToken());

            adjMap.clear();
            
            levels = new boolean[5][100];
            
            StringTokenizer costTokenizer = new StringTokenizer(reader.readLine());
            
            for(int i = 0; i < n; i++)
            {
                cost[i] = Integer.parseInt(costTokenizer.nextToken());
                adjMap.put(i, new ArrayList<Integer>());
            }
            
            for(int i = 0; i < n; i++)
            {
                int cnt = 0;
                StringTokenizer levelTokenizer = new StringTokenizer(reader.readLine());
                
                List<Integer> adjLevels = adjMap.get(i);
                
                while(levelTokenizer.hasMoreTokens())
                {
                    int level = Integer.parseInt(levelTokenizer.nextToken());
                    levels[i][level] = true;
                    sum[i][level] = Integer.MAX_VALUE;
                    levelsToNr[i][level] = cnt++;
                    adjLevels.add(level);
                }
                
            }
            
            int min = Integer.MAX_VALUE;
            
            for(int i = 0; i < n; i++)
            {
                pq.clear();
                if (levels[i][0])
                {
                    visited = new boolean[5][100];
                    pq.offer(new Level(i, 0, 0, 0));
                    
                    while(!pq.isEmpty())
                    {
                        Level level = pq.poll();
                        
                        if (level.level == k)
                        {
                            min = Math.min(min, level.distance);
                            break;
                        }
                        else if (!visited[level.elevator][level.level])
                        {
                            visited[level.elevator][level.level] = true;
                            
                            // 1. move to adjacent level
                            for(int j = 0; j < 2; j++)
                            {
                                int adjLevelNr = level.nr + di[j];
                                List<Integer> adjLevels = adjMap.get(level.elevator);
                                if (adjLevelNr >= 0 && adjLevelNr < adjLevels.size() && !visited[level.elevator][adjLevels.get(adjLevelNr)])
                                {
                                    int adjLevel = adjLevels.get(adjLevelNr);
                                    int altSum = level.distance + cost[level.elevator] * Math.abs(level.level - adjLevel) ;
                                    
                                    if (altSum < sum[level.elevator][adjLevel])
                                    {
                                       pq.offer(new Level(level.elevator, adjLevelNr, adjLevels.get(adjLevelNr),  altSum));
                                       sum[level.elevator][adjLevelNr] = altSum;
                                    }
                                }
                            }
                            
                            // 2. hop adjacent elevator
                            for(int j = 0; j < n; j++)
                            {
                                if (j != level.elevator)
                                {
                                    int adjElevator = j;
                                    
                                    if (adjElevator >= 0 && adjElevator < n && levels[adjElevator][level.level] && !visited[adjElevator][level.level])
                                    {
                                        int altSum = level.distance + 60;
                                        
                                        if (altSum < sum[adjElevator][level.level])
                                        {
                                            pq.offer(new Level(adjElevator, levelsToNr[adjElevator][level.level], level.level, altSum));
                                            sum[adjElevator][level.level] = altSum;
                                        }
                                    }
                                }
                            }                           
                        }
                    }
                }
            }
            
            if (min == Integer.MAX_VALUE)
            {
                System.out.println("IMPOSSIBLE");
            }
            else
            {
                System.out.println(min);
            }
        }
    }
}
