/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> pN2R = nodeToRootPath(root,p.val);  // pN2R -> p ka node to root path
        ArrayList<TreeNode> qN2R = nodeToRootPath(root,q.val); // qN2R -> q ka node to root path
        
        int i = pN2R.size()-1;
        int j = qN2R.size()-1;
        TreeNode lca = null;
        while(i>=0 && j>=0){
            if(pN2R.get(i).val != qN2R.get(j).val){
                break;
            }
            lca = pN2R.get(i);
            i--;
            j--;
        }
        return lca;
    }
    private ArrayList<TreeNode> nodeToRootPath(TreeNode root,int data){
        if(root == null){
            return new ArrayList<>();
        }
        if(root.val == data){
            ArrayList<TreeNode> base = new ArrayList<>();
            base.add(root);
            return base;
        }
        ArrayList<TreeNode> leftAns = nodeToRootPath(root.left,data);
        if(leftAns.size()>0){
            leftAns.add(root);
            return leftAns;
        }
        ArrayList<TreeNode> rightAns = nodeToRootPath(root.right,data);
        if(rightAns.size()>0){
            rightAns.add(root);
            return rightAns;
    }
        return new ArrayList<>();
   }
}