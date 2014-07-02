import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int i, months, depr, month;
		double percentage, payoff, loan, worth, payment;
		Double rate;
		Map<Integer, Double> map = new HashMap<Integer, Double>();
		while((months = sc.nextInt()) >= 0) {
			payoff = sc.nextDouble();
			loan = sc.nextDouble();
			depr = sc.nextInt();
			worth = loan + payoff;
			payment = loan / months;
			month = 0;
			map.clear();

			while(depr-- != 0) {
				map.put(sc.nextInt(), 1 - sc.nextDouble());
			}
			// initial depreciation
			rate = map.get(month);
			worth *= rate;

			while(month++ != months && loan >= worth) {
				if (map.containsKey(month))
					rate = map.get(month);
				worth *= rate;
				loan -= payment;
			}
			switch (--month) {
				case 1:
					System.out.println(month + " month");
					break;
				default:
					System.out.println(month + " months");
			}
			
		}
	}	
}
