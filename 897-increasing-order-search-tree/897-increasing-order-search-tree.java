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
    TreeNode prev=null;
    public TreeNode increasingBST(TreeNode root) {
        if(root==null)return root;
        
        increasingBST(root.right);
        root.right=prev;
        prev=root;
        increasingBST(root.left);
        root.left=null;
        return prev;
    }
}