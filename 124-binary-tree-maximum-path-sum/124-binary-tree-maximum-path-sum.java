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
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        maxPathSumHelper(root);
        return maxSum;
    }
    
    public int maxPathSumHelper(TreeNode node){
        if(node == null){
            return 0;
        }
        
        int left = maxPathSumHelper(node.left);
        int right = maxPathSumHelper(node.right);
        
        int left_dash = Math.max(0,left);
        int right_dash = Math.max(0,right);
        
        int sumFromLeftToRight = left_dash + node.val + right_dash;
        if(sumFromLeftToRight>maxSum){
            maxSum = sumFromLeftToRight;
        }
        return Math.max(left_dash,right_dash) + node.val;
    }
}