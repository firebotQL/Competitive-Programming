import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
	public static List<Long> S = new ArrayList<Long>(10000);
	public static List<Long> array = new ArrayList<Long>(10000);
	public static List<Integer> previous = new ArrayList<Integer>(10000);
	
	public static void main(String[] args) throws IOException
	{
		Scanner scanner = new Scanner(new InputStreamReader(System.in));
		
		int index;
		int bestEnd = 0;
		int maxLength = 1;
		int currentArrayIndex = 1;
		int prevArrayIndex = 0;

		long N = scanner.nextLong();
		
		previous.add(-1);	// -1 stopper for printout
		array.add(N);
		S.add(N);
		
		while(scanner.hasNext())
		{
			N = scanner.nextLong();
			array.add(N);
			
			if (S.get(S.size()-1) < N)
			{
				prevArrayIndex = currentArrayIndex - 1;
				S.add(N);
			}
			else
			{
				index = binary_search(S, N);
				S.set(index, N);
			}
			
			previous.add(prevArrayIndex);
			
			if (S.size() > maxLength)
			{
				bestEnd = previous.size()-1;
				maxLength = S.size();
			}
		}
		
		System.out.println(S.size());
		System.out.println('-');
		
		StringBuffer result = new StringBuffer();
		
		for(int i = 0; i < 100; i++)
		{
			System.out.print(previous.get(i) + " ");
		}
	}

	public static int binary_search(List<Long> array, long value)
	{
		int low = 0, high = array.size() -1, mid = 0;
		int answer = -1;
		
		while(low <= high)
		{
			mid = low + (high - low) / 2;
			if (array.get(mid) >= value)
			{
				answer = mid;
				high = mid - 1;
			}
			else
			{
				low = mid + 1;
			}
		}
		return answer;
	}
}
