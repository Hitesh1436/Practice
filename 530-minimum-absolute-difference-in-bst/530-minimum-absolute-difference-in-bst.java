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
    
    public void inOrder(TreeNode node ,List<Integer> list){
        if(node == null)
            return;
        inOrder(node.left,list);
        list.add(node.val);
         inOrder(node.right,list);
    }
    
    public int getMinimumDifference(TreeNode root) {
        List<Integer> al = new ArrayList<>();
        inOrder(root,al);
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<al.size()-1;i++){
            ans = Math.min(ans,al.get(i+1)-al.get(i));
        }
        return ans;
    }
}