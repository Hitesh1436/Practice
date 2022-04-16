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
    private void travel(TreeNode node){
        if(node == null){
            return;
        }
        travel(node.right);
        sum = sum + node.val;
        node.val = sum;
        travel(node.left);
    }
    
    public TreeNode convertBST(TreeNode root) {
        travel(root);
        return root;
    }
}