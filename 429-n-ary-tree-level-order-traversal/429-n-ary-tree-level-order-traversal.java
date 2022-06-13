/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    private List<List<Integer>> levels;
    public List<List<Integer>> levelOrder(Node root) {
        levels = new ArrayList<>();
        search(root, 0);
        return levels;
    }

    private void search(Node root, int currentLevel) {
        if (root == null) return;

        if (levels.size() <= currentLevel) {
            List<Integer> newLevel = new ArrayList<>();
            newLevel.add(root.val);
            levels.add(newLevel);
        }
        else  {
            levels.get(currentLevel).add(root.val);
        }

        for (Node child : root.children) {
            search(child, currentLevel + 1);
        }
    }
}