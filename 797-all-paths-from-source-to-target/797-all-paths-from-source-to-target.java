class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        int n = graph.length;
        boolean []vis=new boolean[n];
        List<Integer> path = new ArrayList<>();
            path.add(0);  // src add krdia
        dfs(graph,0,n-1,vis,res,path);
        return res;
    }
    private void dfs(int [][]graph,int src,int dest,boolean []vis,List<List<Integer>> res,List<Integer>path){
        if(src == dest){
            res.add(new ArrayList<>(path));
            return;
        }
        vis[src]= true;
        for(int nbr : graph[src]){
            if(vis[nbr]== false){
                path.add(nbr);
                dfs(graph,nbr,dest,vis,res,path);
                path.remove(path.size()-1);
            }
        }
        vis[src]=false;
    }
}