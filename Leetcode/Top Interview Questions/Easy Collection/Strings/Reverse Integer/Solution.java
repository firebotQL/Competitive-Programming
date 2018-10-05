class Solution {
    public int reverse(int x) {
        try {
            int result = 0;
            do {
                result = Math.multiplyExact(result, 10);
                result = Math.addExact(result, x % 10);
            } while ((x /= 10) != 0);
            return result;
        } catch (ArithmeticException e) {
            return 0;
        }
    }
}
