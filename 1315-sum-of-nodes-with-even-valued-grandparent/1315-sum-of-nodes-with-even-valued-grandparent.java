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
    int ans =0;
    public int sumEvenGrandparent(TreeNode root) {
        traverse(root,null,null);
            return ans;
    }
     public void traverse(TreeNode node, TreeNode parent, TreeNode grand){       
        if( node == null )  return  ;
        if( grand != null &&  grand.val % 2 == 0 ){
            ans += node.val ;
        }
        traverse(node.left,node,parent);
        traverse(node.right,node,parent);
    }
}