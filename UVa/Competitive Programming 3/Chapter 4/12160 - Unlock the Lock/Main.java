import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
	public static int[] buttons = new int[10];
	public static boolean[] clicked = new boolean[10000];
	
	public static int L, U, R;
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader  reader = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		int caseNr = 1;
		while((line = reader.readLine()) != null)
		{
			StringTokenizer token = new StringTokenizer(line);
			L = Integer.parseInt(token.nextToken());
			U = Integer.parseInt(token.nextToken());
			R = Integer.parseInt(token.nextToken());
			
			if (L == U && U == R && R == 0)
			{
				break;
			}
			
			Arrays.fill(clicked, false);
			
			token = new StringTokenizer(reader.readLine());
			
			for(int i = 0; i < R; i++)
			{
				buttons[i] = Integer.parseInt(token.nextToken());
			}
			
			int result = bfs();
			if (result != -1)
			{
				System.out.println("Case " + caseNr++ + ": " + result);
			}
			else
			{	
				System.out.println("Case " + caseNr++ + ": Permanently Locked");
			}
		}
		
	}
	
	public static int bfs()
	{
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(L);
		queue.add(0);
		
		while(!queue.isEmpty())
		{
			Integer currentCode = queue.poll();
			Integer pressedButtons = queue.poll();
			
			if (currentCode == U)
			{
				return pressedButtons;
			}
			
			for(int i = 0; i < R; i++)
			{
				int newNumber = (currentCode + buttons[i]) % 10000;
				if (!clicked[newNumber])
				{
					clicked[newNumber] = true;
					queue.add(newNumber);
					queue.add(pressedButtons + 1);
				}
			}
		}
		
		return -1;
	}
}