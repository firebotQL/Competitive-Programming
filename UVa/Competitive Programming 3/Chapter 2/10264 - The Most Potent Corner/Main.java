import java.util.*;
import java.io.*;
import java.lang.*;

public class Main
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		int value, N, maxBitsValue, i, j, neigIndex, result, twoCornerPotency;
		
	    int[] corners = new int[32769];
		int[] potencys = new int[32769];
		
		while((line = reader.readLine()) != null)
		{
			
			N = Integer.parseInt(line);
			
			maxBitsValue = (1 << N);
			
			for(i = 0; i < maxBitsValue; i++)
			{
				corners[i] = Integer.parseInt(reader.readLine());
			}
			
			for(i = 0; i < maxBitsValue; i++)
			{
				potencys[i] = 0;
				
				for(j = 0; j < N; j++)
				{
					neigIndex = i ^ (1 << j);
					potencys[i] += corners[neigIndex];
				}
			}
			
			result = Integer.MIN_VALUE;
			
			for(i = 0; i < maxBitsValue; i++)
			{
				for(j = 0; j < N; j++)
				{
					neigIndex = i ^ (1 << j);
					
					twoCornerPotency = potencys[i] + potencys[neigIndex];
					
					if (twoCornerPotency > result)
					{
						result = twoCornerPotency;
					}
				}
			}
			System.out.println(result);
		}
	}
}