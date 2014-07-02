import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
	public static boolean[] primes = null;
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n, caseNr = 1;
		String line = null;
		primes = sieveOfEratosthenes(33);
		int[] numberArray = null;
		boolean[] takenArray = null;
		
		while((line = reader.readLine()) != null)
		{
			if (caseNr > 1)
			{
				System.out.println();
			}
			
			System.out.println("Case " + caseNr++ + ":");
			n = Integer.valueOf(line);
			numberArray = new int[n];
			takenArray = new boolean[n];
			
			for(int i = 0; i < n; i++)
			{
				numberArray[i] = i + 1;
			}
			generatePrimeSubCircle(0, 1, n, numberArray, takenArray, "1", 1);
		}
	}
	
	public static void generatePrimeSubCircle(int currentIndex, int previousNumber, int n, int[] array, boolean[] taken, String result, int count)
	{
		if (count == n)
		{
			int sumNumber = previousNumber + array[count % n];
			
			if (primes[sumNumber])
			{
				System.out.println(result);
			}
		} 
		else
		{
			for(int i = 1; i < n; i++)
			{
				if (!taken[i])
				{
					int sumNumber = previousNumber + array[i % n];
					
					if (primes[sumNumber])
					{
						taken[i] = true;
						generatePrimeSubCircle(i , array[i % n], n, array, taken, result + " " + array[i % n], count + 1);
						taken[i] = false;
					}
				}
			}
		}
	}
	
	public static boolean[] sieveOfEratosthenes(final int max)
	{
		if (max < 0)
		{
			throw new IllegalArgumentException("max cannot be less than zero: " + max);
		}
		
		final boolean[] primeCandidates = new boolean[max]; // defaults to false
		for(int i = 2; i < max; i++)
		{
			primeCandidates[i] = true;
		}
		
		final double maxRoot = Math.sqrt(max);
		
		for(int candidate = 2; candidate < maxRoot; candidate++)
		{
			if (primeCandidates[candidate] == true)
			{
				for(int j = 2 * candidate; j < max; j += candidate)
				{
					primeCandidates[j] = false;
				}
			}
		}
		
		return primeCandidates;
	}
}