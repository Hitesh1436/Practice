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
    public List<TreeNode> allPossibleFBT(int n) {
        List<TreeNode> ans = new ArrayList<>();
        if(n == 0 || n % 2 == 0){
            return ans;
        }
        if(n == 1){
            ans.add(new TreeNode(0));
            return ans;
        }
        for(int i=1;i<n;i+=2){
            // left ke liye call
            List<TreeNode> left = allPossibleFBT(i);
            // right ke bche hue ke liye call
             List<TreeNode> right = allPossibleFBT(n-i-1);
            
            for(TreeNode lt : left){
                for(TreeNode rt : right){
                    TreeNode node = new TreeNode(0);
                        node.left = lt;
                    node.right = rt;
                    ans.add(node);
                }
            }
        }
        return ans;
    }
}