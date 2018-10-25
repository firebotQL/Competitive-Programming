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
        In order traversal
        every element should be bigger than previous
        O(n) runtime and space complexity
    **/
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> s = new Stack();
        TreeNode current = root;
        Integer prev = null;
        while(current != null || !s.empty()) {
            while(current != null) {
                s.push(current);
                current = current.left;
            }

            current = s.pop();
            if (current != null) {
                if (prev != null && prev >= current.val) return false;
                prev = current.val;
                current = current.right;
            }
        }
        return true;
    }
}
