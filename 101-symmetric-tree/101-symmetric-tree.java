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
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        Stack<TreeNode> ls = new Stack<>();
        Stack<TreeNode> rs = new Stack<>();
        ls.push(root.left); rs.push(root.right);
        
        while(ls.size()>0 && rs.size()>0){
            TreeNode rem1 = ls.pop();
            TreeNode rem2 = rs.pop();
            if(rem1 == null && rem2 == null) continue;
            if(rem1==null || rem2 == null) return false;
            if(rem1.val != rem2.val) return false;
            ls.push(rem1.right);
            ls.push(rem1.left);
            rs.push(rem2.left);
            rs.push(rem2.right);
        }
        return ls.size()==0 && rs.size()==0;
    }
}