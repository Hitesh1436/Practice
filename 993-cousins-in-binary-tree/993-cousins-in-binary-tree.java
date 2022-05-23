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
    TreeNode xParent = null, yParent = null;
    int xDepth = 0, yDepth =0;
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null){
            return false;
        }
        helper(root,x,y,0,null);
        return xParent != yParent && xDepth == yDepth;
    }
    public void helper(TreeNode root,int x,int y,int depth,TreeNode parent){
        if(root == null){
            return;
        }
        if(root.val == x){
            xParent = parent;
            xDepth = depth;
        }
        if(root.val == y){
            yParent = parent;
            yDepth = depth;
        }
        helper(root.left,x,y,depth+1,root);
        helper(root.right,x,y,depth+1,root);
    }
}