import java.util.*;import java.lang.*;import java.io.*;public class Main{	public static char[][] grid = new char[101][101];	public static int sX = -1, sY = -1;	public static char direction = ' ';	public static char[] compass = { 'N', 'L', 'S', 'O' };	public static int[] number = new int[256];		public static void main(String[] args) throws IOException	{		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));		String line = null;		String instructions = null;		String[] split = null;		int N, M, S, i, j, y, collected, nsX, nsY, addX, addY, comp;		char instruction, tmpChr;		number['N'] = 0;		number['L'] = 1;		number['S'] = 2;		number['O'] = 3;				while((line = reader.readLine()) != null)		{			split = line.split("\\s+");			N = Integer.valueOf(split[0]);			M = Integer.valueOf(split[1]);			S = Integer.valueOf(split[2]);						if (N == 0 && M == 0 && S == 0)			{				break;			}						sX = sY = -1;						for(i = 0; i < N; i++)			{				line = reader.readLine();				for(j = 0; j < M; j++)				{					tmpChr = line.charAt(j);					grid[i][j] = tmpChr;					if (sX == -1 && sY == -1)					{						switch(tmpChr)						{							case 'N':							case 'S':							case 'L':							case 'O':								sX = i;								sY = j;								direction = tmpChr;							break;						}					}				}			}						instructions = reader.readLine();			collected = 0;			// N - North			// S - South			// L - East			// O - West			comp = number[direction];						for(y = 0; y < S; y++)			{				instruction = instructions.charAt(y);				switch(instruction)				{					case 'D':						comp = (comp + 1) % 4;						direction = compass[comp];						break;					case 'E':						comp = (comp + (4 - 1)) % 4;						direction = compass[comp];						break;					case 'F':						addX = 0;						addY = 0;						switch(direction)						{							case 'N':								addX = -1;								break;							case 'S':								addX = 1;								break;							case 'L':								addY = 1;								break;							case 'O':								addY = -1;								break;						}												nsX = sX + addX;						nsY = sY + addY;						if (nsX >= 0 && nsX < N && nsY >= 0 && nsY < M && grid[nsX][nsY] != '#')						{							if (grid[nsX][nsY] == '*')							{								collected++;							}							grid[nsX][nsY] = '.';							sX = nsX;							sY = nsY;						}				}			}						System.out.println(collected);					}	}}