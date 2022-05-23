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
    public boolean isCousins(TreeNode root, int x, int y) {
        //depth of x and y should be same and they should have different parents
       
       List<Integer> alx =  findans(root,x);
       List<Integer> aly =  findans(root,y);
        if(alx.size() == aly.size() && alx.get(1) != aly.get(1)) return true;
        return false;
    }
    
    private List<Integer> findans(TreeNode root,int tar){
       if(root == null) return new ArrayList<>();
       if(root.val == tar){
           List<Integer> ans = new ArrayList<>();
           ans.add(root.val);
           return ans;
       }
        List<Integer> left = findans(root.left,tar);
        if(left.size() > 0){
            left.add(root.val);
            return left;
        }
        List<Integer> right = findans(root.right,tar);
        if(right.size() > 0){
            right.add(root.val);
            return right;
        }
       return new ArrayList<>();  
    }
}