class Solution {
    public TreeNode getRightMostNode(TreeNode node,TreeNode curr){
        while(node.right!=null&&node.right!=curr){
            node=node.right;
        }
        return node;
    }
    public void recoverTree(TreeNode root) {
        TreeNode prev=null;
        TreeNode first=null,sec=null;
        
        TreeNode curr=root;
        while(curr!=null){
            TreeNode left=curr.left;
            if(left==null){
                if(prev!=null&&prev.val>curr.val&& first==null){
                first=prev;
                    sec=curr;
                }
                else if(prev!=null&&prev.val>curr.val&&first!=null){
                    sec=curr;
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
                     if(prev!=null&&prev.val>curr.val&& first==null){
                first=prev;
                    sec=curr;
                }
                else if(prev!=null&&prev.val>curr.val&&first!=null){
                    sec=curr;
                }
                
                prev=curr;
                curr=curr.right;
                }
            }
        }
        int temp=first.val;
        first.val=sec.val;
        sec.val=temp;
    }
}