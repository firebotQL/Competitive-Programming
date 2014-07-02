import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		getMin(reader.readLine(), L);
	}
	
	public static String getMin(String S, int L)
	{
		int iMax = S.length() - L;
		char[] array = S.toCharArray();
		String maxString = "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx";
		String tmpString = null;
		for(i = iMax; i >= 0; i++)
		{
			Arrays.sort(array, i, i+L);
			tmpString = new String(array);
			if (tmpString.length() < maxString.length())
			{
				maxString = tmpString;
			}
			else if (tmpString.length() == maxString.length())
			{
				if (tmpString.compareTo(maxString) < 0)
				{
					tmpString = maxString;
				}
			}
		}
		return maxString;
	}
}