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
    public int maxAncestorDiff(TreeNode root) {
        return helper(root,root.val,root.val);
    }
    private int helper(TreeNode node,int min,int max){
        if(node == null) return max - min;
        
        if(node.val < min) min = node.val;
        if(node.val > max) max = node.val;
        
        int left  = helper(node.left,min,max);
        int right = helper(node.right,min,max);
        return Math.max(left,right);
    }
}