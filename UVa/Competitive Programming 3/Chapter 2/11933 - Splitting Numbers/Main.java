import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		int n, a, b, bitNum, i, count;
		while((line = reader.readLine()) != null && (n = Integer.parseInt(line)) != 0)
		{
			a = 0;
			b = 0;
			count = 0;
			bitNum = 32 - Integer.numberOfLeadingZeros(n);
			for(i = 0; i < bitNum; i++)
			{
				if ((n & (1 << i)) != 0)
				{
					count++;
					
					if (count % 2 == 1)
					{
						a |= (1 << i);
					}
					else
					{
						b |= (1 << i);
					}
				}
			}
			System.out.println(a + " " + b);
		}
	}
}