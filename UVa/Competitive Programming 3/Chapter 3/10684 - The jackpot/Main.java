import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws IOException
	{
		Scanner scan = new Scanner(new InputStreamReader(System.in));
		int N, previous_max, current_max;
		while(scan.hasNext())
		{
			N = scan.nextInt();
			
			if (N == 0)
			{
				break;
			}
			
			current_max = 0;
			previous_max = 0;
			
			while(N-- != 0)
			{
				current_max += scan.nextInt();

				if (previous_max < current_max)
				{
					previous_max = current_max;
				}

				if (current_max < 0)
				{
					current_max = 0;
				}
			}

			if (previous_max > 0)
			{
				System.out.println("The maximum winning streak is " + previous_max + ".");
			}
			else
			{
				System.out.println("Losing streak.");
			}
		}
	}
}