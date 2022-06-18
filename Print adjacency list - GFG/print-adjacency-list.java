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
            ArrayList<ArrayList<Integer>> ans = obj.printGraph(V, adj);
            for (int i = 0; i < ans.size(); i++) {
                for (int j = 0; j < ans.get(i).size() - 1; j++) {
                    System.out.print(ans.get(i).get(j) + "-> ");
                }
                System.out.print(ans.get(i).get(ans.get(i).size() - 1));
                System.out.println();
            }
        }
    }
}// } Driver Code Ends


class Solution {
    // Function to return the adjacency list for each vertex.
      public ArrayList<ArrayList<Integer>> printGraph(
        int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        // Make ArrayList of ArrayList
        // [ [], [], [], []]
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        
        for(int i=0; i <adj.size(); i++){
            ArrayList<Integer> l = new ArrayList<>();
            // add initial vertex to ArrayList
            // [[0]. [], [], []]
            l.add(i);
            for(int j=0; j <adj.get(i).size(); j++){
            
               l.add(adj.get(i).get(j));
               // here 0th node has connected to 1 and 4
               // so adj.get(i).size() = 2
               // loop runs for 0th and 1th index
               
               // so, ArrayList, 1 and 4 gets added
               // ArrayList L will be L [0, 1, 4]
               // adj.get(0).get(0) is 1
               // adj.get(0).get(1) is 4
               // comes out of the loop
               
            }
            // add l to ans ArrayList
            // [ [0, 1, 4], [], [], [] , []]
            // and goes on
            ans.add(l);
        }
        return ans;
    }
}