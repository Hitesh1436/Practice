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
    Queue<TreeNode> qu = new LinkedList<>();
    public void flatten(TreeNode root) {
        if(root == null) return;
        preorder(root);
        qu.remove();
        TreeNode tmp = root;
        while(!qu.isEmpty()){
            tmp.right = qu.remove();
            tmp.left = null;
            tmp = tmp.right;
        } 
    }
    private void preorder(TreeNode node){
        if(node == null)return;
        qu.add(node);
        preorder(node.left);
        preorder(node.right);
    }
}