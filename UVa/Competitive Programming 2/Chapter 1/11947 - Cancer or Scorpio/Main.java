import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.lang.Integer;
import java.util.GregorianCalendar;
import java.util.Calendar;

public class Main
{
	public static String getZodiac(int month, int day) {
		switch (month) {
			case 1:
				return day < 21 ? "capricorn" : "aquarius";
			case 2:
				return day < 20 ? "aquarius" : "pisces";
			case 3:
				return day < 21 ? "pisces" : "aries";
			case 4:
				return day < 21 ? "aries" : "taurus";
			case 5:
				return day < 22 ? "taurus" : "gemini";
			case 6:
				return day < 22 ? "gemini" : "cancer";
			case 7:
				return day < 23 ? "cancer" : "leo";
			case 8:
				return day < 22 ? "leo" : "virgo";
			case 9:
				return day < 24 ? "virgo" : "libra";
			case 10:
				return day < 24 ? "libra" : "scorpio";
			case 11:
				return day < 23 ? "scorpio" : "sagittarius";
			case 12:
				return day < 23 ? "sagittarius" : "capricorn";
		}
		return "";
	}

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		int day, month, year;
		String line;
		Calendar gCal = Calendar.getInstance();
		for(int i = 1; i <= N; i++) {
			line = reader.readLine();
			month = Integer.parseInt(line.substring(0,2));
			day = Integer.parseInt(line.substring(2,4));
			year = Integer.parseInt(line.substring(4,8));
			gCal.set(year, month-1, day);
			gCal.add(Calendar.DATE, 40*7);
			System.out.printf("%d %02d/%02d/%04d %s\n",
				i,
				gCal.get(Calendar.MONTH)+1,
				gCal.get(Calendar.DATE),
				gCal.get(Calendar.YEAR),
				getZodiac(gCal.get(Calendar.MONTH)+1, gCal.get(Calendar.DATE)));
		}
	}
}
