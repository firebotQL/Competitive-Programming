/**
    Complexities:
    O(n) - runtime
    O(n) - space (because of function stacks)
**/
class Solution {
    public int[] memo;
    public int rob(int[] nums) {
        memo = new int[nums.length + 1];
        Arrays.fill(memo, -1);
        return rob(nums, 0);
    }

    public int rob(int[] nums, int i) {
        if (i >= nums.length) return 0;
        if (memo[i] != -1) return memo[i];
        return memo[i] = Math.max(rob(nums, i + 2) + nums[i], rob(nums, i + 1));
    }
}
