import java.util.*;
import java.io.*;
import java.lang.*;

public class Main
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		List<Stack<Character>> cStacks = null;
		Stack<Character> newStack = null;
		int i, resCase = 1;
		char ch;
		boolean added = false;
		
		while((line = reader.readLine()) != null && line.charAt(0) != 'e')
		{
			cStacks = new ArrayList<Stack<Character>>();
			
			for(i = 0; i < line.length(); i++)
			{
				ch = line.charAt(i);
				added = false;
				for(Stack<Character> stack : cStacks)
				{
					if (stack.peek() >= ch)
					{
						stack.push(ch);
						added = true;
						break;
					}
				}
				if (!added)
				{
					newStack = new Stack<Character>();
					newStack.push(ch);
					cStacks.add(newStack);
				}
			}
			System.out.println("Case " + resCase++ + ": " + cStacks.size());
		}
	}
}