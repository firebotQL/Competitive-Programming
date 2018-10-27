/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    /**
        Recursive creation of the binary search tree
        O(n) runtime and space complexity
    **/
    public TreeNode sortedArrayToBST(int[] nums) {
            return createNode(nums, 0, nums.length);
    }

    public TreeNode createNode(int[] nums, int leftIdx, int rightIdx) {
        TreeNode current = null;
        if (leftIdx != rightIdx) {
            int mid = (leftIdx + rightIdx) / 2;
            current = new TreeNode(nums[mid]);
            current.left = createNode(nums, leftIdx, mid);
            current.right = createNode(nums, mid + 1, rightIdx);
        }
        return current;
    }
}
