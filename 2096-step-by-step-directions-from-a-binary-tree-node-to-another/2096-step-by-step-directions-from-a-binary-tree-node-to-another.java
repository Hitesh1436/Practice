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
    public String getDirections(TreeNode root, int startValue, int destValue) {
        ArrayList<TreeNode> l1 = getPath(root,startValue);
        ArrayList<TreeNode> l2 = getPath(root,destValue);
        
        int i = l1.size()-1;
        int j = l2.size()-1;
        
        while(i>=0 && j>=0){
            if(l1.get(i)== l2.get(j)){
                i--;
                j--;
            }else{
                break;
            }
        }
        i++;
        j++;
        
        StringBuilder ans = new StringBuilder();
        for(int ii=0;ii<i;ii++){
            ans.append ("U");
        }
        for(int jj=j;jj>0;jj--){
            // check krenge jj ka left child h ya right 
            if(l2.get(jj-1)== l2.get(jj).left){
                ans.append ("L");
            }else{
                ans.append ("R");
            }
        }
        return ans.toString();
    }
    private ArrayList<TreeNode> getPath(TreeNode node,int num){
        ArrayList<TreeNode> ret = new ArrayList<>();
        if(node == null){
            return new ArrayList<>();
        }
        if(node.val == num){
            ret.add(node);
            return ret;
        }else{
            // left mn check krenge
            ArrayList<TreeNode> left = getPath(node.left,num);
            if(left.size()>0){
                left.add(node);
                return left;
            }else{
                // right mn check krenge
                ArrayList<TreeNode> right = getPath(node.right,num);
            if(right.size()>0){
                right.add(node);
                return right;
            }else{
                return new ArrayList<>();
            }
        }
    }
 }
}