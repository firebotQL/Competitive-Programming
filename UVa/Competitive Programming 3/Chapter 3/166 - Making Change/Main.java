import java.lang.*;
import java.io.*;
import java.util.*;

public class Main
{
	public static int[] coinValues = new int[] { 5, 10, 20, 50, 100, 200 };
	public static int[] walletCoinCnt = new int[6];
	public static int[] change = new int[3000001];
	public static int[][] ways = new int[6][30000];
	public static int threshold, minExchange, usedCoins, maxS, S;
	
	public static int change(int value)
	{
		if (value == 0) 
		{
			return 0;
		}
		if (value < 0) 
		{
			return Integer.MAX_VALUE;
		}
		
		if (change[value] != -1) return change[value];
		
		int min = Integer.MAX_VALUE;
		
		for(int i = 0; i < coinValues.length; i++)
		{
			min = Math.min(min, change(value - coinValues[i]));
		}
		
		return change[value] = 1 + min;
	}
	
	// try to the maxS
	public static int ways(int type, int value)
	{
		if (value >= 0 && value <= threshold) 
		{
			minExchange = Math.min(minExchange, change((maxS - value - S)) + usedCoins);
		}
		
		if (value == 0) return 1;
		if (value < 0 || type == coinValues.length) return 0;
		if (ways[type][value] != -1) return ways[type][value];
		
		int firstWay = ways(type + 1, value);

		int secondWay = 0;
		
		if (walletCoinCnt[type] > 0)
		{
			walletCoinCnt[type]--;
			usedCoins++;
			secondWay = ways(type, value - coinValues[type]);
			usedCoins--;
			walletCoinCnt[type]++;
		}

		return ways[type][value] = firstWay + secondWay;
	}
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int i, sum;
		String line = null;
		String[] split = null;
		
		Arrays.fill(change, -1);
		
		change(5000);
		
		
		while((line = reader.readLine()) != null)
		{
			split = line.split("\\s+");
			sum = 0;
			maxS = 0;
			
			for(i = 0; i < 6; i++)
			{
				walletCoinCnt[i] = Integer.valueOf(split[i]);
				sum += walletCoinCnt[i];
				maxS += (coinValues[i] * walletCoinCnt[i]);
			}
			
			if (sum == 0)
			{
				break;
			}
			
			S = Math.round(Float.valueOf(split[6]) * 100);
			
			threshold = maxS - S;
			minExchange = Integer.MAX_VALUE;
			usedCoins = 0;
			
			for(int[] row : ways)
			{
				Arrays.fill(row, -1);
			}
			
			ways(0, maxS);
			System.out.printf("%3d%n", minExchange);
		} 
	}
}
