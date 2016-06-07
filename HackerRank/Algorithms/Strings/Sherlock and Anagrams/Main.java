import java.io.*;
import java.util.*;

/*
*   Given a string , find the number of "unordered anagrammatic pairs" of substrings.
*/

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while(n-- != 0) {
            String s = sc.next();
            System.out.println(getCnt(s));
        }
    }
    
    private static int getCnt(String s) {

        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            String string = "" + s.charAt(i);
            addToMap(map, string);
            for(int j = i + 1; j < s.length(); j++) {
                string += s.charAt(j);
                addToMap(map, string);
            }
        }

        int cnt = 0;
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            Integer value = entry.getValue();
            cnt += value > 1 ? sumUp(value-1) : 0;
        }
        return cnt;
    }

    public static int sumUp(int n) {
        return (n*(n+1))/2;
    }

    private static void addToMap(Map<String, Integer> map, String string) {
        char[] chars = string.toCharArray();
        Arrays.sort(chars);
        String sorted = new String(chars);

        Integer count = map.get(sorted);
        if (count == null) {
            count = new Integer(0);
        }
        count++;
        map.put(sorted, count);
    }

    public static boolean checkIfAnagrams(String str1, String str2) {
        int[] strCnt = new int[256];

        for(int i = 0; i < str1.length(); i++) {
            char ch = str1.charAt(i);
            strCnt[ch]++;
        }

        boolean anagrams = true;
        for(int i = 0; i < str2.length(); i++) {
            char ch = str2.charAt(i);
            if (--strCnt[ch] < 0) {
                anagrams = false;
                break;
            }
        }
        return anagrams;
    }
}