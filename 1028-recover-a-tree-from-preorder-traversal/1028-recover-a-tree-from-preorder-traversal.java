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
    int i=0;
    public TreeNode recoverFromPreorder(String traversal) {
        return helper(traversal,0);
    }
    private TreeNode helper(String str,int depth){
        int d=0;   // d -> dashes 
        while(i+d<str.length() && str.charAt(i+d)== '-'){
            d++;
        }
        if(d != depth){
            return null;
        }
        //  nd -> non-dashes
        int nd =0;
        while(i+d+nd < str.length()&& str.charAt(i+d+nd)!='-'){
            nd++;
        }
        int val = Integer.parseInt(str.substring(i+d,i+d+nd));  // node ki value bnai h 
        i = i+d+nd;  // bnne ke baad i ko next node bnne ke liye move krwa dia
        
        
        TreeNode node = new TreeNode(val);
        node.left = helper(str,depth+1);
        node.right = helper(str,depth+1);
        
        return node;
    }
}