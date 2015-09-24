/** 1.1 Implement an algorithm to determine if a string has all unique characters.
 * What if you cannot use additional data structures.
 */
package chapter1.p1;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String str = "ABCDEA";
        System.out.println("Is is unique: " + isUniqueV1(str));
        System.out.println("Is is unique: " + isUniqueV2(str));
        System.out.println("Is is unique: " + isUniqueV3(str));
    }

    /**
     * Using data structure
     * O(n) runtime, O(n) memory
     */
    public static boolean isUniqueV1(String str) {
        int[] cnt = new int[256];
        for(int i = 0; i < str.length(); i++) {
            if (cnt[str.charAt(i)]++ > 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Without data structure
     * O (n log(n)) runtime, O(1) memory
     */
    public static boolean isUniqueV2(String str) {
        char[] chStr = str.toCharArray();
        Arrays.sort(chStr);
        for(int i = 0; i < chStr.length-1; i++) {
            if (chStr[i] == chStr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Without data structure
     * O (n^2) runtime, O(1) memory
     */
    public static boolean isUniqueV3(String str) {
        for(int i = 0; i < str.length(); i++) {
            for(int j = i + 1; j < str.length(); j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }
}
