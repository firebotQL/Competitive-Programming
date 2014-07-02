import java.util.*;
import java.io.*;
import java.lang.*;

public class Main
{
	public static int[][] array = new int[1000][1000];
	public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in), 50000000);
	
	public static void main(String[] args) throws IOException
	{
		
		String line = null;
		String[] splitLine = null;
		StringBuffer buffer;
		int n, i, j, q, row, column, sum, value;
		StringTokenizer token = null;
		while((line = reader.readLine()) != null)
		{	
			n = Integer.valueOf(line);
			buffer = new StringBuffer();
			
			for(i = 0; i < n; i++)
			{	
				splitLine = reader.readLine().split("\\s+");
				for(j = 0; j < n; j++)
				{
					array[i][j] = Integer.valueOf(splitLine[j]);
				}
			}
			
			q = Integer.valueOf(reader.readLine());
			
			while(q-- != 0)
			{
				token = new StringTokenizer(reader.readLine());
				value = Integer.valueOf(token.nextToken());
				switch(value)
				{
					case 1:
						row = Integer.valueOf(token.nextToken())-1;
						for(i = 0; i < n; i++)
						{
							array[row][i] ^= 1;
						}
						break;
					case 2:
						column = Integer.valueOf(token.nextToken())-1;
						for(i = 0; i < n; i++)
						{
							array[i][column] ^= 1;
						}
						break;
					case 3:
						sum = 0;
						
						for(i = 0; i < n; i++)
						{
							for(j = 0; j < n; j++)
							{
								sum ^= (array[j][i] & array[i][j]);
							}
						}
						
						buffer.append(sum);
						break;
				}
			}
			System.out.println(buffer.toString());
		}
	}
}