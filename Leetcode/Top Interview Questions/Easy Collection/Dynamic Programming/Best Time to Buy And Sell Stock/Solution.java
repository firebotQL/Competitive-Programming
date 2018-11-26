class Solution {
    /**
      O(n) - runtime complexity
      O(1) - space complexity
    **/
    public int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;
        int maxDiff = -1;
        int maxRight = prices[prices.length - 1];
        for(int i = prices.length - 2; i >= 0; i--) {
            if (prices[i] > maxRight) {
                maxRight = prices[i];
            } else {
                int diff = maxRight - prices[i];
                if (diff > maxDiff) {
                    maxDiff = diff;
                }
            }
        }
        return maxDiff < 0 ? 0 : maxDiff;
    }
}
