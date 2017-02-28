import java.util.*;
import java.util.regex.*;
import java.lang.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    Pattern pattern = Pattern.compile("^[\\+-]?(\\d+\\.\\d+)?(\\d+\\.\\d+[eE][\\+-]\\d+)?(\\d+[eE][\\+-]?\\d+)?$");
    String line = null;
    while((line = reader.readLine()) != null) {
      line = line.trim();
      if (line.equals("*")) {
        return;
      }
      String postfix = " is illegal.";
      if (!line.isEmpty()) {
        Matcher matcher = pattern.matcher(line);
        if (matcher.find()) {
            postfix = " is legal.";
        }
      }
      System.out.println(line + postfix);
    }
  }
}
