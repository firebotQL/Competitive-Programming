import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws IOException
	{
		long startTime = System.nanoTime();  
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int N, M;
		StringTokenizer tokenizer = null;
		
		Set<Integer> set1 = null;
		Set<Integer> set2 = null;
		
		String ls = System.getProperty("line.separator");
		
		StringBuilder sb = new StringBuilder();
		
		while((tokenizer = new StringTokenizer(reader.readLine())).hasMoreTokens())
		{
			N = Integer.parseInt(tokenizer.nextToken());
			M = Integer.parseInt(tokenizer.nextToken());
			
			if (N == 0 && M == 0)
			{
				System.out.print(sb.toString());
				break;
			}
			
			set1 = new TreeSet<Integer>();
			set2 = new TreeSet<Integer>();
			
			while(N-- != 0)
			{
				set1.add(Integer.parseInt(reader.readLine()));
			}
			
			while(M-- != 0)
			{
				set2.add(Integer.parseInt(reader.readLine()));
			}
			
			set1.retainAll(set2);			
			
			sb.append(set1.size()).append(ls);
		}
		long estimatedTime = System.nanoTime() - startTime;
		System.out.println(estimatedTime + "ns.");
		System.out.println(estimatedTime/1000000.0 + "ms.");
	}
}