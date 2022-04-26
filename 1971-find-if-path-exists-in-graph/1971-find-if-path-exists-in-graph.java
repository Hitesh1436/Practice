class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if(edges.length == 0)
            return true;
        
        List<List<Integer>> adj = new ArrayList<>();
        
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<Integer>());
        }
        
        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        
        boolean[] visited = new boolean[n];
        
        while(!q.isEmpty()){
            int node = q.remove();
            visited[node] = true;
            
            for(Integer l : adj.get(node)){
                if(l == destination)
                    return true;
                if(!visited[l])
                    q.add(l);
            }
            
        }
        
        return false;
    }
}