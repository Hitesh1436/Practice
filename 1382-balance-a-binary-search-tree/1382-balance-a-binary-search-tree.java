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
    List<Integer> al = new ArrayList<>();
    private void inOrder(TreeNode node){
        // BST of inorder is always sorted
        if(node == null) return;
        inOrder(node.left);
        al.add(node.val);
        inOrder(node.right);
        return;
    }
    private TreeNode createBST(int min,int max){
//postorder, bottom up approach is used because we want to know the child first then the parent       
        if(min > max) return null;
        int mid = min + (max-min)/2;
        int val = al.get(mid);
        
        TreeNode left = createBST(min,mid-1);
        TreeNode right = createBST(mid+1,max);
        
        TreeNode ans = new TreeNode(val,left,right);
        return ans;
    }
    
    public TreeNode balanceBST(TreeNode root) {
        TreeNode  newRoot = null;
        if(root == null) return newRoot;
        inOrder(root);
        newRoot = createBST(0,al.size()-1);
        return newRoot;
    }
}