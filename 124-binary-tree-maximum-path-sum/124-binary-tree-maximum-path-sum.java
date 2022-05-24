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
    int result = Integer.MIN_VALUE;
    
public int maxSum(TreeNode root) {
	if( root == null )
		return 0;
	int leftMax = Math.max(0, maxSum(root.left));
	int rightMax = Math.max(0, maxSum(root.right));
	result = Math.max(result, root.val + leftMax + rightMax);
	return root.val + Math.max(leftMax, rightMax);
}

public int maxPathSum(TreeNode root) {
	if( root == null )
		return 0;
	else {
		maxSum(root);
		return result;
	}
}
 }