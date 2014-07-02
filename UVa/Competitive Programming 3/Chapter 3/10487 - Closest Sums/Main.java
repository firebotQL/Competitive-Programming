import java.util.*;
import java.io.*;
import java.lang.*;

public class Main
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		int n, m, i, j, query, min, tempMin, sum, closestSum, caseCnt = 1;
		int[] values;
		while((line = reader.readLine()) != null && line.charAt(0) != '0')
		{
			n = Integer.valueOf(line);
			values = new int[n];
			
			closestSum = 0;
			
			for( i = 0; i < n; i++)
			{
				values[i] = Integer.valueOf(reader.readLine());
			}
			
			m = Integer.valueOf(reader.readLine());

			System.out.println("Case " + caseCnt++ + ":");
			
			while(m-- != 0)
			{
				min = Integer.MAX_VALUE;
				query = Integer.valueOf(reader.readLine());
				for(i = 0; i < n; i++)
				{
					for(j = i + 1; j < n; j++)
					{
						if (values[i] != values[j])
						{
							sum = values[i] + values[j];							
							tempMin = Math.abs(query - sum);
							
							if ( tempMin < min)
							{
								closestSum = sum;
								min = tempMin;
							}
						}
					}
				}
				System.out.println("Closest sum to " + query + " is " + closestSum + ".");
				
			}
		}
	}

}