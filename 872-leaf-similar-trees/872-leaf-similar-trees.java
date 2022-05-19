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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) return false;
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        helper(sb1, root1);
        helper(sb2, root2);
        return sb1.toString().equals(sb2.toString());
    }
    
    private void helper(StringBuilder sb, TreeNode root) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            sb.append(root.val);
            sb.append('-');
        } 
        helper(sb, root.left);
        helper(sb, root.right);
    }
}