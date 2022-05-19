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
class Solution 
{//Revise left and right shift operator from GFG (recommended)
    public int sumRootToLeaf(TreeNode root)
    {
        if(root == null)//base case for null graph 
            return 0;
        
        return sum(root, 0);//sum is passed because it has a cyclic dependency  in Recursion for calculating the sum 
    }
    public int sum(TreeNode root, int sum)
    {
        if(root == null)//base case 1//we we reach an null node we return 0, no shifting operation is done 
            return 0;
        
        sum= (sum<<1) + root.val;//in binary addition 0 + 1= 1 && 0 + 0= 0, so only the last place will change by 0 or 1//doing left shift will append zero at the end 
        
        if(root.left == null && root.right == null)//base case 2
            return sum;//when we got the desired result(Binary Number in integer) at the leaf node returning it to get the total sum and the traverse if any subtree is left 
        return sum(root.left, sum) + sum(root.right, sum);//calculating the left and right sum recursively //bactracking helps a lot in leaf node sum 
    }
}