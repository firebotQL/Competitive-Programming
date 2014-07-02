import java.util.*;
import java.lang.*;
import java.io.*;


// Bisection method
public class Main
{
	public static double EPS = 1e-7;
	public static int p, q, r, s, t, u;
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		String[] separatedLine = null;
		int[] array = null;
		while((line = reader.readLine()) != null)
		{
			separatedLine = line.split("\\s+");
			
			p = Integer.valueOf(separatedLine[0]);
			q = Integer.valueOf(separatedLine[1]);
			r = Integer.valueOf(separatedLine[2]);
			s = Integer.valueOf(separatedLine[3]);
			t = Integer.valueOf(separatedLine[4]);
			u = Integer.valueOf(separatedLine[5]);
			
			
			if (func(0) * func(1) > 0)
			{
				System.out.println("No solution");
			}
			else
			{
				System.out.printf("%.4f\n", bisection());
			}
		}
	}
	
	public static double bisection()
	{
		double lo = 0, hi = 1;
		while(hi - lo > 1e-7)
		{
			double x = (lo + hi) / 2.0;
			if (func(lo) * func(x) <= 0)
			{
				hi = x;
			} 
			else
			{
				lo = x;
			}
		}
		return (hi + lo) / 2;
	}
	
	public static double func(double x)
	{
		return p * Math.exp(-x) + q * Math.sin(x) + r * Math.cos(x) + s * Math.tan(x) + t * x * x + u;
	}
}