class Solution {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) return true;
        int startIdx = 0;
        int endIdx = s.length() - 1;
        while(startIdx < endIdx) {
            while(startIdx < endIdx && !isAlphaNumeric(s.charAt(startIdx))) startIdx++;
            while(startIdx < endIdx && !isAlphaNumeric(s.charAt(endIdx))) endIdx--;
            if (startIdx >= endIdx) break;
            char leftChar = Character.toLowerCase(s.charAt(startIdx));
            char rightChar = Character.toLowerCase(s.charAt(endIdx));
            if (leftChar != rightChar) return false;
            startIdx++;
            endIdx--;
        }
        return true;
    }

    public static boolean isAlphaNumeric(char ch) {
        return (ch > 64 && ch < 91) || (ch > 96 && ch < 123) || (ch > 47 && ch < 58);
    }
}
