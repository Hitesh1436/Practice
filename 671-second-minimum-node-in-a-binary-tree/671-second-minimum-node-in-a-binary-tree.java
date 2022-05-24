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
    public int findSecondMinimumValue(TreeNode root) {
         HashSet<Integer> list=new HashSet<>();
          helper(root,list);
           List<Integer> al = new ArrayList<>(list);
        Collections.sort(al);

          if(list.size()<2){
              return -1;
          }
        return al.get(1);
    }
    
    private void helper(TreeNode root,HashSet list){
        if(root==null){
            return;
        }
        helper(root.left,list);
        list.add(root.val);
        
        helper(root.right,list);
        list.add(root.val);
    }
}