import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.valueOf(reader.readLine());
		int n, i, counter;
		long sum, C, Cnext;
		String[] splitLine = null;
		while(T-- != 0)
		{
			n = Integer.valueOf(reader.readLine());
			counter = n;
			sum = 1;
			splitLine = reader.readLine().split("\\s+");
			
			for(i = 1; i < n-1; i++)
			{
				C = Long.valueOf(splitLine[i]);
				Cnext = Long.valueOf(splitLine[i+1]);
				
				if (sum + C >= Cnext)
				{
					counter--;
				}
				else
				{
					sum += C;
				}
			}
			System.out.println(counter);
		}
	}
}