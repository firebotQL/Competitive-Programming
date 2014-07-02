import java.io.*;
import java.lang.*;
import java.util.*;

class Main
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		int round = 0;
		int guessCount = 0;
		Set<Character> charsGuessing = new HashSet<Character>();
		while((line = reader.readLine()) != null && (round = Integer.valueOf(line)) != -1)
		{
			charsGuessing.clear();
			System.out.println("Round " + round);
			guessCount = 0;
			line = reader.readLine();
			Set<Character> charsToGuess = new HashSet<Character>(Arrays.asList(toCharacterArray(line)));
			line = reader.readLine(); 
			for(int i = 0; i < line.length() && charsToGuess.size() > 0 && guessCount < 7; i++)
			{
				Character guessChar = new Character(line.charAt(i));
				if (charsToGuess.contains(guessChar))
				{
					charsGuessing.add(guessChar);
					charsToGuess.remove(guessChar);
				}
				else
				{
					if(!charsGuessing.contains(guessChar))
					{
						charsGuessing.add(guessChar);
						guessCount++;
					}
				}
			}

			//System.out.println(guessCount + " " + charsToGuess.size());
			if (guessCount == 7)
			{
				System.out.println("You lose.");
			}
			else
			{
				if (charsToGuess.size() > 0)
				{
					System.out.println("You chickened out.");
				}
				else
				{
					System.out.println("You win.");
				}
			}
		}
	}
	
	public static Character[] toCharacterArray(String s) {
	   if (s == null) {
		 return null;
	   }
	   Character[] array = new Character[s.length()];
	   for (int i = 0; i < s.length(); i++) {
		  array[i] = new Character(s.charAt(i));
	   }

	   return array;
	}
}