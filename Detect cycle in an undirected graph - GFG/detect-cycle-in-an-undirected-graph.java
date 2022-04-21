// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}// } Driver Code Ends


class Pair{
    int first;
    int second;
    public Pair(int first , int second){
        this.first = first;
        this.second = second;
    }
}
class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {

    //     *****bfs*****
        boolean vis[] = new boolean[V];
        Arrays.fill(vis , false);
        
        for(int i=0 ; i<V ; i++){
            if(vis[i] == false){
                if(checkCycle(i , vis , adj)==true)
                    return true;
            }
        }
        return false;
    }
    public boolean checkCycle(int s , boolean vis[] , ArrayList<ArrayList<Integer>> adj){
        
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(s , -1));
        vis[s] = true;
        
        while(q.isEmpty()==false){
            int node = q.peek().first;
            int parent = q.peek().second;
            q.remove();
            
            for(Integer it : adj.get(node)){
                
                if(vis[it] == false){
                    q.add(new Pair(it , node));
                    vis[it] = true;
                }
                else if(parent != it)
                    return true;
            }
        }
        return false;
    }
}