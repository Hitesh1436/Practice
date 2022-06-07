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
    private int index;
    public TreeNode recoverFromPreorder(String traversal) {
        if(traversal == null || traversal.length() == 0) return null;
        
        index = 0;
        return buildIt(traversal, 0); 
    }
    
    private TreeNode buildIt(String data, int level){
        if(index >= data.length()) return null; // end of string
        
        // get level
        int dashs = getDashs(data);
        if(dashs < level) return null; 
        
        // correct level, adjust index
        index += dashs;
        
        // get number
        int val = getNumber(data);
        
        TreeNode root = new TreeNode(val);
        
        root.left = buildIt(data, level+1);
        root.right = buildIt(data, level+1); 
        
        return root; 
    }
    
    // do not move index, we need to know first if the 
    // level is correct.
    private int getDashs(String s){
        int dashs = 0;
        while(s.charAt(index+dashs) == '-'){
            dashs++;
        }
        return dashs;
    }
    
    private int getNumber(String s){
        StringBuilder sb = new StringBuilder();
        while(index < s.length() && s.charAt(index) != '-'){
            sb.append(s.charAt(index++));
        }
        return Integer.parseInt(sb.toString()); 
    }
}