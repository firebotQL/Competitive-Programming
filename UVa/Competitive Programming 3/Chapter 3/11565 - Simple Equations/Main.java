import java.util.*;
import java.io.*;
import java.lang.*;

public class Main
{
	
	public static Map<Integer, List<Integer>> numberToFactors = new HashMap<Integer, List<Integer>>();
	
	public static List<Integer> factor(int number)
	{
		List<Integer> factors =  new ArrayList<Integer>();
		int max = (int)Math.sqrt(number);
		int temp;
		for(int factor = 1; factor <= max; factor++)
		{
			if (number % factor == 0)
			{
				factors.add(factor);
				factors.add(-1 * factor);
				temp = number / factor;
				if (factor != temp)
				{
					factors.add(temp);
					factors.add(-1 * temp);
				}
			}
		}
		Collections.sort(factors);
		return factors;
	}
	
	public static void initialise()
	{
		for(int i = 0 ; i < 10000; i++)
		{
			numberToFactors.put(i, factor(i));
		}
	}
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.valueOf(reader.readLine());
		int a,b,c, A, B, C;
		
		long x, y, z;
		
		initialise();
		String[] splitLine = null;
		boolean found;
		while (N-- != 0)
		{
			found = false;
			splitLine = reader.readLine().split("\\s+");
			A = Integer.valueOf(splitLine[0]);
			B = Integer.valueOf(splitLine[1]);
			C = Integer.valueOf(splitLine[2]);
			
			List<Integer> factors = numberToFactors.get(B);
			
			for(a = 0; a < factors.size(); a++)
			{
				for(b = a + 1; b < factors.size(); b++)
				{
					for(c = b + 1; c < factors.size(); c++)
					{
						x = factors.get(a);
						y = factors.get(b);
						z = factors.get(c);
						
						if (x + y + z == A && 
							x * y * z == B && 
							x * x + y * y + z * z == C)
						{
							System.out.println(x + " " + y + " " + z);
							found = true;
							break;
						}
					}
				}
			}
			
			if (!found)
			{
				System.out.println("No solution.");
			}
		}
	}
}