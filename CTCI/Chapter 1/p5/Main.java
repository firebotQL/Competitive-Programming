/**
 * 1.5 There are three types of edits that can be performed on strings: insert a character, remove a character, or replace
 * a character. Given two strings, write a function to check if they are one edit (or zero edits) away.
 */
public class Main {
    public static void main(String[] args) {
        String str = "pale";
        String str2 = "pale";
        System.out.println(isOneWay(str, str2));
    }

    /**
     * O(n) runtime
     */
    private static boolean isOneWay(String str, String str2) {
        if (Math.abs(str.length() - str2.length()) > 1) {
            return false;
        }

        int i = 0;
        int j = 0;
        int diff = 0;
        while(i < str.length() && j < str2.length()) {
            char a = str.charAt(i);
            char b = str2.charAt(j);
            if (a != b) {
                diff++;
                if (str.length() > str2.length()) {
                    i++;
                } else if (str.length() < str2.length()) {
                    j++;
                } else {
                    i++;
                    j++;
                }
            }else {
                i++; j++;
            }
            if (diff > 1) {
                return false;
            }
        }
        if (diff == 1 && str.length() != str2.length() && (i != str.length() || j != str2.length())) {
            return false;
        }
        return true;
    }
}
