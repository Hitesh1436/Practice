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
       //procedure 
       /*
       1. Traverse the graph normally in dfs fashion and store the result in stack
       2. Reverse the edgees
       3. using the stack again do dfs traversal while stack is not empty
       */
       
       Stack<Integer> st = new Stack<>();
       boolean[] visited = new boolean[V];
       
       Arrays.fill(visited, false);
       
       for(int i = 0; i<V; i++){
           if(!visited[i])
            dfs(i, visited, st, adj);
       }
       ArrayList<ArrayList<Integer>> transposeAdj = new ArrayList<>();
       transposeGraph(V, adj, transposeAdj);
       
       int componentCount = 0;
       Arrays.fill(visited, false);
       while(!st.isEmpty()){
           int u = st.peek();
           st.pop();
           if(!visited[u]){
            componentCount++;
            dfs(u, visited, transposeAdj);
           }
       }
       return componentCount;
    }
    static void dfs(int u, boolean[] visited, Stack<Integer>st,  ArrayList<ArrayList<Integer>> adj){
        visited[u] = true;
        for(int v : adj.get(u)){
            if(visited[v] == false)
                dfs(v, visited, st, adj);
        }
        st.push(u);
    }
    static void transposeGraph(int V, ArrayList<ArrayList<Integer>> adj,
    ArrayList<ArrayList<Integer>> transposeAdj){
        for(int i = 0; i<V; i++){
            transposeAdj.add(new ArrayList<Integer>());
        }
        
        for(int i = 0; i<V;i++){
            for(int v: adj.get(i)){
                transposeAdj.get(v).add(i);
            }
        }
    }
    //overloading concept
    static void dfs(int u, boolean[] visited, ArrayList<ArrayList<Integer>> adj){
        visited[u] = true;
        for(int v : adj.get(u)){
            if(visited[v] == false)
            {
                dfs(v, visited, adj);
            }
        }
    }
}

