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
    public TreeNode helper(int[] preorder,int psi,int pei, int[] inorder,int isi,int iei) {
        if(isi>iei){
            return null;
        }
        int idx = isi;
        while(inorder[idx]!=preorder[psi])
            idx++;
            // tnol-> tonal no. of elements
            int tnol = idx - isi;   // left subtree mn itne honge
            
            TreeNode ans = new TreeNode(preorder[psi]);
            
            ans.left = helper(preorder,psi+1,psi+tnol,inorder,isi,idx-1);
            ans.right= helper(preorder,psi+tnol+1,pei,inorder,idx+1,iei);
        return ans;
        
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        return helper(preorder,0,n-1,inorder,0,n-1);
    }
}