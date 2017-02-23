import java.util.*;
import java.util.regex.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    Scanner scanner = new Scanner(System.in);
    Pattern pattern = Pattern.compile("(\\d+)(\\+|-)(\\d+)=(-?\\d+)");
    int solvedNumber = 0;
    while(scanner.hasNext()) {
      String expression = scanner.next();
      Matcher matcher = pattern.matcher(expression);
      if (matcher.matches()) {
          int a = Integer.valueOf(matcher.group(1));
          int b = Integer.valueOf(matcher.group(3));
          String operator = matcher.group(2);
          int c = Integer.valueOf(matcher.group(4));
          switch(operator) {
            case "+" :
                solvedNumber += (a + b == c) ? 1 : 0;
                break;
            case "-":
                solvedNumber += (a - b == c) ? 1 : 0;
                break;
          }
      }
    }
    System.out.println(solvedNumber);
  }
}
