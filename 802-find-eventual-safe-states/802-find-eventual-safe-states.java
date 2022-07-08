class Solution {
    int []vis;
    public List<Integer> eventualSafeNodes(int[][] graph) {
        ArrayList<Integer> ans = new ArrayList<>();
            vis = new int[graph.length];
        
        for(int i=0;i<graph.length;i++){
            boolean safe = dfs(i,graph);
            if(safe){
                ans.add(i);
            }
        }
        return ans;
    }
    public boolean dfs(int v,int [][]graph){
        if(vis[v]==2){
            return true;
        }else if(vis[v]==1){
            return false;
        }else{
            vis[v]= 1;
            for(int nbr : graph[v]){
                boolean isNbrSafe = dfs(nbr,graph);
                if(isNbrSafe==false){
                    return false;
                }
            }
            vis[v] = 2;
            return true;
        }
    }
}