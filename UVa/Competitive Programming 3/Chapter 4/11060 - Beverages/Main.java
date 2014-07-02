import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
	public static class Drink
	{
		int inputOrder;
		String name;
		
		public Drink(int inputOrder, String name)
		{
			this.inputOrder  = inputOrder;
			this.name = name;
		}	
		
	}
	
	public static class DrinkComparator implements Comparator<Drink>
	{
		public int compare(Drink a, Drink b)
		{
			return a.inputOrder - b.inputOrder;
		}
	}
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		
		Map<String, List<String>> adjDrinks = new HashMap<String, List<String>>();
		Set<String> drinks = new HashSet<String>();
		Map<String, Drink> map = new HashMap<String, Drink>();
		List<Drink> alcoholOrder = new LinkedList<Drink>();
		int caseNr = 1;
		
		while((line = reader.readLine()) != null)
		{
			int N = Integer.valueOf(line);
			
			alcoholOrder.clear();
			adjDrinks.clear();
			drinks.clear();
			map.clear();
			
			for(int i = 0; i < N; i++)
			{
				String drinkName = reader.readLine();
				map.put(drinkName, new Drink(i, drinkName));
				drinks.add(drinkName);
			}
			
			int M = Integer.valueOf(reader.readLine());
			
			while(M-- != 0)
			{
				StringTokenizer token = new StringTokenizer(reader.readLine());
				
				String drink1 = token.nextToken();
				String drink2 = token.nextToken();
				
				List<String> adjList = adjDrinks.get(drink1);
				
				if (adjList == null)
				{
					adjList = new ArrayList<String>();
				}
				adjList.add(drink2);
				
				adjDrinks.put(drink1, adjList);
				
				drinks.remove(drink2);
			}
			
			PriorityQueue<Drink> S = new PriorityQueue<Drink>(100, new DrinkComparator());
			
			for(String drink : drinks)
			{
				S.add(map.get(drink));
			}
			
			String result = new String();
			
			
			while(!S.isEmpty())
			{
				Drink drink = S.poll();
				
				if (result.isEmpty())
				{
					result += drink.name;
				}
				else
				{
					result += " " + drink.name;
				}
				
				List<String> nextDrinks = adjDrinks.get(drink.name);
				
				if (nextDrinks != null)
				{
					for(Iterator<String> it = nextDrinks.iterator(); it.hasNext(); )
					{
						String mDrink = it.next();
						it.remove();
						
						boolean found = false;
						
						for(Map.Entry<String, List<String>> entry : adjDrinks.entrySet())
						{
							List<String> tmpDrinks = entry.getValue();
							if (tmpDrinks != null && tmpDrinks.contains(mDrink))
							{
								found = true;
								break;
							}
						}
						
						if (!found)
						{
							S.add(map.get(mDrink));
						}
					}
				}
			}
			
			
			System.out.println("Case #" + caseNr++ + ": Dilbert should drink beverages in this order: " + result + ".");
			System.out.println();
			reader.readLine();
		}
	}
}