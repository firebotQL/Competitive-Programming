import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
	public static final int MAX_N = 100000;
	public static List<Long> L = new ArrayList<Long>(MAX_N);
	public static List<Long> array = new ArrayList<Long>(MAX_N);
	public static int[] L_id = new int[MAX_N];
	public static int[] P = new int[MAX_N];
	
	public static void print(int bestEnd)
	{
		StringBuffer result = new StringBuffer();
		String ls = System.getProperty("line.separator");
		
		while(P[bestEnd] >= 0)
		{
			result.insert(0, array.get(bestEnd) + ls);
			bestEnd = P[bestEnd];
		}
		
		result.insert(0, array.get(bestEnd) + ls);
		
		System.out.print(result.toString());
	}
	
	public static void main(String[] args) throws IOException
	{
		Scanner scanner = new Scanner(new InputStreamReader(System.in));
		long N;
		int index = 0, pos, bestEnd = 0, maxLength = 0;
		
		while(scanner.hasNext())
		{
			N = scanner.nextLong();
			array.add(N);
			pos = Collections.binarySearch(L, N);
			
			if (pos < 0)
			{
				pos = -(pos + 1);
			}

			if (pos >= L.size()) 
			{
				L.add(N);
			}
			else
			{
				L.set(pos, N);
			}
			
			L_id[pos] = index;
			P[index] = pos > 0 ? L_id[pos - 1] : -1;
			
			if (pos + 1 > maxLength)
			{
				maxLength = pos + 1;
				bestEnd = index;
			}
			index++;
		}
		
		System.out.println(maxLength);
		System.out.println("-");
		print(bestEnd);
	}
	
}