package chapter1.p4;

/**
 * Given a string, write a function to check if it is a permutation of a palindrome. A palindrome is a word or phrase
 * that is the same forwards and backwards. A permutation is rearrangement of letters. The palindrome does not need to
 * be limited to just dictionary words.
 */
public class Main {
    public static void main(String[] args) {
        String str = "Tact Coa";
        System.out.println(isPermutationOfPalindrome(str.toLowerCase()));
    }

    private static boolean isPermutationOfPalindrome(String str) {
        boolean[] cnt = new boolean[256];
        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == ' ') continue;
            cnt[ch] = !cnt[ch];
        }
        int left = 0;
        for(int i = 0; i < cnt.length; i++) {
            if (cnt[i]) {
                if (++left > 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
