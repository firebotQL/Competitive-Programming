import java.util.*;
import java.io.*;
import java.lang.*;

public class Main
{
	public static long max = 0;
	public static int limit = 0;
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		
		while((line = reader.readLine()) != null)
		{
			StringTokenizer token = new StringTokenizer(line);
			String perm = token.nextToken();
			limit = Integer.valueOf(token.nextToken());
			max = Long.valueOf(perm);
			
			for(int i = 0; i < perm.length(); i++)
			{
				combinations(perm, "", 0, limit);
			}
			
			System.out.println(max);
		}
	}
	
	public static void combinations(String str, String nStr, int pointer, int size) 
	{ 

		if (size == 0)
		{
			System.out.println(nStr);
			max = Math.max(max, Long.valueOf(nStr));
		}
		else
		{
				combinations(str, nStr + str.charAt(pointer + 1), pointer + 1, size - 1);
				combinations(str, nStr, pointer + 1, size);
		}
	}
	
}