import java.util.Random;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		List<Integer> listOfInteger = new ArrayList<Integer>();
		Random randomGenerator = new Random();
		for(int i = 0; i < 1000000; ++i) {
			listOfInteger.add(randomGenerator.nextInt(1000));
		}
		Collections.sort(listOfInteger);
		System.out.println(Collections.binarySearch(listOfInteger, 10));
	}
}
