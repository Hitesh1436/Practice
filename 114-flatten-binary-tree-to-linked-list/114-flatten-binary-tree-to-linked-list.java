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
        TreeNode head;
        TreeNode tail;
        Pair(){
            
        }
        Pair(TreeNode head,TreeNode tail){
            this.head = head;
            this.tail = tail;
        }
    }
    public void flatten(TreeNode root) {
        if(root != null){
            helper(root);
        }
    }
    private Pair helper(TreeNode node){
        if(node.left != null && node.right != null){ 
            Pair lp = helper(node.left);
            Pair rp = helper(node.right);
            Pair myP = new Pair();
            
            myP.head = node;
            myP.head.left= null;
            myP.head.right = lp.head;
            lp.tail.right = rp.head;
            myP.tail = rp.tail;
            
            return myP;
        }else if(node.left != null){
            Pair lp = helper(node.left);
            Pair myP = new Pair();
            
            myP.head = node;
            myP.head.left= null;
            myP.head.right = lp.head;
            myP.tail = lp.tail;
            
            return myP;
        }else if(node.right != null){
            Pair rp = helper(node.right);
            Pair myP = new Pair();
            
            myP.head = node;
            myP.head.left= null;
            myP.head.right = rp.head;
            myP.tail = rp.tail;
            
            return myP;
        }else{
          Pair myP = new Pair(node,node);
            return myP;
        }
    }
}