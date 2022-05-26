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
    public int pathSum(TreeNode root, int sum) {
        HashMap<Integer, Integer> map = new HashMap();
        map.put(0,1);
        int ans = helper(root, 0, sum, map);
        return ans;
    }
    
    public int helper(TreeNode root, int psum, int target, HashMap<Integer, Integer> map) {
        
        if (root == null) {
            return 0;
        }
        
        psum += root.val;
        int res = map.getOrDefault(psum - target, 0);
        map.put(psum, map.getOrDefault(psum, 0) + 1);
        
        int left = helper(root.left, psum, target, map);
        int right =  helper(root.right, psum, target, map);
        
        res += left + right;
        
        map.put(psum, map.get(psum) - 1);
        return res;
    }
}