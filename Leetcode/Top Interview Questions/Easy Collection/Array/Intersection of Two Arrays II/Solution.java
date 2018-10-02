class Solution {
    // This is O(n + k) run time and O(n + k) space complexity
    // Can be done in O(nlogn + nlogn) run time complexity (after sorting both arrays) and O(1) space complexity
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length < nums2.length) {
            int[] tmp = nums1;
            nums1 = nums2;
            nums2 = tmp;
        }
        List<Integer> result = new ArrayList<Integer>();
        Map<Integer, Integer> countMap = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums1.length; i++) {
            Integer count = countMap.get(nums1[i]);
            if (count == null) count = new Integer(0);
            countMap.put(nums1[i], count + 1);
        }

        for(int j = 0; j < nums2.length; j++) {
            int number = nums2[j];
            Integer count = countMap.get(number);
            if (count != null) {
                result.add(number);
                if ((count - 1) == 0) {
                    countMap.remove(number);
                } else {
                    countMap.put(number, count - 1);
                }
            }
        }

        return result.stream().mapToInt(i -> i).toArray();
    }
}
