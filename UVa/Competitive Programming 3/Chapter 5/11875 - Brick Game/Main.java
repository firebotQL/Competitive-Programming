import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.valueOf(reader.readLine());
    for(int i = 1; i <= T; i++) {
      String[] line = reader.readLine().split("\\s+");
      int N = Integer.valueOf(line[0]);
      System.out.format("Case %d: %s%n", i, line[N/2 + 1]);
    }
  }
}
