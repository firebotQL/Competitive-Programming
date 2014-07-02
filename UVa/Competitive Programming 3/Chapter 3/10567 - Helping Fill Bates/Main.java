import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String S = reader.readLine();
		int Q = Integer.valueOf(reader.readLine());
		List<ArrayList<Integer>> S_counts = new ArrayList< ArrayList<Integer>>(256);
		
		for(int i = 0; i < 256; i++)
		{
			S_counts.add(new ArrayList<Integer>());
		}

		
		for(int i = 0; i < S.length(); i++)
		{
			S_counts.get((int)S.charAt(i)).add(i);
		}
		
		
		while(Q-- != 0)
		{
			String SS = reader.readLine();
			int index = -1, first = 0;
			boolean found = true;
			
			for(int i = 0; i < SS.length(); i++)
			{
				ArrayList<Integer> SS_counts = S_counts.get((int)SS.charAt(i));
				
				index = binary_search(SS_counts, index);
				
				if (index == -1)
				{
					found = false;
					break;
				}
				
				index = SS_counts.get(index);
				
				if (i == 0)
				{
					first = index;
				}
			}
			if (found)
			{
				System.out.println("Matched " + first + " " + index);
			}
			else
			{
				System.out.println("Not matched");
			}
		}
	}
	
	public static int binary_search(ArrayList<Integer> SS_counts, int index)
	{
		int low = 0, high = SS_counts.size()-1, mid = 0;
		int answer = -1;
		
		while(low <= high)
		{
			mid = low + (high - low) / 2;
			
			if (SS_counts.get(mid) > index)
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