import java.io.*;
import java.util.*;
import java.lang.*;

class Main 
{
	public static void main(String[] args) throws IOException {
		final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		int y, x, num, decimalNumber, answer, power;
		while((line = reader.readLine()) != null) {
			String[] lines = line.split(" ");
			y = new Integer(lines[0]).intValue();
			x = new Integer(lines[1]).intValue();
			num = new Integer(lines[2]).intValue();
			power = 0;
			decimalNumber = 0;
			answer = 0;
			do {
				decimalNumber += (num % 10) * Math.pow(y, power++);
			} while ((num /= 10) != 0);

			power = 0;
			do {
				answer += decimalNumber % x * Math.pow(10, power++);	
			}	while ((decimalNumber /= x) != 0)	;
			
			System.out.println(answer);  
		}		
	}
}
