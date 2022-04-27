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
    
    public void inOrder(TreeNode root, ArrayList<Integer>al){
        if(root == null){
            return;
        }
        inOrder(root.left,al);
        al.add(root.val);
        inOrder(root.right,al);
    }
    
    public TreeNode buildTree(ArrayList<Integer>al){
        if(al.size()==0){
            return null;
        }
        TreeNode root = new TreeNode(al.remove(0));
        root.right= buildTree(al);
        return root;
    }
    
    public TreeNode increasingBST(TreeNode root) {
        ArrayList<Integer> al = new ArrayList<>();
        inOrder(root,al);
        return buildTree(al);
    }
}