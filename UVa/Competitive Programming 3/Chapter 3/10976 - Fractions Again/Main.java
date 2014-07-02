import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		int k, n, i, count;
		double x;
		StringBuilder builder = null;
		String lineSeparator = System.getProperty("line.separator");
		while((line = reader.readLine()) != null)
		{
			k = Integer.valueOf(line);
			n = 2 * k;
			count = 0;
			builder = new StringBuilder();
			
			for(i = k + 1; i <= n; i++)
			{
				x = getX(k, i);
				if (Math.round(x) == x)
				{
					count++;
					builder.append(getResult(k, (int) x , i)).append(lineSeparator);
				}
			}
			
			System.out.println(count);
			System.out.print(builder.toString());
		}
	}
	
	public static double getX(int k, int y)
	{
		return ((double) k * y) / (y - k);
	}
	
	public static String getResult(int k, int x, int y)
	{
		return "1/" + k + " = 1/" + x + " + 1/" + y;
	}
}