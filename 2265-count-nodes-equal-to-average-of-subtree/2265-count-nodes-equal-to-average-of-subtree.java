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
    class Pair{
        int sum,count;
        Pair(int _sum,int _count){
            sum=_sum;
            count=_count;
        }
    }
    int ans=0;
    public Pair averageHelper(TreeNode root)
    {
        if(root==null)
            return new Pair(0,0);
        
        Pair l=averageHelper(root.left);
        Pair r=averageHelper(root.right);
        
        int avg=(int)((l.sum+r.sum+root.val)/(l.count+r.count+1));
        
        if(avg==root.val)
            ans+=1;
        return new Pair(l.sum+r.sum+root.val,l.count+r.count+1);
        
    }
    public int averageOfSubtree(TreeNode root) {
        Pair x=averageHelper(root);
        return ans;
    }
}