import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		int size, i, count, incr, n = Integer.valueOf(reader.readLine());
		for(int testNr = 1; testNr <= n; testNr++)
		{
			size = Integer.valueOf(reader.readLine());
			line = reader.readLine();
			count = 0;
			incr = 1;
			for(i = 0; i < size; i += incr)
			{
				if (line.charAt(i) == '#')
				{
					incr = 1;
				}
				else
				{
					count++;
					incr = 3;
				}
			}
			System.out.println("Case " + testNr + ": " + count);
		}
	}
}