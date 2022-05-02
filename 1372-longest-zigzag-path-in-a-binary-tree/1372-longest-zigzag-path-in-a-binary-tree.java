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
    
    int maxLen=0;
    //[0,1]  -> {forwardSlope,backwardSlope}
    
    public int [] helper(TreeNode root){
        if(root == null){
            return new int[]{-1,-1};
        }
        int [] left = helper(root.left);
        int []right = helper(root.right);
        
        maxLen = Math.max(maxLen,Math.max(left[1],right[0])+1);
        return new int[]{left[1]+1,right[0]+1};
    }
        
    public int longestZigZag(TreeNode root) {
        helper(root);
        return maxLen;
    }
}