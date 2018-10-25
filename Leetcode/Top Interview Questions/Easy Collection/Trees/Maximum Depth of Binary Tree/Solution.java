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
      Simple BFS search counting depth
      O(n) - runtime and O(n) - space  complexities
    **/
    public int maxDepth(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        int depth = 0;
        while(!q.isEmpty() && q.peek() != null) {
            TreeNode current;
            while((current = q.poll()) != null) {
                if (current.left != null) q.offer(current.left);
                if (current.right != null) q.offer(current.right);
            }
            depth++;
            q.offer(null);
        }
        return depth;
    }
}
