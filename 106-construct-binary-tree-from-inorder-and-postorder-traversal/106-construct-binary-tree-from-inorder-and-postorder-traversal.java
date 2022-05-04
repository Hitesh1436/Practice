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
    
     public  TreeNode buildTreeHelper( int[] postorder,int posi,int poei,int[] inorder,int isi,int iei){
        if(isi>iei){
            return null;
        }
        int idx = isi;
        while(inorder[idx]!=postorder[poei])
        idx++;
        
        int tnol = idx-isi;
        TreeNode ans = new TreeNode(postorder[poei]);
        
        ans.left = buildTreeHelper(postorder,posi,posi+tnol-1,inorder,isi,idx-1);
        ans.right = buildTreeHelper(postorder,posi+tnol,poei-1,inorder,idx+1,iei);
        
        return ans;
    }

    public  TreeNode buildTree(int[] inorder, int[] postorder){
        int n = postorder.length;
        return buildTreeHelper(postorder,0,n-1,inorder,0,n-1);
    }
}