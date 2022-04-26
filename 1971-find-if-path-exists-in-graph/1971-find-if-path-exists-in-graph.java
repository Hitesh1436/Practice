class Solution {

 private  boolean hasPath(ArrayList<Integer>[] graph,int src,int dst,boolean[] vis){
  if(src == dst) return true;

  vis[src] = true;

  for(int nbr : graph[src]){
     if(vis[nbr] == false){
         if(hasPath(graph,nbr,dst,vis)==true){
             return true;
         }
     }
        
  }
  return false;
}

public boolean validPath(int n, int[][] edges, int src, int dest) {
    ArrayList<Integer>[] graph = new ArrayList[n];
    for(int i =0 ;i<n;i++){
        graph[i] = new ArrayList<>();
    }
    
    for(int [] edge : edges){
        graph[edge[0]].add(edge[1]);
        graph[edge[1]].add(edge[0]);
    }
    boolean[] vis = new boolean[n];
    return hasPath(graph,src,dest,vis);
}
}