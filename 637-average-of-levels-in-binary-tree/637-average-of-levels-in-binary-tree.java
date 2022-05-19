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
                int size=qu.size();double sm=0.0;int cnt=0;
            while(size-->0) { 
                TreeNode rem = qu.removeFirst();
                sm=sm+rem.val;
                cnt++;
                if (rem.left != null){
                    qu.add(rem.left);
                } 
                if (rem.right != null){
                    qu.add(rem.right);  
                }    
            }
            ans.add((double)(sm/cnt));
        }
        return ans;
    }
}