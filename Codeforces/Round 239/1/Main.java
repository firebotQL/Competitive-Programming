import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		String[] splitLine = null;
		int[] people = new int[101];
		int min, sum;
		while((line = reader.readLine()) != null)
		{
			int n = Integer.valueOf(line);
			
			line = reader.readLine();
			
			sum = 0;
			min = Integer.MAX_VALUE;
			for(int i = 0; i < n; i++)
			{
				splitLine = reader.readLine().split("\\s+");
				sum = 0;
				for(int j = 0; j < splitLine.length; j++)
				{
					sum += 5 * Integer.valueOf(splitLine[j]) + 15;
				}
				if (min > sum)
				{
					min = sum;
				}
			}
			
			System.out.println(min);
			
		}
	}
}