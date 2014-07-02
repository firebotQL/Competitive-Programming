import java.util.*;
import java.io.*;
import java.lang.*;

public class Main
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = null;
		int T, n, index, i;
		T = Integer.valueOf(reader.readLine());
		int[] A;
		long bcnt;
		
		while(T-- != 0)
		{
			n = Integer.valueOf(reader.readLine());
			A = new int[n];
			token = new StringTokenizer(reader.readLine());
			index = 0;			
			bcnt = 0;
			//System.out.println(n);
			while(token.hasMoreTokens())
			{
				A[index] = Integer.valueOf(token.nextToken());				
				
				for(i = 0; i < index; i++)
				{
					if (A[i] <= A[index])
					{
						bcnt++;
					}
				}
				index++;
			}
			
			System.out.println(bcnt);
		}
	}
}