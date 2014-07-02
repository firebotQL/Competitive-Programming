import java.util.Scanner;
import java.io.IOException;

public class Main {
	public static int[] monthDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	public static int[] leapMonthDays = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	public static int getLeftDaysThisYear(int d, int m, int y) {
		int days = 0;
		int[] currentMonthDays = isLeapYear(y) ? leapMonthDays : monthDays;
		for(m -= 1;m < currentMonthDays.length; m++) {
			days += currentMonthDays[m];
		}
		return days - d;
	}

	public static boolean isLeapYear(int y) {
		return (y % 4 == 0 && y % 100 != 0) || y % 400 == 0;
	}

	public static void printDate(int N, int year) {
		int month = 0;
		int[] currentMonthDays = isLeapYear(year) ? leapMonthDays : monthDays;
		//System.out.println("N: " + N);
		for(month = 0 ;month < monthDays.length; month++) {
			if (N > currentMonthDays[month]) {
				N -= currentMonthDays[month];
			} else {
				break;
			}
		}

		System.out.println(N + " " + (month+1) + " " + year);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int day, month, year, N, daysThisYear;
		while((N = sc.nextInt()) != 0 &&
			(day = sc.nextInt()) != 0 &&
			(month = sc.nextInt()) != 0 &&
			(year = sc.nextInt()) != 0) {

			daysThisYear = getLeftDaysThisYear(day, month, year);

			while(N > daysThisYear) {
				N -= daysThisYear;
				year++;
				daysThisYear = isLeapYear(year) ? 366 : 365;
			}

			N += (isLeapYear(year) ? 366 : 365) - daysThisYear;

			printDate(N, year); 
		}
		
	}
}
