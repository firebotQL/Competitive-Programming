import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
	public static int[][] city = int[2001][2001];
	
	public static class Coord
	{
		public int x, y;
		public Coord(int x, int y)
		{
			this.x = x;
			this.y = y;
		}
	}
	
	public static boolean readMall(BufferedReader reader, int mallNr)
	{
		int p = Integer.parseInt(line);
				
		if (p == 0)
		{
			return false;
		}
		
		while(p != 0)
		{
			StringTokenizer token = new StringTokenizer(reader.readLine());
			while(token.hasNextToken())
			{
				int a = Integer.parseInt(token.nextToken());
				int s = Integer.parseInt(token.nextToken());
				city[a][s] = mallNr;
			}
		}
		return true;
	}
	
	public static void main(String[] args) throws IOException
	{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			String line = null;
			
			while((line = reader.readLine()) != null)
			{
				readMall(reader, 1);
				readMall(reader, 2);
			}
	}
}