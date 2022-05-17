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
    class Node {
        int row;
        int val;
        Node(int row, int val) {
            this.row = row;
            this.val = val;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, Queue<Node>> map = new TreeMap<>();
        helper(root, map, 0, 0);
        
        List<List<Integer>> ret = new ArrayList<>();
        for (int c : map.keySet()) {
            List<Integer> list = new ArrayList<>();
            ret.add(list);
            Queue<Node> q = map.get(c);
            while (!q.isEmpty()) {
                list.add(q.poll().val);
            }
        }
        return ret;
    }
    
    private void helper(TreeNode cur, TreeMap<Integer, Queue<Node>> map, int r, int c) {
        if (cur == null) return;
        map.putIfAbsent(c, new PriorityQueue<Node>((a, b) -> a.row != b.row ? a.row - b.row : a.val - b.val));
        map.get(c).add(new Node(r, cur.val));
        helper(cur.left, map, r + 1, c - 1);
        helper(cur.right, map, r + 1, c + 1);
    }
}