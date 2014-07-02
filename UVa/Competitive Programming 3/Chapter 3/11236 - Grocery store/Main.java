import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws IOException
	{
		long i, j, k, z = 1;
		// i + j + k + z = i * j * k * z;
		// ijk < 4
		// ijk <= 3
		// ijkz <= 2000
		// ijk = b; 
		// z <= 2000;
		// z <= 1000;
		// z <= 666.6
		// (1, 2, 3)
		// ijk/3 <= 1
		// ijkz/3 <= 2000/3	6.6666
		// 
		// 1 1 1 , 1 1 2, 1 1 3
		for(i = 1; i < 2000; i++)
		{
	 		for(j = i; j < 2000; j++)
			{
				for(k = j; k < 2000; k++)
				{
					for(z = k; z < 2000; z++)
					{
						double a = i / 100.0;
						double b = j / 100.0;
						double c = k / 100.0;
						double d = z / 100.0;
						
						double p1 = a * b * c * d;
						double p2 = a + b + c + d;
						
						if (Math.abs(p1 - p2) < 1e-9)
						{
							System.out.println(String.format("%.2f %.2f %.2f %.2f", i/100.0, j/100.0, k/100.0, z/100.0));
						}
					}
				}
			}
		}
	}
}