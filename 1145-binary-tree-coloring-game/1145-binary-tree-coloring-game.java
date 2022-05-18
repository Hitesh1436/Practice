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
// When you find the selected node, there are three different paths you can block: left ,right or parent 
// if i color left(a) node blue, then red person can color all right and parent nodes red
// if i color right (b) node blue, then red person can color all left and parent nodes red
// if i color parent(c) node blue, then red person can color all right and left nodes red
// so i can only win if i choose a node which contains elements greater than the count of elements in otther 2 nodes i.e a>b+c i color a node blue, or b>a+c i color b node blue , or c>a+b i color c node blue
// if none of these 3 conditions hold true then red person wins bcoz he has more nodes to color
class Solution {
	public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
		if(root==null) return false;
		if(root.val==x){
			int a=countofnodes(root.left);
			int b=countofnodes(root.right);
			int c=n-a-b-1; // 1 for root
			if(a>b+c || b>c+a || c>a+b) return true;
			return false;
		}
		boolean left=btreeGameWinningMove(root.left,n,x);
		if(left) return true;
		boolean right=btreeGameWinningMove(root.right,n,x);
		if(right) return true;

		return false;
	}
	public int countofnodes(TreeNode root){
		if(root==null) return 0;
		return countofnodes(root.left)+countofnodes(root.right)+1;
	}
}