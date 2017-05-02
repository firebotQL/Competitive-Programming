import java.util.*;
import java.io.*;
import java.util.stream.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    while(T-- != 0) {
      int[] arr = new int[10];
      int N = sc.nextInt();
      for(int i = 1; i <= N; i++) {
        int tmp = i;
        while(tmp != 0) {
          arr[tmp % 10]++;
          tmp /= 10;
        }
      }
      System.out.println(Arrays.stream(arr)
                                .mapToObj(i -> ((Integer) i).toString())
                                .collect(Collectors.joining(" ")));
    }
  }
}
