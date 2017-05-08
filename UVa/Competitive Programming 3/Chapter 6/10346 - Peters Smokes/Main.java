import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while(sc.hasNext()) {
      int n = sc.nextInt();
      int k = sc.nextInt();
      int butts = 0;
      int smoked = 0;
      do {
        smoked += n;
        int tmp = n;
        n = (tmp + butts) / k;
        butts = (tmp + butts) % k;
      } while (n > 0);
      System.out.println(smoked);
    }
  }
}
