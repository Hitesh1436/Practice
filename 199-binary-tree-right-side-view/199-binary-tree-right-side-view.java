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
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> qu = new ArrayDeque<>();
        if(root!=null){
            qu.add(root);
        }
        List<Integer> ans = new ArrayList<>();
        while(qu.size()>0){
            int size = qu.size();
            int i = 1,s = size;
            while(size-->0){
                TreeNode rem = qu.remove();
                if(i==s){
                    ans.add(rem.val);
                } 
                i++;
                if(rem.left!=null){
                    qu.add(rem.left);
                }
                if(rem.right!=null){
                    qu.add(rem.right);
                }
            }
        }
        return ans;
    }
}