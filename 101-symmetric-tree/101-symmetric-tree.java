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
  if (root == null) { // required
    return true;
  }
  return isMirror(root.left, root.right); // so t1 and t2 are different trees
  }
    private boolean isMirror(TreeNode t1, TreeNode t2) {
  // base case
  if (t1 == null && t2 == null) return true;
  if (t1 == null || t2 == null) return false;
  // check values
  if (t1.val != t2.val) return false;
  // check left subtree and right subtree
  return isMirror(t1.right, t2.left) && isMirror(t1.left, t2.right);
}
}