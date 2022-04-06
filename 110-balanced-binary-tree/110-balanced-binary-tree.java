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
    
    class pair{
        int h;
        boolean isBal;
    }
    
    public pair isBal(TreeNode node){
        if(node == null){
            pair base = new pair();
            base.h = 0;
            base.isBal = true;
            return base;
        }
        pair left  = isBal(node.left);
        pair right = isBal(node.right);
        
        pair my = new pair();
        my.isBal = left.isBal && right.isBal && Math.abs(left.h-right.h)<=1;
        
        my.h = Math.max(left.h,right.h)+1;
        return my;
    }
    
    public boolean isBalanced(TreeNode root) {
        pair ans = isBal(root);
        return ans.isBal;
    }
}