class Solution {
     public static String countAndSay(int n) {
        String result = "1";
        for(int i = 0; i < n - 1; i++) {
            int cnt = 1;
            StringBuilder sb = new StringBuilder();
            
            for(int j = 0; j < result.length() - 1; j++, cnt++) {
                if (result.charAt(j) != result.charAt(j + 1)) {
                    sb.append(cnt);
                    sb.append(result.charAt(j));
                    cnt = 0;
                }
            }

            sb.append(cnt);
            sb.append(result.charAt(result.length() - 1));

            result = sb.toString();
        }
        return result;
    }
}
