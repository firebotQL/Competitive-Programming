import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		String[] separatedLine = null;
		int set, N, S, Q, Qi, i, numOfCargoes;
		set = Integer.valueOf(reader.readLine());
		List<Queue<Integer>> ring = null;
		Queue<Integer> platformB = null;
		while(set-- != 0)
		{
			numOfCargoes = 0;
			separatedLine = reader.readLine().split("\\s+");
			N = Integer.valueOf(separatedLine[0]); // Number of stations in the ring
			S = Integer.valueOf(separatedLine[1]); // Maximum nunber of cargoes carrier can stack
			Q = Integer.valueOf(separatedLine[2]); // Maximum number of cargoes platform B can accomodate
			
			ring = new LinkedList<Queue<Integer>>();
			
			while(N-- != 0)
			{
				separatedLine = reader.readLine().split("\\s+");
				Qi = Integer.valueOf(separatedLine[0]);
				numOfCargoes += Qi;
				platformB = new LinkedList<Integer>();
				i = 0;
				while(i++ < Qi) // from front to read?
				{
					platformB.add(Integer.valueOf(separatedLine[i]));
				}
				ring.add(platformB);
				//System.out.println(platformB);
			}
			System.out.println(simulateCargos(ring, S, Q, numOfCargoes));
		}
	}
	
	public static long simulateCargos(List<Queue<Integer>> ring, int cargoSize, int maximumBSize, int numberOfCargos)
	{
		int i = 0;
		int ringSize = ring.size();
		int currentStation = 1;
		Queue<Integer> platformB = null;
		Stack<Integer> cargo = new Stack<Integer>();
		long minutes = 0;
		//System.out.println(ringSize);
		while(numberOfCargos != 0)
		{
			
			currentStation = i++ % ringSize;
			platformB = ring.get(currentStation);
			//System.out.println("platformB: " + platformB + " : " + cargo);
			while(cargo.size() > 0)
			{
				// unloading to plaform A
				if (cargo.peek() == currentStation+1)
				{
					cargo.pop();
					minutes++;
					numberOfCargos--;
					continue;
				}
				
				// if platformB can accomodate more cargoes unload to platform B
				// or stop the process
				if (platformB.size() != maximumBSize)
				{
					platformB.add(cargo.pop());
					minutes++;
				}
				else
				{
					break;
				}
			}
			
			while(platformB.size() > 0)
			{
				if (cargo.size() != cargoSize)
				{
					cargo.push(platformB.poll());
					minutes++;
				}
				else
				{
					break;
				}
			}
			
			if (numberOfCargos != 0)
			{
				minutes += 2;
			}
		}
		
		return minutes;
	}
}