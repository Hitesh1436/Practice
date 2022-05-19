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
    
    public void helper(TreeNode node,StringBuilder res){
        if(node == null){
          return;  
        }   
        res.append(node.val);
        if(node.left != null){
            res.append("(");
            helper(node.left,res);
            res.append(")");
        }
        if(node.right != null){
            if(node.left == null){
                res.append("()");
            }
            res.append("(");
           helper(node.right,res);
            res.append(")");
        }
    }
    
    public String tree2str(TreeNode root) {
        StringBuilder ans = new StringBuilder();
        helper(root,ans);
        return ans.toString();
    }
}