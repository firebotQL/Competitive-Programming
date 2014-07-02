import java.util.*;
import java.io.*;
import java.lang.*;

public class Main
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		while((line = reader.readLine()) != null)
		{
			StringTokenizer token = new StringTokenizer(line);
			int n = Integer.valueOf(token.nextToken());
			int m = Integer.valueOf(token.nextToken());
			String[] split = reader.readLine().split("\\s+");
			int j = m;
			int count = 1;
			
			for(int i = n-1; i >= 0;)
			{
				int a = Integer.valueOf(split[i]);
				if (j - a >= 0)
				{
					j -= a;
					i--;
				}
				else
				{
					count++;
					j = m;
				}
			}
			
			System.out.println(count);
		}
	}
}