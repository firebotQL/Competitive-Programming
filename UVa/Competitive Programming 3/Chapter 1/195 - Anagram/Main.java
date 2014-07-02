import java.io.*;
import java.util.*;
import java.lang.*;
import java.text.*;

public class Main
{	
	public static Comparator<Character> comp = new Comparator<Character>() {
			public int compare(Character c1, Character c2) {
				int cmp = Character.compare(
					Character.toLowerCase(c1.charValue()),
					Character.toLowerCase(c2.charValue())
				);
				if (cmp != 0) return cmp;
				return Character.compare(c1.charValue(), c2.charValue());
			}
	};
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int size = Integer.valueOf(reader.readLine());
		char[] permutationLine = null;
		while(size-- != 0)
		{
			permutationLine = sortLexicographically(reader.readLine());
			permutationsChar(0, permutationLine, new boolean[permutationLine.length], new char[permutationLine.length]);		
		}
	}
	
	public static char[] sortLexicographically(String string)
	{
		Character[] chars = toCharacterArray(string);
		Arrays.sort(chars, comp);
		return convertCharacters(chars);
	}	
	
	public static char[] convertCharacters(Character[] string)
	{
		char[] result = new char[string.length];
		for(int i = 0; i < string.length; i++)
		{
			result[i] = string[i];
		}
		return result;
	}
	
	public static Character[] toCharacterArray(String str) {
	   Character[] arr = new Character[str.length()];
		for (int i = 0; i < str.length(); i++)
			arr[i] = str.charAt(i);
		return arr;
	}
	
	public static void permutationsChar(int index, char[] initialString, boolean[] visited, char[] result) {	
        if (index == result.length) {		
            System.out.println(new String(result));			
        } else {		
            for (int j = 0; j < initialString.length; j++) {
                if (!visited[j]) {
				
                    if ((j > 0 && !visited[j - 1] && initialString[j - 1] == initialString[j])) {
                        continue;
                    }
					
                    visited[j] = true;					
                    result[index] = initialString[j];
					
                    permutationsChar(index + 1, initialString, visited, result);// recurse to choose next
                    // character
                    visited[j] = false;// back track
                    result[index] = '-';
                }
            }
        }
    }
	
}