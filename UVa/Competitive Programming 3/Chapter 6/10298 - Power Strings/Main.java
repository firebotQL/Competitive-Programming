import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String line;
    while((line = reader.readLine()) != null) {
      if (line.equals(".")) {
        break;
      }

      int power = 1;

      for(int i = 2; i <= line.length(); i++) {         // Size of char group
        if (line.length() % i == 0) {
          int L = line.length() / i;                    // Count of groups in line
          boolean matched = true;
          for(int j = L; j < line.length(); j++) {
            if (line.charAt(j % L) != line.charAt(j)) { // If one of the groups don't match
              matched = false;
              break;
            }
          }
          if (matched) {
            power = Math.max(power, i);
          }
        }
      }

      System.out.println(power);
    }
  }
}
