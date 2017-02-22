import java.util.*;
import java.io.*;

/** Runtime : 0.770s **/

public class Main {
  public static void main(String[] args) throws IOException {
    Scanner input = new Scanner(System.in);
    while(input.hasNext()) {
      int N = input.nextInt();
      String message = input.next();
      Map<String, Integer> countMap = new HashMap<>();
      String newStr = message.substring(0, N);
      String maxCypher = newStr;
      int max = 1;
      for(int i = N; i < message.length(); i++) {
        newStr = newStr.substring(1, newStr.length()) + message.charAt(i);
        Integer count = countMap.getOrDefault(newStr, 0);
        countMap.put(newStr, ++count);
        if (count > max) {
          maxCypher = newStr;
          max = count;
        }
      }
      System.out.println(maxCypher);
    }
  }
}
