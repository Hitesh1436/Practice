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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> st1 = new Stack<>();
        Stack<TreeNode> st2 = new Stack<>();

        while (root1 != null || root2 != null || st1.size() > 0 || st2.size() > 0) {
            // make left calls
            while (root1 != null) {
                st1.push(root1);
                root1 = root1.left;
            }

            while (root2 != null) {
                st2.push(root2);
                root2 = root2.left;
            }

            // Perform operation in inoredr area : compare  values from bith the stacks and make right
            // calls according to the comparison condition

            if (st2.isEmpty() || (!st1.isEmpty() && st1.peek().val <= st2.peek().val)) {
                root1 = st1.pop();
                ans.add(root1.val);
                // right calls
                root1 = root1.right;
            } else {
                root2 = st2.pop();
                ans.add(root2.val);
                // right call
                root2 = root2.right;
            }
        }

        return ans;
    }
}