import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] cnts = new int[n];
        Map<Integer, List<String>> mappings = new HashMap<Integer, List<String>>();
        for (int i = 0; i < n; i++) {
            int val = sc.nextInt();
            String str = sc.next();
            cnts[val]++;
            List<String> list = mappings.get(val);
            if (list == null) {
                list = new ArrayList<String>();
            }
            if (n / 2 > i) {
                list.add("-");
            } else {
                list.add(str);
            }
            mappings.put(val, list);
        }
        for(int i = 0; i < cnts.length; i++) {
            int cnt = cnts[i];
            if (cnt > 0) {
                List<String> list = mappings.get(i);
                for(int j = 0; j < cnt; j++) {
                    System.out.print(list.get(j) + " ");
                }
            }
        }
    }
}
