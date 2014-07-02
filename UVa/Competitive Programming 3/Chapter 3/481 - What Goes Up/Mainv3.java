import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
	public static List<Long> S = new ArrayList<Long>(1000);
	public static List<Long> array = new ArrayList<Long>(1000);
	public static int[] previous = new int[10000];
	public static int[] positionMap = new int[10000];
	public static void main(String[] args) throws IOException
	{
		Scanner scanner = new Scanner(new InputStreamReader(System.in));
		long N;
		int index;
		int bestEnd = 0, maxLength = 1;
		
		int currentIndex = 0;
		
		int prevArrayIndex = -1;
		
		while(scanner.hasNext())
		{
			N = scanner.nextLong();
			array.add(N);
			
			if (S.size() == 0 || S.get(S.size()-1) < N)
			{
				prevArrayIndex = currentIndex - 1;
				S.add(N);
			}
			else
			{
				index = binary_search(S, N);
				S.set(index, N);
			}
			
			previous[currentIndex] = prevArrayIndex;
			
			if (S.size() > maxLength)
			{
				bestEnd = currentIndex;
				maxLength = S.size();
			}
			currentIndex++;
		}
		System.out.println(S.size());
		System.out.println('-');
		
		StringBuffer result = new StringBuffer();
		while(bestEnd != -1)
		{
			result.insert(0, array.get(bestEnd) + System.lineSeparator());
			bestEnd = previous[bestEnd];
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
