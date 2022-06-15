class Solution {
    public boolean isBipartite(int[][] graph) {
        int [] vis = new int[graph.length];
        for(int v=0;v<graph.length;v++){
            if(vis[v] == 0){
                boolean isBip = traverseDFS(graph,vis,v,1);
                if(isBip == false){
                    return false;
                }
            }
        }
        return true;
    }
    private boolean traverseDFS(int[][] graph,int []vis,int v,int color){
        vis[v] = color;
        for(int nbr : graph[v]){
            if(vis[nbr] == 0){
                boolean isBip = traverseDFS(graph,vis,nbr,color*-1);
                if(isBip == false){
                    return false;
                }
            }else{
                int oldColor = vis[nbr];
                int newColor = color * -1;
                if(oldColor != newColor){
                    return false;
                }
            }
        }
        return true;
    }
}