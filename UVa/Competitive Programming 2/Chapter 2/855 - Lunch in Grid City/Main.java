import java.util.*;
import java.io.*;

class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		int S,A,F;
		ArrayList<Integer> street = new ArrayList<Integer>();
		ArrayList<Integer> avenue = new ArrayList<Integer>();
		Integer s,a;
		while(T-- != 0) {
			street.clear();
			avenue.clear();
			S = scan.nextInt();
			A = scan.nextInt();
			F = scan.nextInt();
			while(F-- != 0) {
				street.add(scan.nextInt());
				avenue.add(scan.nextInt());
			}
			Collections.sort(street);
			Collections.sort(avenue);
			s = street.get(street.size() % 2 == 0 ? street.size()/2-1 : street.size()/2);
			a = avenue.get(avenue.size() % 2 == 0 ? street.size()/2-1 : street.size()/2);
			System.out.println("(Street: " + s + "," + " Avenue: " + a + ")");
		}
		
	}
}
