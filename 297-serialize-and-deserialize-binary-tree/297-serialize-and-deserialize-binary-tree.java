/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    static StringBuilder sb;
    public String serialize(TreeNode root) {
      sb = new StringBuilder();
    serializeHelper(root);
    return sb.toString();
}
public void serializeHelper(TreeNode root) {
    if(root==null){
        sb.append(". "); return;
    }
    sb.append(root.val+" ");
    serializeHelper(root.left);
    serializeHelper(root.right);
}

    // Decodes your encoded data to tree.
    static int idx;
public TreeNode deserialize(String data) {
    idx = 0;
    return deserializeHelper(data.split(" "));
}

public TreeNode deserializeHelper(String[] data) {
    if(idx>=data.length || data[idx].equals(".")){
        return null;
    }
    TreeNode root = new TreeNode(Integer.parseInt(data[idx]));
    idx++;
    root.left = deserializeHelper(data);
    idx++;
    root.right = deserializeHelper(data);
    return root;
 }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));