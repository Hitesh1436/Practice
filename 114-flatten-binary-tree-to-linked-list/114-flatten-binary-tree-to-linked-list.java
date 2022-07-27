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
    TreeNode prev = null;
    void rec(TreeNode root){
        if(root.right!=null) rec(root.right);
        if(root.left!=null) rec(root.left);
        root.right=prev;
        prev=root;
        root.left=null;
    }
    public void flatten(TreeNode root) {
        if(root==null) return ;
        rec(root);
    }
}