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
    List<TreeNode> ans = new ArrayList<>();
    HashSet<Integer> set = new HashSet<>();
    public List<TreeNode> delNodes(TreeNode root, int[] delete) {
        for(int i=0;i<delete.length;i++){
            int val = delete[i];
            set.add(val);
        }
        helper(root);
        if(!set.contains(root.val)){
            ans.add(root);
        }
        return ans;
    }
    private TreeNode helper(TreeNode node){
        if(node == null) return null;
        
        node.left = helper(node.left);
        node.right = helper(node.right);
        
        if(set.contains(node.val)){
            if(node.left != null){
                ans.add(node.left);
            }
            if(node.right != null){
                ans.add(node.right);
            }
            return null;
        }
        return node;
    }
    
}