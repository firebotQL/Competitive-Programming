import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    public static int[] logTable;
	public static int[][] rmq;	
	
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        while((line = reader.readLine()) != null)
        {
            StringTokenizer token = new StringTokenizer(line);
            int N = Integer.parseInt(token.nextToken());
            int T = Integer.parseInt(token.nextToken());
            token = new StringTokenizer(reader.readLine());
			
            byte[] segments = new byte[N];
			
            for(int i = 0; i < N; ++i)
            {
                segments[i] = Byte.parseByte(token.nextToken());
            }
			
			createRmqSparseTable(segments);
			
			for(int i = 0; i < T; ++i)
			{
				token = new StringTokenizer(reader.readLine());
				int s = Integer.parseInt(token.nextToken());
				int e = Integer.parseInt(token.nextToken());
				
				System.out.println(min(segments, s, e));
			}
        }
    }
	
	public static void createRmqSparseTable(byte[] array)
	{
		int n = array.length;
		logTable = new int[n + 1];
		
		for(int i = 2; i <= n; ++i)
		{
			logTable[i] = logTable[i >> 1] + 1;
		}
		
		rmq = new int[logTable[n] + 1][n];
		
		for(int i = 0; i < n; ++i)
		{
			rmq[0][i] = i;
		}
		
		for(int k = 1; (1 << k) < n; ++k)
		{
			for(int i = 0; i + (1 << k) <= n; ++i)
			{
				int x = rmq[k - 1][i];
				int y = rmq[k - 1][i + (1 << k - 1)];
				rmq[k][i] = array[x] <= array[y] ? x : y;
			}
		}
	}
	
	public static int min(byte[] array, int i, int j)
	{
		int k = logTable[j - i];
		int x = rmq[k][i];
		int y = rmq[k][j - (1 << k) + 1];
		return Math.min(array[x], array[y]);
	}
}
