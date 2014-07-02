import java.lang.*;
import java.io.*;
import java.lang.*;

public class Main
{
	public static int[] array = null;
	public static int n, m;
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		String[] separatedLine = null;
		
		int max = 0;
		while((line = reader.readLine()) != null)
		{
			separatedLine = line.split("\\s+");
			
			max = 0;
			n = Integer.valueOf(separatedLine[0]);
			m = Integer.valueOf(separatedLine[1]);
			
			separatedLine = reader.readLine().split("\\s+");
			
			array = new int[n];
			
			for(int i = 0; i < n; i++)
			{
				array[i] = Integer.valueOf(separatedLine[i]);
			}
			
			System.out.println(simulate((int) 1e9 + 5));
		}
	}
	
	public static int simulate(int max)
	{
		int lo = 1, hi = max, mid = 0, ans = 0;
		while(lo <= hi)
		{
			mid = (lo + hi) / 2;

 			if (can(mid))
			{
				ans = mid; 
				hi = mid - 1;
			}
			else
			{
				lo = mid + 1;
			}
		}
		return ans;
	}
	
	public static boolean can(int capacity)
	{
 		int currentCapacity = capacity;
		int counter = 1;
		for(int i = 0; i < n; i++)
		{
			if (array[i] > capacity)	// if any vessel is bigger than provided capacity container
			{
				return false;
			}
			
			if (array[i] <= currentCapacity)	// if any vessel is lesser than provided capacity then using ONE CAPACITY CONTAINER
			{
				currentCapacity -= array[i];	// decrementing capacity
			}
			else
			{
				currentCapacity = capacity - array[i];	// USING NEXT CAPACITY CONTAINER
				counter++;
			}
		}
		if (counter > m)
            return false;
        return true;
	}
}