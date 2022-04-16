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
    int cache = 0;
    private void preOrderReversed(TreeNode root){
        if(root == null)
            return;
        
        preOrderReversed(root.right);
        cache = root.val + cache;
        root.val = cache;
        preOrderReversed(root.left);
        
    }
    public TreeNode bstToGst(TreeNode root) {
        preOrderReversed(root);
        return root;
    }
}