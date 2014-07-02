import java.util.*;
import java.io.*;
import java.lang.*;

public class Main
{
	public static String side;
	public static int maxLoad;
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int m, size;
		
		int c = Integer.valueOf(reader.readLine());
		
		int count;
		
		StringTokenizer tokenizer = null;
		Queue<Integer> q1 = null;
		Queue<Integer> q2 = null;
		
		while(c-- != 0)
		{	
			q1 = new LinkedList<Integer>();
			q2 = new LinkedList<Integer>();
			
			tokenizer = new StringTokenizer(reader.readLine());
			maxLoad = Integer.parseInt(tokenizer.nextToken()) * 100;
			m = Integer.parseInt(tokenizer.nextToken());
			
			while(m-- != 0)
			{
				tokenizer = new StringTokenizer(reader.readLine());
				size = Integer.parseInt(tokenizer.nextToken());
				side = tokenizer.nextToken();
				
				if (side.equals("left"))
					q1.add(size);
				else 
					q2.add(size);
			}
			
			count = 0;
			side = "left";
			
			while(q1.size() != 0 || q2.size() != 0)
			{		
				if (side.equals("left"))
				{
					loadAndTravelAndUnload(q1, "right");
				}
				else
				{
					loadAndTravelAndUnload(q2, "left");
				}
				count++;
			}
			
			System.out.println(count);

		}
		
		reader.close();
		System.exit(0);
	}
	
	public static void loadAndTravelAndUnload(Queue<Integer> q, String travelSide)
	{
		int load = 0;
		
		while((q.size() != 0) && (q.peek() + load <= maxLoad))
		{
			load += q.poll();
		}
		
		side = travelSide;
	}
}