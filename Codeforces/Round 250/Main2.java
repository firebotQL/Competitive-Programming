import java.util.*;
import java.lang.*;
import java.io.*;

public class Main2
{
	public static void ways(long limit, long csum, long esum)
	{
		long lowbits = (long)Math.pow(2.0, value);
		
		if (limit == 1)
		{
			return;
		}
		
		ways(limit - 1, value + csum, esum);
		ways(limit, csum, esum);
	}
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		
		while((line = reader.readLine()) != null)
		{
			StringTokenizer token = new StringTokenizer(line);
			int sum = Integer.valueOf(token.nextToken());
			int limit = Integer.valueOf(token.nextToken());
			
		}
	}
}