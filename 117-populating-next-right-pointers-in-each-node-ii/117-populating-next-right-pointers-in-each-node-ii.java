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
        if (root == null) {
            return null;
        }
        if (root.left != null) {
            if (root.right != null) {
                root.left.next = root.right;
            } else {
                Node nxt = findNext(root.next);
                root.left.next = nxt;
            }
        }
        if (root.right != null) {
            Node nxt = findNext(root.next);
            root.right.next = nxt;
        }
		// this is a key: build the connection from right to left.
		// you can change it from left to right, see what will happend. lol 
        connect(root.right);
        connect(root.left);
        return root;
    }
    
	//this helper function likes to operate a linkedlist
    private Node findNext(Node root) {
        while (root != null) {
            if (root.left != null) {
                return root.left;
            }
            if (root.right != null) {
                return root.right;
            }
            root = root.next;
        }
        return root;
    }
}