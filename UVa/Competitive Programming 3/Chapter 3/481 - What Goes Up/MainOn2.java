import java.util.*;
import java.lang.*;
import java.io.*;

public class MainOn2
{
	public static List<Integer> array = new ArrayList<Integer>(1000);
	
	public static void main(String[] args) throws IOException
	{
		Scanner scanner = new Scanner(new InputStreamReader(System.in));
		
		
		while(scanner.hasNext())
		{
			array.add(scanner.nextLong());
		}
		
		int N = array.size();
		
		int[] DP = new int[N];
		int[] prev = new int[N];
		
		int maxLength = 1, bestEnd = 0, i, j;
		
		DP[0] = 1;
		prev[0] = -1;
		List<Long> L = new ArrayList<Long>();
		
		for(i = 1; i < N; i++)
		{
			DP[i] = 1;
			prev[i] = -1;
			
			
			for(j = i - 1; j >= 0; j--)
			{
				// previous element bigger than current
				// then set current as previous + 1
				if (DP[j] + 1 > DP[i] && array.get(j) < array.get(i)) 
				{
					DP[i] = DP[j] + 1;
					prev[i] = j;
				}
			}
			
			if (DP[i] >= maxLength)
			{
				bestEnd = i;
				maxLength = DP[i];
			}
			
		}
		
		System.out.println(maxLength);
		System.out.println('-');
		
		StringBuffer result = new StringBuffer();
		while(bestEnd != -1)
		{
			result.insert(0, array.get(bestEnd) + System.lineSeparator());
			bestEnd = prev[bestEnd];
		}
		System.out.print(result.toString());
	}
}