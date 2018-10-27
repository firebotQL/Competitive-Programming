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
        Recursive solution of checking if its
        a mirror of itself
        O(n) - runtime and space complexities
    **/
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return nodeEquals(root.left, root.right);
    }

    public static boolean nodeEquals(TreeNode left, TreeNode right) {
        if (left == null || right == null) return left == null && right == null;
        return left.val == right.val
            && nodeEquals(left.left, right.right)
            && nodeEquals(left.right, right.left);
    }
        /**
        Simple BFS solution
        O(n) runtime and space complexity
    **/

    /**public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        q.offer(null);
        List<TreeNode> list = new ArrayList<>();
        while(!q.isEmpty() && q.peek() != null) {
            TreeNode current;
            while((current = q.poll()) != null) {
                list.add(current.left);
                list.add(current.right);
                if (current.left != null) q.offer(current.left);
                if (current.right != null) q.offer(current.right);
            }
            q.offer(null);
            for(int i = 0; i < list.size()/2; i++) {
                TreeNode left = list.get(i);
                TreeNode right = list.get(list.size() - 1 - i);
                if (left == null && right != null) return false;
                if (left != null && right == null) return false;
                if (left != null && right != null && left.val != right.val) return false;
            }
            list.clear();
        }
        return true;
    }**/
}
