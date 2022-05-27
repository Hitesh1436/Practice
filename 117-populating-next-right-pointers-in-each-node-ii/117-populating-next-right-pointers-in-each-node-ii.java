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
        if(root ==null) return null;
        Queue<Node> qu = new LinkedList<>();
        qu.add(root);
        while(qu.size()>0){
            int size = qu.size();
            for(int i=0;i<size;i++){
                Node curr = qu.remove();
                if(i<size-1){
                    curr.next = qu.peek();
                }
                if(curr.left != null) qu.add(curr.left);
                if(curr.right != null) qu.add(curr.right);
            }
        }
        return root;
    }
}