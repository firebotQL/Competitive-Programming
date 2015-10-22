/**
 * 1.9 Assume you have a method isSubstring which checks if one word is a substring of another.
 * Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 using only
 * one call to isSubstring (e.g. "waterbottle", "erbottlewat")
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(isSubstring("waterbottle", "erbottlewat"));
    }

    public static boolean isSubstring(String s1, String s2) {
        return s1.length() == s2.length() && (s1 + s2).indexOf(s2) != -1;
    }
}