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
    TreeNode newRoot  = null;
    TreeNode previous = null;
    public TreeNode increasingBST(TreeNode root) {
        if(root == null){
            return null;
        }
        increasingBST(root.left);
        if(newRoot==null){
            newRoot = root;
            previous = root;
        }else if(previous != null){
            previous.right = new TreeNode(root.val);
            previous = previous.right;
        }
        increasingBST(root.right);
        return newRoot;
    }
}