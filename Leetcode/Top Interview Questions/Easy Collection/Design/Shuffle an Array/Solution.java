class Solution {

    private final int[] original;
    private int[] current;

    public Solution(int[] nums) {
        original = nums;
        current = original.clone();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        current = original.clone();
        return current;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        IntStream.range(0, current.length).forEach(i -> swap(current, i, new Random().nextInt(current.length)));
        return current;
    }

    public void swap(int[] arr, int i , int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
