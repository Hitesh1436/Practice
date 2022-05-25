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
    int count =0;
    public int pathSum(TreeNode root, int tar) {
        if(root == null) return 0;
        
        helper(root,tar,0);
        pathSum(root.left,tar);
        pathSum(root.right,tar);
        
        return count;
    }
    
    public void helper(TreeNode node,int tar,int currSum){
        if(node == null) return;
        currSum +=node.val;
        if(currSum == tar){
            count++;
        }
        helper(node.left,tar,currSum);
        helper(node.right,tar,currSum);
    }
}