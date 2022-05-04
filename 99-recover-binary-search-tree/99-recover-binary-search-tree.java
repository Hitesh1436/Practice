class Solution {
    public void recoverTree(TreeNode root) {
        TreeNode prev=null;
        TreeNode a=null;
        TreeNode b=null;
        TreeNode curr=root;
        ArrayList<Integer> al=new ArrayList<>();
        while(curr!=null){
            TreeNode leftNode=curr.left;
            if(leftNode==null){
                al.add(curr.val);
                if(prev!=null && prev.val>curr.val){
                    if(a==null){
                        a=prev;
                    }
                    b=curr;
                }
                prev=curr;
                curr=curr.right;
            }else{
                TreeNode rightNode=getRightMostNode(curr,leftNode);
                
                if(rightNode.right==null){
                    rightNode.right=curr;
                    curr=curr.left;
                }else{
                    al.add(curr.val);
                    if(prev.val>curr.val){
                        if(a==null){
                            a=prev;
                        }
                        b=curr;
                    }
                    prev=curr;
                    
                    rightNode.right=null;
                    curr=curr.right;
                }
            }
        }
        if(a!=null){
            int temp=a.val;
            a.val=b.val;
            b.val=temp;
        }  
    }
    
    public TreeNode getRightMostNode(TreeNode root,TreeNode Node){
        while(Node.right!=null && Node.right!=root){
            Node=Node.right;
        }
        return Node;
    }
}