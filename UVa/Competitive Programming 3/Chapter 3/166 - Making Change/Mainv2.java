import java.lang.*;
import java.io.*;
import java.util.*;

public class Main
{
	public static int[] coinValues = new int[] { 5, 10, 20, 50, 100, 200 };
	public static int[] walletCoinCnt = new int[6];
	public static int[] change = new int[501];
	public static int[][] ways = new int[6][501];
	public static int i, min, threshold, minExchange, usedCoins;
	
	public static int change(int value)
	{
		if (value == 0) return 0;
		if (value < 0) return Integer.MAX_VALUE;
		if (change[value] != -1) return change[value];
		
		min = Integer.MAX_VALUE;
		
		for(i = 0; i < coinValues.length; i++)
		{
			min = Math.min(min, change(value - coinValues[i]));
		}
		
		return change[value] = 1 + min;
	}
	
	// try to the maxS
	public static int ways(int type, int value)
	{
		if (value >= 0 && value <= threshold) minExchange = Math.min(minExchange, change(value) + usedCoins);
		if (value == 0) return 1;	// try all permutations
		if (value < 0 || type == coinValues.length || walletCoinCnt[type] == 0) return 0;
		if (ways[type][value] != -1) return ways[type][value];
		
		int firstWay = ways(type + 1, value);
		
		walletCoinCnt[type]--;
		usedCoins--;
		int secondWay = ways(type, value - coinValues[type]);
		usedCoins++;
		walletCoinCnt[type]++;
		
		return ways[type][value] = firstWay + secondWay;
	}
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		S, i, sum;
		String line = null;
		String[] split = null;
		
		for(int[] row : memo)
		{
			Arrays.fill(row, -1);
		}
		
		Arrays.fill(change, -1);
		
		change(500);
		
		while((line = reader.readLine()) != null)
		{
			split = line.split("\\s+");
			sum = 0;
			maxS = 0;
			
			for(i = 0; i < 6; i++)
			{
				walletCoinCnt[i] = Integer.valueOf(split[i]);
				sum += walletCoinCnt[i];
				maxS += coinValues[i];
			}
			
			if (sum == 0)
			{
				break;
			}
			
			S = Math.round(Float.valueOf(split[6]) * 100);
			
			threshold = maxS - S;
			minExchange = Integer.MAX_VALUE;
			usedCoins = sum;
			
			ways(0, maxS);
			System.out.println(minExchange);
		}
	}
}