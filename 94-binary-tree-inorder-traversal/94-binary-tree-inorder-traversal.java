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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        
        TreeNode curr = root;
        
        while(curr != null){
            if(curr.left== null){
                ans.add(curr.val);
                curr = curr.right;
            }else{
                // iop -> inOrder predecessor i.e hmre left ka rightMost node
                TreeNode iop = curr.left;
                while(iop.right!= null  && iop.right != curr){
                    iop = iop.right;
                }
                if(iop.right == null){   
                    iop.right = curr;    // making of thread
                    curr = curr.left;
                }else{
                    iop.right = null;    // breaking of thread
                        ans.add(curr.val);
                    curr = curr.right;
                }
            }
        }
        return ans;
    }
}