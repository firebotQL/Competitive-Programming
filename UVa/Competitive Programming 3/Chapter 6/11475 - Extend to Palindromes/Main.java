import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       while(sc.hasNext()) {
           String line = sc.next();
           if (line.length() == 1) {
             System.out.println(line);
             continue;
           }
           String rev = new StringBuilder(line).reverse().toString();

           int[] T = generatePrefixArray(rev);
           int startIdx = match(line, rev, T);

           System.out.println(line + rev.substring(startIdx, rev.length()));
       }
  }

  private static int match(String text, String pattern, int[] T) {
          int j = 0, i = 0;
          while(j + i < text.length()) {
              if (pattern.charAt(i) == text.charAt(i + j)) {
                  if (j == pattern.length()) {
                      return i;
                  }
                  i++;
              } else {
                  j += i - T[i];
                  if (T[i] > -1) {
                      i = T[i];
                  } else {
                      i = 0;
                  }
              }
          }
          return i;
      }

  private static int[] generatePrefixArray(String pattern) {
      int i = 2, sub = 0;
      int[] T = new int[pattern.length()];
      T[0] = -1;
      T[1] = 0;
      while(i < pattern.length()) {
          if (pattern.charAt(i-1) == pattern.charAt(sub)) {
              sub++;
              T[i] = sub;
              i++;
          } else if (sub > 0) {
              sub = T[sub];
          } else {
              T[i] = 0;
              i++;
          }
      }
      return T;
  }
}
