class Solution {
    public int firstUniqChar(String s) {
        int[] cnt = new int [256];
        for(int i = 0; i < s.length(); i++) {
            cnt[s.charAt(i)]++;
        }
        for(int i = 0; i < s.length(); i++) {
            if (cnt[s.charAt(i)] == 1) return i;
        }
        return -1;
    }
}
