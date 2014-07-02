import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
	public static int i1, i2, d1, d2, n, m;
	public static boolean possible = false;
	
	public static class Piece
	{
		boolean rotate = false;
		
		public int p1;
		public int p2;
		
		public Piece(int p1, int p2)
		{
			this.p1 = p1;
			this.p2 = p2;
		}
	}
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		String[] splitLine = null;
		Piece[] mSet;
		while((line = reader.readLine()) != null && line.charAt(0) != '0')
		{
			n = Integer.valueOf(line);
			m = Integer.valueOf(reader.readLine());
			splitLine = reader.readLine().split("\\s+");
			i1 = Integer.valueOf(splitLine[0]);
			i2 = Integer.valueOf(splitLine[1]);
			splitLine = reader.readLine().split("\\s+");
			d1 = Integer.valueOf(splitLine[0]);
			d2 = Integer.valueOf(splitLine[1]);
			mSet = new Piece[m];
			for(int i = 0; i < m; i++)
			{
				splitLine = reader.readLine().split("\\s+");
				mSet[i] = new Piece(Integer.valueOf(splitLine[0]), Integer.valueOf(splitLine[1]));
			}
			possible = false;
			boolean[] usedPieces = new boolean[m];
			solve(mSet, usedPieces, 0, i2);
			
			if (!possible)
			{
				System.out.println("NO");
			}
			else
			{
				System.out.println("YES");
			}
			
		}
	}
	
	public static void solve(Piece[] mSet, boolean[] usedPiece, int usedSpace, int leftEnd)
	{
		if (usedSpace == n)
		{
			if (leftEnd == d1)
			{
				possible = true;
			}
			
			return;
		}
		
		for(int i = 0; i < m; i++)
		{
			if (!usedPiece[i])
			{
				if (leftEnd == mSet[i].p1 && usedSpace < n)
				{
					usedPiece[i] = true;
					solve(mSet, usedPiece, usedSpace + 1, mSet[i].p2);
					usedPiece[i] = false;
				}
				
				if (leftEnd == mSet[i].p2 && usedSpace < n)
				{
					usedPiece[i] = true;
					solve(mSet, usedPiece, usedSpace + 1, mSet[i].p1);
					usedPiece[i] = false;
				}
			}
		}
	}
}