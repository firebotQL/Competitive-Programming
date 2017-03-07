import java.util.*;
import java.io.*;

public class Main {
  public static StringBuilder sb = new StringBuilder();
  public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       while(sc.hasNext()) {
           String line = sc.next();
           sb.setLength(0);
           sb.append(line);
           int palindromeStart = 0;
           int i = 0, j = line.length() - 1;
           while(i < j) {
               if (equalCharacters(line, i, j)) {
                   j--; i++;
               } else {
                   j = line.length() - 1;
                   if (palindromeStart == i) {
                       i++;
                   } else {
                       i = palindromeStart + 1;
                   }
                   palindromeStart = i;
               }
           }
           if (i >= j) {
               while(--palindromeStart >= 0) {
                  sb.append(line.charAt(palindromeStart));
               }
           } else {
               sb.append(line);
           }
           System.out.println(sb.toString());
       }
  }

  private static boolean equalCharacters(String line, int i, int j) {
      return line.charAt(i) == line.charAt(j);
  }
}
