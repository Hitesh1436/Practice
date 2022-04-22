class Solution {
    
     /*
   -1  ->unvis
    1  ->blue
    0  ->red
    
    */
    
    public class pair{
        int vertex;
        int color;
        pair(int vertex,int color){
            this.vertex = vertex;
            this.color=color;
        }
    }
    
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int [] vis = new int[n];
        Arrays.fill(vis,-1); // initially bhrdi vis array -1 se mns unvisited hn sab
        
        
        // graph components mn hoskts h toh sbhi components ko dkha pdega 
        
        for(int v=0;v<n;v++){
            if(vis[v]==-1){
                // unvisited hn toh 
                // BFS mtlb Remove Mark/Work and Add
                
                Queue<pair> qu = new LinkedList<>();
                // seeding 
                qu.add(new pair(v,0));
                
                
                while(qu.size()>0){
                    int size = qu.size();
                    while(size-- >0){
                        // remove
                        pair rem = qu.remove();
                        
                        if(vis[rem.vertex]!=-1){
                            // visited
                            if(vis[rem.vertex]== rem.color){
                                // mtlb agr remove vale ka color and iska color same h                                    toh koi dikkt ni hogi
                                continue;
                            }else{
                                return false;
                            }
                        }
                        // agr vis ni h toh ab mark kro
                        vis[rem.vertex] = rem.color;
                        int src = rem.vertex;
                        for(int e : graph[src]){
                            if(vis[e]==-1){
                                // add krao
                                qu.add(new pair(e,1-rem.color));
                                // 0 dega mtlb red 1 toh blue 
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}