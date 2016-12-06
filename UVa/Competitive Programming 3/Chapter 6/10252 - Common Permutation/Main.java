import java.io.*;
import java.util.*;

public class Main {
  public static final int ASCII_SIZE = 256;

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String a, b;

    while((a = reader.readLine()) != null) {
      b = reader.readLine();

      int[] aCharCounter = getCountedChars(a);
      int[] bCharCounter = getCountedChars(b);
      StringBuffer sb = new StringBuffer();
      for(int i = 0; i < ASCII_SIZE; i++) {
          while(aCharCounter[i]-- > 0 && bCharCounter[i]-- > 0) {
            sb.append((char)i);
          }
      }
      System.out.println(sb.toString());
    }
  }

  public static int[] getCountedChars(String str) {
      int[] result = new int[ASCII_SIZE];

      for(int i = 0; i < str.length(); i++) {
        result[str.charAt(i)]++;
      }

      return result;
  }
}
