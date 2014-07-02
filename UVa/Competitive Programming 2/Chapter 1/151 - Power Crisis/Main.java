import java.util.Scanner;
import java.util.LinkedList;
import java.util.List;
import java.lang.Integer;

class Main
{
	static List regions = new LinkedList();
	public static void initRegions(int size) {
		regions.clear();
		for(int i = 0; i < size; ++i) {
			regions.add(i+1);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N, i, m, min;
		while(sc.hasNextInt() && 
			(N = sc.nextInt()) != 0) {
			min = Integer.MAX_VALUE;
			m = 0;
			while(m >= 0) {
				initRegions(N);
				i = 0;
				while(regions.size() != 1) {
					regions.remove(i); 
					i += m;
					i = i % regions.size();
				}
				if ((Integer)regions.get(0) == 13) {
					min = m;			
					break;		
				}
				m++;
			}
			System.out.println(min+1);
		}
	}
}
