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
		long N, cSum, nSum;
		int i;
		while((line = reader.readLine()) != null)
		{
			N = Long.valueOf(line);
			nSum = 0;
			cSum = 0;
			splitLine = reader.readLine().split("\\s+");
			for(i = 0; i < N; i++)
			{
				cSum += Long.valueOf(splitLine[i]);
				nSum += i + 1;
			}
			
			if (cSum == nSum)
			{
				System.out.println("YES");
			}
			else
			{
				System.out.println("NO");
			}
		}
	}
}