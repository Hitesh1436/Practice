class Solution {
    public boolean isBipartite(int[][] graph) {
         int [] vis = new int [graph.length];
        
        for(int v=0;v<graph.length;v++){
            if(vis[v] == 0){
                boolean isBip =  traverseBFS(graph,vis,v);
                if(isBip == false){
                    return false;
                }
            }
        }
        return true;
    }
    class Pair{
        int v;
        int clr;
        
        Pair(int v,int clr){
            this.v = v;
            this.clr = clr;
        }
    }
    private boolean traverseBFS(int[][]graph,int []vis,int v){
        ArrayDeque<Pair> qu = new ArrayDeque<>();
        
        qu.add(new Pair(v,1));  // 1 mns red and -1 mns green 
        while(qu.size()>0){
            // r
            Pair rem = qu.remove();
            // m*
            if(vis[rem.v] != 0){
                int oldClr = vis[rem.v];
                int newClr = rem.clr;
                if(oldClr == newClr){
                    continue;
                }else{
                    return false;
                }
            }
            vis[rem.v] = rem.clr;
            
            for(int nbr : graph[rem.v]){
                if(vis[nbr] == 0){
                    qu.add(new Pair(nbr,rem.clr * -1));
                }
            }
        }
        return true;
    }
}