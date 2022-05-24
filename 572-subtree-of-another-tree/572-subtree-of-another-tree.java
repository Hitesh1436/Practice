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
    
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
		// in case of bad input
        if (root == null) return false;
		
        // if root vals are equal, then make sure rest of subtree is equal
        if (root.val == subRoot.val && helper(root, subRoot)) return true;
        
		// there can still be duplicate vals in the tree, so we need to keep
		// checking deeper for top root val then dive into the equals method
		// if we find it
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
    
    private boolean helper(TreeNode root, TreeNode subRoot) {
		// base case, both nodes are null return true
        if (root == null && subRoot == null) return true;
		// now if one node is null, trees are not equal, also check for root val equivalence
        if (root == null || subRoot == null || root.val != subRoot.val) return false;

		// check entire depth of both subtrees
        return helper(root.left, subRoot.left) && helper(root.right, subRoot.right);
    }
}