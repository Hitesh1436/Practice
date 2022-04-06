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
    
    boolean isBal = true;
    
    public int isBTBal(TreeNode node){
        if(node == null){
            return 0;
        }
        int lH = isBTBal(node.left);
        int rH = isBTBal(node.right);
        
        isBal = isBal && Math.abs(lH-rH)<=1;
        return Math.max(lH,rH)+1;
        
    }
    public boolean isBalanced(TreeNode root) {
        isBTBal(root);
        return isBal;
    }
}