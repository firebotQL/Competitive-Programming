import java.util.*;
import java.io.*;

public class Main
{
    public static int size = 26;
    public static int[][] dist1 = new int[size][size];
    public static int[][] dist2 = new int[size][size];
    
    public static Set<Integer> set1 = new HashSet<Integer>();
    public static Set<Integer> set2 = new HashSet<Integer>();
    
    public static PriorityQueue<Place> result = new PriorityQueue<Place>();
    
    static class Place implements Comparable<Place>
    {
        char place;
        int cost;
        
        public Place(char place, int cost)
        {
            this.place = place;
            this.cost = cost;
        }
        @Override
        public int compareTo(Place other)
        {
            return this.place - other.place;
        }
    }
    
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
         String line = null;
        while((line = reader.readLine()) != null)
        {
            int N = Integer.parseInt(line);
            
            if (N == 0)
            {
                break;
            }
            
            initDistances(dist1);
            initDistances(dist2);
            
            set1.clear();
            set2.clear();
            
            while(N-- != 0)
            {
                StringTokenizer token = new StringTokenizer(reader.readLine());
                char age = token.nextToken().charAt(0);
                char direction = token.nextToken().charAt(0);
                int startPos = token.nextToken().charAt(0) - 'A';
                int endPos = token.nextToken().charAt(0) - 'A';
                int weight = Integer.parseInt(token.nextToken());
                if (age == 'Y')
                {
                    fill(startPos, endPos, weight, direction, dist1, set1);
                }
                else
                {
                    fill(startPos, endPos, weight, direction, dist2, set2);
                }
            }
            
            StringTokenizer token = new StringTokenizer(reader.readLine());
            int dist1Pos = token.nextToken().charAt(0) - 'A';
            int dist2Pos = token.nextToken().charAt(0) - 'A';
            
			set1.add(dist1Pos);
            set2.add(dist2Pos);
			
            Set<Integer> intersection = new HashSet<Integer>(set1);
            intersection.retainAll(set2);
            
            if (intersection.isEmpty())
            {
                System.out.println("You will never meet.");
            }
            else
            {
                floydMarshall(dist1, set1);
                floydMarshall(dist2, set2);
                
                int minDistance = Integer.MAX_VALUE;
                
                for(Integer i : intersection)
                {
                    if (dist1[dist1Pos][i] != Integer.MAX_VALUE && dist2[dist2Pos][i] != Integer.MAX_VALUE)
                    {
                        int dist = dist1[dist1Pos][i] + dist2[dist2Pos][i];
                        if (dist < minDistance)
                        {
                            minDistance = dist;
                            result.clear();
                            result.offer(new Place((char)(i.intValue() + 'A'), dist));
                        }
                        else if (dist == minDistance)
                        {
                            result.offer(new Place((char)(i.intValue() + 'A'), dist));
                        }
                    }
                }
                
				if (!result.isEmpty())
				{
					StringBuffer buff = new StringBuffer();
					buff.append(minDistance).append(" ");
					while (!result.isEmpty())
					{
						Place place = result.poll();
						buff.append(place.place);
						if (!result.isEmpty())
						{
							buff.append(" ");
						}
					}
					
					System.out.println(buff.toString());
				}
				else
				{
					System.out.println("You will never meet.");
				}
            }
        }
    }
    
    public static void floydMarshall(int[][] dist, Set<Integer> set)
    {
        for(Integer k : set)
        {
            for(Integer i : set)
            {
                for(Integer j : set)
                {
                    if (dist[i][k] != Integer.MAX_VALUE
                            && dist[k][j] != Integer.MAX_VALUE)
                    {
                        int sum = dist[i][k] + dist[k][j];
                        
                        if (sum < dist[i][j])
                        {
                            dist[i][j] = sum;
                        }
                    }
                }
            }
        }
    }
    
    public static void fill(int s, int e, int w, char d, int[][] dist, Set<Integer> set)
    {
        set.add(s);
        set.add(e);
        dist[s][e] = Math.min(w, dist[s][e]);
        
        if (d == 'B')
        {
            dist[e][s] = Math.min(w, dist[e][s]);
        }
    }
    
    public static void initDistances(int[][] dist)
    {
        for(int i = 0; i < size; ++i)
        {
            for(int j = 0; j < size; ++j)
            {
                if (i != j)
                {
                    dist[i][j] = Integer.MAX_VALUE;
                }
                else
                {
                    dist[i][j] = 0;
                }
            }
        }
    }
}
