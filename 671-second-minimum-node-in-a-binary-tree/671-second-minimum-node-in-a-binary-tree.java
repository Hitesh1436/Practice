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
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    
    public int findSecondMinimumValue(TreeNode root) {
       inOrder(root);
        if(pq.size()<=1){
            return -1;
        }else{
            pq.remove();
            return pq.remove();
        }
    }
    
    private void inOrder(TreeNode node){
        if(node == null) return;
        
        inOrder(node.left);
        
        if(!pq.contains(node.val)){
            pq.add(node.val);
        }
        inOrder(node.right);
    }
}