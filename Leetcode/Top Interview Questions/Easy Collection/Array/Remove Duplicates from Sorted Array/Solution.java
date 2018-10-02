class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0 || nums.length == 1) return nums.length;
        int prevIdx = 0;
        for(int currentIdx = 1; currentIdx < nums.length; currentIdx++) {
            if (nums[prevIdx] != nums[currentIdx]) {
                nums[++prevIdx] = nums[currentIdx];
            }
        }
        nums = Arrays.copyOf(nums, prevIdx + 1);

        return nums.length;
    }
}
