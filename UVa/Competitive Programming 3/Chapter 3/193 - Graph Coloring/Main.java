import java.io.*;

public class Main
{
	public static int n = 0;
	public static int minimumWhiteColorCnt = 0;
	public static boolean[] resultColored = null;
	public static boolean[] colored = null;
	public static boolean[][] graph = null;
	
	public static void color(int index, int whiteColorCnt)
	{
		if (index > n)
		{
			if (whiteColorCnt < minimumWhiteColorCnt)
			{
				minimumWhiteColorCnt = whiteColorCnt;
				resultColored = colored.clone();
			}
		}
		else
		{
			 boolean canColorBlack = true;
			 for(int j = 1; j < graph.length; j++)
			 {
				 if (graph[index][j])
				 {
					 canColorBlack = canColorBlack && !colored[j];
				 }
			 }
			 
			 if (canColorBlack)
			 {
				 colored[index] = true;
				 color(index + 1, whiteColorCnt);
				 colored[index] = false;
			 }
			 
			 color(index + 1, whiteColorCnt + 1);
		}
	}
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		String[] separatedLine = null;
		int m, k, e1, e2;
		m = Integer.valueOf(reader.readLine());

		
		
		while(m-- != 0)
		{
			separatedLine = reader.readLine().split("\\s+");
			n = Integer.valueOf(separatedLine[0]);
			k = Integer.valueOf(separatedLine[1]);
			
			graph = new boolean[n + 1][n + 1];
			
			while(k-- != 0)
			{
				separatedLine = reader.readLine().split("\\s+");
				e1 = Integer.valueOf(separatedLine[0]);
				e2 = Integer.valueOf(separatedLine[1]);
				
				graph[e1][e2] = graph[e2][e1] = true;

			}
			
			colored = new boolean[n + 1];
			minimumWhiteColorCnt = n;
			
			color(1, 0);
			
			System.out.println(n - minimumWhiteColorCnt);
			int cnt = 0;
			for(int i = 1; i < resultColored.length; i++)
			{
				if (resultColored[i])
				{
					if (cnt != 0)
					{
						System.out.print(" " + i);
					}
					else
					{
						System.out.print(i);
					}
					cnt++;
				}
				

			}
			System.out.println();
		}
		
	}
	

}