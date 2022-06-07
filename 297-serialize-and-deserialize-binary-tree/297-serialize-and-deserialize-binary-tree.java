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
    class Pair{
        TreeNode node;
        int state;
        
        public Pair(TreeNode node){
            this.node=node;
            this.state=0;
        }
    }

    // Encodes a tree to a single string.
    StringBuilder sb = new StringBuilder("");
    public String serialize(TreeNode root) {
        helper(root);
        return sb.toString();
    }
    
    public void helper(TreeNode node){
        if(node==null){
            sb.append(". ");
            return;
        }
        
        sb.append(node.val+" ");
        helper(node.left);
        helper(node.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Stack<Pair> s=new Stack<>();
        TreeNode root=new TreeNode();
        
        
        String []str=data.split(" ");
        
        if(str[0].equals(".")){
            return null;
        }
        root.val=Integer.parseInt(str[0]);
        s.push(new Pair(root));
        
        for(int i=1;i<str.length;i++){
            if(!s.isEmpty()){
                Pair curr=s.peek();
                TreeNode newNode=new TreeNode();
            
                if(str[i].equals(".")){
                    newNode=null;
                }else{
                    newNode.val=Integer.parseInt(str[i]);
                }
                
                if(curr.state==0){
                    curr.node.left=newNode;
                }else if(curr.state==1){
                    curr.node.right=newNode;
                }
            
                curr.state=curr.state+1;
                
                if(newNode!=null){
                    s.push(new Pair(newNode));
                }  
            }
            
            while(!s.isEmpty() && s.peek().state==2){
                s.pop();
            }
        }
        
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));