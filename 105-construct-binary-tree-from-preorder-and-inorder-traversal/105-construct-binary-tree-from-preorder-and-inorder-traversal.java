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


// psi = pre start index,pei= pre end index,isi = in statr index, iei = in end index
class Solution {
    public TreeNode helper(int[] preorder,int pstart,int pend, int[] inorder,int istart,int iend) {
        if(istart>iend){
            return null;
        }
        int idx = istart;
        while(inorder[idx]!=preorder[pstart])
            idx++;
            // tnol-> tonal no. of elements
            int tnol = idx - istart;   // left subtree mn itne honge
            
            TreeNode ans = new TreeNode(preorder[pstart]);
            
            ans.left = helper(preorder,pstart+1,pstart+tnol,inorder,istart,idx-1);
            ans.right= helper(preorder,pstart+tnol+1,pend,inorder,idx+1,iend);
        return ans;
        
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        return helper(preorder,0,n-1,inorder,0,n-1);
    }
}