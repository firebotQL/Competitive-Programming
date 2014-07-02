import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
	public static long U, L, N;
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		long i, max, val, M1, M2;
				String line = null;
		String[] split = null;
		while((line = reader.readLine()) != null)
		{
			split = line.split("\\s+");
			N = Long.valueOf(split[0]);
			L = Long.valueOf(split[1]);
			U = Long.valueOf(split[2]);
			
			M1 = getResult(L);
			M2 = getResult(U);
	
			//System.out.println(() + " " + (N^M2));
			if ((N^M1) > (N^M2))
			{
				System.out.println(M1);
			}
			else
			{
				System.out.println(M2);
			}
			//System.out.println(N + ":" + Long.toBinaryString(N)+ " - " + M + ":" + Long.toBinaryString(M));
		}
	}
	
	public static long getResult(long M)
	{
		for(long i = 32; i >= 0; i--)
		{
			if ((N & (1L << i)) != 0)
			{
				M &= ~(1L << i);	// unsetting bit
				 
				 if (M < L)
				 {
					M |= (1L << i);
				 }
			}
			else
			{
			   M |= (1L << i);
			   if (M > U)
			   {
					M &= ~(1L << i);
			   }
				// This bit is not set
			}
		}
		return M;
	}
}