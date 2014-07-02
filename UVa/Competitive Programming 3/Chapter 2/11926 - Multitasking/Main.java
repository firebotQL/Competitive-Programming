import java.util.*;
import java.io.*;
import java.lang.*;

public class Main
{
	public static int maxSize = 1000001;
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		int n, m , num1, num2, num3, i;
		
		BitSet bits = new BitSet(maxSize);
		StringTokenizer tokenizer = null;
		boolean conflict = false;
		
		while((line = reader.readLine()) != null)
		{
			conflict = false;
			bits.clear();
			tokenizer = new StringTokenizer(line);
		
			n = Integer.parseInt(tokenizer.nextToken());
			m = Integer.parseInt(tokenizer.nextToken());
			
			if (n == 0 && m == 0)
			{
				break;
			}

			while(n-- != 0)
			{
				tokenizer = new StringTokenizer(reader.readLine());
				
				num1 = Integer.parseInt(tokenizer.nextToken());
				num2 = Integer.parseInt(tokenizer.nextToken());

				for(i = num1; i < num2 && !conflict; i++)
				{
					if (bits.get(i))
					{
						conflict = true;
						break;
					}					
					bits.set(i);
				}
			}
			
			while (m-- != 0)
			{
				tokenizer = new StringTokenizer(reader.readLine());
				
				num1 = Integer.parseInt(tokenizer.nextToken());
				num2 = Integer.parseInt(tokenizer.nextToken());
				num3 = Integer.parseInt(tokenizer.nextToken());
				
				while(!conflict && num1 < 1000000)
				{
					
					for(i = num1; i < num2; i++)
					{
						if (bits.get(i))
						{
							conflict = true;
							break;
						}
						bits.set(i);
					}
					num1 += num3;
					num2 += num3;
				}
			}
			
			if (conflict)
			{
				System.out.println("CONFLICT");
			}
			else
			{
				System.out.println("NO CONFLICT");
			}			
		}
	}
}