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
		List<List<Integer>> ans = new ArrayList<>();
		if (root == null)
			return ans;
		// 2. Initialize queue for BFS
		Queue<Node> qu = new LinkedList<>();
		qu.add(root); //start by adding the root
		while (!qu.isEmpty()) {
			List<Integer> current = new ArrayList<>(); // inorder to store the current level items
			int size = qu.size();
			for (int i=0; i<size; i++) {
				Node temp = qu.poll(); // pop out the first element from the queue.
				current.add(temp.val);   // add the element into current list.
				qu.addAll(temp.children); // add all the children of the node to the queue.
			}
			ans.add(current);  // we have all the elements of current level and add it into the final result
		}
		return ans;
    }
}