import java.util.*;
import java.io.*;
import java.lang.*;

public class Main
{
	public static char[][] oldWorld = null;
	public static char[][] newWorld = null;
	public static int r, c;
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		int t = Integer.valueOf(reader.readLine());
		int n;
		while(t-- != 0)
		{
			String[] var = reader.readLine().split("\\s+");
			
			r = Integer.valueOf(var[0]);
			c = Integer.valueOf(var[1]);
			n = Integer.valueOf(var[2]);
			
			oldWorld = new char[r][];			
			for(int i = 0; i < r; i++)
			{
				oldWorld[i] = reader.readLine().toCharArray();
			}
			//showWorld(n);
			simulateWarsForDays(n);
			showWorld(n);
			
			if (t != 0 && (r != 0 || c != 0))
			{
				System.out.println();
			}
		}
	}
	
	public static void showWorld(int n)
	{
		for(int i = 0; i < r; i++)
		{
			for(int j = 0; j < c; j++)
			{
				System.out.print(oldWorld[i][j]);
			}
			System.out.println();
		}
	}
	
	public static void simulateWarsForDays(int n)
	{
		newWorld = getNewWorld();
		int left, right, up, down;
		while (n-- != 0)
		{
			for(int i = 0; i < r; i++)
			{
				for(int j = 0; j < c; j++)
				{
					solveLocation(i, j, oldWorld[i][j]);
				}
			}
			oldWorld = newWorld;
			newWorld = getNewWorld();
		}
	}
	
	public static char[][] getNewWorld()
	{
		char[][] result = new char[r][c];
		
		for(int i = 0; i < r; i++)
		{
			for(int j = 0; j < c; j++)
			{
				result[i][j] = oldWorld[i][j];
			}
		}
		
		return result;
	}
	
	public static void solveLocation(int i, int j, char lifeForm)
	{
		int left = j - 1;
		int right = j + 1;
		int up = i - 1;
		int down = i + 1;
		if (canDefeat(i, left, lifeForm)) newWorld[i][left] = lifeForm;
		if (canDefeat(i, right, lifeForm)) newWorld[i][right] = lifeForm;
		if (canDefeat(up, j, lifeForm)) newWorld[up][j] = lifeForm;
		if (canDefeat(down, j, lifeForm)) newWorld[down][j] = lifeForm;
	}
	
	public static boolean canDefeat(int i, int j, char lifeForm)
	{
		//System.out.println(i + " " + j + " : " + r + " " + c);
		if (i < 0 || i >= r || j < 0 || j >= c) return false;
		char adjacentLifeForm = oldWorld[i][j];
		
		switch(lifeForm)
		{
			case 'R':
				switch (adjacentLifeForm)
				{
					case 'S':
						return true;
					case 'P':
						return false;
				}
				break;
			case 'S':
				switch (adjacentLifeForm)
				{
					case 'R':
						return false;
					case 'P':
						return true;
				}
				break;
			case 'P':
				switch (adjacentLifeForm)
				{
					case 'R':
						return true;
					case 'S':
						return false;
				}
				break;
		}
		return false;
	}
}