// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
            for(int i = 0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++){
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isEularCircuitExist(V, adj);
            if(ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution
{
    public void dfs(ArrayList<ArrayList<Integer>> adj, int index, boolean[]visited){
        if(visited[index]==true){
            return;
        }    
        visited[index] = true;
        
        for(int i: adj.get(index)){
            dfs(adj, i, visited);    
        }
    }
    
    public boolean isEularCircuitExist(int V, ArrayList<ArrayList<Integer>> adj){
        boolean[]visited = new boolean[V];
        int i = 0;
        //Find the 1st vertex that has degree>0
        for(; i<adj.size();i++){
            if(adj.get(i).size()!=0){
                break;
            }
        }
        //Check if all vertices with non zero degree are connected
        if(i<V){
            dfs(adj, i, visited);
            
            for(int j=0; j<V;j++){
                if(visited[j]==false && adj.get(j).size()>0){
                    return false;
                }
            }
        }
        //Check if any vertex has odd degree
        int odd = 0;
        
        for(int j=0; j<V;j++){
            if(adj.get(j).size()%2!=0){
                odd++;
                return false;
            }
        }
        return true;
    }
}