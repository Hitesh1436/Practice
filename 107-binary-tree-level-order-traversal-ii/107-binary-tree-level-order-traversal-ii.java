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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        
        Queue<TreeNode>queue=new LinkedList<>();
        List<List<Integer>>ans=new ArrayList<>();
        if(root==null)return ans;
       
        
        queue.add(root);
         
        while(queue.size()>0){
            ArrayList<Integer> sans=new ArrayList<>();
            int c=queue.size();
            for(int i=0;i<c;i++){
                TreeNode temp=queue.poll();
               
                sans.add(temp.val);
                if(temp.left!=null)queue.add(temp.left);
            if(temp.right!=null)queue.add(temp.right);
                }
           
            ans.add(sans);
        }
        Collections. reverse(ans);
        return ans;
    }
}