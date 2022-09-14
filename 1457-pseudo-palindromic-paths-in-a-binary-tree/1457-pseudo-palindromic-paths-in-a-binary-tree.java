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
    public int pseudoPalindromicPaths (TreeNode root) {
        Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
        return pseudoPalindromicPathsHelper(root, hm);
  }
    
    public int pseudoPalindromicPathsHelper(TreeNode root, Map<Integer, Integer> hm){
        
        if(root == null) return 0;
        
        // leaf node reached
        if(root != null && root.left == null && root.right == null){
            boolean flag = false;
            putKey(hm, root);
            
            if(checkOdds(hm)) flag = true;
            
            removeKey(hm, root);
            
            return flag ? 1 : 0;
        }
        
        putKey(hm, root); // insertion
        int count = pseudoPalindromicPathsHelper(root.left, hm)
                        + pseudoPalindromicPathsHelper(root.right, hm);
        removeKey(hm, root); // negate when backtracking
        
        return count;
    }
    
    public void putKey(Map<Integer, Integer> hm, TreeNode root){
        int count = hm.containsKey(root.val) ? hm.get(root.val) : 0;
        hm.put(root.val, count + 1);
    }
    
    public void removeKey(Map<Integer, Integer> hm, TreeNode root){
        
        int count = hm.get(root.val);
        
        if(count == 1){
            hm.remove(root.val);
        }else{
            hm.put(root.val, count - 1);
        }
    }
    
    public boolean checkOdds(Map<Integer, Integer> hm){
        int numOdds = 0;
        for(Integer i : hm.keySet()){
            if(hm.get(i) % 2 == 1) numOdds++;
        }
        
        return numOdds <= 1;
    }
}