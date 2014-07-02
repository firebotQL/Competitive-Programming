import java.util.*;
import java.io.*;
import java.lang.*;

public class Main
{
	//set up the primesieve
	public static boolean isPrime(long n) {
		if(n < 1) return false;
		if(n == 1) return true;
		if(n == 2 || n == 3) return true;
		if(n%2 == 0 || n%3 == 0) return false;
		long sqrtN = (long)Math.sqrt(n)+1;
		for(long i = 6L; i <= sqrtN; i += 6) {
			if(n%(i-1) == 0 || n%(i+1) == 0) return false;
		}
		return true;
	}

	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		int i, sum, chworth;
		//fillSieve();
		//System.out.println(isPrime(2));
		while((line = reader.readLine()) != null)
		{
			sum = 0;
			for(i = 0; i < line.length(); i++)
			{
				chworth = (int)line.charAt(i);
				if (chworth > 96)
				{
					sum += chworth - 96;
				}
				else
				{
					sum += chworth - 38;
				}
			}

			if (isPrime(sum))
			{
				System.out.println("It is a prime word.");
			}
			else
			{
				System.out.println("It is not a prime word.");
			}
		}
	}
}