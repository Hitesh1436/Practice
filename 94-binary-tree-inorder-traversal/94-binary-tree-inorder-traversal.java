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
    
    public  TreeNode getRightMostNode(TreeNode leftNode,TreeNode curr){
      while(leftNode.right!=null && leftNode.right!=curr){
          leftNode = leftNode.right;
      }
      return leftNode;
  }
    public List<Integer> inorderTraversal(TreeNode root) {
     ArrayList<Integer> ans = new ArrayList<>();
    TreeNode curr = root;
    
    while(curr!=null){
        TreeNode leftNode = curr.left;
        if(leftNode == null){
            ans.add(curr.val);
            curr = curr.right;
        }else{
            TreeNode rightMostNode = getRightMostNode(leftNode,curr);
            if(rightMostNode.right == null){  // thread create
                rightMostNode.right = curr;
                curr = curr.left;
            }else{
                rightMostNode.right = null;
                ans.add(curr.val);
                curr = curr.right;
            }
        }
    }
    return ans;
 }
}