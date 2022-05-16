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
    public List<List<Integer>> levelOrderBottom(TreeNode node) {
         Queue<TreeNode> queue = new LinkedList<>();
        Stack<List<Integer>> st=new Stack<>();
        List<Integer> l=new ArrayList<>();
    queue.add(node);
    queue.add(null);
        List<List<Integer>> bl=new ArrayList<>();
        if(node==null)
            return bl;

    while(queue.size() > 0){
        TreeNode temp = queue.remove();

        if(temp != null){
            l.add(temp.val);

            if(temp.left != null){
                queue.add(temp.left);
            }

            if(temp.right != null){
                queue.add(temp.right);
            }
        } else {
            if(queue.size() > 0){
                
                queue.add(temp);
                 
                 
            }
            st.push(l);
                 l=new ArrayList<>();
            
        }
       
       
    }
        List<List<Integer>> rl=new ArrayList<>();
        while(st.size()>0)
        {
            rl.add(st.pop());
        }
        return rl;
    }
}