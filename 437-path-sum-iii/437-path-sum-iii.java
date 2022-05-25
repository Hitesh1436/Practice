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
    HashMap<Integer,Integer> map;
    int tar;
    public int pathSum(TreeNode root, int targetSum) {
        map = new HashMap<>();
        map.put(0,1);
        tar = targetSum;
        return helper(root,0);
    }
    
    private int helper(TreeNode node,int preSum){
        if(node == null) return 0;
        
        int count =0;
        preSum += node.val;
        count +=map.getOrDefault(preSum - tar, 0);
        map.put(preSum,map.getOrDefault(preSum,0)+1);
        count += helper(node.left,preSum);
        count += helper(node.right,preSum);
        map.put(preSum,map.get(preSum)-1);
        
        return count;
    }
}