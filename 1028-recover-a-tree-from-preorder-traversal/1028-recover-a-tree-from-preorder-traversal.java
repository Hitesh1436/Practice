/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    // Require a Static Integer Because Left Node is Easily Identified But to Identify the Right Node.
    public static int index;
    public TreeNode construct(String traversal,int steps)
    {
        if(index>=traversal.length()){return null;}
        else
        {
            for(int i=index;i<index+steps;i++)
            {
                //If Any where in Between we get a value !='-' then It Coresponds to Higher Level Not The Child Node so simply return null.
                if(traversal.charAt(i)!='-'){return null;}
            }
            index=index+steps;
            int val=0;
            // Extracting out the Value of The Current Node
            while(index<traversal.length() && traversal.charAt(index)!='-')
            {
                val=val*10+(traversal.charAt(index)-48);
                index++;
            }
            TreeNode root=new TreeNode(val);
            //Next Child Should be Found after steps+1 Dashes in The String
            root.left=construct(traversal,steps+1);
            root.right=construct(traversal,steps+1);
            return root;
        }
    }
    public TreeNode recoverFromPreorder(String traversal) 
    {
        index=0;
        return construct(traversal,0);   
    }
}