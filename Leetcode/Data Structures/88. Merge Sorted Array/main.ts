/**
 Do not return anything, modify nums1 in-place instead.
 */
function merge(nums1: number[], m: number, nums2: number[], n: number): void {
    let i = m-1, j = n-1, p = (m + n) - 1;
    while(0 <= p) {
        if (nums1[i] < nums2[j] || i < 0) {
            nums1[p] = nums2[j];
            j--;
        } else {
            nums1[p] = nums1[i];
            i--;
        }
        p--;
    }
};
