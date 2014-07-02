import java.io.*;
import java.util.*;

public class Main
{
	public static void main(String[] args) throws IOException
	{
		Scanner reader = new Scanner(new InputStreamReader(System.in));
		String line = null;
		int i, n, value, count;
		int[] array = new int[1001];
		while(reader.hasNextInt())
		{
			n = reader.nextInt();
			
			if (n == 0)
			{
				break;
			}

			count = 0;
			
			for(i = 0; i < n; i++)
			{
				value = reader.nextInt();
				
				if (value > 0)
				{
					array[count++] = value;
				}
			}
			
			if (count == 0)
			{
				System.out.println("0");
			}
			else
			{
				for(i = 0; i < count; i++)
				{
					System.out.print(array[i]);
					if (i != count-1)
					{
						System.out.print(" ");
					}
				}
				System.out.println();
			}
		}
	}
}