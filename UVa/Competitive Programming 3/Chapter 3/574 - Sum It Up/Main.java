import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
	public static String[] splittedLine = null;
	public static boolean foundResult = false;
	public static Set<String> uniqueResults = null;
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		
		int t, n;
		while(true)
		{
			splittedLine = reader.readLine().split("\\s+");;
			t = Integer.valueOf(splittedLine[0]);
			n = Integer.valueOf(splittedLine[1]);
			if (t == 0 && n == 0)
			{
				break;
			}
			foundResult = false;
			
			uniqueResults = new HashSet<String>();
			
			System.out.println("Sums of " + t + ":");
			findSumItUp(2, t, 0, new boolean[n+2], "");
			
			if (uniqueResults.size() == 0)
			{
				System.out.println("NONE");
			}
		}
	}
	
	public static void findSumItUp(int currentIndex, int t, long sum, boolean[] used, String sumStr)
	{
		if (t == sum)
		{
			String result = sumStr.substring(1, sumStr.length());
			if (!uniqueResults.contains(result))
			{
				uniqueResults.add(result);
				System.out.println(result);
			}
			return;
		}
		long value;
		
		for(int i = currentIndex; i < splittedLine.length; i++)
		{
			if (!used[i])
			{
				used[i] = true;
				value = Long.valueOf(splittedLine[i]);
				findSumItUp(i + 1, t, sum + value, used, sumStr + "+" + value);
				used[i] = false;
			}
		}
	}
}