import java.util.*;
import java.lang.*;
import java.io.*;

// Binary search tree

public class Main
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		String[] splitLine = null;
		while((line = reader.readLine()) != null)
		{
			if (line.isEmpty())
			{
				System.out.println();
				continue;
			}
			
			int N = Integer.valueOf(line);
			int[] array = new int[N];
			splitLine = reader.readLine().split("\\s+");
			for(int i = 0; i < N; i++)
			{
				array[i] = Integer.valueOf(splitLine[i]);
			}
			int M = Integer.valueOf(reader.readLine());
			
			Arrays.sort(array);

			int minDifference = Integer.MAX_VALUE;
			int i = 0, j = 0;
			
			for(int a = 0; a < N; a++)
			{
				int first = array[a];
				int b = binary_search(array, M - first, 0, N-1, a);
				if (b >= 0)
				{
					int second = array[b];
					if ((first + second) == M)
					{
						if (minDifference > Math.abs(first - second))
						{
							j = second;
							i = first;
							minDifference = Math.abs(first - second);
						}
					}
				}
			}
			
			System.out.println("Peter should buy books whose prices are " + i + " and " + j + ".");
		}
	}
	
	public static int binary_search(int[] A, int key, int ileft, int iright, int excludedIndex)
	{
		if (iright < ileft)
		{
			return -1;
		}
		else
		{
			int imid = ileft + ((iright - ileft) / 2);
			
			if (A[imid] > key)
			{
				return binary_search(A, key, ileft, imid - 1, excludedIndex);
			}
			else if (A[imid] < key)
			{
				return binary_search(A, key, imid+1, iright, excludedIndex);
			}
			else
			{
				if (imid == excludedIndex)
				{
					return -1;
				}
				
				return imid;
			}
		}
	}
}