import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
	public static boolean[][] array = new boolean[2002][2002];
	public static int i, j, n = 2002;
	public static boolean tmp;
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		String[] splitLine = null;
		int a, b, max, count, from, to, rotCnt;
		int[][] coord = new int[3][2];
		boolean found = false, result;
		while((line = reader.readLine()) != null)
		{
			found = false;
			
			rotCnt = 4;
			splitLine = line.split("\\s+");
			a = Integer.valueOf(splitLine[0]);
			b = Integer.valueOf(splitLine[1]);
			max = Math.max(a, b);
			from = 1000 - max;
			to = 1000 + max;
			coord = new int[3][2];
			result = true;
			while(rotCnt-- != 0)
			{
				rotate();
				count = 0;
				for(i = from; i < to && count != 3; i++)
				{
					for(j = from; j < to && count != 3; j++)
					{
						if (array[i][j])
						{
							coord[count][0] = i;
							coord[count][1] = j;
							count++;
						}
					}
				}
				
				if ((coord[0][0] == coord[1][0] || coord[0][0] == coord[2][0] || coord[1][0] == coord[2][0])
				|| (coord[0][1] == coord[1][1] || coord[0][1] == coord[2][1] || coord[1][1] == coord[2][1]))
				{
					result = false;
				}
				else
				{
					result = true;
					break;
				}
			}
			
			if (result)
			{
				System.out.println("YES");
				System.out.println(coord[0][0] + " " + coord[0][1]);
				System.out.println(coord[1][0] + " " + coord[1][1]);
				System.out.println(coord[2][0] + " " + coord[2][1]);
			}
			else
			{
				System.out.println("NO");
			}
				
		}
		
	}
	public static void rotate()
	{
		for (i=0; i<n/2; i++){
			for (j=i; j<n-i-1; j++){
					tmp = array[i][j];
					array[i][j] = array[j][n-i-1];
					array[j][n-i-1] = array[n-i-1][n-j-1];
					array[n-i-1][n-j-1] = array[n-j-1][i];
					array[n-j-1][i] = tmp;
			}
		}
	}
}