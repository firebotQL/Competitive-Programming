class Solution {
    public void moveZeroes(int[] nums) {
        int moveIdx = 0;
        for(int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (moveIdx != i) {
                    nums[moveIdx] = nums[i];
                }
                moveIdx++;
            }
        }
        for(; moveIdx < nums.length; moveIdx++) {
            nums[moveIdx] = 0;
        }
    }
}
