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
   public TreeNode balanceBST(TreeNode root) {
    List<TreeNode> list=new ArrayList<>();
    inorder(root,list);
    return buildTree(list,0,list.size()-1);     
}
public TreeNode buildTree(List<TreeNode> list,int start,int end){ 
    if(start>end){
        return null;
    }
    int mid=start+(end-start)/2;
    TreeNode root=list.get(mid);
    root.left=buildTree(list,start,mid-1);
    root.right=buildTree(list,mid+1,end); 
    return root;
}
public void inorder(TreeNode root,List<TreeNode> list){
    if(root==null){
        return;
    }
    inorder(root.left,list);
    list.add(root);
    inorder(root.right,list);
  }
}