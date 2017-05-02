import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int caseNr = 1;
    while(sc.hasNext()) {
      int R = sc.nextInt();
      int N = sc.nextInt();
      if (R == 0 && N == 0) {
        break;
      }
      int result = 0;
      if (R > N) {
        result = (R/N) - 1 + (R % N > 0 ? 1 : 0);
      }
      if (result <= 26) {
        System.out.format("Case %d: %d%n", caseNr++, result);
      } else {
        System.out.format("Case %d: %s%n", caseNr++, "impossible");
      }
    }
  }
}
