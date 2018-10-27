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
        O(n) rumtime and space complexity
    **/
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        q.offer(null);
        List<List<Integer>> result = new ArrayList<>();
        while(!q.isEmpty() && q.peek() != null) {
            TreeNode current;
            List<Integer> subResult = new ArrayList<>();
            while((current = q.poll()) != null) {
                subResult.add(current.val);
                if (current.left != null) q.offer(current.left);
                if (current.right != null) q.offer(current.right);
            }
            q.offer(null);
            result.add(subResult);
        }
        return result;
    }
}
