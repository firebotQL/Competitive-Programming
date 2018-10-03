class Solution {
    // O(n) - runtime, O(n) - space complexities
    public int[] plusOne(int[] digits) {
        List<Integer> result = new ArrayList<Integer>();
        int carry = 1;
        for(int i = digits.length - 1; i >= 0; i--) {
            int sum = digits[i] + carry;
            carry = sum / 10;
            result.add(sum % 10);
        }
        if (carry > 0) {
            result.add(carry);
        }
        Collections.reverse(result);
        return result.stream().mapToInt(i -> i).toArray();
    }
}
