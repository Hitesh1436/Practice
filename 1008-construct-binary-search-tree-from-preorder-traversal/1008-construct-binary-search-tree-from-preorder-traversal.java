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
    int index =0;
    public TreeNode bstFromPreorder(int[] preorder) {
        return construct(preorder,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    private TreeNode construct(int []pre , int min,int max){
        if(index == pre.length){
            return null;
        }else if(pre[index]>min && pre[index]<max){
            TreeNode ans = new TreeNode(pre[index]);
            index++;
            
            ans.left = construct(pre,min,ans.val);
            ans.right = construct(pre,ans.val,max);
            
            return ans;
        }else{
            return null;
        }
    }
}