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
    int count = 0;
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null){
            return 0;
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        // root ,jhn jarhe h vo val,targetSum,map pass krdia helper mn
        helper(root,root.val,targetSum,map);
        return count;
    }
    // psum = prefix sum, 
    private void helper(TreeNode node,int psum,int tar,HashMap<Integer,Integer> map){
        
        if(map.containsKey(psum - tar)== true){
            count += map.get(psum-tar);
        }
        
        if(map.containsKey(psum)== false){ // age vo key ni h toh daldo and uske against 1 dldo 
            map.put(psum,1);
        }else{
            map.put(psum,map.get(psum)+1);// age vo key h toh daldo and usko +1 krdo
        }
        
        if(node.left != null){
            helper(node.left,psum + node.left.val,tar,map);
        }
        if(node.right != null){
            helper(node.right,psum + node.right.val,tar,map);
        }
        
        // calls
        if(map.get(psum)==1){  // agr 1 h toh remove krdo
            map.remove(psum);
        }else{
            map.put(psum,map.get(psum)-1);  // agr 1 se jyda h toh -1 krdo
        }
    }
}