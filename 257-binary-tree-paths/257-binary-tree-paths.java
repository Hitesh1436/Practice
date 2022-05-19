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
    List<String> result = new ArrayList<String>();
    
public List<String> binaryTreePaths(TreeNode root){ 

    helper(root, new StringBuilder());
    return result;
}


void helper(TreeNode node, StringBuilder sb){

    if(node==null) return;
    
    int length = sb.length();
    sb.append(node.val);
    
    if(node.left == null && node.right == null)
        result.add(sb.toString()); 
    
    else
    {
       sb.append("->");
       helper(node.left, sb);
       helper(node.right, sb);
    }
    sb.setLength(length);
 }
}