import java.util.*;
import java.io.*;
import java.lang.*;

public class Main
{
	public static long number, P;
	public static int rr, rc, r, c;
	public static int SZ, maxP, offset;
	
	public static void main(String[] args) throws IOException
	{
		//long startTime = System.nanoTime(); 
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer tokenizer = null;
		
		while((tokenizer = new StringTokenizer(reader.readLine())).hasMoreTokens())
		{

			SZ = Integer.parseInt(tokenizer.nextToken());
			P = Long.parseLong(tokenizer.nextToken());

			if (SZ == 0 && P == 0)
			{
				break;
			}
			
			maxP = (int)Math.ceil(Math.sqrt(P));
			
			if (maxP % 2 == 0)
			{
				maxP += 1;
			}
			
			number = (long)maxP * maxP;
			
			//System.out.println(P + " " + number + " " + maxP);
			
			//maxP += 1;
			//maxP /=2;			
			
			spiralFillMatrix();	
			//System.out.println(rr + " " + rc);
			offset = (SZ - maxP) / 2;
			System.out.println("Line = " + (SZ - (rr + offset)) + ", column = " + (rc + offset + 1) + "."); 

		}	
		//long estimatedTime = System.nanoTime() - startTime;	
		//System.out.println(estimatedTime + "ns.");
		//System.out.println(estimatedTime/1000000.0 + "ms.");		
	 }
	 
	 public static void spiralFillMatrix()
	 {
		int sizeOfArray = maxP;		
		int start = 0;
		rc = -1;
		rr = -1;
		
		while (number != 0 && rr == -1)
		{
			if ((sizeOfArray - start) % 2 == 0)
			{
				peelEven(start, sizeOfArray);
				start++;				
			}
			else
			{
				peelOdd(start, sizeOfArray);
				sizeOfArray--;
			}
			
		}
	 }
	 
	 public static void peelOdd(int start, int sizeOfArray)
	 {
			c = sizeOfArray - 1;
			r = start;
			for(; r < sizeOfArray; r++)
			{
				if (number == P)
				{
					rr = r;
					rc = c;
					return;
				}
				number--;
			}
			
			r = sizeOfArray - 1;
			
			for(c = c - 1; c >= start; c--)
			{
				if (number == P)
				{
					rr = r;
					rc = c;	
					return;
				}
				number--;
			}
	 }	 
	 
	 public static void peelEven(int start, int sizeOfArray)
	 {	
			
			r = sizeOfArray - 1;
			c = start;
			for(; r >= start; r--)
			{	
				if (number == P)
				{
					rr = r;
					rc = c;	
					return;
				}
				number--;
			}
			
			r = start;
			c = start + 1;

			for(; c < sizeOfArray; c++)
			{
				if (number == P)
				{
					rr = r;
					rc = c;	
					return;
				}
				number--;
			}
			
			
	 }
	 
	 
	 
}