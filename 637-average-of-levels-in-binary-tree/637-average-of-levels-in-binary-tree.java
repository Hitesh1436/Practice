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

    public List<Double> averageOfLevels(TreeNode root)  {
        List<Double> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        LinkedList<TreeNode> qu = new LinkedList<>();
        qu.addLast(root);
        while(qu.size()>0){
                int size=qu.size();double sum=0.0;int count=0;
            while(size-->0) { 
                TreeNode rem = qu.removeFirst();
                sum += rem.val;
                count++;
                if (rem.left != null){
                    qu.add(rem.left);
                } 
                if (rem.right != null){
                    qu.add(rem.right);  
                }    
            }
            ans.add((double)(sum/count));
        }
        return ans;
    }
}