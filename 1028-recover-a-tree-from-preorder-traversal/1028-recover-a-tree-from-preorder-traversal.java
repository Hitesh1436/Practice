/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode recoverFromPreorder(String traversal) {
        if (traversal == null || traversal.isEmpty()) return null;
        final int L = traversal.length();
        TreeNode root = null;
        Deque<TreeNode> stack = new ArrayDeque<>();
        int idx = 0;
        while (idx < L) {
            int depth = 0;
            while (idx < L && traversal.charAt(idx) == '-') {
                idx++;
                depth++;
            }
            int val = 0;
            while (idx < L && traversal.charAt(idx) != '-') {
                val = traversal.charAt(idx) - '0' + val * 10;
                idx++;
            }
            while (stack.size() > depth) { // Pop the nodes at same level or below.
                stack.pop();
            }
            TreeNode node = new TreeNode(val);
            if (!stack.isEmpty()) {
                TreeNode parent = stack.peek();
                if (parent.left == null) {
                    parent.left = node;
                } else {
                    parent.right = node;
                }
            }
            stack.push(node);
            if (root == null) root = node;
        }
        return root;
    }
}