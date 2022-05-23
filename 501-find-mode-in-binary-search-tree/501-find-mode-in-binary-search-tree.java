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
        Integer prev = null;
        int count = 1;
        int max =0;
    private void inOrder(TreeNode node,List<Integer>retVal){
        if(node == null){
            return;
        }
        
        inOrder(node.left,retVal);
        // work hoga
        if(prev != null){
            //check if value is equal to the current value and increment count
            if(prev == node.val){
                count++;
            }else{
                count =1;
            }
        }
        if(count > max){
            max = count;
            retVal.clear();
            retVal.add(node.val);
        }else if(count == max){
            retVal.add(node.val);
        }
        //to store the previous node and later compare it to the next node
        prev = node.val;
        inOrder(node.right,retVal);
    }
    
    public int[] findMode(TreeNode root) {
        List<Integer> al = new ArrayList<>();
            inOrder(root,al);
        int [] ans = new int[al.size()];
        for(int i=0;i<ans.length;i++){
            ans[i] = al.get(i);
        }
        return ans;
    }
}