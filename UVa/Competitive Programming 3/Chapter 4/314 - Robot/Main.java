import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
   public static byte[][] grid = new byte[50][50];
    public static boolean[][][] visited = new boolean[50][50][4];
    
    public static int[] dr = { -1, 0, 1, 0 };
    public static int[] dc = { 0, 1, 0, -1};
    
    public static int[] robotr = { 0, 0, 1, 1 };
    public static int[] robotc = { 0, 1, 0, 1 };
    
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
    
    public static int bfs(int startX, int startY, int endX, int endY)
    {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(startX);
        queue.add(startY);
        queue.add(directionMap.get(currentDirection));
        queue.add(0);
        queue.add(0);
        
        markUsed(startX, startY, directionMap.get(currentDirection));
        int result = Integer.MAX_VALUE;
        
        while(!queue.isEmpty())
        {
            int r = queue.poll();
            int c = queue.poll();
            int d = queue.poll();
            int z = queue.poll();
            int cnt = queue.poll();
            
            if (endX == r && endY == c)
            {
                print(r, c);
                
                int z1 = z;
                int cnt1 = cnt;
                
                for(int j = 3; j > 0; --j)
                {
                    z1 += cnt1 / j;                            
                    cnt1 %= j;
                }
                
                result = Math.min(result, z1);
            }
            
            for(int i = 0; i < 4; i++)
            {
                int nr = r + dr[i];
                int nc = c + dc[i];
                
                while (canPlace(nr, nc, i))
                {
                    markUsed(nr, nc, i);
                    print(r, c);
                    
                    queue.add(r);
                    queue.add(c);
                    queue.add(i);
                    
                    if (d != i)
                    {
                        z += getSecondsPerTurn(i, d);
                        
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
        return result;
    }
    
    public static int getSecondsPerTurn(int i, int d)
    {
        return (i % 2 ==  d % 2) ? 2 : 1;
    }
    
    public static boolean place(Queue<Integer> queue, int r, int c, int i)
    {
        if (canPlace(r, c, i))
        {
            
            return true;
        }
        return false;
    }
    
    public static void markUsed(int startX, int startY, int d)
    {
        visited[startX][startY][d] = true;
    }
    
    public static boolean canPlace(int r, int c, int direction)
    { 
        // 1. Is robot within boundaries?
        for(int i = 0; i < 4; ++i)
        {        
            if (!inBoundary(r + robotr[i], c + robotc[i]))
            {
                return false;
            }
        }

        // 2. Is this location already been visited?
        if (visited[r][c][direction])
        {
            return false;
        }
        
        // 3. Is this location contains obstacles?
        for(int i = 0; i < 4; ++i)
        { 
            if (isObstacle(r + robotr[i], c + robotc[i]))
            {
                return false;
            }
        }
        
        return true;
    }
    
    
    public static boolean inBoundary(int r, int c)
    {
        return r >= 0 && c >= 0 && r < M && c < N; 
    }
    
    public static boolean isObstacle(int r, int c)
    {
        return  grid[r][c] == 1;
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
                    System.out.print("* ");
                }
                else
                {
                    System.out.print(grid[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
