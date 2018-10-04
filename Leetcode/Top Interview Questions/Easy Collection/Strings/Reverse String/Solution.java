class Solution {
    // could have used embedded reverse function
    // or swapped with n / 2 runtime complexity char array
    public String reverseString(String s) {
        StringBuilder str = new StringBuilder();
        for(int i = s.length() - 1; i >= 0; i--) {
            str.append(s.charAt(i));
        }
        return str.toString();
    }
}
