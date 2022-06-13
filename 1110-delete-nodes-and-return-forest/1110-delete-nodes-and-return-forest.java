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

//1. When and from where to remove the node?? I knew that if I have to delete any node I have to assign it to null. But how could I do that the same time I am checking if the node has to be deleted or not. We can't do that. What we have to do is to get to know if the leftNode/rightNode is deleted or not. If yes then assign the current node's left/right node to null.
//2. When to add the node?? We have to add the node only when the current node is going to be deleted. So if the left node is not deleted add it to the list. Same is the scenario for right node.
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