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
    int count = 0;
    public int pathSum(TreeNode root, int sum) {

        if (root == null) return 0;

        pathSumHelper(root, sum, 0);
        pathSum(root.left, sum);
        pathSum(root.right, sum);

        return count;

    }

    void pathSumHelper(TreeNode root, int sum, int currentSum) {
        if (root == null) {
            return;
        }
        currentSum += root.val;
        if (currentSum == sum) {
            count++;
        }
        pathSumHelper(root.left, sum, currentSum);
        pathSumHelper(root.right, sum, currentSum);
    } 
}