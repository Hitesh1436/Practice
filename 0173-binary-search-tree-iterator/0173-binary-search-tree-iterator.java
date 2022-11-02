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
class BSTIterator {
    List<Integer> al = new ArrayList<>();
    int i=0;
    public BSTIterator(TreeNode root) {
        inorder(root);
    }
    private void inorder(TreeNode node){
        if(node == null) return;
        inorder(node.left);
            al.add(node.val);
        inorder(node.right);
    }
    
    public int next() {
        return al.get(i++);
    }
    
    public boolean hasNext() {
        if(i<al.size()){
            return true;
        }
        return false;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */