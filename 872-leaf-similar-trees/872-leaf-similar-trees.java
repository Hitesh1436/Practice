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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if(root1==null && root2==null) return true;
        if(root1==null || root2==null) return false;
        
        ArrayList<Integer> l1=getVal(root1, new ArrayList<>());
        ArrayList<Integer> l2=getVal(root2, new ArrayList<>());
        
        return l1.equals(l2);
    }
    
    public ArrayList<Integer> getVal(TreeNode root, ArrayList<Integer> temp){
        if(root==null) return null;
        
        getVal(root.left,temp);
        if(root.left==null && root.right==null) temp.add(root.val);
        getVal(root.right,temp);
        
        return temp;
    }
}