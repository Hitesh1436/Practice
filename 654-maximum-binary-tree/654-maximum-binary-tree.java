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
            int n = nums.length;
        if(n==0) return null;
        int index = maxIndex(nums);
        TreeNode ans = new TreeNode(nums[index]);
        // pass the the left subarray of nums and pass it to the left node
        ans.left = constructMaximumBinaryTree(Arrays.copyOfRange(nums,0,index));
        //split the other subarray of nums and pass it to the right right to the node
        ans.right = constructMaximumBinaryTree(Arrays.copyOfRange(nums,index+1,nums.length));
        return ans;
    }
    //searching for the max of the index
    private int maxIndex(int []arr){
        int max = Integer.MIN_VALUE;
        int idx = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>max){
                max = arr[i];
                idx = i;
            }
        }
        return idx;
    }
}