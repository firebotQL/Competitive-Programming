package chapter1.p2;

/**
 * 1.2  Given two strings, write a method to decide if one is a permutation of the other.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(isPermutation("HELPMEOUT","HPMEZOUT1")); // Case 1. Different size!
        System.out.println(isPermutation("HELPMEOUT","HPMEZOUTL")); // Case 2. One character difference
        System.out.println(isPermutation("HELPMEOUT","HPMEEOUTL")); // Case 3. Equal
    }

    /*
    * Using data structure
    * O(n) runtime, O(n) memory
    * NOTE: Could also do in O(n^2) time and O(1) memory,
    * or O(nlog(n)) time and O(1) memory
    */
    private static boolean isPermutation(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        int[] cnt = new int[256];
        for(int i = 0; i < str1.length(); i++) {
            cnt[str1.charAt(i)]++;
        }
        for(int i = 0; i < str2.length(); i++) {
            if (--cnt[str2.charAt(i)] < 0) {
                return false;
            }
        }
        return true;
    }

}
