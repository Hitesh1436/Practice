class Solution {
    public TreeNode getRightMostNode(TreeNode node,TreeNode curr){
        while(node.right!=null && node.right!=curr){
            node=node.right;
        }
        return node;
    }
    public void recoverTree(TreeNode root) {
        TreeNode prev=null;
        TreeNode n1=null,n2=null;
        
        TreeNode curr=root;
        while(curr!=null){
            TreeNode left=curr.left;
            if(left==null){
                if(prev!=null && prev.val>curr.val && n1==null){
                n1=prev;
                    n2=curr;
                }
                else if(prev!=null && prev.val>curr.val && n1!=null){
                    n2=curr;
                }
                
                prev=curr;
                curr=curr.right;
            }else{
                TreeNode rightMost=getRightMostNode(left,curr);
                if(rightMost.right==null){
                    rightMost.right=curr;
                    curr=curr.left;
                }else{
                    rightMost.right=null;
                     if(prev!=null && prev.val>curr.val && n1==null){
                n1=prev;
                    n2=curr;
                }
                else if(prev!=null && prev.val>curr.val && n1!=null){
                    n2=curr;
                }
                
                prev=curr;
                curr=curr.right;
                }
            }
        }
        int temp=n1.val;
        n1.val=n2.val;
        n2.val=temp;
    }
}