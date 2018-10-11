class Solution {
    // Very long solution :/
    public int myAtoi(String str) {
        if (str == null || str.length() == 0) return 0;

        StringBuilder sb = new StringBuilder();
        int startIdx = 0;
        while(startIdx < str.length() && str.charAt(startIdx) == ' ') startIdx++;

        boolean negative = startIdx < str.length() && str.charAt(startIdx) == '-';
        if (startIdx < str.length() && isPlusMinusSymbol(str.charAt(startIdx))) startIdx++;

        while(startIdx < str.length() && isNumber(str.charAt(startIdx))) sb.append(str.charAt(startIdx++));

        int result = 0;

        try {
            for(int i = 0; i < sb.length(); i++) {
                char ch = sb.charAt(i);
                result = Math.multiplyExact(result, 10);
                result = Math.addExact(result, ch - 48);
            }
        } catch (ArithmeticException e) {
            return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }

        try {
            if (negative) result = Math.multiplyExact(result, -1);
        } catch (ArithmeticException e) {
            return Integer.MIN_VALUE;
        }

        return result;
    }

    public boolean isNumber(char ch) {
        return ch > 47 && ch < 58;
    }

    public boolean isPlusMinusSymbol(char ch) {
        return ch == '+' || ch == '-';
    }
}
