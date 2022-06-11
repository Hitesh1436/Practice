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
    int good =0;
    public int goodNodes(TreeNode root) {
        good = 0;
        helper(root,Integer.MIN_VALUE);
        return good;
    }
    private void helper(TreeNode node,int max){
        if(node == null) return;
        if(node.val >= max) {
            good++;
            max = Math.max(max,node.val);
        }
        helper(node.left,max);
        helper(node.right,max);
    }
}