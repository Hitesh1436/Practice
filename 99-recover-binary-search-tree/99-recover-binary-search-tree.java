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
    TreeNode prev = null, first = null, end = null;
    public void recoverTree(TreeNode root) {
        helper(root);
        int temp = first.val;
        first.val = end.val;
        end.val = temp;
    }
    private void helper(TreeNode root) {
        if (root == null)
            return;
        helper(root.left);
        if (prev != null && prev.val > root.val) {
            if (first == null)
                first = prev;
            end = root;
        }
        prev = root;
        helper(root.right);
    }
}