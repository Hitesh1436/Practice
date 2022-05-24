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


// psi = pre start index,pei= pre end index,isi = in statr index, iei = in end index
class Solution {
     private  HashMap<Integer,Integer> hm = new HashMap<>() ;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        for(int i = 0 ; i < inorder.length ; i = i + 1)
        {
            hm.put(inorder[i],i) ;
        }
        return Construct(0,preorder.length-1,0,inorder.length-1,preorder ) ; 
    }

    private TreeNode Construct(int pLo,int pHi , int inL , int inHi ,int pre[]  )
    {
        if(pLo>pHi  ||  inL > inHi)
        {
            return null ;
        }
        TreeNode node = new TreeNode(pre[pLo]) ;

        int pos = findInInorder(pre[pLo] ) ;

        int diffL =  pos - inL ;
         
        node.left = Construct( pLo+1, pLo+diffL, inL,pos-1,pre ) ;
        node.right = Construct( pLo+diffL+1, pHi, pos+1,inHi,pre ) ;

        return node ;
    }

    private int findInInorder(int val  )
    {
         if(hm.containsKey(val))
         {
             return hm.get(val) ;
         }

        return - 1;
    }
} 