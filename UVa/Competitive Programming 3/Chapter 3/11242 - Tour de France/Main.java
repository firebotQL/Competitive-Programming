import java.util.*;
import java.io.*;
import java.lang.*;

public class Main
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int r, f, re, fe, i, j, cnt;
		double[] d;
		double max, spread;
		String line = null;
		String[] split1 = null;
		String[] split2 = null;
		while((line = reader.readLine()) != null)
		{
			split1 = line.split("\\s+");
			
			f = Integer.valueOf(split1[0]);
			
			if (f == 0)
			{
				break;
			}
			
			r = Integer.valueOf(split1[1]);
			
			d = new double[f * r];
			cnt = 0;
			split1 = reader.readLine().split("\\s+");
			split2 = reader.readLine().split("\\s+");
			for(i = 0; i < f; i++)
			{
				fe = Integer.valueOf(split1[i]);
				for(j = 0; j < r; j++)
				{
					re = Integer.valueOf(split2[j]);
					d[cnt++] = re/ (double)fe;
				}
			}
			
			Arrays.sort(d);
			
			max = Double.MIN_VALUE;
			
			for(i = d.length-1; i > 0; i--)
			{
					//System.out.println(i);
					spread = d[i]/d[i-1];
					if(spread > max)
					{
						max = spread;
					}
			}
			
			System.out.println(String.format("%.3g", max));
		}
	}
}