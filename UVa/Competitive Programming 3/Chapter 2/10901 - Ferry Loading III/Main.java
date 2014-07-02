import java.util.*;
import java.io.*;
import java.lang.*;

public class Main
{

	public static int currentTime;
	public static String side;
	public static int i;
	public static Queue<Car> q = null;
	
	public static class Car
	{
			public int arrivalTime;
			public int departureTime;
			public Car(int aT, int dT)
			{
				arrivalTime = aT;
				departureTime = dT;
			}
	}
	
	static class PQsort implements Comparator<Car> {
 
		public int compare(Car one, Car two) {
			return one.arrivalTime - two.arrivalTime;
		}
	}
	
	public static void main(String[] args) throws IOException
	{
		PQsort pqs = new PQsort();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n, t, m, carArrivalTime;
		int c = Integer.valueOf(reader.readLine());
		
		StringTokenizer tokenizer = null;
		PriorityQueue<Car> pq1 = null;
		PriorityQueue<Car> pq2 = null;
		
		
		while(c-- != 0)
		{
			pq1 = new PriorityQueue<Car>(10, pqs);
			pq2 = new PriorityQueue<Car>(10, pqs);
			
			q = new LinkedList<Car>();
			
			currentTime = 0;
			
			tokenizer = new StringTokenizer(reader.readLine());
			n = Integer.parseInt(tokenizer.nextToken());
			t = Integer.parseInt(tokenizer.nextToken());
			m = Integer.parseInt(tokenizer.nextToken());
			
			while(m-- != 0)
			{
				tokenizer = new StringTokenizer(reader.readLine());
				carArrivalTime = Integer.parseInt(tokenizer.nextToken());
				side = tokenizer.nextToken();
				
				Car car = new Car(carArrivalTime, -1);
				
				if (side.equals("left"))
				{
					pq1.add(car);
				} 
				else 
				{
					pq2.add(car);
				}
				
				q.add(car);
			}
			
			side = "left";
			boolean waitingCar = false;
			
			while(pq1.size() != 0 || pq2.size() != 0)
			{			
				waitingCar = false;
				if (currentWaitingCar(pq1) || currentWaitingCar(pq2))
				{
					waitingCar = true;
				}
				
				if (waitingCar)
				{
					if (side.equals("left"))
					{
						loadAndTravelAndUnload(pq1, t, n, "right");
					}
					else
					{
						loadAndTravelAndUnload(pq2, t, n, "left");
					}
				}
				else
				{
					carArrival(pq1, pq2, t);
				}
			}
			
			while(q.size() > 0)
			{
				System.out.println(q.poll().departureTime);
			}
			
			if (c != 0)
			{
				System.out.println();
			}

		}
	}
	
	public static void carArrival(PriorityQueue<Car> pq1, PriorityQueue<Car> pq2, int t)
	{
		if (pq1.size() != 0 && pq2.size() != 0)
		{
			if (pq1.peek().arrivalTime < pq2.peek().arrivalTime)
			{
				currentTime = pq1.peek().arrivalTime;
			}
			else if (pq1.peek().arrivalTime > pq2.peek().arrivalTime)
			{
				currentTime = pq2.peek().arrivalTime;
			}
			else
			{
				currentTime = pq1.peek().arrivalTime;
			}
		}
		else if (pq1.size() != 0)
		{
			currentTime = pq1.peek().arrivalTime;
		}
		else
		{
			currentTime = pq2.peek().arrivalTime;
		}
	}
	
	public static boolean currentWaitingCar(PriorityQueue<Car> pq)
	{
		return pq.size() != 0 && pq.peek().arrivalTime <= currentTime;
	}
	
	public static void loadAndTravelAndUnload(PriorityQueue<Car> pq, int t, int n, String travelSide)
	{
		int count = 0;
		Queue<Car> carArrivalTimes = new LinkedList<Car>();
		
		while((pq.size() != 0) && (pq.peek().arrivalTime <= currentTime) && (count < n))
		{
			count++;
			carArrivalTimes.add(pq.poll());
		}
		
		currentTime += t;
		
		while(count-- != 0)
		{
			Car car = carArrivalTimes.poll();
			car.departureTime = currentTime;
		}
		
		side = travelSide;
	}
}