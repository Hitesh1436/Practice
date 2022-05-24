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
    public int deepestLeavesSum(TreeNode root) {
         int sum =0;
        Queue<TreeNode> qu = new LinkedList<>();
        qu.add(root);
        
        while(qu.size()>0){
            int size = qu.size();
            sum =0;
            for(int i=0;i<size;i++){
                TreeNode rem = qu.remove();
                sum += rem.val;
                if(rem.left != null) qu.add(rem.left);
                if(rem.right != null) qu.add(rem.right);
            }
        }
        return sum;
    }
}