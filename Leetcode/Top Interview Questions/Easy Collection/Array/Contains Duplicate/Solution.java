class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> countMap = new HashSet<Integer>();
        for(Integer number : nums) {
            if (!countMap.add(number)) return true;
        }
        return false;
    }
}
