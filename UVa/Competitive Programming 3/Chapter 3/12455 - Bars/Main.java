import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		int t = Integer.valueOf(reader.readLine());
		int i, j, sum, n, p;
		String[] splittedLine = null;
		boolean found = false;
		while(t-- != 0)
		{
				n = Integer.valueOf(reader.readLine());
				p = Integer.valueOf(reader.readLine());
				
				splittedLine = reader.readLine().split("\\s+");

				found = false;
				// All permutations with bitmasking
				for(i = 0; i < (1 << p); i++)
				{
					sum = 0;
					for(j = 0; j < p; j++)
					{
						if ((i & (1 << j)) != 0)
						{
							sum += Integer.valueOf(splittedLine[j]);
						}
					}
					if (sum == n) 
					{
						found = true;
					}
				}
				if (found)
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