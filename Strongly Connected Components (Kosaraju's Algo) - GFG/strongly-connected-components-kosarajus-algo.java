// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Gfg
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            // arraylist of arraylist to represent graph
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            int V = Integer.parseInt(sc.next());
            int E = Integer.parseInt(sc.next());
            
            for(int i =0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
                
            for(int i = 1; i <= E; i++)
            {    int u = Integer.parseInt(sc.next());
                 int v = Integer.parseInt(sc.next());
                 
                 // adding directed edgese between 
                 // vertex 'u' and 'v'
                 adj.get(u).add(v);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.kosaraju(V, adj));
		}
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to find number of strongly connected components in the graph.
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        // code here
        // topological sort
        Stack<Integer> stack=new Stack<>();
        boolean[] vis=new boolean[V];
        for(int i=0;i<V;i++) {
            if(!vis[i])
                topSort(adj,stack,i,vis);
        }
        // reverse list items
        ArrayList<ArrayList<Integer>> newAdj=new ArrayList<ArrayList<Integer>>(); 
        for(int i=0;i<V;i++) {
            newAdj.add(new ArrayList<Integer>());
        }
        for(int i=0;i<V;i++) {
            for(int x:adj.get(i)) {
                newAdj.get(x).add(i);
            }
        }
        // dfs search on topologically sorted items
        Arrays.fill(vis,false);
        int res=0;
        while(!stack.isEmpty()) {
            int i=stack.pop();
            if(!vis[i]) {
               dfs(newAdj,i,vis);
               res++;
            }
        }
        return res;
    }
    
    public void topSort(ArrayList<ArrayList<Integer>> adj,Stack<Integer> stack,int u,boolean[] vis) {
        vis[u]=true;
        for(int v:adj.get(u)) {
            if(!vis[v])
                topSort(adj,stack,v,vis);
        }
        stack.push(u);
    }
    
    public void dfs(ArrayList<ArrayList<Integer>> adj,int u,boolean[] vis) {
        vis[u]=true;
        for(int v:adj.get(u)) {
            if(!vis[v])
                dfs(adj,v,vis);
        }
    }
}