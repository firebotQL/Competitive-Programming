import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.valueOf(reader.readLine());
		int player = 1, N;
		while(T-- != 0)
		{
			N = Integer.valueOf(reader.readLine());
			
			player = 1;
			
			while(N != 1)
			{
				if (!isPrime(N))
				{
					N /= getFactorOf(N);
				} 
				else
				{
					N -= 1;
				}
				player ^= 1;
			}
			
			if (player == 1)
			{
				System.out.println("Tom");
			}
			else
			{
				System.out.println("Mike");
			}
		}
	}
	
	public static boolean isPrime(long n) 
	{
		if(n < 1) return false;
		if(n == 1) return false;
		if(n == 2 || n == 3) return true;
		if(n%2 == 0 || n%3 == 0) return false;
		long sqrtN = (long)Math.sqrt(n)+1;
		for(long i = 6L; i <= sqrtN; i += 6) {
			if(n%(i-1) == 0 || n%(i+1) == 0) return false;
		}
		return true;
	}
	
	public static int getFactorOf(int val) 
	{
        int limit = (int) Math.ceil(Math.sqrt(val));

        for (int i = limit; i >= 2; i--) {
            if (val % i == 0) {
                return i;
            }
        }
        return 1;
    }
}