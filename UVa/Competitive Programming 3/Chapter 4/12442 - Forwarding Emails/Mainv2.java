import java.util.*;
import java.io.*;
import java.lang.*;

public class Main
{
	public static int[] edges = new int[50001];
	public static int[] eLeng = new int[50001];
	public static int[] counter = new int[50001];
	
	public static void main(String[] args) throws IOException
	{
		//long t1 = System.nanoTime();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		OutputStream out = new BufferedOutputStream(System.out);
		Stack<Integer> s = new Stack<Integer>();
		
		StringTokenizer tokenizer = null;
		int T = Integer.valueOf(reader.readLine());		
		String ls = System.getProperty("line.separator");
		Set<Integer> visited = new HashSet<Integer>();
		
		for(int i = 1; i <= T; i++)
		{
			int N = Integer.valueOf(reader.readLine());
			
			for(int j = 0 ; j < N; j++)
			{
				tokenizer = new StringTokenizer(reader.readLine());
				int u = Integer.valueOf(tokenizer.nextToken());
				int v = Integer.valueOf(tokenizer.nextToken());
				edges[u] = v;
				eLeng[u] = 0;
			}
			
			int maxM = 0;
			int bestM = 0;

			for(int j = N; j > 0; j--)
			{				
				int count = 0;
				int cyclei = j;	
				int lastElement = j;
				
				boolean cycle = false;	
				
				visited.clear();
				
				s.add(j);

				while(!s.empty())
				{
					lastElement = s.pop();
					
					if (eLeng[lastElement] == 0)	// if node is already calculated
					{
						if (visited.add(lastElement))
						{
							s.add(edges[lastElement]);
							counter[lastElement] = count++;
						}
						else		// cycle detected
						{
							cyclei = lastElement;
							cycle = true;
						}
					}
					else
					{
						count += eLeng[lastElement];
					}
				}

				int linearSize = count;
				
				if (cycle)
				{
					int cycleVertex = cyclei;
					int cycleSize = count - counter[cycleVertex]; 
					
					do
					{
						eLeng[cycleVertex] = cycleSize;
						cycleVertex = edges[cycleVertex];
						
					} while (cyclei != cycleVertex);
					
					lastElement = cyclei;
				}
				
				// This is wrong!
				for(int z = j; z != lastElement; z = edges[z])
				{
					eLeng[z] = linearSize--;
				}
				
				if (maxM <= eLeng[j])
				{
					maxM = eLeng[j];
					bestM = j;
				}
			}
			
			out.write(("Case " + i + ": " + bestM + ls).getBytes());
		}
		out.flush();
		//long t2 = System.nanoTime();
		//System.out.println("Execution time: " + ((t2 - t1) * 1e-6) + " milliseconds");
	}
}