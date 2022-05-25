// { Driver Code Starts
//Initial Template for Java

import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class GFG {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    static void printInorder(Node root){
        if(root == null)
            return;
            
        printInorder(root.left);
        System.out.print(root.data+" ");
        
        printInorder(root.right);
    }
    
    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());

        while(t > 0){
            String s = br.readLine();
            Node root = buildTree(s);
            
            Solution ob = new Solution();
            System.out.println(ob.maxPathSum(root));
            t--;
        }
    }
}
// } Driver Code Ends


//User function Template for Java

/* class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
} */
class Solution
{
    // Global variables
    int gmax = Integer.MIN_VALUE;
    
    Node mainroot;
    
    private int rec(Node root, Node parent)
    {
        /*Root can also be considered as a leaf node 
        as it satisfies the definition given in the question.*/
        if(root==null && parent == mainroot) return 0;
        
        //If node is null, return a very small value so as to not consider it.
        if(root==null) return -1000000;
        
        //If node is a leaf node then return its data.
        if(root.left==null && root.right==null) return root.data;
        
        //Get the left tree's sum.
        int left = rec(root.left, root);
        
        //Get the right tree's sum.
        int right = rec(root.right, root);
        
        int sum = left+right+root.data;
        
        //Update global maximum sum.
        gmax = Math.max(gmax, sum);
        
        /*Return the max of left sum and the right
        sum added with current node's data.*/
        return Math.max(left+root.data, right+root.data);
        
    }
    
    
    int maxPathSum(Node root)
    {
        //Initialize gmax with Integer.MIN_VALUE;
        gmax = Integer.MIN_VALUE;
        
        /*Global pointer to root node to
        check if root is a leaf node or not
        in the recursive function.*/
        mainroot = root;
        
        rec(root, root);
        
        return gmax;
    } 
}