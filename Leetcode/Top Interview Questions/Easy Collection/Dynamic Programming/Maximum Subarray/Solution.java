class Solution {
  /**
  * Divide and conquer solution
  * O(nlogn) runtime complexity 
  **/
    public int maxSubArray(int[] nums) {
        return maxSubArraySum(nums, 0, nums.length - 1);
    }

    public int maxSubArraySum(int[] nums, int left, int right) {
        if (left == right) return nums[left];
        int mid = (left + right) / 2;
        return Math.max(Math.max(maxSubArraySum(nums, left, mid), maxSubArraySum(nums, mid + 1, right)), maxCrossingSubArray(nums, left, mid, right));
    }

    public int maxCrossingSubArray(int[] nums, int left, int mid, int right) {
        int currentSum = 0;
        int leftMaxSum = Integer.MIN_VALUE;
        for(int i = mid; i >= left; i--) {
            currentSum += nums[i];
            leftMaxSum = Math.max(leftMaxSum, currentSum);
        }
        currentSum = 0;
        int rightMaxSum = Integer.MIN_VALUE;
        for(int i = mid + 1; i <= right; i++) {
            currentSum += nums[i];
            rightMaxSum = Math.max(rightMaxSum, currentSum);
        }

        return leftMaxSum + rightMaxSum;
    }

}
