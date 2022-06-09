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
    int total =0;
    public int sumNumbers(TreeNode root) {
        total =0;
        helper(root,0);
        return total;
    }
    private void helper(TreeNode node,int sum){
        if(node == null) return;
        
        sum = sum * 10 + node.val;
        if(node.left == null && node.right == null){
            total = total + sum;
            return;
        }
        helper(node.left,sum);
        helper(node.right,sum);
    }
}