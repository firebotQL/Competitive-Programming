class Solution {
    // if it's unicode and not acii then I use map of chars
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null) return false;
        if (s.length() != t.length()) return false;

        int[] cnt = new int[256];
        for(int i = 0; i < s.length(); i++) {
            cnt[s.charAt(i)]++;
            cnt[t.charAt(i)]--;
        }

        for(int i = 0; i < 256; i++) {
            if (cnt[i] != 0) return false;
        }
        return true;
    }
}
