import java.util.*;
import java.io.*;
import java.lang.*;

public class Main
{

	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		String[] values = null;
		
		List<Integer> princess = new ArrayList<Integer>();
		List<Integer> prince = new ArrayList<Integer>();
		int card = 0;
		int i = 0;
		int princeWin = 0;
		int princessWin = 0;
		int[] deck = null;
		while((line = reader.readLine()) != null && line.charAt(0) != '0')
		{
			deck = new int[53];
			card = -1;
			princeWin = 0;
			princessWin = 0;
			values = line.split("\\s+");
			
			princess = new ArrayList<Integer>();
			prince = new ArrayList<Integer>();
			
			princess.add(Integer.parseInt(values[0]));
			princess.add(Integer.parseInt(values[1]));
			princess.add(Integer.parseInt(values[2]));
			
			prince.add(Integer.parseInt(values[3]));
			prince.add(Integer.parseInt(values[4]));
			
			deck[princess.get(0).intValue()]++;
			deck[princess.get(1).intValue()]++;
			deck[princess.get(2).intValue()]++;
			
			deck[prince.get(0).intValue()]++;
			deck[prince.get(1).intValue()]++;	

			
			Collections.sort(princess);	
			Collections.sort(prince, Collections.reverseOrder());						

			Iterator<Integer> princessIterator = princess.iterator();			
			
			while(princessIterator.hasNext())
			{
				Integer princessCard = princessIterator.next();
				
				Iterator<Integer> princeIterator = prince.iterator();
				
				while (princeIterator.hasNext())
				{
					Integer princeCard = princeIterator.next();					

					//System.out.println(princessCard + " > " + princeCard);
					if (princessCard.intValue() > princeCard.intValue())
					{
						princeIterator.remove();
						princessIterator.remove();
						princessWin++;
						break;
					}
				}				
			}
			
			//System.out.println(princessWin);
			
			if (princessWin == 2)
			{
				card = -1;
			}
			else
			{
				if (princessWin == 1)
				{
					for(i = princess.get(1); i < 53; i++)
					{
						if (deck[i] == 0)
						{
							card = i;
							break;
						}
					}
				}
				else
				{
					for(i = 1; i < 53; i++)
					{
						if (deck[i] == 0)
						{
							card = i;
							break;
						}
					}
				}
			}

			System.out.println(card);
		}
	}
}