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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> ans = new ArrayList<>();
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        inorder(root1,a);
        inorder(root2,b);
        System.out.print(a);
        System.out.print(b);
        mergeLists(a,b,ans);
        return ans; 
    }
    // O(n)
    private void inorder(TreeNode node,List<Integer>al){
        if(node == null) return;
        inorder(node.left,al);
        al.add(node.val);
        inorder(node.right,al);
    }
    // O(m+n)
    private void mergeLists(List<Integer>l1,List<Integer>l2,List<Integer>res){
        int n = l1.size(),m=l2.size();
        int i=0,j=0;
        while(i<n && j<m){
            if(l1.get(i)<=l2.get(j)){
                res.add(l1.get(i++));
            }else{
                res.add(l2.get(j++));    
            }
         
        }
         while(i<n){
                res.add(l1.get(i++));
            }
            while(j<m){
                res.add(l2.get(j++));
    }
    }
}