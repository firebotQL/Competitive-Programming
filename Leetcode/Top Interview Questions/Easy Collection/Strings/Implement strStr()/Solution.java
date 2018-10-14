class Solution {
    // O(n*m) runtime and O(1) space complexity
    // where n - haystack length and m is needle length
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0) return 0;
        for(int hIdx = 0; hIdx < haystack.length(); hIdx++) {
            if (haystack.length() - hIdx < needle.length()) return -1;
            int nIdx = 0;
            for(; nIdx < needle.length(); nIdx++) {
                if (haystack.charAt(hIdx + nIdx) != needle.charAt(nIdx)) break;
            }
            if (nIdx == needle.length()) return hIdx;
        }
        return -1;
    }
}
