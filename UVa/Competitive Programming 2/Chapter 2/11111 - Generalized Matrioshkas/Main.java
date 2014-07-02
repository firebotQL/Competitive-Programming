import java.io.*;
import java.util.*;
import java.lang.*;

class Main {
		static Integer original, search, intermed;
		static Stack stack = new Stack();
		static Stack countStack = new Stack();
		
		public static boolean matrioska(Scanner scan) {
			
			original = scan.nextInt();
			if ((search - original) != 0) {
				if (original < 0) {
					stack.push(original);
					if (!countStack.empty()) {
						intermed = (Integer)countStack.pop()-original;
						
						if (intermed >= 0) {
							return false;
						}
						countStack.push(intermed);
						countStack.push(original);
					} else {
						countStack.push(original);
					}
					search = Math.abs(original);
				} else {
					return false;
				}
			} else {
				stack.pop();
				countStack.pop();
				if (!stack.empty()) {
					search = Math.abs((Integer)stack.peek());
				}
			}
			
			if (scan.hasNextInt() && !stack.empty()) {
					return matrioska(scan);
			} else {
				if (stack.empty()) {
					return true;
				}
			}
			
			return false;
		}
		
		public static void main(String[] args) throws IOException {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			String toy;
			Scanner scan;
			original = 0;
			search = 0;
			while((toy = reader.readLine()) != null) {
				if (matrioska(new Scanner(toy)) && stack.empty()) {
					System.out.println(":-) Matrioshka!");
				} else {
					System.out.println(":-( Try again.");
				}				
				stack = new Stack();
				countStack = new Stack();
			}
		}
}