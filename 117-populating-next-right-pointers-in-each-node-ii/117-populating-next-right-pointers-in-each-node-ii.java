/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
	public Node connect(Node root) {
		if(null == root) {
			return null;
		}

		if (root.left != null && root.right != null) {
			root.left.next = root.right;
			root.right.next = findNext(root.next);
		} else if (root.left != null) {
			root.left.next = findNext(root.next);
		} else if (root.right != null) {
			root.right.next = findNext(root.next);
		}

		/**right first*/
		connect(root.right);
		connect(root.left);
		return root;
	}

	private Node findNext(Node root) {
		if (null == root) {
			return null;
		} else if (null != root.left) {
			return root.left;
		} else if (null != root.right) {
			return root.right;
		}
		return findNext(root.next);
	}
}