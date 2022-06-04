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
    private int helper(TreeNode root)
    {
        if(root==null)
            return 0;
        int left=helper(root.left);
        int right=helper(root.right);
        int excessOrDeficit=(left+right+root.val)-1;
        ans+=Math.abs(excessOrDeficit);
        return excessOrDeficit;
    }
    int ans=0;
    public int distributeCoins(TreeNode root) {
        ans=0;
        helper(root);
        return ans;
    }
}