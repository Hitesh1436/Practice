/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.StringTokenizer;
public class Codec {
public String serialize(TreeNode root) {
    StringBuilder sb = new StringBuilder();
    serialize(root, sb);
    return sb.toString();
}

private void serialize(TreeNode root, StringBuilder sb) {
    if (root == null)
        sb.append("# ");
    else {
        sb.append(root.val + " ");
        serialize(root.left, sb);
        serialize(root.right, sb);
    }
}

// ADD "import java.util.StringTokenizer;" AT TOP ==========================
// Decodes your encoded data to tree.
public TreeNode deserialize(String data) {
    if (data == null || data.length() == 0) return null;
    StringTokenizer st = new StringTokenizer(data, " ");
    return deserialize(st);
}

private TreeNode deserialize(StringTokenizer st) {
    if (!st.hasMoreTokens())
        return null;
    String s = st.nextToken();
    if (s.equals("#"))
        return null;
    TreeNode root = new TreeNode(Integer.valueOf(s));
    root.left = deserialize(st);
    root.right = deserialize(st);
    
    return root;
 }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));