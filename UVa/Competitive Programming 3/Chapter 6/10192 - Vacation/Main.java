import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
     BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
     String cities1;
     String cities2;
     int caseNr = 1;

     while ((cities1 = reader.readLine()) != null) {
       if (cities1.startsWith("#")) break;
       cities2 = reader.readLine();
       int[][] memo = new int[cities1.length()][cities2.length()];
       for (int[] row: memo) {
         Arrays.fill(row, -1);
       }
       int citiesCount = match(0, 0, cities1, cities2, memo);
       System.out.println(String.format("Case #%d: you can visit at most %d cities.", caseNr++, citiesCount));
     }
  }

  public static int match(int s1, int s2, String cities1, String cities2, int[][] memo) {
      if (s1 == cities1.length()) return 0;
      if (s2 == cities2.length()) return 0;

      if (memo[s1][s2] != -1) {
        return memo[s1][s2];
      }

      if (cities1.charAt(s1) == cities2.charAt(s2)) {
        return memo[s1][s2] = 1 + match(s1 + 1, s2 + 1, cities1, cities2, memo);
      } else {
        int left = match(s1 + 1, s2, cities1, cities2, memo);
        int right = match(s1, s2 + 1, cities1, cities2, memo);
        return memo[s1][s2] = Math.max(left, right);
      }
  }
}
