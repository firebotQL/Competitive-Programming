import java.util.*;
import java.io.*;
import java.lang.*;

public class Main
{
	public static void main(String[] args) throws IOException
	{

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		String line;
		int S, B, L, R, i, S2;
		String LR, RR;
		int[] leftSoldiers = new int[100100];
		int[] rightSoldiers = new int[100100];
		
		StringTokenizer tokenizer = null;
		StringBuffer buffer = new StringBuffer();
		
		String lineSeparator = System.lineSeparator();
		
		while((tokenizer = new StringTokenizer(reader.readLine())).hasMoreTokens())
		{				
			S = Integer.parseInt(tokenizer.nextToken());
			B = Integer.parseInt(tokenizer.nextToken());
			
			if(S == 0)
			{
				break;
			}
			
			for(i = 0; i < S + 1; i++)
			{
				leftSoldiers[i] = i - 1;
				rightSoldiers[i] = i + 1;
			}
			
			while(B-- != 0)
			{
				tokenizer = new StringTokenizer(reader.readLine());
				
				L = Integer.parseInt(tokenizer.nextToken());
				R = Integer.parseInt(tokenizer.nextToken());
				
				if (leftSoldiers[L] < 1) buffer.append("* ");
				else buffer.append(leftSoldiers[L]).append(" ");
				if (rightSoldiers[R] > S) buffer.append("*").append(lineSeparator);
				else buffer.append(rightSoldiers[R]).append(lineSeparator);
				
				leftSoldiers[rightSoldiers[R]] = leftSoldiers[L];
				rightSoldiers[leftSoldiers[L]] = rightSoldiers[R];
			}
			buffer.append("-").append(lineSeparator);
		}
		System.out.print(buffer.toString());
	}
}