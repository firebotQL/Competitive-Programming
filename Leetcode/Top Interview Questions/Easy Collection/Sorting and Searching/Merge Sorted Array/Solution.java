class Solution {
    /**
      O(n + m) - time complexity
    **/
    public void merge(int[] nums1, int m, int[] nums2, int n) {
          int mergeIdx = nums1.length - 1;
          int startIdx1 = nums1.length - nums2.length - 1;
          int startIdx2 = nums2.length - 1;
          while(startIdx1 >= 0 || startIdx2 >= 0) {
            if (startIdx1 >= 0 && startIdx2 >= 0) {
                if (nums1[startIdx1] > nums2[startIdx2]) {
                  nums1[mergeIdx--] = nums1[startIdx1--];
                } else {
                  nums1[mergeIdx--] = nums2[startIdx2--];
                }
            } else if (startIdx1 >= 0) {
              nums1[mergeIdx--] = nums1[startIdx1--];
            } else {
              nums1[mergeIdx--] = nums2[startIdx2--];
            }
          }
    }
}
