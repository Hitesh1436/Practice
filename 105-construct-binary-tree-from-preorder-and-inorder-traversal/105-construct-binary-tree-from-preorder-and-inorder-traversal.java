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
    
    public  TreeNode helperTree(int[] preorder,int psi,int pei, int[] inorder,int isi,int iei){
        if(isi>iei){
            return null;
        }
        int idx = isi;   
        while(inorder[idx]!=preorder[psi]) // mtlb inorder mn travel kro tbtk jbtk preorder ke 
                                            //psi ki value inorder ke idx ki value ke equal ni hoti
            idx++;
            int colse = idx-isi;  // count of  left subtree elements 
            // jis idx pr same value aai usse phle vale elements left Subtree ka part honge and baki right subtree ka
            
            TreeNode node = new TreeNode(preorder[psi]);
            
            node.left = helperTree(preorder,psi+1,psi+colse,inorder,isi,idx-1);
            node.right = helperTree(preorder,psi+colse+1,pei,inorder,idx+1,iei);
             return node;
        
       
    }

    public  TreeNode buildTree(int[] preorder, int[] inorder){
        int n = preorder.length;   // ya inorder.length krlo bcz dono same hongi
        return helperTree(preorder,0,n-1,inorder,0,n-1);
    }
}