import java.util.*;
import java.io.*;
import java.lang.*;

public class Main
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		int n, mod, div, pages, temp, sheet;
		boolean flip = false;
		String l, r;
		while((line = reader.readLine()) != null && (n = Integer.valueOf(line)) != 0)
		{
			sheet = 1;
			mod = n % 4;
			div = n / 4;
			div = mod > 0 ? div + 1 : div;
			pages = div * 4;
			temp = pages - n;
			
			System.out.println("Printing order for " + n + " pages:");
			
			if (n == 1)
			{
				pages = 2;
			}
			
			for(int i = 0; i < pages/2; i++)
			{
					//System.out.println(temp);
					if (temp-- > 0)
					{
						r = "Blank";
					}
					else
					{
						r = String.valueOf(n--);
					}
					

					l = String.valueOf(i + 1);
					
					if (i % 2 == 0) // FRONT
					{
						System.out.println(String.format("Sheet %s, front: %s, %s",sheet, r, l));
					}
					else
					{
						System.out.println(String.format("Sheet %s, back : %s, %s",sheet, l, r));
						sheet++;
					}
			}
		}
	}
}