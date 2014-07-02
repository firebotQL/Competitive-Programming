import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws IOException
	{
		Scanner scanner = new Scanner(new InputStreamReader(System.in));
		long N;
		int index;
		List<Long> S = new ArrayList<Long>(100);
		List<Integer> previous = new ArrayList<Integer>(100);
		int bestEnd = 0;
		
		while(scanner.hasNext())
		{
			N = scanner.nextLong();
			if (S.size() == 0 || S.get(S.size()-1) < N)
			{
				index = S.size();
				S.add(N);
			}
			else
			{
				index = binary_search(S, N);
				S.set(index, N);
			}
			
			previous.add(index);
			
			if (S.size() >= maxLength)
			{
				bestEnd = index;
				maxLength = S.size();
			}
		}
		System.out.println(S.size());
		System.out.println('-');
		
		StringBuffer result = new StringBuffer();
		while(bestEnd != -1)
		{
			result.insert(0, array.get(bestEnd) + System.lineSeparator());
			bestEnd = previous.get(bestEnd);
		}
		System.out.print(result.toString());
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