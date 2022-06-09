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
    int sum =0;
    public int sumNumbers(TreeNode root) {
        sum =0;
        helper(root,new StringBuilder());
        return sum;
    }
    private void helper(TreeNode node,StringBuilder sb){
        if(node == null) return;
        
        sb.append(node.val);
        helper(node.left,sb);
        helper(node.right,sb);
        
        if(node.left == null && node.right == null){
           int num = Integer.parseInt(sb.toString());
            sum += num;
        }
        sb.deleteCharAt(sb.length()-1);
    }
}