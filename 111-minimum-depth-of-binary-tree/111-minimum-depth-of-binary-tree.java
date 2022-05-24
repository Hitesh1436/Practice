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
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> qu = new LinkedList<>();
        qu.add(root);
        
        int count = 0;
        while (qu.size()>0) {
            int n = qu.size();
            count++;
            
            for (int i = 0; i < n; i++) {
                TreeNode rem = qu.remove();
                if (rem.left == null && rem.right == null)
                    return count;
                if (rem.left != null) 
                    qu.add(rem.left);
                if (rem.right != null) 
                    qu.add(rem.right);
            }
        }
        
        return count;
    }
}