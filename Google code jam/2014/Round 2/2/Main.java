import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		String[] split = null;
		int cases = Integer.valueOf(reader.readLine());
		int result = 0;
		int A, B, K;
		int j, k;
		for(int i = 1; i <= cases; i++)
		{
			line = reader.readLine();
			split = line.split("\\s+");
			A = Integer.valueOf(split[0]);
			B = Integer.valueOf(split[1]);
			K = Integer.valueOf(split[2]);
			result = 0;
			for(j = 0; j < A; j++)
			{
				for(k = 0; k < B; k++)
				{
					if ((j & k) < K)
					{
						result++;
					}
				}
			}
			
			System.out.printf("Case #%d: %d%n", i, result);
		}
	}
}