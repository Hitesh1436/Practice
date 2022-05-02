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
    //{withRobbery Maximum Amount , withoutRobbery Maximum Amount} 
    public int[] helper(TreeNode root){
        if(root == null){
            return new int[2];
        }
        int []left  = helper(root.left);
        int []right = helper(root.right);
        
        int [] myAns = new int[2];
        
        myAns[0] = left[1] + right[1] + root.val;
        myAns[1] = Math.max(left[0],left[1])+ Math.max(right[0],right[1]);
        
        return myAns;
        
    }
    
    public int rob(TreeNode root) {
        int [] ans = helper(root);
        return Math.max(ans[0],ans[1]);
    }
}