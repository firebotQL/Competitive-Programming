import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.lang.Character;
import java.lang.Integer;
import java.util.ArrayList;
/* TODO: FIX IT COUSE THIS CODE IS ABOMINATION */
class Main 
{
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		String gameOverLine = "Game Over";
		int i, sum, count, length, x, y, z;

		int[] array = new int[256];
		for(i = 49; i < 58; ++i)
			array[i] = i - 48;
		array['X'] = 10;
		array['/'] = 10;
		long start = System.currentTimeMillis();
		char[] scores;
		while((line = reader.readLine()) != null 
			&& line.compareTo(gameOverLine) != 0) {
			sum = 0;
			count = 0;
			System.out.println("R-Lenght: " + line.length());
			length = line.length()/2-2;
			System.out.println("Lenght: " + length);
			for(i = 0; i < length; i++) {	
				count++;
				x = i * 2;
				y = x + 2;
				z = y + 2;			
				if (line.charAt(x) == 'X') {
					sum += 10;
					if (count < 10) {
						sum += array[line.charAt(z)];
						if (line.charAt(z) != '/') 	
							sum += array[line.charAt(y)];
						
					}
				} else {
					sum += array[line.charAt(y)];
					if (line.charAt(y) == '/') {
						if (count < 10) 
							sum += array[line.charAt(y)];						
					} else {					
						sum += array[line.charAt(x)];
					}
					i++;	
				}
				
			}
			
			System.out.println(sum);
		}
		long end = System.currentTimeMillis();
		System.out.println("Execution time was "+(end-start)+" ms.");
	}
}
