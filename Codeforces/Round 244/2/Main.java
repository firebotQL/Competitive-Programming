import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		String[] input = null; 
		String[] crimeRate = null;
		int i, n, t, c, sequenceCount, result, maxIndex, prevMax;
	while((line = reader.readLine()) != null)
		{
			input = line.split("\\s+");
			n = Integer.valueOf(input[0]);
			t = Integer.valueOf(input[1]);
			c = Integer.valueOf(input[2]);
			crimeRate = reader.readLine().split("\\s+");
			prevMax = -1;
			maxIndex = -1;
			result = 0;
			sequenceCount = 0;
			
			for(i = 0; i < n; i++)
			{
				if (Integer.valueOf(crimeRate[i]) > t)
				{
					maxIndex = i;
				}
				
				if (maxIndex != -1)
				{
					if (prevMax != -1)
					{
						sequenceCount = (maxIndex - prevMax) - 1;
					}
					else
					{
						sequenceCount = maxIndex;
					}
					
					if (sequenceCount / c > 0)
					{
						result += sequenceCount - (c - 1);
					}
					
					prevMax = maxIndex;
					maxIndex = -1;
				}
				
			}
			
			if (prevMax != -1)
			{
				sequenceCount = (n - prevMax) - 1;
			}
			else
			{
				sequenceCount = n;
			}
			
			if (sequenceCount / c > 0)
			{
				result += sequenceCount - (c - 1);
			}
			
			System.out.println(result);
		}
	}
}