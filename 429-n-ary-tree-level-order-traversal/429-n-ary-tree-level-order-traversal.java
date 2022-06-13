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
    public List<List<Integer>> levelOrder(Node root) {
        // 1. initialise our result holding variable
		List<List<Integer>> result = new ArrayList<>();
		if (root == null)
			return result;
		// 2. Initialize queue for BFS
		Queue<Node> queue = new LinkedList<>();
		queue.offer(root); //start by adding the root
		while (!queue.isEmpty()) {
			List<Integer> current = new ArrayList<>(); // inorder to store the current level items
			int size = queue.size();
			for (int i=0; i<size; i++) {
				Node temp = queue.poll(); // pop out the first element from the queue.
				current.add(temp.val);   // add the element into current list.
				queue.addAll(temp.children); // add all the children of the node to the queue.
			}
			result.add(current);  // we have all the elements of current level and add it into the final result
		}
		return result;
    }
}