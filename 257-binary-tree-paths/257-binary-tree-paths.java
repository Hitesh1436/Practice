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
    public static List<String> binaryTreePaths(TreeNode root) {
		List<String> list = new ArrayList<>();
		path(root, list, new StringBuilder());
		return list;
	}

	private static void path(TreeNode root, List<String> list, StringBuilder sb) {
		if (root != null) {
			sb.append(root.val);
            int len = sb.length();
			if (root.left == null && root.right == null) {
				list.add(sb.toString());
			} else {
                path(root.left, list, sb.append("->"));
                sb.delete(len,sb.length());
    			path(root.right, list, sb.append("->"));   
            }
		}
	}
}