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
    public List<List<Integer>> levelOrder(TreeNode root){
       Queue<TreeNode> qu = new LinkedList<>();
        qu.add(root);
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;       
        while(!qu.isEmpty()){
            int size = qu.size();
            List<Integer> subAns = new ArrayList<>();
            while(size!=0){
                TreeNode rem = qu.remove();
                    subAns.add(rem.val);
                if(rem.left != null){
                    qu.add(rem.left);
                }
                if(rem.right != null){
                    qu.add(rem.right);
                }
                size--;
            }
            ans.add(subAns);
        } 
        return ans;
    }
}