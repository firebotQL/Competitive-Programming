import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    public static byte[][] grid = new byte[50][50];
    public static int[] dr = { -1, 0, 1, 0 };
    public static int[] dc = { 0, 1, 0,  -1};
    public static Map<String, Integer> directionMap = new HashMap<String, Integer>();
    public static Map<Integer, String> directionMap2 = new HashMap<Integer, String>();
    public static String currentDirection = null;
    
    static 
    {
        directionMap.put("north", 0);
        directionMap.put("east", 1);
        directionMap.put("south", 2);
        directionMap.put("west", 3);
        
        directionMap2.put(0, "north");
        directionMap2.put(1, "east");
        directionMap2.put(2, "south");
        directionMap2.put(3, "west");
    }
    
    public static int N, M;
    
    public static void main(String[] args) throws IOException
    {
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        while((line = reader.readLine()) != null)
        {
            StringTokenizer token = new StringTokenizer(line);
            M = Integer.parseInt(token.nextToken());
            N = Integer.parseInt(token.nextToken());
            
            if (M == 0 && N == 0)
            {
                break;
            }
            
            for(int i = 0; i < M; ++i)
            {
                token = new StringTokenizer(reader.readLine());
                for(int j = 0; j < N; ++j)
                {
                    grid[i][j] = Byte.parseByte(token.nextToken());
                }
            }
            
            token = new StringTokenizer(reader.readLine());
            
            int startX = Integer.parseInt(token.nextToken()) - 1;
            int startY = Integer.parseInt(token.nextToken()) - 1;
            
            int endX = Integer.parseInt(token.nextToken()) - 1;
            int endY = Integer.parseInt(token.nextToken()) - 1;
            print(startX, startY);
            currentDirection = token.nextToken();
            
            System.out.println(bfs(startX, startY, endX, endY));
        }
        
    }
    
    public static void markUsed(int startX, int startY)
    {
        grid[startX][startY] = 3;
    }
    
    public static int bfs(int startX, int startY, int endX, int endY)
    {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(startX);
        queue.add(startY);
        queue.add(directionMap.get(currentDirection));
        queue.add(0);
        queue.add(0);
        
        markUsed(startX, startY);
        
        while(!queue.isEmpty())
        {
            int r = queue.poll();
            int c = queue.poll();
            int d = queue.poll();
            int z = queue.poll();
            int cnt = queue.poll();
            
            if (endX == r && endY == c)
            {
                for(int j = 3; j > 0; --j)
                {
                    z += cnt / j;                            
                    cnt %= j;
                }
                
                return z;
            }
            
            for(int i = 0; i < 4; i++)
            {
                int nr = r + dr[i];
                int nc = c + dc[i];
                
                if (place(queue, nr, nc, i))
                {
                    if (d != i)
                    {
                        z += (i % 2 ==  d % 2) ? 2 : 1;
                        
                        for(int j = 3; j > 0; --j)
                        {
                            z += cnt / j;                            
                            cnt %= j;
                        }
                        cnt++;
                    }
                    else
                    {
                        cnt++;
                    }
                    
                    queue.add(z);
                    queue.add(cnt);
                }
            }
        }
        return -1;
    }
    
    public static boolean place(Queue<Integer> queue, int r, int c, int i)
    {
        if (canPlace(r, c, i))
        {
            markUsed(r, c);
            print(r, c);
            queue.add(r);
            queue.add(c);
            queue.add(i);
            return true;
        }
        return false;
    }
    
    public static void print(int nx, int ny)
    {
        System.out.println("------------");
        for(int i = 0; i < M; i++)
        {
            for(int j = 0; j < N; j++)
            {

                if ((nx == i && ny == j) || (nx == (i - 1) && ny == (j - 1))
                    || (nx == i && ny == (j - 1)) || (nx == (i - 1) && ny == j))
                {
                    System.out.print(2 + " ");
                }
                else
                {
                    System.out.print(grid[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
    
    public static boolean canPlace(int r, int c, int direction)
    {
        if (cannotPlaceBoundary(r, c, 1, 3))
        {
            return false;
        }
        
        int nr1 = 0;
        int nc1 = 0;
        
        int nr2 = 0;
        int nc2 = 0;
        
        switch(direction)
        {
            case 0:
                nr1 = nr2 = r;
                nc1 = nc2 = c + 1;
                break;
            case 1:
                nr1 = r;
                nc1 = c + 1;
                nr2 = r + 1;
                nc2 = c + 1;
                break;
            case 2:
                nr1 = r + 1;
                nc1 = c;
                nr2 = r + 1;
                nc2 = c + 1;
                break;
            case 3:
                nr1 = nr2 = r + 1;
                nc1 = nc2 = c;
                break;
        }
        
        if (cannotPlaceBoundary(nr1, nc1, 0, 1) || cannotPlaceBoundary(nr2, nc2, 0, 1) || grid[nr1][nc1] == 1 || grid[nr2][nc2] == 1)
        {
            return false;
        }
        
        return true;
    }
    
    public static boolean cannotPlaceBoundary(int r, int c, int bound, int mark)
    {
        return r < 0 || c < 0 || r >= (M - bound) || c >= (N - bound) || grid[r][c] == mark;
    }
}
