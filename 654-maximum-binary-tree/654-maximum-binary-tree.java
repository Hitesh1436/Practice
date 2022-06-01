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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 0) return null;
        int index = maxIndex(nums);
        TreeNode node = new TreeNode(nums[index]);
        node.left = constructMaximumBinaryTree(Arrays.copyOfRange(nums, 0, index)); // pass the the left subarray of nums and pass it to the left node
        node.right = constructMaximumBinaryTree(Arrays.copyOfRange(nums, index + 1, nums.length)); //split the other subarray of nums and pass it to the right right to the node
        return node;

    }
//search for the max of the index
    public int maxIndex(int[] nums) {
        int max = Integer.MIN_VALUE;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }
        return index;

    }
}