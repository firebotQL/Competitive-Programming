import java.util.*;
import java.io.*;
import java.lang.*;

public class Main
{
	public static char[] suits = { 'S', 'H', 'D', 'C' };
	public static char[] majorCards = { 'A', 'K', 'Q', 'J' };
	public static int[] stoppedSuits = new int[256];
	public static int[] cardPoints = new int[256];
	public static int[] suitCounts = new int[256];
	
	public static int stoppedCount = 0;
	
	public static void prepareCardPoints()
	{
		for (int i = majorCards.length; i > 0; i--)
		{
			cardPoints[majorCards[majorCards.length - i]] = i;
		}
	}
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		int points = 0;
		int addPoints = 0;
		int subPoints = 0;
		int maxBid = 0;
		int suitCount = 0;
		char bid;
		prepareCardPoints();
		while((line = reader.readLine()) != null)
		{
			String[] cards = line.split("\\s+");
			suitCounts = new int[256];
			stoppedSuits = new int[256];
			
			points = 0;
			addPoints = 0;
			subPoints = 0;
			stoppedCount = 0;
			
			for(int i = 0; i < cards.length; i++)
			{
				points += cardPoints[cards[i].charAt(0)];
				suitCounts[cards[i].charAt(1)]++;
			}
			
			addPoints = getAddPoints();
			subPoints = getSubPointsAndCalcSuits(cards);
			points += addPoints - subPoints;
			
			if (points < 14)
			{
				System.out.println("PASS");
			} 
			else if (points - addPoints >= 16 && stoppedCount == 4)
			{
				System.out.println("BID NO-TRUMP");
			}
			else
			{
				maxBid = -1;
				bid = ' ';
				for(int i = 0; i < suits.length; i++)
				{
					suitCount = suitCounts[suits[i]];
					if (suitCount > maxBid)
					{
						maxBid = suitCount;
						bid = suits[i];
					}
				}
				System.out.println("BID " + bid);
			}
			//System.out.println("Points: " + points + " | Add Points: " + addPoints + " | Substract Points: " + subPoints + " | Stopped Count: " + stoppedCount);
		}
	}

	public static int getSubPointsAndCalcSuits(String[] cards)
	{
		int result = 0;
		int permCount, suitCount, stpCount;
		char suit;
		for(int i = 0; i < cards.length; i++)
		{
			suit = cards[i].charAt(1);
			suitCount = suitCounts[suit];
			switch(cards[i].charAt(0))
			{
				case 'A':
					stpCount = 0;
					permCount = -1;
					break;
				case 'K':
					stpCount = 1;
					permCount = 2;
					break;
				case 'Q':
					stpCount = 2;
					permCount = 3;
					break;
				case 'J':
					stpCount = 14;
					permCount = 4;
					break;
				default:
					stpCount = 14;
					permCount = -1;
					break;
			}
			//System.out.println("For card: " + cards[i] + " | " + suitCount + " > " + stpCount + "  |  " + stoppedSuits[suit]);
			if (suitCount < permCount)
			{
				result++;
			}
			
			if (suitCount > stpCount && stoppedSuits[suit] == 0)
			{
				stoppedSuits[suit]++;
				stoppedCount++;
			}
		}
		
		return result;
	}
	
	public static int getAddPoints()
	{
		int result = 0;
		for(int i = 0; i < suits.length; i++)
		{
			switch(suitCounts[suits[i]])
			{
				case 2:
					result += 1;
					break;
				case 1:
				case 0:
					result += 2;
					break;
			}
		}
		return result;
	}
}