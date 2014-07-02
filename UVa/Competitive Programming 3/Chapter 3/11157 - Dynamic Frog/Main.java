import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws IOException
	{
		Scanner reader = new Scanner(new InputStreamReader(System.in));
		List<Character> stoneType = null;
		List<Long> stones = null;
		int T = reader.nextInt();
		int N, i, size, caseCnt = 1;
		long D, currentRock, maxLeap;
		
		String rock = null;
		
		while(T-- != 0)
		{

			N = reader.nextInt();
			D = reader.nextLong();	
			stoneType = new ArrayList<Character>(N+2);
			stones = new ArrayList<Long>(N+2);
			
			for(i = 0; i < N; i++)
			{
				rock = reader.next("(\\p{Alpha})-(\\d+)");
				size = rock.length();
				currentRock = Long.valueOf(rock.substring(2, size));
				stones.add(currentRock);
				stoneType.add(rock.charAt(0));
			}
	
			stones.add(0, 0L);
			stones.add(stones.size(), D);
			stoneType.add(0, 'B');
			stoneType.add(stoneType.size(), 'B');
			
			maxLeap = getMaxLeap(stones, stoneType);
			
			maxLeap = Math.max(maxLeap, getMaxLeap(stones));
			
			System.out.println("Case " + caseCnt++ + ": " + maxLeap);

		}
	}
	public static long getMaxLeap(List<Long> stones)
	{
		int i = 0;
		long maxLeap = 0, leap = 0;;
		for(i = stones.size() - 1; i > 0; i--)
		{
			leap = stones.get(i) - stones.get(i-1);
			if (maxLeap < leap)
			{
				maxLeap = leap;
			}
		}
		
		return maxLeap;
	}
	public static long getMaxLeap(List<Long> stones, List<Character> stoneType)
	{
		long maxLeap = 0, currentRock, rockOne, rockTwo, currentLeap;
		int i = 0, incr = 0, decr = 0;
		char currentRockType, rockOneType;

		while(i < stones.size()-1)
		{
			currentRock = stones.get(i);
			currentRockType = stoneType.get(i);
			
			rockOne = stones.get(i+1);
			rockOneType = stoneType.get(i+1);
			
			switch(rockOneType)
			{
				case 'S':
					if (i+2 < stones.size())
					{
						rockTwo = stones.get(i+2);
						incr = 2;
						currentLeap = Math.abs(rockTwo - currentRock);
						if (maxLeap < currentLeap)
						{
							maxLeap = currentLeap;
						}
						break;
					}
				case 'B':
					incr = 1;
					currentLeap = Math.abs(rockOne - currentRock);
					if (maxLeap < currentLeap)
					{
						maxLeap = currentLeap;
					}
			}
			
			decr = 0;
			
			if (currentRockType == 'S')
			{
				stones.remove(i);
				stoneType.remove(i);
				i--;
			}
			
			i += incr;
			
		}
		return maxLeap;
	
	}
}