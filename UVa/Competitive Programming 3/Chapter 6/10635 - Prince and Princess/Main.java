import java.util.*;
import java.lang.*;

public class Main {

   public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       int t = sc.nextInt();
       for(int i = 1; i <= t; i++) {
           int n = sc.nextInt();
           int p = sc.nextInt();
           int q = sc.nextInt();
           Map<Integer, Integer> qmap = new HashMap<Integer, Integer>();
           for(int j = 0; j <= p; j++) {
               qmap.put(sc.nextInt(), j);
           }
           List<Integer> plist = new ArrayList<>();
           for(int j = 0; j <= q; j++) {
               int qc = sc.nextInt();
               if (qmap.containsKey(qc)) {
                   plist.add(qmap.get(qc));
               }
           }
           int[] arr = plist.stream().mapToInt(z->z).toArray();
           System.out.println("Case " + i + ": " + lis(arr, plist.size()));
       }
   }

   public static int CeilIndex(int A[], int l, int r, int key) {
     while(r - l > 1) {
       int m = l + (r - l) / 2;
       if (A[m] >= key)
          r = m;
       else
          l = m;
     }
     return r;
   }

   public static int lis(int arr[], int n) {
     int[] tb = new int[n];
     int len = 1;
     tb[0] = arr[0];
     for(int i = 1; i < n; i++) {
       if (arr[i] < tb[i]) {
         tb[0] = arr[i];
       } else if (arr[i] > tb[len - 1]) {
         tb[len++] = arr[i];
       } else {
         tb[CeilIndex(tb, -1, len - 1, arr[i])] = arr[i];
       }
     }

     return len;
   }
}
