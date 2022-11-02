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
    public int kthSmallest(TreeNode root, int k) {
        // using Morris Traversal
        TreeNode curr = root;
        int count =0;
        while(curr != null){
            if(curr.left == null){
                count++;
                if(count == k){
                    return curr.val;
                }
                curr = curr.right;
            }else{
                // iop - inOrder predecessor
                TreeNode iop = curr.left;
                while(iop.right != null && iop.right != curr){
                    iop = iop.right;
                }
                if(iop.right == null){  // thread bnai
                    iop.right = curr;
                    curr = curr.left;
                }else{
                    iop.right = null;  // thread todii hai
                    count++;
                    if(count == k){
                         return curr.val;
                    }
                    curr = curr.right;
                }
            }
        }
        return -1;
    }
}