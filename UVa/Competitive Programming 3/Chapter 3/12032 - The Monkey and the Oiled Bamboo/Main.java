import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
	public static int[] array = null;
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		String[] split = null;
		int cases = Integer.valueOf(reader.readLine());
		for(int j = 1; j <= cases; j++)
		{
			int n = Integer.valueOf(reader.readLine());
			array = new int[n];
			split = reader.readLine().split("\\s+");
			for(int i = 0; i < n; i++)
			{
				array[i] = Integer.valueOf(split[i]);
			}
			System.out.println("Case " + j + ": " + getMinimumStrengthFactor(array[n-1]));
		}
	}
	
	public static int getMinimumStrengthFactor(int maxK)
	{
		int low = 1, high = maxK, mid = 0, ans = 0;
		while(low <= high)
		{
			mid = (high + low) / 2;
			if (can(mid))
			{
				ans = mid;
				high = mid - 1;
			}
			else
			{
				low = mid + 1;
			}
		}
		return ans;
	}
	
	public static boolean can(int maxK)
	{
		int currentHeight = 0;
		int jumpSize = 0;
		for(int i = 0; i < array.length; i++)
		{
			jumpSize = array[i] - currentHeight;
			if (jumpSize > maxK)
			{
				return false;
			} 
			else if (jumpSize == maxK)
			{
				maxK -= 1;
			}
			currentHeight = array[i];
		}
		
		return true;
	}
}