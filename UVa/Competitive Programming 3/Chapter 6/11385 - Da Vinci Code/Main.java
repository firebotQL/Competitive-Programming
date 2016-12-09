import java.util.*;
import java.io.*;

public class Main {
  public static Map<Integer, Integer> preCalcFib() {
      Map<Integer, Integer> map = new HashMap<>();
      long prev = 1;
      long curr = 2;
      int count = 0;
      map.put((int)prev, count++);
      map.put((int)curr, count++);
      long newNum;
      while ((newNum = prev + curr) <= Integer.MAX_VALUE) {
          map.put((int)newNum, count++);
          prev = curr;
          curr = newNum;
      }

      return map;
  }


  public static void main(String[] args) throws IOException {
      Map<Integer, Integer> map = preCalcFib();
      BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
      int T = Integer.parseInt(reader.readLine());
      while(T-- != 0) {
          char[] decyphered = new char[44];
          Arrays.fill(decyphered, ' ');

          int N = Integer.parseInt(reader.readLine());
          String[] fibNumbers = reader.readLine().split("\\s+");
          String words = reader.readLine().replaceAll("[^A-Z]", "");

          for(int i = 0; i < N; i++) {
              int num = map.get(Integer.parseInt(fibNumbers[i]));
              char ch = words.charAt(i);
              decyphered[num] = ch;
          }

          System.out.println(new String(decyphered).replaceAll("\\s+$", ""));
      }
  }
}
